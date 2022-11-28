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

public class ModBlocks {

    public static final TrafficConeBlock TRAFFIC_CONE = registerTrafficConeBlock("traffic_cone",
            new TrafficConeBlock(FabricBlockSettings.of(Material.WOOD).strength(0f)), ModItemGroup.PARTS);
    public static final GuardRailBlock GUARD_RAIL = registerGuardRailBlock("guard_rail",
            new GuardRailBlock(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroup.PARTS);
    public static final TrafficLightBlock TRAFFIC_LIGHT = registerTrafficLight("traffic_light",
            new TrafficLightBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool().luminance(15)), ModItemGroup.PARTS);
    public static final StripedPostBlock STRIPED_POST = registerStripedPostBlock("striped_post",
            new StripedPostBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.PARTS);
    public static final DirectionSignBlock DIRECTION_SIGN = registerDirectionSignBlock("direction_sign",
            new DirectionSignBlock(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.PARTS);

    private static TrafficConeBlock registerTrafficConeBlock(String name, TrafficConeBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static GuardRailBlock registerGuardRailBlock(String name, GuardRailBlock block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static TrafficLightBlock registerTrafficLight(String name, TrafficLightBlock block, ItemGroup group) {
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
        StreetParts.LOGGER.debug("Registering Other Blocks for " + StreetParts.MOD_ID);
    }
}
