package com.shredemption.streetparts.template;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ShapedBlock extends Block {
    private final VoxelShape shape;

    public ShapedBlock(BlockBehaviour.Properties properties, VoxelShape shape) {
        super(properties);
        this.shape = shape;
    }

    @Override
    public @Nonnull VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos,
            @Nonnull CollisionContext context) {
        return shape;
    }
}
