package net.fabricmc.streetparts.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class DirectionSignBlock extends HorizontalFacingBlock {
    public DirectionSignBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> SHAPE_N;
            case EAST -> SHAPE_E;
            case WEST -> SHAPE_W;
            case SOUTH -> SHAPE_S;
            default -> null;
        };
    }

    private static final VoxelShape SHAPE_N = Block.createCuboidShape(7, 4, 0, 9, 12, 22);
    private static final VoxelShape SHAPE_E = Block.createCuboidShape(-6, 4, 7, 16, 12, 9);
    private static final VoxelShape SHAPE_W = Block.createCuboidShape(0, 4, 7, 22, 12, 9);
    private static final VoxelShape SHAPE_S = Block.createCuboidShape(7, 4, -6, 9, 12, 16);

}

