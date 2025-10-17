package com.shredemption.streetparts.block.entity;

import com.shredemption.streetparts.registry.BlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.SIGN.get(), pos, state);
    }
}
