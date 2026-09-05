package com.shredemption.cityparts.registry;

import com.shredemption.cityparts.CityParts;
import com.shredemption.cityparts.item.PaintbrushItem;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemsRegistry {

        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CityParts.MOD_ID);

        public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, CityParts.MOD_ID);

        public static final DeferredItem<PaintbrushItem> PAINTBRUSH = ITEMS.registerItem(
                        "paintbrush",
                        registryName -> new PaintbrushItem(new Item.Properties()
                                        .durability(64)
                                        .component(DataComponents.DAMAGE, 64)
                                        .component(DataComponentsRegistry.PAINT_COLOR.get(), DyeColor.WHITE)));

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PAINT_ITEMS = CREATIVE_TABS.register(
                        "cityparts_paint_items",
                        () -> CreativeModeTab.builder()
                                        .title(Component.translatable(
                                                        "itemGroup." + CityParts.MOD_ID + ".paint_items"))
                                        .icon(() -> PAINTBRUSH.get().getDefaultInstance())
                                        .displayItems((parameters, output) -> {
                                                output.accept(PAINTBRUSH.get());

                                                for (DyeColor color : DyeColor.values()) {
                                                        ItemStack stack = PAINTBRUSH.get().getDefaultInstance();
                                                        stack.set(DataComponentsRegistry.PAINT_COLOR.get(), color);
                                                        stack.setDamageValue(0);
                                                        output.accept(stack);
                                                }
                                        })
                                        .build());

        public static void registerItems(IEventBus modEventBus) {
                ITEMS.register(modEventBus);
                CREATIVE_TABS.register(modEventBus);
        };
}
