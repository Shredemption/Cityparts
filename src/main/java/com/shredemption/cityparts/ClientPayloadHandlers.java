package com.shredemption.cityparts;

import com.shredemption.cityparts.blockentity.DirectionSignBlockEntity;
import com.shredemption.cityparts.gui.DirectionSignEditScreen;
import com.shredemption.cityparts.network.OpenDirectionSignEditPayload;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ClientPayloadHandlers {

    @SuppressWarnings("null")
    public static void handleOpenDirectionSign(OpenDirectionSignEditPayload payload) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null)
            return;

        BlockEntity be = mc.level.getBlockEntity(payload.pos());
        if (be instanceof DirectionSignBlockEntity signBe) {
            Screen current = mc.screen;
            if (current != null)
                current.removed();
            mc.setScreen(new DirectionSignEditScreen(signBe, payload.frontText()));
        }
    }
}