package com.shredemption.streetparts.registry;

import com.shredemption.streetparts.StreetParts;
import com.shredemption.streetparts.custom.block.RotatableHorizontalBlock;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.Shapes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class RoadBlocksRegistry {

        private static final List<String> blockSuffixes = List.of(
                        "midline",
                        "sideline",
                        "halfline",

                        "innercorner",
                        "middlecorner",
                        "outercorner",

                        "cross",
                        "cornercross",

                        "tsplitshort",
                        "tsplitmid",
                        "tsplittall",

                        "jcorner",
                        "lcorner",

                        "straightarrow",
                        "leftarrow",
                        "rightarrow",
                        "leftrightarrow",
                        "leftsubarrow",
                        "rightsubarrow",
                        "leftrightsubarrow",

                        "shortleftt",
                        "shortrightt",
                        "middleleftt",
                        "middlerightt",
                        "tallleftt",
                        "tallrightt",

                        "sharktooth",
                        "pedestrian_crossing");

        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StreetParts.MOD_ID);
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StreetParts.MOD_ID);
        public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, StreetParts.MOD_ID);

        private static final List<DeferredBlock<RotatableHorizontalBlock>> REGISTERED_FULL_BLOCKS = new ArrayList<>();
        private static final List<DeferredBlock<RotatableHorizontalBlock>> REGISTERED_SLAB_BLOCKS = new ArrayList<>();

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ROAD_BLOCKS_TAB = CREATIVE_TABS
                        .register("streetparts_road_blocks", () -> CreativeModeTab.builder()
                                        .title(net.minecraft.network.chat.Component
                                                        .translatable("itemGroup.streetparts.road_blocks"))
                                        .icon(() -> net.minecraft.core.registries.BuiltInRegistries.ITEM
                                                        .get(fromNamespaceAndPath(StreetParts.MOD_ID, "asphalt"))
                                                        .getDefaultInstance())
                                        .displayItems((params, output) -> {

                                                output.accept(net.minecraft.core.registries.BuiltInRegistries.ITEM
                                                                .get(fromNamespaceAndPath(StreetParts.MOD_ID,
                                                                                "asphalt"))
                                                                .asItem());

                                                REGISTERED_FULL_BLOCKS.forEach(b -> output.accept(b.get().asItem()));

                                                output.accept(net.minecraft.core.registries.BuiltInRegistries.ITEM
                                                                .get(fromNamespaceAndPath(StreetParts.MOD_ID,
                                                                                "asphalt_slab"))
                                                                .asItem());

                                                REGISTERED_SLAB_BLOCKS.forEach(b -> output.accept(b.get().asItem()));
                                        })
                                        .build());

        public static void registerRoadBlocks(IEventBus modEventBus) {
                BLOCKS.register(modEventBus);
                ITEMS.register(modEventBus);
                CREATIVE_TABS.register(modEventBus);

                for (String suffix : blockSuffixes) {
                        // Register full block
                        String fullName = "roadlines_" + suffix;
                        DeferredBlock<RotatableHorizontalBlock> fullBlock = BLOCKS.register(fullName,
                                        () -> new RotatableHorizontalBlock(BlockBehaviour.Properties.of()
                                                        .mapColor(MapColor.COLOR_GRAY).strength(2.0f),
                                                        Shapes.block()));
                        ITEMS.register(fullName, () -> new BlockItem(fullBlock.get(), new Item.Properties()));
                        REGISTERED_FULL_BLOCKS.add(fullBlock);

                        // Register slab block
                        String slabName = "roadlines_" + suffix + "_slab";
                        DeferredBlock<RotatableHorizontalBlock> slabBlock = BLOCKS
                                        .register(slabName,
                                                        () -> new RotatableHorizontalBlock(BlockBehaviour.Properties.of()
                                                                        .mapColor(MapColor.COLOR_GRAY).strength(2.0f),
                                                                        Shapes.box(0, 0, 0, 1, 0.5, 1)));
                        ITEMS.register(slabName, () -> new BlockItem(slabBlock.get(), new Item.Properties()));
                        REGISTERED_SLAB_BLOCKS.add(slabBlock);
                }
        }
}
