package net.fabricmc.streetparts.custom.lights;

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

public class LCornerBlock extends HorizontalFacingBlock {
    public LCornerBlock(Settings settings) {
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

    private static final VoxelShape SHAPE_N = Block.createCuboidShape(6, 0, 0, 16, 12, 10);
    private static final VoxelShape SHAPE_E = Block.createCuboidShape(6, 0, 6, 16, 12, 16);
    private static final VoxelShape SHAPE_W = Block.createCuboidShape(0, 0, 0, 10, 12, 10);
    private static final VoxelShape SHAPE_S = Block.createCuboidShape(0, 0, 6, 10, 12, 16);

}

