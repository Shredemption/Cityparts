package com.shredemption.cityparts.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class PaintbrushItem extends Item {
    public PaintbrushItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return stack.getDamageValue() > 0
                && stack.getDamageValue() < stack.getMaxDamage();
    }
}
