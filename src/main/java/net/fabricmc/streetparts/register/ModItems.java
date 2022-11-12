package net.fabricmc.streetparts.register;

import net.fabricmc.streetparts.StreetParts;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item LINE_PAINTER = registerItem("line_painter", new Item(new Item.Settings().group(ModItemGroup.TEST)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(StreetParts.MOD_ID, name), item);
    }

    public static void registerModItems() {
        StreetParts.LOGGER.debug("Registering Items for "+ StreetParts.MOD_ID);
    }
}
