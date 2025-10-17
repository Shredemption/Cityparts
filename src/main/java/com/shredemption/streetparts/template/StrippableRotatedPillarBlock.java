package com.shredemption.streetparts.template;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.shredemption.streetparts.registry.WoodBlocksRegistry;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;

public class StrippableRotatedPillarBlock extends RotatedPillarBlock {

    public StrippableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(@Nonnull BlockState state, @Nonnull UseOnContext context,
            @Nonnull ItemAbility itemAbility,
            boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            Block stripped = WoodBlocksRegistry.getStrippables().get(state.getBlock());
            if (stripped != null) {
                return stripped.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
