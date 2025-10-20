package com.shredemption.cityparts.network;

import com.shredemption.cityparts.CityParts;

import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record SaveDirectionSignPayload(BlockPos pos, boolean frontText, Component[] lines)
        implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<SaveDirectionSignPayload> TYPE = new CustomPacketPayload.Type<>(
            ResourceLocation.fromNamespaceAndPath(CityParts.MOD_ID, "save_direction_sign"));

    public static final StreamCodec<FriendlyByteBuf, SaveDirectionSignPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, SaveDirectionSignPayload::posX,
            ByteBufCodecs.VAR_INT, SaveDirectionSignPayload::posY,
            ByteBufCodecs.VAR_INT, SaveDirectionSignPayload::posZ,
            ByteBufCodecs.BOOL, SaveDirectionSignPayload::frontText,
            StreamCodec.<FriendlyByteBuf, Component[]>of(
                    // encoder
                    (buf, components) -> {
                        buf.writeVarInt(components.length);
                        for (Component comp : components) {
                            buf.writeUtf(Component.Serializer.toJson(comp, RegistryAccess.EMPTY));
                        }
                    },
                    // decoder
                    buf -> {
                        int length = buf.readVarInt();
                        Component[] components = new Component[length];
                        for (int i = 0; i < length; i++) {
                            components[i] = Component.Serializer.fromJson(buf.readUtf(32767), RegistryAccess.EMPTY);
                        }
                        return components;
                    }),
            SaveDirectionSignPayload::lines,
            (x, y, z, front, lines) -> new SaveDirectionSignPayload(new BlockPos(x, y, z), front, lines));

    @Override
    public CustomPacketPayload.Type<SaveDirectionSignPayload> type() {
        return TYPE;
    }

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
