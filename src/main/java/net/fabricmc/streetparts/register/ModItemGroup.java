package net.fabricmc.streetparts.register;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.streetparts.StreetParts;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroup {
    public static final ItemGroup MAIN = Registry.register(Registries.ITEM_GROUP,
            new Identifier(StreetParts.MOD_ID, "main"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBuildingBlocks.ANDESITE_PAVEMENT))
                    .displayName(Text.translatable("itemgroup.streetparts.main"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBuildingBlocks.ASPHALT);
                        entries.add(ModBuildingBlocks.ASPHALT_SLAB);
                        entries.add(ModBuildingBlocks.RED_ASPHALT);
                        entries.add(ModBuildingBlocks.RED_ASPHALT_SLAB);
                        entries.add(ModBuildingBlocks.STONE_PAVEMENT);
                        entries.add(ModBuildingBlocks.STONE_PAVEMENT_STAIRS);
                        entries.add(ModBuildingBlocks.STONE_PAVEMENT_SLAB);
                        entries.add(ModBuildingBlocks.ANDESITE_PAVEMENT);
                        entries.add(ModBuildingBlocks.ANDESITE_PAVEMENT_STAIRS);
                        entries.add(ModBuildingBlocks.ANDESITE_PAVEMENT_SLAB);
                        entries.add(ModBuildingBlocks.DIORITE_PAVEMENT);
                        entries.add(ModBuildingBlocks.DIORITE_PAVEMENT_STAIRS);
                        entries.add(ModBuildingBlocks.DIORITE_PAVEMENT_SLAB);
                        entries.add(ModBuildingBlocks.GRANITE_PAVEMENT);
                        entries.add(ModBuildingBlocks.GRANITE_PAVEMENT_STAIRS);
                        entries.add(ModBuildingBlocks.GRANITE_PAVEMENT_SLAB);
                        entries.add(ModBuildingBlocks.GRAY_BRICKS);
                        entries.add(ModBuildingBlocks.GRAY_BRICKS_STAIRS);
                        entries.add(ModBuildingBlocks.GRAY_BRICKS_SLAB);
                        entries.add(ModBuildingBlocks.BROWN_BRICKS);
                        entries.add(ModBuildingBlocks.BROWN_BRICKS_STAIRS);
                        entries.add(ModBuildingBlocks.BROWN_BRICKS_SLAB);
                        entries.add(ModBuildingBlocks.SANDSTONE_BRICKS);
                        entries.add(ModBuildingBlocks.SANDSTONE_BRICKS_STAIRS);
                        entries.add(ModBuildingBlocks.SANDSTONE_BRICKS_SLAB);
                    }).build());

    public static ItemGroup SIGNS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(StreetParts.MOD_ID, "signs"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModSignBlocks.SIGN_ROUND_STOP))
                    .displayName(Text.translatable("itemgroup.streetparts.signs"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModSignBlocks.SIGN_ROUND_STOP);
                        entries.add(ModSignBlocks.SIGN_TRIA_WARNING);
                        entries.add(ModSignBlocks.SIGN_NO_ENTRY);
                        entries.add(ModSignBlocks.SIGN_ROUNDABOUT);
                        entries.add(ModSignBlocks.SIGN_RIGHT_PASS);

                        entries.add(ModSignBlocks.SIGN_RND_ARROW_L);
                        entries.add(ModSignBlocks.SIGN_SQR_ARROW_L);

                        entries.add(ModSignBlocks.SIGN_RND_ARROW_F);
                        entries.add(ModSignBlocks.SIGN_SQR_ARROW_F);

                        entries.add(ModSignBlocks.SIGN_RND_ARROW_R);
                        entries.add(ModSignBlocks.SIGN_SQR_ARROW_R);

                        entries.add(ModSignBlocks.SIGN_RND_ARROW_FL);
                        entries.add(ModSignBlocks.SIGN_SQR_ARROW_FL);

                        entries.add(ModSignBlocks.SIGN_RND_ARROW_FR);
                        entries.add(ModSignBlocks.SIGN_SQR_ARROW_FR);

                        entries.add(ModSignBlocks.SIGN_RND_ARROW_RL);
                        entries.add(ModSignBlocks.SIGN_SQR_ARROW_RL);
                    }).build());

    public static ItemGroup ROADLINES = Registry.register(Registries.ITEM_GROUP,
            new Identifier(StreetParts.MOD_ID, "roadlines"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.streetparts.roadlines"))
                    .icon(() -> new ItemStack(ModBuildingBlocks.ASPHALT))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBuildingBlocks.ASPHALT);
                        entries.add(ModBuildingBlocks.ASPHALT_SLAB);
                        entries.add(ModRoadBlocks.ROADLINES_MIDLINE);
                        entries.add(ModRoadBlocks.ROADLINES_SIDELINE);
                        entries.add(ModRoadBlocks.ROADLINES_STRAIGHTARROW);
                        entries.add(ModRoadBlocks.ROADLINES_INNERCORNER);
                        entries.add(ModRoadBlocks.ROADLINES_OUTERCORNER);
                        entries.add(ModRoadBlocks.ROADLINES_TSPLITMID);
                        entries.add(ModRoadBlocks.ROADLINES_JCORNER);
                        entries.add(ModRoadBlocks.ROADLINES_LCORNER);
                        entries.add(ModRoadBlocks.ROADLINES_TSPLITSHORT);
                        entries.add(ModRoadBlocks.ROADLINES_LEFTARROW);
                        entries.add(ModRoadBlocks.ROADLINES_RIGHTARROW);
                        entries.add(ModRoadBlocks.ROADLINES_LEFTRIGHTARROW);
                        entries.add(ModRoadBlocks.ROADLINES_LEFTSUBARROW);
                        entries.add(ModRoadBlocks.ROADLINES_RIGHTSUBARROW);
                        entries.add(ModRoadBlocks.ROADLINES_HALFLINE);
                        entries.add(ModRoadBlocks.ROADLINES_MIDDLECORNER);
                        entries.add(ModRoadBlocks.ROADLINES_CORNERCROSS);
                        entries.add(ModRoadBlocks.ROADLINES_SHORTLEFTT);
                        entries.add(ModRoadBlocks.ROADLINES_SHORTRIGHTT);
                        entries.add(ModRoadBlocks.ROADLINES_TALLLEFTT);
                        entries.add(ModRoadBlocks.ROADLINES_TALLRIGHTT);
                        entries.add(ModRoadBlocks.ROADLINES_LEFTRIGHTSUBARROW);
                        entries.add(ModRoadBlocks.ROADLINES_SHARKTOOTH);
                        entries.add(ModRoadBlocks.ROADLINES_PEDESTRIAN_CROSSING);

                    }).build());

    public static ItemGroup LIGHTS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(StreetParts.MOD_ID, "lights"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.streetparts.lights"))
                    .icon(() -> new ItemStack(ModLightBlocks.BLACK_LIGHT_POST))
                    .entries((displayContext, entries) -> {
                        entries.add(ModLightBlocks.BLACK_LIGHT_POST);
                        entries.add(ModLightBlocks.BLACK_LIGHT_ARM);
                        entries.add(ModLightBlocks.BLACK_LIGHT_CORNER);
                        entries.add(ModLightBlocks.BLACK_LIGHT_L_CORNER);
                        entries.add(ModLightBlocks.BLACK_LIGHT_T);
                        entries.add(ModLightBlocks.BLACK_LIGHT_LIGHT);

                        entries.add(ModLightBlocks.WHITE_LIGHT_POST);
                        entries.add(ModLightBlocks.WHITE_LIGHT_ARM);
                        entries.add(ModLightBlocks.WHITE_LIGHT_CORNER);
                        entries.add(ModLightBlocks.WHITE_LIGHT_L_CORNER);
                        entries.add(ModLightBlocks.WHITE_LIGHT_T);
                        entries.add(ModLightBlocks.WHITE_LIGHT_LIGHT);

                        entries.add(ModLightBlocks.GRAY_LIGHT_POST);
                        entries.add(ModLightBlocks.GRAY_LIGHT_ARM);
                        entries.add(ModLightBlocks.GRAY_LIGHT_CORNER);
                        entries.add(ModLightBlocks.GRAY_LIGHT_L_CORNER);
                        entries.add(ModLightBlocks.GRAY_LIGHT_T);
                        entries.add(ModLightBlocks.GRAY_LIGHT_LIGHT);

                        entries.add(ModLightBlocks.GREEN_LIGHT_POST);
                        entries.add(ModLightBlocks.GREEN_LIGHT_ARM);
                        entries.add(ModLightBlocks.GREEN_LIGHT_CORNER);
                        entries.add(ModLightBlocks.GREEN_LIGHT_L_CORNER);
                        entries.add(ModLightBlocks.GREEN_LIGHT_T);
                        entries.add(ModLightBlocks.GREEN_LIGHT_LIGHT);

                        entries.add(ModBlocks.TRAFFIC_LIGHT);
                        entries.add(ModBlocks.STRIPED_POST);
                    }).build());

    public static ItemGroup PARTS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(StreetParts.MOD_ID, "parts"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.streetparts.parts"))
                    .icon(() -> new ItemStack(ModBlocks.TRAFFIC_CONE))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.TRAFFIC_CONE);
                        entries.add(ModBlocks.GUARD_RAIL);
                        entries.add(ModBlocks.STRIPED_POST);
                        entries.add(ModBlocks.TRAFFIC_LIGHT);
                        entries.add(ModBlocks.DIRECTION_SIGN);

                    }).build());
    public static void registerItemGroups() {
        StreetParts.LOGGER.info("Registering Item Groups for " + StreetParts.MOD_ID);
    }
}
