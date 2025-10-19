package com.shredemption.cityparts;

import com.shredemption.cityparts.registry.BlockEntities;
import com.shredemption.cityparts.registry.WoodBlocksRegistry;
import com.shredemption.cityparts.render.DirectionSignRenderer;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class ClientSetup {

    public static void register(IEventBus modBus) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modBus.addListener((FMLClientSetupEvent event) -> {
                event.enqueueWork(() -> {

                    WoodBlocksRegistry.WOOD_TYPES.forEach((name, woodType) -> {
                        Sheets.addWoodType(woodType);

                        ResourceLocation textureLocation = ResourceLocation.fromNamespaceAndPath(CityParts.MOD_ID,
                                "entity/signs/" + name);

                        Material material = new Material(Sheets.SIGN_SHEET, textureLocation);

                        ResourceLocation hangingTextureLocation = ResourceLocation.fromNamespaceAndPath(
                                CityParts.MOD_ID,
                                "entity/signs/hanging/" + name);

                        Material hangingMaterial = new Material(Sheets.SIGN_SHEET, hangingTextureLocation);

                        Sheets.SIGN_MATERIALS.put(woodType, material);
                        Sheets.HANGING_SIGN_MATERIALS.put(woodType, hangingMaterial);
                    });

                    BlockEntityRenderers.register(BlockEntities.SIGN.get(), SignRenderer::new);
                    BlockEntityRenderers.register(BlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
                    BlockEntityRenderers.register(BlockEntities.DIRECTION_SIGN.get(), DirectionSignRenderer::new);

                });
            });

            modBus.addListener((EntityRenderersEvent.RegisterLayerDefinitions event) -> {
                event.registerLayerDefinition(DirectionSignRenderer.DIRECTION_SIGN_LAYER,
                        DirectionSignRenderer::createDirectionSignLayer);
            });
        }
    }
}