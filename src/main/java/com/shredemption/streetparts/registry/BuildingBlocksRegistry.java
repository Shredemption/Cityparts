package com.shredemption.streetparts.registry;

import com.shredemption.streetparts.StreetParts;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BuildingBlocksRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StreetParts.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StreetParts.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StreetParts.MOD_ID);

    public static final DeferredBlock<Block> ASPHALT =
            BLOCKS.registerSimpleBlock("asphalt", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK));

    public static final DeferredItem<BlockItem> ASPHALT_ITEM =
            ITEMS.registerSimpleBlockItem("asphalt", ASPHALT);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BUILDING_BLOCKS =
            CREATIVE_TABS.register("building_blocks", () -> CreativeModeTab.builder()
                    .title(net.minecraft.network.chat.Component.translatable("itemGroup.streetparts.building_blocks"))
                    .displayItems((params, output) -> {
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);
    }
}
