package com.shredemption.cityparts.template;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RotatableHorizontalLightBlock extends RotatableHorizontalBlock {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    private static final int SKY_LIGHT_THRESHOLD = 5;

    public RotatableHorizontalLightBlock(Properties properties, VoxelShape baseShape) {
        super(properties, baseShape);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LIT, false));
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {

        super.createBlockStateDefinition(builder);
        builder.add(LIT);
    }

    @Override
    protected void tick(@Nonnull BlockState state, @Nonnull ServerLevel level, @Nonnull BlockPos pos,
            @Nonnull RandomSource random) {

        updateLightState(state, level, pos);

        level.scheduleTick(pos, this, 20);
    }

    @Override
    public void onPlace(@Nonnull BlockState state, @Nonnull net.minecraft.world.level.Level level,
            @Nonnull BlockPos pos, @Nonnull BlockState oldState, boolean movedByPiston) {

        super.onPlace(state, level, pos, oldState, movedByPiston);

        if (!level.isClientSide) {
            level.scheduleTick(pos, this, 1);
        }
    }

    private void updateLightState(BlockState state, ServerLevel level, BlockPos pos) {

        int skyLight = level.getBrightness(LightLayer.SKY, pos);

        boolean shouldBeLit = skyLight < SKY_LIGHT_THRESHOLD;
        boolean isLit = state.getValue(LIT);

        if (shouldBeLit != isLit) {
            level.setBlock(pos, state.setValue(LIT, shouldBeLit), Block.UPDATE_ALL);
        }
    }
}
