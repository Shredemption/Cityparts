package net.fabricmc.streetparts;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.streetparts.register.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StreetParts implements ModInitializer {
	public static final String MOD_ID = "streetparts";
	public static final Logger LOGGER = LoggerFactory.getLogger("streetparts");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("StreetParts Initializing");
		ModItems.registerModItems();
		ModItemGroup.registerItemGroups();
		ModBuildingBlocks.registerModBuildingBlocks();
		ModRoadBlocks.registerModRoadBlocks();
		ModLightBlocks.registerModLightBlocks();
		ModSignBlocks.registerModSignBlocks();
		ModBlocks.registerModBlocks();

	}
}