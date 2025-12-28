package com.shredemption.cityparts.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

import com.shredemption.cityparts.CityParts;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class ConstructionBlocksRegistry {
        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CityParts.MOD_ID);
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CityParts.MOD_ID);
        public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, CityParts.MOD_ID);

        public enum BlockSetType {
                FULL, // block + slab + stairs + wall
                SLAB, // block + slab
                STAIR_ONLY, // stairs only
        }

        private static final List<DeferredBlock<? extends Block>> REGISTERED_BLOCKS = new ArrayList<>();

        private static void registerBuildingSet(String name, BlockBehaviour.Properties props, BlockSetType type) {
                // Base block
                DeferredBlock<Block> base = BLOCKS.register(name, () -> new Block(props));
                ITEMS.register(name, () -> new BlockItem(base.get(), new Item.Properties()));
                REGISTERED_BLOCKS.add(base);

                // Stairs
                if (type == BlockSetType.FULL) {
                        DeferredBlock<StairBlock> stairs = BLOCKS.register(name + "_stairs",
                                        () -> new StairBlock(base.get().defaultBlockState(), props));
                        ITEMS.register(name + "_stairs", () -> new BlockItem(stairs.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(stairs);
                }

                // Slab
                if (type == BlockSetType.FULL || type == BlockSetType.SLAB) {
                        DeferredBlock<SlabBlock> slab = BLOCKS.register(name + "_slab", () -> new SlabBlock(props));
                        ITEMS.register(name + "_slab", () -> new BlockItem(slab.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(slab);
                }

                // Wall
                if (type == BlockSetType.FULL) {
                        DeferredBlock<WallBlock> wall = BLOCKS.register(name + "_wall", () -> new WallBlock(props));
                        ITEMS.register(name + "_wall", () -> new BlockItem(wall.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(wall);
                }
        }

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CONSTRUCTION_BLOCKS_TAB = CREATIVE_TABS
                        .register("cityparts_construction_blocks", () -> CreativeModeTab.builder()
                                        .title(Component.translatable("itemGroup.cityparts.construction_blocks"))
                                        .icon(() -> net.minecraft.core.registries.BuiltInRegistries.ITEM
                                                        .get(fromNamespaceAndPath(CityParts.MOD_ID, "stone_pavement"))
                                                        .getDefaultInstance())
                                        .displayItems((params, output) -> {
                                                REGISTERED_BLOCKS.forEach(entry -> output.accept(entry.get().asItem()));
                                        })
                                        .build());

        public static void registerConstructionBlocks(IEventBus modEventBus) {
                BLOCKS.register(modEventBus);
                ITEMS.register(modEventBus);
                CREATIVE_TABS.register(modEventBus);

                registerBuildingSet("asphalt",
                                BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(2.0f),
                                BlockSetType.SLAB);
                registerBuildingSet("red_asphalt",
                                BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0f),
                                BlockSetType.SLAB);

                registerBuildingSet("stone_pavement",
                                BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.8f),
                                BlockSetType.FULL);
                registerBuildingSet("andesite_pavement",
                                BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.8f),
                                BlockSetType.FULL);
                registerBuildingSet("diorite_pavement",
                                BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).strength(1.8f),
                                BlockSetType.FULL);
                registerBuildingSet("granite_pavement",
                                BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1.8f),
                                BlockSetType.FULL);
                registerBuildingSet("deepslate_pavement",
                                BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(2.0f),
                                BlockSetType.FULL);

                registerBuildingSet("sandstone_bricks",
                                BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(2.0f),
                                BlockSetType.FULL);
                registerBuildingSet("brown_bricks",
                                BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0f),
                                BlockSetType.FULL);
                registerBuildingSet("maroon_bricks",
                                BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).strength(2.0f),
                                BlockSetType.FULL);
                registerBuildingSet("green_bricks",
                                BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).strength(2.0f),
                                BlockSetType.FULL);
                registerBuildingSet("blue_bricks",
                                BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).strength(2.0f),
                                BlockSetType.FULL);
                registerBuildingSet("white_bricks",
                                BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(2.0f),
                                BlockSetType.FULL);
                registerBuildingSet("gray_bricks",
                                BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(2.0f),
                                BlockSetType.FULL);
                registerBuildingSet("black_bricks",
                                BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f),
                                BlockSetType.FULL);
                registerBuildingSet("beige_bricks",
                                BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).strength(2.0f),
                                BlockSetType.FULL);

                // String redRoofTilesName = "red_roof_tiles";
                // DeferredBlock<StairBlock> redRoofTiles = BLOCKS.register(redRoofTilesName,
                //                 () -> new StairBlock(Blocks.STONE.defaultBlockState(),
                //                                 Properties.of().mapColor(MapColor.CRIMSON_HYPHAE).strength(2.0f)));
                // ITEMS.register(redRoofTilesName, () -> new BlockItem(redRoofTiles.get(), new Item.Properties()));
                // REGISTERED_BLOCKS.add(redRoofTiles);

                // String hayRoofName = "hay_roof";
                // DeferredBlock<StairBlock> hayRoof = BLOCKS.register(hayRoofName,
                //                 () -> new StairBlock(Blocks.STONE.defaultBlockState(),
                //                                 Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(2.0f)));
                // ITEMS.register(hayRoofName, () -> new BlockItem(hayRoof.get(), new Item.Properties()));
                // REGISTERED_BLOCKS.add(hayRoof);
        }
}
