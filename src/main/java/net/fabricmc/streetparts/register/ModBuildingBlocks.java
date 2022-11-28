package net.fabricmc.streetparts.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.streetparts.StreetParts;
import net.fabricmc.streetparts.custom.ModStairsBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBuildingBlocks {
    public static final Block STONE_PAVEMENT = registerBlock("stone_pavement",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock STONE_PAVEMENT_STAIRS = registerStairsBlock("stone_pavement_stairs",
            new ModStairsBlock(ModBuildingBlocks.STONE_PAVEMENT.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock STONE_PAVEMENT_SLAB = registerSlabBlock("stone_pavement_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);

    public static final Block ANDESITE_PAVEMENT = registerBlock("andesite_pavement",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock ANDESITE_PAVEMENT_STAIRS = registerStairsBlock("andesite_pavement_stairs",
            new ModStairsBlock(ModBuildingBlocks.ANDESITE_PAVEMENT.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock ANDESITE_PAVEMENT_SLAB = registerSlabBlock("andesite_pavement_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);

    public static final Block DIORITE_PAVEMENT = registerBlock("diorite_pavement",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock DIORITE_PAVEMENT_STAIRS = registerStairsBlock("diorite_pavement_stairs",
            new ModStairsBlock(ModBuildingBlocks.DIORITE_PAVEMENT.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock DIORITE_PAVEMENT_SLAB = registerSlabBlock("diorite_pavement_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);

    public static final Block GRANITE_PAVEMENT = registerBlock("granite_pavement",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock GRANITE_PAVEMENT_STAIRS = registerStairsBlock("granite_pavement_stairs",
            new ModStairsBlock(ModBuildingBlocks.GRANITE_PAVEMENT.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock GRANITE_PAVEMENT_SLAB = registerSlabBlock("granite_pavement_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);

    public static final Block GRAY_BRICKS = registerBlock("gray_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock GRAY_BRICKS_STAIRS = registerStairsBlock("gray_bricks_stairs",
            new ModStairsBlock(ModBuildingBlocks.GRAY_BRICKS.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock GRAY_BRICKS_SLAB = registerSlabBlock("gray_bricks_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final Block BROWN_BRICKS = registerBlock("brown_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock BROWN_BRICKS_STAIRS = registerStairsBlock("brown_bricks_stairs",
            new ModStairsBlock(ModBuildingBlocks.BROWN_BRICKS.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock BROWN_BRICKS_SLAB = registerSlabBlock("brown_bricks_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final Block SANDSTONE_BRICKS = registerBlock("sandstone_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock SANDSTONE_BRICKS_STAIRS = registerStairsBlock("sandstone_bricks_stairs",
            new ModStairsBlock(ModBuildingBlocks.SANDSTONE_BRICKS.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock SANDSTONE_BRICKS_SLAB = registerSlabBlock("sandstone_bricks_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);

    public static final Block ASPHALT = registerBlock("asphalt",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock ASPHALT_SLAB = registerSlabBlock("asphalt_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final Block RED_ASPHALT = registerBlock("red_asphalt",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock RED_ASPHALT_SLAB = registerSlabBlock("red_asphalt_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static ModStairsBlock registerStairsBlock(String name, ModStairsBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static SlabBlock registerSlabBlock(String name, SlabBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(StreetParts.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModBuildingBlocks() {
        StreetParts.LOGGER.debug("Registering Building Blocks for " + StreetParts.MOD_ID);
    }
}
