package net.fabricmc.streetparts.register;

import com.google.common.util.concurrent.Striped;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.streetparts.StreetParts;
import net.fabricmc.streetparts.custom.*;
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

    public static final Block ASPHALT = registerBlock("asphalt",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final SlabBlock ASPHALT_SLAB = registerSlabBlock("asphalt_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
    public static final Block RED_ASPHALT = registerBlock("red_asphalt",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MAIN);
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

    public static final SignBlock SIGN_ROUND_STOP = registerSignBlock("sign_round_stop",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_TRIA_WARNING = registerSignBlock("sign_tria_warning",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_NO_ENTRY = registerSignBlock("sign_no_entry",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_RND_ARROW_L = registerSignBlock("sign_rnd_arrow_l",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_RND_ARROW_F = registerSignBlock("sign_rnd_arrow_f",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_RND_ARROW_R = registerSignBlock("sign_rnd_arrow_r",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_RND_ARROW_FL = registerSignBlock("sign_rnd_arrow_fl",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_RND_ARROW_FR = registerSignBlock("sign_rnd_arrow_fr",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_RND_ARROW_RL = registerSignBlock("sign_rnd_arrow_rl",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_SQR_ARROW_L = registerSignBlock("sign_sqr_arrow_l",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_SQR_ARROW_F = registerSignBlock("sign_sqr_arrow_f",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_SQR_ARROW_R = registerSignBlock("sign_sqr_arrow_r",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_SQR_ARROW_FL = registerSignBlock("sign_sqr_arrow_fl",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_SQR_ARROW_FR = registerSignBlock("sign_sqr_arrow_fr",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_SQR_ARROW_RL = registerSignBlock("sign_sqr_arrow_rl",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_ROUNDABOUT = registerSignBlock("sign_roundabout",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);
    public static final SignBlock SIGN_right_pass = registerSignBlock("sign_right_pass",
            new SignBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.SIGNS);

    public static final PostBlock BLACK_LIGHT_POST = registerPostBlock("black_light_post",
            new PostBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final ArmBlock BLACK_LIGHT_ARM = registerArmBlock("black_light_arm",
            new ArmBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final CornerBlock BLACK_LIGHT_CORNER = registerCornerBlock("black_light_corner",
            new CornerBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final LCornerBlock BLACK_LIGHT_L_CORNER = registerLCornerBlock("black_light_l_corner",
            new LCornerBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final TBlock BLACK_LIGHT_T = registerTBlock("black_light_t",
            new TBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final LightBlock BLACK_LIGHT_LIGHT = registerLightBlock("black_light_light",
            new LightBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool().luminance(15)), ModItemGroup.LIGHTS);

    public static final PostBlock GRAY_LIGHT_POST = registerPostBlock("gray_light_post",
            new PostBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final ArmBlock GRAY_LIGHT_ARM = registerArmBlock("gray_light_arm",
            new ArmBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final CornerBlock GRAY_LIGHT_CORNER = registerCornerBlock("gray_light_corner",
            new CornerBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final LCornerBlock GRAY_LIGHT_L_CORNER = registerLCornerBlock("gray_light_l_corner",
            new LCornerBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final TBlock GRAY_LIGHT_T = registerTBlock("gray_light_t",
            new TBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final LightBlock GRAY_LIGHT_LIGHT = registerLightBlock("gray_light_light",
            new LightBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool().luminance(15)), ModItemGroup.LIGHTS);

    public static final PostBlock WHITE_LIGHT_POST = registerPostBlock("white_light_post",
            new PostBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final ArmBlock WHITE_LIGHT_ARM = registerArmBlock("white_light_arm",
            new ArmBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final CornerBlock WHITE_LIGHT_CORNER = registerCornerBlock("white_light_corner",
            new CornerBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final LCornerBlock WHITE_LIGHT_L_CORNER = registerLCornerBlock("white_light_l_corner",
            new LCornerBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final TBlock WHITE_LIGHT_T = registerTBlock("white_light_t",
            new TBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final LightBlock WHITE_LIGHT_LIGHT = registerLightBlock("white_light_light",
            new LightBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool().luminance(15)), ModItemGroup.LIGHTS);

    public static final PostBlock GREEN_LIGHT_POST = registerPostBlock("green_light_post",
            new PostBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final ArmBlock GREEN_LIGHT_ARM = registerArmBlock("green_light_arm",
            new ArmBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final CornerBlock GREEN_LIGHT_CORNER = registerCornerBlock("green_light_corner",
            new CornerBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final LCornerBlock GREEN_LIGHT_L_CORNER = registerLCornerBlock("green_light_l_corner",
            new LCornerBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final TBlock GREEN_LIGHT_T = registerTBlock("green_light_t",
            new TBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final LightBlock GREEN_LIGHT_LIGHT = registerLightBlock("green_light_light",
            new LightBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool().luminance(15)), ModItemGroup.LIGHTS);

    public static final TrafficLight TRAFFIC_LIGHT = registerTrafficLight("traffic_light",
            new TrafficLight(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool().luminance(15)), ModItemGroup.LIGHTS);
    public static final StripedPostBlock STRIPED_POST = registerStripedPostBlock("striped_post",
            new StripedPostBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.LIGHTS);
    public static final DirectionSignBlock DIRECTION_SIGN = registerDirectionSignBlock("direction_sign",
            new DirectionSignBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.SIGNS);

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
    private static RoadBlock registerRoadBlock(String name, RoadBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static SignBlock registerSignBlock(String name, SignBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static PostBlock registerPostBlock(String name, PostBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static ArmBlock registerArmBlock(String name, ArmBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static CornerBlock registerCornerBlock(String name, CornerBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static LCornerBlock registerLCornerBlock(String name, LCornerBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static TBlock registerTBlock(String name, TBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static TrafficLight registerTrafficLight(String name, TrafficLight block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static LightBlock registerLightBlock(String name, LightBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static StripedPostBlock registerStripedPostBlock(String name, StripedPostBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static DirectionSignBlock registerDirectionSignBlock(String name, DirectionSignBlock block, ItemGroup group) {
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
