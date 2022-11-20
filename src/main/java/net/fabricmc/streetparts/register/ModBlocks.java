package net.fabricmc.streetparts.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.streetparts.StreetParts;
import net.fabricmc.streetparts.custom.HRotBlock;
import net.fabricmc.streetparts.custom.ModStairsBlock;
import net.fabricmc.streetparts.custom.RoadBlock;
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

    public static final Block GRAY_BRICKS = registerBlock("gray_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock GRAY_BRICKS_STAIRS = registerStairsBlock("gray_bricks_stairs",
            new ModStairsBlock(ModBlocks.GRAY_BRICKS.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock GRAY_BRICKS_SLAB = registerSlabBlock("gray_bricks_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final Block BROWN_BRICKS = registerBlock("brown_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock BROWN_BRICKS_STAIRS = registerStairsBlock("brown_bricks_stairs",
            new ModStairsBlock(ModBlocks.BROWN_BRICKS.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock BROWN_BRICKS_SLAB = registerSlabBlock("brown_bricks_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final Block SANDSTONE_BRICKS = registerBlock("sandstone_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final ModStairsBlock SANDSTONE_BRICKS_STAIRS = registerStairsBlock("sandstone_bricks_stairs",
            new ModStairsBlock(ModBlocks.SANDSTONE_BRICKS.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock SANDSTONE_BRICKS_SLAB = registerSlabBlock("sandstone_bricks_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);

    public static final HRotBlock ASPHALT = registerHRotBlock("asphalt",
            new HRotBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock ASPHALT_SLAB = registerSlabBlock("asphalt_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final HRotBlock RED_ASPHALT = registerHRotBlock("red_asphalt",
            new HRotBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock RED_ASPHALT_SLAB = registerSlabBlock("red_asphalt_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);

    public static final RoadBlock ROADLINES_MIDLINE = registerRoadBlock("roadlines_midline",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_SIDELINE = registerRoadBlock("roadlines_sideline",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_STRAIGHTARROW = registerRoadBlock("roadlines_straightarrow",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_INNERCORNER = registerRoadBlock("roadlines_innercorner",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_OUTERCORNER = registerRoadBlock("roadlines_outercorner",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_TSPLITMID = registerRoadBlock("roadlines_tsplitmid",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_JCORNER = registerRoadBlock("roadlines_jcorner",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_LCORNER = registerRoadBlock("roadlines_lcorner",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_TSPLITSHORT = registerRoadBlock("roadlines_tsplitshort",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_LEFTARROW = registerRoadBlock("roadlines_leftarrow",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_RIGHTARROW = registerRoadBlock("roadlines_rightarrow",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_LEFTRIGHTARROW = registerRoadBlock("roadlines_leftrightarrow",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_LEFTSUBARROW = registerRoadBlock("roadlines_leftsubarrow",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_RIGHTSUBARROW = registerRoadBlock("roadlines_rightsubarrow",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_HALFLINE = registerRoadBlock("roadlines_halfline",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_MIDDLECORNER = registerRoadBlock("roadlines_middlecorner",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_CORNERCROSS = registerRoadBlock("roadlines_cornercross",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_SHORTLEFTT = registerRoadBlock("roadlines_shortleftt",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_SHORTRIGHTT = registerRoadBlock("roadlines_shortrightt",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_TALLLEFTT = registerRoadBlock("roadlines_tallleftt",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_TALLRIGHTT = registerRoadBlock("roadlines_tallrightt",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_LEFTRIGHTSUBARROW = registerRoadBlock("roadlines_leftrightsubarrow",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_SHARKTOOTH = registerRoadBlock("roadlines_sharktooth",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);
    public static final RoadBlock ROADLINES_PEDESTRIAN_CROSSING = registerRoadBlock("roadlines_pedestrian_crossing",
            new RoadBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.ROADLINES);


    public static final HRotBlock H_ROT_TEST = registerHRotBlock("h_rot_test",
            new HRotBlock(FabricBlockSettings.of(Material.STONE).strength(-1f).requiresTool()), ModItemGroup.TEST);

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
    private static HRotBlock registerHRotBlock(String name, HRotBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static RoadBlock registerRoadBlock(String name, RoadBlock block, ItemGroup group) {
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
