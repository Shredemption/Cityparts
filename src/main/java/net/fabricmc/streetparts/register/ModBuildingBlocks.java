package net.fabricmc.streetparts.register;

import net.fabricmc.streetparts.StreetParts;
import net.fabricmc.streetparts.custom.ModStairsBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBuildingBlocks {
    public static final Block STONE_PAVEMENT = registerBlock("stone_pavement",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final ModStairsBlock STONE_PAVEMENT_STAIRS = registerStairsBlock("stone_pavement_stairs",
            new ModStairsBlock(ModBuildingBlocks.STONE_PAVEMENT.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SlabBlock STONE_PAVEMENT_SLAB = registerSlabBlock("stone_pavement_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));

    public static final Block ANDESITE_PAVEMENT = registerBlock("andesite_pavement",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final ModStairsBlock ANDESITE_PAVEMENT_STAIRS = registerStairsBlock("andesite_pavement_stairs",
            new ModStairsBlock(ModBuildingBlocks.ANDESITE_PAVEMENT.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SlabBlock ANDESITE_PAVEMENT_SLAB = registerSlabBlock("andesite_pavement_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));

    public static final Block DIORITE_PAVEMENT = registerBlock("diorite_pavement",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final ModStairsBlock DIORITE_PAVEMENT_STAIRS = registerStairsBlock("diorite_pavement_stairs",
            new ModStairsBlock(ModBuildingBlocks.DIORITE_PAVEMENT.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SlabBlock DIORITE_PAVEMENT_SLAB = registerSlabBlock("diorite_pavement_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));

    public static final Block GRANITE_PAVEMENT = registerBlock("granite_pavement",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final ModStairsBlock GRANITE_PAVEMENT_STAIRS = registerStairsBlock("granite_pavement_stairs",
            new ModStairsBlock(ModBuildingBlocks.GRANITE_PAVEMENT.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SlabBlock GRANITE_PAVEMENT_SLAB = registerSlabBlock("granite_pavement_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));

    public static final Block GRAY_BRICKS = registerBlock("gray_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final ModStairsBlock GRAY_BRICKS_STAIRS = registerStairsBlock("gray_bricks_stairs",
            new ModStairsBlock(ModBuildingBlocks.GRAY_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SlabBlock GRAY_BRICKS_SLAB = registerSlabBlock("gray_bricks_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final Block BROWN_BRICKS = registerBlock("brown_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final ModStairsBlock BROWN_BRICKS_STAIRS = registerStairsBlock("brown_bricks_stairs",
            new ModStairsBlock(ModBuildingBlocks.BROWN_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SlabBlock BROWN_BRICKS_SLAB = registerSlabBlock("brown_bricks_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final Block SANDSTONE_BRICKS = registerBlock("sandstone_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final ModStairsBlock SANDSTONE_BRICKS_STAIRS = registerStairsBlock("sandstone_bricks_stairs",
            new ModStairsBlock(ModBuildingBlocks.SANDSTONE_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SlabBlock SANDSTONE_BRICKS_SLAB = registerSlabBlock("sandstone_bricks_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));

    public static final Block ASPHALT = registerBlock("asphalt",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SlabBlock ASPHALT_SLAB = registerSlabBlock("asphalt_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final Block RED_ASPHALT = registerBlock("red_asphalt",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SlabBlock RED_ASPHALT_SLAB = registerSlabBlock("red_asphalt_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StreetParts.MOD_ID, name), block);
    }
    private static ModStairsBlock registerStairsBlock(String name, ModStairsBlock block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StreetParts.MOD_ID, name), block);
    }
    private static SlabBlock registerSlabBlock(String name, SlabBlock block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StreetParts.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(StreetParts.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBuildingBlocks() {
        StreetParts.LOGGER.debug("Registering Building Blocks for " + StreetParts.MOD_ID);
    }
}
