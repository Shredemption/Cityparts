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

    public static ItemGroup MAIN = Registry.register(Registries.ITEM_GROUP, new Identifier(StreetParts.MOD_ID, "main"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.main")).icon(() -> new ItemStack(ModBuildingBlocks.STONE_PAVEMENT)).entries((displayContext, entries) -> {
                entries.add(ModBlocks.DIRECTION_SIGN);
            }).build());
    public static ItemGroup ROADLINES = Registry.register(Registries.ITEM_GROUP, new Identifier(StreetParts.MOD_ID, "roadlines"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.roadlines")).icon(() -> new ItemStack(ModBuildingBlocks.ASPHALT)).entries((displayContext, entries) -> {
                entries.add(ModBuildingBlocks.ASPHALT);
            }).build());
    public static ItemGroup LIGHTS = Registry.register(Registries.ITEM_GROUP, new Identifier(StreetParts.MOD_ID, "lights"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.lights")).icon(() -> new ItemStack(ModLightBlocks.BLACK_LIGHT_POST)).entries((displayContext, entries) -> {
                entries.add(ModLightBlocks.BLACK_LIGHT_POST);
            }).build());
    public static ItemGroup SIGNS = Registry.register(Registries.ITEM_GROUP, new Identifier(StreetParts.MOD_ID, "signs"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.signs")).icon(() -> new ItemStack(ModSignBlocks.SIGN_ROUND_STOP)).entries((displayContext, entries) -> {
                entries.add(ModSignBlocks.SIGN_ROUND_STOP);
            }).build());
    public static ItemGroup PARTS = Registry.register(Registries.ITEM_GROUP, new Identifier(StreetParts.MOD_ID, "parts"),
        FabricItemGroup.builder().displayName(Text.translatable("itemgroup.parts")).icon(() -> new ItemStack(ModBlocks.TRAFFIC_CONE)).entries((displayContext, entries) -> {
            entries.add(ModBlocks.TRAFFIC_CONE);
        }).build());
    public static ItemGroup GEN = Registry.register(Registries.ITEM_GROUP, new Identifier(StreetParts.MOD_ID, "gen"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.gen")).icon(() -> new ItemStack(ModItems.LINE_PAINTER)).entries((displayContext, entries) -> {
                entries.add(ModItems.LINE_PAINTER);
            }).build());
    public static ItemGroup TEST = Registry.register(Registries.ITEM_GROUP, new Identifier(StreetParts.MOD_ID, "test"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.test")).icon(() -> new ItemStack(ModItems.LINE_PAINTER)).entries((displayContext, entries) -> {
                entries.add(ModItems.LINE_PAINTER);
            }).build());
}
