package com.shredemption.streetparts.registry;

import com.shredemption.streetparts.StreetParts;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BuildingBlocksRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StreetParts.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StreetParts.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StreetParts.MOD_ID);

    public static DeferredBlock<Block> registerBlock(String name, Supplier<Block> blockSupplier) {
        DeferredBlock<Block> block = BLOCKS.register(name, blockSupplier);
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static final DeferredBlock<Block> ASPHALT = registerBlock("asphalt",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f)));

    public static final DeferredBlock<Block> RED_ASPHALT = registerBlock("red_asphalt",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f)));

    public static final DeferredBlock<Block> STONE_PAVEMENT = registerBlock("stone_pavement",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f)));

    public static final DeferredBlock<Block> ANDESITE_PAVEMENT = registerBlock("andesite_pavement",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f)));

    public static final DeferredBlock<Block> DIORITE_PAVEMENT = registerBlock("diorite_pavement",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f)));

    public static final DeferredBlock<Block> GRANITE_PAVEMENT = registerBlock("granite_pavement",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f)));

    public static final DeferredBlock<Block> GRAY_BRICKS = registerBlock("gray_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f)));

    public static final DeferredBlock<Block> BROWN_BRICKS = registerBlock("brown_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f)));

    public static final DeferredBlock<Block> SANDSTONE_BRICKS = registerBlock("sandstone_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f)));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BUILDING_BLOCKS =
            CREATIVE_TABS.register("building_blocks", () -> CreativeModeTab.builder()
                    .title(net.minecraft.network.chat.Component.translatable("itemGroup.streetparts.building_blocks"))
                    .icon(() -> STONE_PAVEMENT.asItem().getDefaultInstance())
                    .displayItems((params, output) -> {
                        BLOCKS.getEntries().forEach(entry -> output.accept(entry.get().asItem()));
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);
    }
}
