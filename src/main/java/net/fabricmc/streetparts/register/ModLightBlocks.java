package net.fabricmc.streetparts.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.streetparts.StreetParts;
import net.fabricmc.streetparts.custom.*;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModLightBlocks {
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
    private static LightBlock registerLightBlock(String name, LightBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(StreetParts.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModLightBlocks() {
        StreetParts.LOGGER.debug("Registering Light Blocks for " + StreetParts.MOD_ID);
    }
}
