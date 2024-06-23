package net.fabricmc.streetparts.register;

import net.fabricmc.streetparts.StreetParts;
import net.fabricmc.streetparts.custom.SignBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModSignBlocks {
    public static final SignBlock SIGN_ROUND_STOP = registerSignBlock("sign_round_stop",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_TRIA_WARNING = registerSignBlock("sign_tria_warning",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_NO_ENTRY = registerSignBlock("sign_no_entry",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_RND_ARROW_L = registerSignBlock("sign_rnd_arrow_l",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_RND_ARROW_F = registerSignBlock("sign_rnd_arrow_f",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_RND_ARROW_R = registerSignBlock("sign_rnd_arrow_r",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_RND_ARROW_FL = registerSignBlock("sign_rnd_arrow_fl",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_RND_ARROW_FR = registerSignBlock("sign_rnd_arrow_fr",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_RND_ARROW_RL = registerSignBlock("sign_rnd_arrow_rl",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_SQR_ARROW_L = registerSignBlock("sign_sqr_arrow_l",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_SQR_ARROW_F = registerSignBlock("sign_sqr_arrow_f",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_SQR_ARROW_R = registerSignBlock("sign_sqr_arrow_r",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_SQR_ARROW_FL = registerSignBlock("sign_sqr_arrow_fl",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_SQR_ARROW_FR = registerSignBlock("sign_sqr_arrow_fr",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_SQR_ARROW_RL = registerSignBlock("sign_sqr_arrow_rl",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_ROUNDABOUT = registerSignBlock("sign_roundabout",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));
    public static final SignBlock SIGN_RIGHT_PASS = registerSignBlock("sign_right_pass",
            new SignBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(4f).requiresTool()));

    private static SignBlock registerSignBlock(String name, SignBlock block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StreetParts.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(StreetParts.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModSignBlocks() {
        StreetParts.LOGGER.debug("Registering Sign Blocks for " + StreetParts.MOD_ID);
    }
}
