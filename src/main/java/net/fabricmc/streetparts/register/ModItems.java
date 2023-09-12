package net.fabricmc.streetparts.register;

import net.fabricmc.streetparts.StreetParts;
import net.fabricmc.streetparts.custom.LightGenItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item LINE_PAINTER = registerItem("line_painter", new Item(new Item.Settings()));

    public static final Item LightGenItem = registerLightGenItem("light_generator", new LightGenItem(new Item.Settings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(StreetParts.MOD_ID, name), item);
    }
    private static Item registerLightGenItem(String name, net.fabricmc.streetparts.custom.LightGenItem item) {
        return Registry.register(Registries.ITEM, new Identifier(StreetParts.MOD_ID, name), item);
    }


    public static void registerModItems() {
        StreetParts.LOGGER.debug("Registering Items for "+ StreetParts.MOD_ID);
    }
}
