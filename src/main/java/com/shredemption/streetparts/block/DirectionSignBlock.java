package com.shredemption.streetparts.block;

import javax.annotation.Nonnull;

import com.shredemption.streetparts.template.AttachableHorizontalBlock;

import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DirectionSignBlock extends AttachableHorizontalBlock {

    private static final VoxelShape baseShape = Shapes.or(
            Shapes.box(7 / 16f, 4 / 16f, 0 / 16f, 9 / 16f, 12 / 16f, 22 / 16f));

    public DirectionSignBlock(BlockBehaviour.Properties properties) {
        super(properties, baseShape);
    }

    @Override
    public RenderShape getRenderShape(@Nonnull BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
}
