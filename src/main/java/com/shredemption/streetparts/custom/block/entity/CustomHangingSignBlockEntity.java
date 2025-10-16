package com.shredemption.streetparts.custom.block.entity;

import com.shredemption.streetparts.registry.BlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CustomHangingSignBlockEntity extends SignBlockEntity {
    public CustomHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.HANGING_SIGN.get(), pos, state);
    }

    @Override
    public int getTextLineHeight() {
        return 9;
    }

    @Override
    public int getMaxTextLineWidth() {
        return 60;
    }

    @Override
    public SoundEvent getSignInteractionFailedSoundEvent() {
        return SoundEvents.WAXED_HANGING_SIGN_INTERACT_FAIL;
    }
}
