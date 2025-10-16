package com.shredemption.streetparts;

import com.shredemption.streetparts.registry.BlockEntities;
import com.shredemption.streetparts.registry.WoodBlocksRegistry;

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

public class ClientSetup {

    public static void register(IEventBus modBus) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modBus.addListener((FMLClientSetupEvent event) -> {
                event.enqueueWork(() -> {

                    WoodBlocksRegistry.WOOD_TYPES.forEach((name, woodType) -> {
                        Sheets.addWoodType(woodType);

                        ResourceLocation textureLocation = ResourceLocation.fromNamespaceAndPath(StreetParts.MOD_ID,
                                "entity/signs/" + name);

                        Material material = new Material(Sheets.SIGN_SHEET, textureLocation);

                        ResourceLocation hangingTextureLocation = ResourceLocation.fromNamespaceAndPath(
                                StreetParts.MOD_ID,
                                "entity/signs/hanging/" + name);

                        Material hangingMaterial = new Material(Sheets.SIGN_SHEET, hangingTextureLocation);

                        Sheets.SIGN_MATERIALS.put(woodType, material);
                        Sheets.HANGING_SIGN_MATERIALS.put(woodType, hangingMaterial);
                    });

                    BlockEntityRenderers.register(BlockEntities.SIGN.get(), SignRenderer::new);
                    BlockEntityRenderers.register(BlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
                });
            });
        }
    }
}