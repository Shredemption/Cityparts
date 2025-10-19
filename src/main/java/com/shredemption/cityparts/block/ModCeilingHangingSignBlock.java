package com.shredemption.cityparts.block;

import javax.annotation.Nonnull;

import com.shredemption.cityparts.blockentity.ModHangingSignBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModCeilingHangingSignBlock extends CeilingHangingSignBlock {
    public ModCeilingHangingSignBlock(WoodType woodType, Properties properties) {
        super(woodType, properties);
    }

    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new ModHangingSignBlockEntity(pos, state);
    }
}
