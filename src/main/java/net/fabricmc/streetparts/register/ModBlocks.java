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

public class ModBlocks {

    public static final Block STONE_PAVEMENT = registerBlock("stone_pavement",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock STONE_PAVEMENT_STAIRS = registerStairsBlock("stone_pavement_stairs",
            new ModStairsBlock(ModBlocks.STONE_PAVEMENT.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock STONE_PAVEMENT_SLAB = registerSlabBlock("stone_pavement_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);

    public static final Block ANDESITE_PAVEMENT = registerBlock("andesite_pavement",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock ANDESITE_PAVEMENT_STAIRS = registerStairsBlock("andesite_pavement_stairs",
            new ModStairsBlock(ModBlocks.ANDESITE_PAVEMENT.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock ANDESITE_PAVEMENT_SLAB = registerSlabBlock("andesite_pavement_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);

    public static final Block DIORITE_PAVEMENT = registerBlock("diorite_pavement",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock DIORITE_PAVEMENT_STAIRS = registerStairsBlock("diorite_pavement_stairs",
            new ModStairsBlock(ModBlocks.DIORITE_PAVEMENT.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock DIORITE_PAVEMENT_SLAB = registerSlabBlock("diorite_pavement_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);

    public static final Block GRANITE_PAVEMENT = registerBlock("granite_pavement",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock GRANITE_PAVEMENT_STAIRS = registerStairsBlock("granite_pavement_stairs",
            new ModStairsBlock(ModBlocks.GRANITE_PAVEMENT.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock GRANITE_PAVEMENT_SLAB = registerSlabBlock("granite_pavement_slab",
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
    public static void registerModBlocks() {
        StreetParts.LOGGER.debug("Registering ModBlocks for " + StreetParts.MOD_ID);
    }
}
