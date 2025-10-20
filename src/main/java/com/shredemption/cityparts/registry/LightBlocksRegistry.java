package com.shredemption.cityparts.registry;

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
import java.util.Map;

import com.shredemption.cityparts.CityParts;
import com.shredemption.cityparts.template.RotatableHorizontalBlock;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class LightBlocksRegistry {

        private static final List<String> COLOR_ORDER = List.of(
                        "gray",
                        "white",
                        "black",
                        "green");

        private static final Map<String, MapColor> COLOR_INFOS = Map.of(
                        "green", MapColor.COLOR_GREEN,
                        "black", MapColor.COLOR_BLACK,
                        "white", MapColor.SNOW,
                        "gray", MapColor.COLOR_GRAY);

        public record BlockTypeInfo(BlockBehaviour.Properties properties, VoxelShape shape) {
        }

        private static final List<String> TYPE_ORDER = List.of(
                        "light",
                        "post",
                        "arm",
                        "corner",
                        "l_corner",
                        "t_corner");

        private static final Map<String, BlockTypeInfo> TYPE_INFOS = Map.of(
                        "corner", new BlockTypeInfo(
                                        BlockBehaviour.Properties.of().strength(2.0f),
                                        Shapes.box(6 / 16f, 0, 0, 10 / 16f, 12 / 16f, 10 / 16f)),
                        "t_corner", new BlockTypeInfo(
                                        BlockBehaviour.Properties.of().strength(2.0f),
                                        Shapes.box(6 / 16f, 0, 0, 10 / 16f, 12 / 16f, 16 / 16f)),
                        "arm", new BlockTypeInfo(
                                        BlockBehaviour.Properties.of().strength(2.0f),
                                        Shapes.box(6 / 16f, 8 / 16f, 0, 10 / 16f, 12 / 16f, 16 / 16f)),
                        "post", new BlockTypeInfo(
                                        BlockBehaviour.Properties.of().strength(2.0f),
                                        Shapes.box(6 / 16f, 0, 6 / 16f, 10 / 16f, 16 / 16f, 10 / 16f)),
                        "l_corner", new BlockTypeInfo(
                                        BlockBehaviour.Properties.of().strength(2.0f),
                                        Shapes.box(6 / 16f, 0, 0, 16 / 16f, 12 / 16f, 10 / 16f)),
                        "light", new BlockTypeInfo(
                                        BlockBehaviour.Properties.of().strength(2.0f).lightLevel(state -> 15),
                                        Shapes.or(Shapes.box(5.5 / 16f, 7.5 / 16f, 2 / 16f, 10.5 / 16f, 12.5 / 16f,
                                                        10 / 16f),
                                                        Shapes.box(6 / 16f, 8 / 16f, 9 / 16f, 10 / 16f, 12 / 16f,
                                                                        16 / 16f))));

        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CityParts.MOD_ID);
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CityParts.MOD_ID);
        public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, CityParts.MOD_ID);

        private static final List<DeferredBlock<RotatableHorizontalBlock>> REGISTERED_LIGHT_BLOCKS = new ArrayList<>();

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> LIGHTS_TAB = CREATIVE_TABS
                        .register("cityparts_light_blocks", () -> CreativeModeTab.builder()
                                        .title(net.minecraft.network.chat.Component
                                                        .translatable("itemGroup.cityparts.lights"))
                                        .icon(() -> net.minecraft.core.registries.BuiltInRegistries.ITEM
                                                        .get(fromNamespaceAndPath(CityParts.MOD_ID,
                                                                        "light_gray_light"))
                                                        .getDefaultInstance())
                                        .displayItems((params, output) -> {
                                                REGISTERED_LIGHT_BLOCKS.forEach(b -> output.accept(b.get().asItem()));
                                        })
                                        .build());

        public static void registerLightBlocks(IEventBus modEventBus) {
                BLOCKS.register(modEventBus);
                ITEMS.register(modEventBus);
                CREATIVE_TABS.register(modEventBus);

                for (String color : COLOR_ORDER) {
                        for (String type : TYPE_ORDER) {
                                BlockTypeInfo info = TYPE_INFOS.get(type);
                                MapColor mapColor = COLOR_INFOS.get(color);
                                String fullName = "light_" + color + "_" + type;
                                DeferredBlock<RotatableHorizontalBlock> block = BLOCKS.register(fullName,
                                                () -> new RotatableHorizontalBlock(info.properties.mapColor(mapColor),
                                                                info.shape));
                                ITEMS.register(fullName, () -> new BlockItem(block.get(), new Item.Properties()));
                                REGISTERED_LIGHT_BLOCKS.add(block);
                        }
                }
        }
}
