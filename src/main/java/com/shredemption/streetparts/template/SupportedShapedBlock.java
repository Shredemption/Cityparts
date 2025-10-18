package com.shredemption.streetparts.template;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SupportedShapedBlock extends ShapedBlock {

    public SupportedShapedBlock(BlockBehaviour.Properties properties, VoxelShape shape) {
        super(properties, shape);
    }

    @Override
    public boolean canSurvive(@Nonnull BlockState state, @Nonnull LevelReader world, @Nonnull BlockPos pos) {
        BlockPos below = pos.below();
        BlockState belowState = world.getBlockState(below);
        return belowState.isFaceSturdy(world, below, Direction.UP);
    }

    @Override
    public BlockState updateShape(@Nonnull BlockState state, @Nonnull Direction facing,
            @Nonnull BlockState neighborState,
            @Nonnull LevelAccessor level, @Nonnull BlockPos pos, @Nonnull BlockPos neighborPos) {
        if (!state.canSurvive(level, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return state;
    }
}