package com.shredemption.streetparts;

import com.mojang.logging.LogUtils;
import com.shredemption.streetparts.registry.ConstructionBlocksRegistry;
import com.shredemption.streetparts.registry.LightBlocksRegistry;
import com.shredemption.streetparts.registry.RoadBlocksRegistry;
import com.shredemption.streetparts.registry.SignBlockRegistry;
import com.shredemption.streetparts.registry.WoodBlocksRegistry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(StreetParts.MOD_ID)
public class StreetParts {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "streetparts";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod
    // is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and
    // pass them in automatically.
    public StreetParts(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (StreetParts)
        // to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in
        // this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ConstructionBlocksRegistry.registerConstructionBlocks(modEventBus);
        RoadBlocksRegistry.registerRoadBlocks(modEventBus);
        SignBlockRegistry.registerSignBlocks(modEventBus);
        LightBlocksRegistry.registerLightBlocks(modEventBus);
        WoodBlocksRegistry.registerWoodBlocks(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
