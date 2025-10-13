package com.shredemption.streetparts.registry;

import com.shredemption.streetparts.StreetParts;
import com.shredemption.streetparts.custom.RotatableHorizontalBlock;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class SignBlockRegistry {

        private static final List<String> roundSigns = List.of(
                        "stop",
                        "no_entry",
                        "roundabout",
                        "left_pass",
                        "left_right_pass",
                        "right_pass",
                        "arrow_left",
                        "arrow_forward",
                        "arrow_right",
                        "arrow_forward_left",
                        "arrow_left_right",
                        "arrow_forward_right",
                        "30",
                        "45",
                        "50",
                        "60",
                        "80",
                        "90",
                        "100",
                        "120",
                        "130",
                        "oncoming_yield");

        private static final List<String> squareSigns = List.of(
                        "arrow_left",
                        "arrow_forward",
                        "arrow_right",
                        "arrow_forward_left",
                        "arrow_left_right",
                        "arrow_forward_right",
                        "oncoming_priority",
                        "parking");

        private static final List<String> triangleSigns = List.of(
                        "warning",
                        "danger",
                        "danger_cross",
                        "crossing_left",
                        "crossing_left_right",
                        "crossing_right",
                        "sharp_left",
                        "sharp_right");

        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StreetParts.MOD_ID);
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StreetParts.MOD_ID);
        public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, StreetParts.MOD_ID);

        private static final List<DeferredBlock<RotatableHorizontalBlock>> REGISTERED_ROUND_SIGNS = new ArrayList<>();
        private static final List<DeferredBlock<RotatableHorizontalBlock>> REGISTERED_SQUARE_SIGNS = new ArrayList<>();
        private static final List<DeferredBlock<RotatableHorizontalBlock>> REGISTERED_TRIANGLE_SIGNS = new ArrayList<>();

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SIGNS_TAB = CREATIVE_TABS
                        .register("streetparts_signs", () -> CreativeModeTab.builder()
                                        .title(net.minecraft.network.chat.Component
                                                        .translatable("itemGroup.streetparts.signs"))
                                        .icon(() -> net.minecraft.core.registries.BuiltInRegistries.ITEM
                                                        .get(fromNamespaceAndPath(StreetParts.MOD_ID,
                                                                        "sign_round_stop"))
                                                        .getDefaultInstance())
                                        .displayItems((params, output) -> {
                                                REGISTERED_ROUND_SIGNS.forEach(b -> output.accept(b.get().asItem()));
                                                REGISTERED_SQUARE_SIGNS.forEach(b -> output.accept(b.get().asItem()));
                                                REGISTERED_TRIANGLE_SIGNS.forEach(b -> output.accept(b.get().asItem()));
                                        })
                                        .build());

        private static final VoxelShape SignShape = Shapes.or(
                        Shapes.box(7 / 16f, 9 / 16f, 1.0f, 9 / 16f, 11 / 16f, 1.375f),
                        Shapes.box(2 / 16f, 4 / 16f, 15 / 16f, 14 / 16f, 1.0f, 1.0f));

        public static void registerSignBlocks(IEventBus modEventBus) {
                BLOCKS.register(modEventBus);
                ITEMS.register(modEventBus);
                CREATIVE_TABS.register(modEventBus);

                for (String type : roundSigns) {
                        String fullName = "sign_round_" + type;
                        DeferredBlock<RotatableHorizontalBlock> fullBlock = BLOCKS.register(fullName,
                                        () -> new RotatableHorizontalBlock(BlockBehaviour.Properties.of()
                                                        .mapColor(MapColor.COLOR_GRAY).strength(2.0f), SignShape));
                        ITEMS.register(fullName, () -> new BlockItem(fullBlock.get(), new Item.Properties()));
                        REGISTERED_ROUND_SIGNS.add(fullBlock);
                }

                for (String type : squareSigns) {
                        String fullName = "sign_square_" + type;
                        DeferredBlock<RotatableHorizontalBlock> fullBlock = BLOCKS.register(fullName,
                                        () -> new RotatableHorizontalBlock(BlockBehaviour.Properties.of()
                                                        .mapColor(MapColor.COLOR_GRAY).strength(2.0f), SignShape));
                        ITEMS.register(fullName, () -> new BlockItem(fullBlock.get(), new Item.Properties()));
                        REGISTERED_SQUARE_SIGNS.add(fullBlock);
                }

                for (String type : triangleSigns) {
                        String fullName = "sign_triangle_" + type;
                        DeferredBlock<RotatableHorizontalBlock> fullBlock = BLOCKS.register(fullName,
                                        () -> new RotatableHorizontalBlock(BlockBehaviour.Properties.of()
                                                        .mapColor(MapColor.COLOR_GRAY).strength(2.0f), SignShape));
                        ITEMS.register(fullName, () -> new BlockItem(fullBlock.get(), new Item.Properties()));
                        REGISTERED_TRIANGLE_SIGNS.add(fullBlock);
                }
        }
}
