package com.shredemption.streetparts.block.entity;

import com.shredemption.streetparts.registry.BlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DirectionSignBlockEntity extends SignBlockEntity {
    public DirectionSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BlockEntities.DIRECTION_SIGN.get();
    }
}
