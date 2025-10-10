package com.shredemption.streetparts.registry;

import com.shredemption.streetparts.StreetParts;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class BuildingBlocksRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StreetParts.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StreetParts.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StreetParts.MOD_ID);

    private static final Map<String, BlockBehaviour.Properties> BUILDING_BLOCKS = new LinkedHashMap<>();

    static {
        BUILDING_BLOCKS.put("asphalt", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f));
        BUILDING_BLOCKS.put("red_asphalt", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f));
        BUILDING_BLOCKS.put("stone_pavement", BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.8f));
        BUILDING_BLOCKS.put("andesite_pavement", BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.8f));
        BUILDING_BLOCKS.put("diorite_pavement", BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.8f));
        BUILDING_BLOCKS.put("granite_pavement", BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.8f));
        BUILDING_BLOCKS.put("gray_bricks", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(2.0f));
        BUILDING_BLOCKS.put("brown_bricks", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0f));
        BUILDING_BLOCKS.put("sandstone_bricks", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(2.0f));
    }

    private static final List<DeferredBlock<? extends Block>> REGISTERED_BLOCKS = new ArrayList<>();

    private static void registerBuildingSet(String name, BlockBehaviour.Properties props) {
        // Base block
        DeferredBlock<Block> base = BLOCKS.register(name, () -> new Block(props));
        ITEMS.register(name, () -> new BlockItem(base.get(), new Item.Properties()));
        REGISTERED_BLOCKS.add(base);

        // Stairs
        DeferredBlock<StairBlock> stairs = BLOCKS.register(name + "_stairs",
                () -> new StairBlock(base.get().defaultBlockState(), props));
        ITEMS.register(name + "_stairs", () -> new BlockItem(stairs.get(), new Item.Properties()));
        REGISTERED_BLOCKS.add(stairs);

        // Slab
        DeferredBlock<SlabBlock> slab = BLOCKS.register(name + "_slab", () -> new SlabBlock(props));
        ITEMS.register(name + "_slab", () -> new BlockItem(slab.get(), new Item.Properties()));
        REGISTERED_BLOCKS.add(slab);
    }

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BUILDING_BLOCKS_TAB =
            CREATIVE_TABS.register("building_blocks", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.streetparts.building_blocks"))
                    .icon(() -> net.minecraft.core.registries.BuiltInRegistries.ITEM
                            .get(fromNamespaceAndPath(StreetParts.MOD_ID, "stone_pavement"))
                            .getDefaultInstance())
                    .displayItems((params, output) -> {
                        REGISTERED_BLOCKS.forEach(entry -> output.accept(entry.get().asItem()));
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);

        // Register each defined building block with slab + stairs
        BUILDING_BLOCKS.forEach(BuildingBlocksRegistry::registerBuildingSet);
    }
}
