package com.shredemption.cityparts.network;

import com.mojang.datafixers.util.Function4;
import com.shredemption.cityparts.CityParts;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record OpenDirectionSignEditPayload(BlockPos pos, boolean frontText) implements CustomPacketPayload {

    // Define a static TYPE for NeoForge
    public static final CustomPacketPayload.Type<OpenDirectionSignEditPayload> TYPE = new CustomPacketPayload.Type<>(
            ResourceLocation.fromNamespaceAndPath(CityParts.MOD_ID, "open_direction_sign"));

    // Define codec for serialization / deserialization
    public static final StreamCodec<FriendlyByteBuf, OpenDirectionSignEditPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, OpenDirectionSignEditPayload::posX,
            ByteBufCodecs.VAR_INT, OpenDirectionSignEditPayload::posY,
            ByteBufCodecs.VAR_INT, OpenDirectionSignEditPayload::posZ,
            ByteBufCodecs.BOOL, OpenDirectionSignEditPayload::frontText,
            new Function4<Integer, Integer, Integer, Boolean, OpenDirectionSignEditPayload>() {
                @Override
                public OpenDirectionSignEditPayload apply(Integer x, Integer y, Integer z, Boolean front) {
                    return new OpenDirectionSignEditPayload(new BlockPos(x, y, z), front);
                }
            });

    @Override
    public CustomPacketPayload.Type<OpenDirectionSignEditPayload> type() {
        return TYPE;
    }

    // Getters for codec
    public int posX() {
        return pos.getX();
    }

    public int posY() {
        return pos.getY();
    }

    public int posZ() {
        return pos.getZ();
    }
}
