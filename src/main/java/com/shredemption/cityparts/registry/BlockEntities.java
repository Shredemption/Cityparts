package com.shredemption.cityparts.registry;

import com.shredemption.cityparts.CityParts;
import com.shredemption.cityparts.blockentity.DirectionSignBlockEntity;
import com.shredemption.cityparts.blockentity.ModHangingSignBlockEntity;
import com.shredemption.cityparts.blockentity.ModSignBlockEntity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockEntities {
        public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
                        .create(Registries.BLOCK_ENTITY_TYPE, CityParts.MOD_ID);

        @SuppressWarnings("null")
        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModSignBlockEntity>> SIGN = BLOCK_ENTITIES
                        .register("sign",
                                        () -> BlockEntityType.Builder
                                                        .of(ModSignBlockEntity::new,
                                                                        WoodBlocksRegistry.getAllSignBlocks()
                                                                                        .toArray(Block[]::new))
                                                        .build(null));

        @SuppressWarnings("null")
        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModHangingSignBlockEntity>> HANGING_SIGN = BLOCK_ENTITIES
                        .register("hanging_sign",
                                        () -> BlockEntityType.Builder
                                                        .of(ModHangingSignBlockEntity::new,
                                                                        WoodBlocksRegistry.getAllHangingSignBlocks()
                                                                                        .toArray(Block[]::new))
                                                        .build(null));

        @SuppressWarnings("null")
        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DirectionSignBlockEntity>> DIRECTION_SIGN = BLOCK_ENTITIES
                        .register("direction_sign",
                                        () -> BlockEntityType.Builder
                                                        .of(DirectionSignBlockEntity::new,
                                                                        RoadFurnitureRegistry.getDirectionSignBlocks()
                                                                                        .toArray(Block[]::new))
                                                        .build(null));

        public static void register(IEventBus bus) {
                BLOCK_ENTITIES.register(bus);
        }
}
