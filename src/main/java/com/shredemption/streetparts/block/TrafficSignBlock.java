package com.shredemption.streetparts.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TrafficSignBlock extends AttachableHorizontalBlock {

    private static final VoxelShape SignShape = Shapes.or(
            Shapes.box(7 / 16f, 9 / 16f, 1.0f, 9 / 16f, 11 / 16f, 1.375f),
            Shapes.box(2 / 16f, 4 / 16f, 15 / 16f, 14 / 16f, 1.0f, 1.0f));

    public TrafficSignBlock(BlockBehaviour.Properties properties) {
        super(properties, SignShape);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
}
