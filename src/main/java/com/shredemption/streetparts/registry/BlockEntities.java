package com.shredemption.streetparts.registry;

import com.shredemption.streetparts.StreetParts;
import com.shredemption.streetparts.custom.block.entity.CustomHangingSignBlockEntity;
import com.shredemption.streetparts.custom.block.entity.CustomSignBlockEntity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockEntities {
        public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
                        .create(Registries.BLOCK_ENTITY_TYPE, StreetParts.MOD_ID);

        @SuppressWarnings("null")
        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CustomSignBlockEntity>> SIGN = BLOCK_ENTITIES
                        .register("sign",
                                        () -> BlockEntityType.Builder
                                                        .of(CustomSignBlockEntity::new,
                                                                        WoodBlocksRegistry.getAllSignBlocks()
                                                                                        .toArray(Block[]::new))
                                                        .build(null));

        @SuppressWarnings("null")
        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CustomHangingSignBlockEntity>> HANGING_SIGN = BLOCK_ENTITIES
                        .register("hanging_sign",
                                        () -> BlockEntityType.Builder
                                                        .of(CustomHangingSignBlockEntity::new,
                                                                        WoodBlocksRegistry.getAllHangingSignBlocks()
                                                                                        .toArray(Block[]::new))
                                                        .build(null));

        public static void register(IEventBus bus) {
                BLOCK_ENTITIES.register(bus);
        }
}
