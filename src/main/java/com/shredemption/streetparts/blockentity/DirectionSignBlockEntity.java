package com.shredemption.streetparts.blockentity;

import com.shredemption.streetparts.registry.BlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;

public class DirectionSignBlockEntity extends SignBlockEntity {

    private SignText frontText = this.createDefaultSignText();
    private SignText backText = this.createDefaultSignText();

    public DirectionSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BlockEntities.DIRECTION_SIGN.get();
    }

    public SignText getText(boolean isFrontText) {
        return isFrontText ? this.frontText : this.backText;
    }

    public SignText getFrontText() {
        return this.frontText;
    }

    public SignText getBackText() {
        return this.backText;
    }    
}
