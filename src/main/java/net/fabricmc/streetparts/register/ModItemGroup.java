package net.fabricmc.streetparts.register;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.streetparts.StreetParts;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup MAIN = FabricItemGroupBuilder.build(new Identifier(StreetParts.MOD_ID, "main"), () -> new ItemStack(ModBuildingBlocks.STONE_PAVEMENT));
    public static final ItemGroup ROADLINES = FabricItemGroupBuilder.build(new Identifier(StreetParts.MOD_ID, "roadlines"), () -> new ItemStack(ModBuildingBlocks.ASPHALT));
    public static final ItemGroup LIGHTS = FabricItemGroupBuilder.build(new Identifier(StreetParts.MOD_ID, "lights"), () -> new ItemStack(ModLightBlocks.BLACK_LIGHT_POST));
    public static final ItemGroup SIGNS = FabricItemGroupBuilder.build(new Identifier(StreetParts.MOD_ID, "signs"), () -> new ItemStack(ModSignBlocks.SIGN_ROUND_STOP));
    public static final ItemGroup PARTS = FabricItemGroupBuilder.build(new Identifier(StreetParts.MOD_ID, "other"), () -> new ItemStack(ModBlocks.TRAFFIC_CONE));
    public static final ItemGroup TEST = FabricItemGroupBuilder.build(new Identifier(StreetParts.MOD_ID, "test"), () -> new ItemStack(ModItems.LINE_PAINTER));
}
