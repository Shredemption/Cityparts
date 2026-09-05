package com.shredemption.cityparts.registry;

import com.shredemption.cityparts.CityParts;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.DyeColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DataComponentsRegistry {

    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister
            .createDataComponents(Registries.DATA_COMPONENT_TYPE, CityParts.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<DyeColor>> PAINT_COLOR = DATA_COMPONENTS
            .registerComponentType("paint_color",
                    builder -> builder.persistent(DyeColor.CODEC).networkSynchronized(DyeColor.STREAM_CODEC));

    public static void register(IEventBus bus) {
        DATA_COMPONENTS.register(bus);
    }
}
