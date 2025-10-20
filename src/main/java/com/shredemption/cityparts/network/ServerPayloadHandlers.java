package com.shredemption.cityparts.network;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignText;

import com.shredemption.cityparts.blockentity.DirectionSignBlockEntity;

import net.minecraft.network.chat.Component;

public class ServerPayloadHandlers {

    public static void handleSaveDirectionSign(SaveDirectionSignPayload payload, ServerPlayer player) {
        Level world = player.level();
        BlockEntity be = world.getBlockEntity(payload.pos());
        if (be instanceof DirectionSignBlockEntity signBe) {
            SignText newText = componentsToSignText(signBe, payload.frontText(), payload.lines());
            signBe.updateText(oldText -> newText, payload.frontText());
            world.getChunk(signBe.getBlockPos()).setUnsaved(true);
        }
    }

    private static SignText componentsToSignText(DirectionSignBlockEntity sign, boolean front, Component[] lines) {
        SignText oldText = sign.getText(front);
        SignText newText = new SignText()
                .setColor(oldText.getColor())
                .setHasGlowingText(oldText.hasGlowingText());

        for (int i = 0; i < 4; i++) {
            if (i < lines.length && lines[i] != null) {
                newText = newText.setMessage(i, lines[i], lines[i]);
            } else {
                Component oldRaw = oldText.getMessage(i, false);
                Component oldFiltered = oldText.getMessage(i, true);
                newText = newText.setMessage(i,
                        oldRaw != null ? oldRaw : Component.empty(),
                        oldFiltered != null ? oldFiltered : Component.empty());
            }
        }

        return newText;
    }

}