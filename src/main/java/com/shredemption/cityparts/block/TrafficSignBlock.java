package com.shredemption.cityparts.block;

import com.shredemption.cityparts.template.AttachableHorizontalBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TrafficSignBlock extends AttachableHorizontalBlock {

    public static final EnumProperty<AttachFace> FACE = BlockStateProperties.ATTACH_FACE;

    private static final VoxelShape WALL_SHAPE = Shapes.or(
            Shapes.box(7 / 16f, 9 / 16f, 16 / 16f, 9 / 16f, 11 / 16f, 22 / 16f),
            Shapes.box(1 / 16f, 2 / 16f, 15 / 16f, 15 / 16f, 16 / 16f, 16 / 16f));

    private static final VoxelShape FLOOR_SHAPE = Shapes.or(
            Shapes.box(6 / 16f, 0 / 16f, 6 / 16f, 10 / 16f, 12 / 16f, 10 / 16f),
            Shapes.box(1 / 16f, 2 / 16f, 5 / 16f, 15 / 16f, 16 / 16f, 6 / 16f));

    public TrafficSignBlock(BlockBehaviour.Properties properties) {
        super(properties, WALL_SHAPE);
        this.registerDefaultState(
                this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction clickedFace = context.getClickedFace();

        if (clickedFace == Direction.UP) {
            return this.defaultBlockState()
                    .setValue(FACE, AttachFace.FLOOR)
                    .setValue(FACING, context.getHorizontalDirection().getOpposite());
        }

        if (clickedFace == Direction.DOWN) {
            return null;
        }

        return this.defaultBlockState()
                .setValue(FACE, AttachFace.WALL)
                .setValue(FACING, clickedFace);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {

        switch (state.getValue(FACE)) {
            case AttachFace.FLOOR:
                return rotateShape(FLOOR_SHAPE, state.getValue(FACING));
            default:
                return rotateShape(WALL_SHAPE, state.getValue(FACING));
        }
    }

    @Override
    public boolean canSurvive(
            BlockState state,
            LevelReader world,
            BlockPos pos) {

        if (state.getValue(FACE) == AttachFace.FLOOR) {
            // Floor-mounted sign needs a solid block underneath.
            return world.getBlockState(pos.below())
                    .isFaceSturdy(world, pos.below(), Direction.UP);
        }

        // Wall-mounted sign needs support behind it.
        Direction facing = state.getValue(FACING);
        BlockPos supportPos = pos.relative(facing.getOpposite());

        return !world.getBlockState(supportPos).isAir();
    }

    @Override
    public BlockState updateShape(
            BlockState state,
            Direction direction,
            BlockState neighborState,
            LevelAccessor level,
            BlockPos pos,
            BlockPos neighborPos) {

        boolean needsUpdate;

        if (state.getValue(FACE) == AttachFace.FLOOR) {
            // Only the block underneath matters.
            needsUpdate = direction == Direction.DOWN;
        } else {
            // Only the block behind the sign matters.
            Direction facing = state.getValue(FACING);
            needsUpdate = direction == facing.getOpposite();
        }

        if (needsUpdate && !this.canSurvive(state, level, pos)) {
            return Blocks.AIR.defaultBlockState();
        }

        return state;
    }

    private VoxelShape rotateShape(VoxelShape shape, Direction direction) {
        int times = switch (direction) {
            case EAST -> 1;
            case SOUTH -> 2;
            case WEST -> 3;
            default -> 0;
        };

        VoxelShape rotated = shape;

        for (int i = 0; i < times; i++) {
            VoxelShape newShape = Shapes.empty();

            for (var box : rotated.toAabbs()) {
                newShape = Shapes.or(newShape,
                        Shapes.box(1 - box.maxZ, box.minY, box.minX, 1 - box.minZ, box.maxY, box.maxX));
            }

            rotated = newShape;
        }

        return rotated;
    }
}
