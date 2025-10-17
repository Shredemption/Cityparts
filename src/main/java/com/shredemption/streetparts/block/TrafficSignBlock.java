package com.shredemption.streetparts.block;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TrafficSignBlock extends RotatableHorizontalBlock {

    private static final VoxelShape SignShape = Shapes.or(
            Shapes.box(7 / 16f, 9 / 16f, 1.0f, 9 / 16f, 11 / 16f, 1.375f),
            Shapes.box(2 / 16f, 4 / 16f, 15 / 16f, 14 / 16f, 1.0f, 1.0f));

    public TrafficSignBlock(BlockBehaviour.Properties properties) {
        super(properties, SignShape);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState updateShape(@Nonnull BlockState state, @Nonnull Direction dir, @Nonnull BlockState neighborState,
            @Nonnull LevelAccessor level, @Nonnull BlockPos pos, @Nonnull BlockPos neighborPos) {
        if (dir.getOpposite() == state.getValue(FACING) && !this.canSurvive(state, level, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return state;
    }

    @Override
    public boolean canSurvive(@Nonnull BlockState state, @Nonnull LevelReader world, @Nonnull BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos supportPos = pos.relative(direction.getOpposite());
        BlockState suppoertState = world.getBlockState(supportPos);

        return !suppoertState.isAir();
    }
}
