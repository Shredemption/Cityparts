package net.fabricmc.streetparts.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.streetparts.StreetParts;
import net.fabricmc.streetparts.custom.SignBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSignBlocks {
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

    private static SignBlock registerSignBlock(String name, SignBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(StreetParts.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModSignBlocks() {
        StreetParts.LOGGER.debug("Registering Sign Blocks for " + StreetParts.MOD_ID);
    }
}
