package com.shredemption.cityparts.template;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DyableRotatableHorizontalBlock extends RotatableHorizontalBlock {

    public static final EnumProperty<DyeColor> COLOR = EnumProperty.create("color", DyeColor.class);

    public DyableRotatableHorizontalBlock(Properties properties, VoxelShape shape) {
        super(properties, shape);
        this.registerDefaultState(this.stateDefinition.any().setValue(COLOR, DyeColor.WHITE));
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(COLOR);
    }

    public static int getColor(BlockState state) {
        return state.getValue(COLOR).getTextureDiffuseColor();
    }
}