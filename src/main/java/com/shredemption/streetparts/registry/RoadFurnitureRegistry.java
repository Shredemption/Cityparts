package com.shredemption.streetparts.registry;

import java.util.ArrayList;
import java.util.List;

import com.shredemption.streetparts.StreetParts;
import com.shredemption.streetparts.block.DirectionSignBlock;
import com.shredemption.streetparts.template.SupportedShapedBlock;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.Shapes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class RoadFurnitureRegistry {
        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StreetParts.MOD_ID);
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StreetParts.MOD_ID);
        public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, StreetParts.MOD_ID);

        private static final List<DeferredBlock<? extends Block>> REGISTERED_BLOCKS = new ArrayList<>();
        private static final List<DeferredBlock<? extends Block>> DIR_SIGNS = new ArrayList<>();

        public static List<? extends Block> getDirectionSignBlocks() {
                return DIR_SIGNS.stream().map(DeferredBlock::get).toList();
        }

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ROAD_FURNITURE_TAB = CREATIVE_TABS
                        .register("streetparts_road_furnitrue", () -> CreativeModeTab.builder()
                                        .title(net.minecraft.network.chat.Component
                                                        .translatable("itemGroup.streetparts.road_furniture"))
                                        .icon(() -> net.minecraft.core.registries.BuiltInRegistries.ITEM
                                                        .get(fromNamespaceAndPath(StreetParts.MOD_ID,
                                                                        "direction_sign"))
                                                        .getDefaultInstance())
                                        .displayItems((params, output) -> {
                                                REGISTERED_BLOCKS.forEach(b -> output.accept(b.get().asItem()));
                                        })
                                        .build());

        public static void registerRoadFurnitureBlocks(IEventBus modEventBus) {
                BLOCKS.register(modEventBus);
                ITEMS.register(modEventBus);
                CREATIVE_TABS.register(modEventBus);

                String dirSignName = "direction_sign";
                DeferredBlock<DirectionSignBlock> dirSignBlock = BLOCKS.register(dirSignName,
                                () -> new DirectionSignBlock(
                                                BlockBehaviour.Properties.ofFullCopy(
                                                                net.minecraft.world.level.block.Blocks.STONE)));
                ITEMS.register(dirSignName, () -> new BlockItem(dirSignBlock.get(), new Item.Properties()));
                REGISTERED_BLOCKS.add(dirSignBlock);

                DIR_SIGNS.add(dirSignBlock);

                String trafficConeName = "traffic_cone";
                DeferredBlock<SupportedShapedBlock> trafficConeBlock = BLOCKS.register(trafficConeName,
                                () -> new SupportedShapedBlock(
                                                BlockBehaviour.Properties.of().strength(0.0f), Shapes.or(
                                                                Shapes.box(2 / 16f, 0, 2 / 16f, 14 / 16f, 1f,
                                                                                14 / 16f))));
                ITEMS.register(trafficConeName, () -> new BlockItem(trafficConeBlock.get(), new Item.Properties()));
                REGISTERED_BLOCKS.add(trafficConeBlock);

        }
}
