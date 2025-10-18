package com.shredemption.streetparts.blockentity;

import javax.annotation.Nonnull;

import com.shredemption.streetparts.block.DirectionSignBlock;
import com.shredemption.streetparts.registry.BlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class DirectionSignBlockEntity extends SignBlockEntity {

    public DirectionSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    protected SignText createDefaultSignText() {
        return new SignText().setColor(DyeColor.WHITE).setHasGlowingText(true);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BlockEntities.DIRECTION_SIGN.get();
    }

    @Override
    public boolean isFacingFrontText(@Nonnull Player player) {
        if (this.getBlockState().getBlock() instanceof DirectionSignBlock signblock) {
            Vec3 vec3 = signblock.getSignHitboxCenterPosition(this.getBlockState());
            double d0 = player.getX() - ((double) this.getBlockPos().getX() + vec3.x);
            double d1 = player.getZ() - ((double) this.getBlockPos().getZ() + vec3.z);
            float f = signblock.getYRotationDegrees(this.getBlockState());
            float f1 = (float) (Mth.atan2(d1, d0) * 180.0F / (float) Math.PI) - 90.0F;
            return Mth.degreesDifferenceAbs(f, f1) <= 90.0F;
        } else {
            return false;
        }
    }
}
