package com.shredemption.streetparts;

import com.shredemption.streetparts.registry.BlockEntities;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

    public static void register(IEventBus modBus) {
        modBus.addListener(ClientSetup::onClientSetup);
    }

    private static void onClientSetup(FMLClientSetupEvent event) {
        BlockEntityRenderers.register(BlockEntities.SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.register(BlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
    }

}
