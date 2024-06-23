package net.fabricmc.streetparts.register;

import net.fabricmc.streetparts.StreetParts;
import net.fabricmc.streetparts.custom.RoadBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRoadBlocks {
    public static final RoadBlock ROADLINES_MIDLINE = registerRoadBlock("roadlines_midline",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_SIDELINE = registerRoadBlock("roadlines_sideline",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_STRAIGHTARROW = registerRoadBlock("roadlines_straightarrow",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_INNERCORNER = registerRoadBlock("roadlines_innercorner",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_OUTERCORNER = registerRoadBlock("roadlines_outercorner",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_TSPLITMID = registerRoadBlock("roadlines_tsplitmid",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_JCORNER = registerRoadBlock("roadlines_jcorner",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_LCORNER = registerRoadBlock("roadlines_lcorner",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_TSPLITSHORT = registerRoadBlock("roadlines_tsplitshort",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_LEFTARROW = registerRoadBlock("roadlines_leftarrow",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_RIGHTARROW = registerRoadBlock("roadlines_rightarrow",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_LEFTRIGHTARROW = registerRoadBlock("roadlines_leftrightarrow",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_LEFTSUBARROW = registerRoadBlock("roadlines_leftsubarrow",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_RIGHTSUBARROW = registerRoadBlock("roadlines_rightsubarrow",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_HALFLINE = registerRoadBlock("roadlines_halfline",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_MIDDLECORNER = registerRoadBlock("roadlines_middlecorner",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_CORNERCROSS = registerRoadBlock("roadlines_cornercross",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_SHORTLEFTT = registerRoadBlock("roadlines_shortleftt",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_SHORTRIGHTT = registerRoadBlock("roadlines_shortrightt",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_TALLLEFTT = registerRoadBlock("roadlines_tallleftt",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_TALLRIGHTT = registerRoadBlock("roadlines_tallrightt",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_LEFTRIGHTSUBARROW = registerRoadBlock("roadlines_leftrightsubarrow",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_SHARKTOOTH = registerRoadBlock("roadlines_sharktooth",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final RoadBlock ROADLINES_PEDESTRIAN_CROSSING = registerRoadBlock("roadlines_pedestrian_crossing",
            new RoadBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));

    private static RoadBlock registerRoadBlock(String name, RoadBlock block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StreetParts.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(StreetParts.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModRoadBlocks() {
        StreetParts.LOGGER.debug("Registering Mod Road Blocks for " + StreetParts.MOD_ID);
    }
}
