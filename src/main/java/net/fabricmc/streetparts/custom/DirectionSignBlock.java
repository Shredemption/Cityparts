package net.fabricmc.streetparts.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class DirectionSignBlock extends HorizontalFacingBlock {
    public DirectionSignBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)){
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            case SOUTH:
                return SHAPE_S;
        }
        return null;
    }

    private static final VoxelShape SHAPE_N = Block.createCuboidShape(7, 4, 0, 9, 12, 22);
    private static final VoxelShape SHAPE_E = Block.createCuboidShape(-6, 4, 7, 16, 12, 9);
    private static final VoxelShape SHAPE_W = Block.createCuboidShape(0, 4, 7, 22, 12, 9);
    private static final VoxelShape SHAPE_S = Block.createCuboidShape(7, 4, -6, 9, 12, 16);

}

