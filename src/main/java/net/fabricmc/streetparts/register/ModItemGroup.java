package net.fabricmc.streetparts.register;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.streetparts.StreetParts;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup MAIN = FabricItemGroupBuilder.build(new Identifier(StreetParts.MOD_ID, "main"), () -> new ItemStack(ModBlocks.STONE_PAVEMENT));
    public static final ItemGroup TEST = FabricItemGroupBuilder.build(new Identifier(StreetParts.MOD_ID, "test"), () -> new ItemStack(ModItems.LINE_PAINTER));
}
