package net.fabricmc.streetparts.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.streetparts.StreetParts;
import net.fabricmc.streetparts.custom.*;
import net.fabricmc.streetparts.custom.lights.TrafficLightBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final TrafficConeBlock TRAFFIC_CONE = registerTrafficConeBlock("traffic_cone",
            new TrafficConeBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(0f)));
    public static final GuardRailBlock GUARD_RAIL = registerGuardRailBlock("guard_rail",
            new GuardRailBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(3f).requiresTool()));
    public static final TrafficLightBlock TRAFFIC_LIGHT = registerTrafficLight("traffic_light",
            new TrafficLightBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5f).requiresTool().luminance(15)));
    public static final StripedPostBlock STRIPED_POST = registerStripedPostBlock("striped_post",
            new StripedPostBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5f).requiresTool()));
    public static final DirectionSignBlock DIRECTION_SIGN = registerDirectionSignBlock("direction_sign",
            new DirectionSignBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5f).requiresTool()));

    private static TrafficConeBlock registerTrafficConeBlock(String name, TrafficConeBlock block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static GuardRailBlock registerGuardRailBlock(String name, GuardRailBlock block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static TrafficLightBlock registerTrafficLight(String name, TrafficLightBlock block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static StripedPostBlock registerStripedPostBlock(String name, StripedPostBlock block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }
    private static DirectionSignBlock registerDirectionSignBlock(String name, DirectionSignBlock block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(StreetParts.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(StreetParts.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        StreetParts.LOGGER.debug("Registering Other Blocks for " + StreetParts.MOD_ID);
    }
}
