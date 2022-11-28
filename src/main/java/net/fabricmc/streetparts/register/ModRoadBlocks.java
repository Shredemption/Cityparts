package net.fabricmc.streetparts.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.streetparts.StreetParts;
import net.fabricmc.streetparts.custom.RoadBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRoadBlocks {
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

    private static RoadBlock registerRoadBlock(String name, RoadBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(StreetParts.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModRoadBlocks() {
        StreetParts.LOGGER.debug("Registering Mod Road Blocks for " + StreetParts.MOD_ID);
    }
}
