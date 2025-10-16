package com.shredemption.streetparts.custom.block;

import javax.annotation.Nonnull;

import com.shredemption.streetparts.custom.block.entity.CustomHangingSignBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class CustomCeilingHangingSignBlock extends CeilingHangingSignBlock {
    public CustomCeilingHangingSignBlock(WoodType woodType, Properties properties) {
        super(woodType, properties);
    }

    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new CustomHangingSignBlockEntity(pos, state);
    }
}
