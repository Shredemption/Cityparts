package com.shredemption.streetparts.custom.sign;

import com.shredemption.streetparts.registry.BlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CustomSignBlockEntity extends SignBlockEntity {
    public CustomSignBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.SIGN.get(), pos, state);
    }
}
