package com.shredemption.streetparts.template;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HorizontalConnectingBlock extends Block {
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final BooleanProperty POST = BooleanProperty.create("post");

    private final VoxelShape postShape;
    private final VoxelShape tapeShapeNorth;
    private final VoxelShape tapeShapeEast;
    private final VoxelShape tapeShapeSouth;
    private final VoxelShape tapeShapeWest;

    public HorizontalConnectingBlock(Properties properties, VoxelShape postShape, VoxelShape tapeShapeNorth) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(POST, true));

        this.postShape = postShape;
        this.tapeShapeNorth = tapeShapeNorth;
        this.tapeShapeEast = rotateShape(tapeShapeNorth, Direction.EAST);
        this.tapeShapeSouth = rotateShape(tapeShapeNorth, Direction.SOUTH);
        this.tapeShapeWest = rotateShape(tapeShapeNorth, Direction.WEST);
    }

    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext ctx) {
        Level level = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        Block self = this;

        boolean north = connectsTo(level, pos.north(), self);
        boolean east = connectsTo(level, pos.east(), self);
        boolean south = connectsTo(level, pos.south(), self);
        boolean west = connectsTo(level, pos.west(), self);

        boolean post = shouldHavePost(north, east, south, west);

        return this.defaultBlockState()
                .setValue(NORTH, north)
                .setValue(EAST, east)
                .setValue(SOUTH, south)
                .setValue(WEST, west)
                .setValue(POST, post);
    }

    private boolean connectsTo(LevelReader world, BlockPos pos, Block self) {
        BlockState neighbor = world.getBlockState(pos);
        return neighbor.getBlock() == self;
    }

    private boolean shouldHavePost(boolean n, boolean e, boolean s, boolean w) {
        int connections = (n ? 1 : 0) + (e ? 1 : 0) + (s ? 1 : 0) + (w ? 1 : 0);

        if (connections == 2) {
            if ((n && s) || (e && w)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level,
            @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        VoxelShape shape = Shapes.empty();

        if (state.getValue(POST)) {
            shape = Shapes.or(shape, postShape);
        }

        if (state.getValue(NORTH)) {
            shape = Shapes.or(shape, tapeShapeNorth);
        }
        if (state.getValue(EAST)) {
            shape = Shapes.or(shape, tapeShapeEast);
        }
        if (state.getValue(SOUTH)) {
            shape = Shapes.or(shape, tapeShapeSouth);
        }
        if (state.getValue(WEST)) {
            shape = Shapes.or(shape, tapeShapeWest);
        }

        return shape;
    }

    @Override
    public BlockState updateShape(@Nonnull BlockState state, @Nonnull Direction dir, @Nonnull BlockState neighborState,
            @Nonnull LevelAccessor level, @Nonnull BlockPos pos, @Nonnull BlockPos neighborPos) {
        if (!dir.getAxis().isHorizontal())
            return state;

        Block self = state.getBlock();

        boolean north = connectsTo(level, pos.north(), self);
        boolean east = connectsTo(level, pos.east(), self);
        boolean south = connectsTo(level, pos.south(), self);
        boolean west = connectsTo(level, pos.west(), self);

        boolean post = shouldHavePost(north, east, south, west);

        return state
                .setValue(NORTH, north)
                .setValue(EAST, east)
                .setValue(SOUTH, south)
                .setValue(WEST, west)
                .setValue(POST, post);
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, POST);
    }

    private VoxelShape rotateShape(VoxelShape shape, Direction direction) {
        VoxelShape rotated = shape;
        int times = switch (direction) {
            case EAST -> 1;
            case SOUTH -> 2;
            case WEST -> 3;
            default -> 0;
        };
        for (int i = 0; i < times; i++) {
            VoxelShape newShape = Shapes.empty();
            for (var box : rotated.toAabbs()) {
                newShape = Shapes.or(newShape, Shapes.box(
                        1 - box.maxZ, box.minY, box.minX,
                        1 - box.minZ, box.maxY, box.maxX));
            }
            rotated = newShape;
        }
        return rotated;
    }
}