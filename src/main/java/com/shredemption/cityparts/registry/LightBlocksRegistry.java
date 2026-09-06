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
                        "post_lamp",
                        "post",
                        "arm",
                        "corner",
                        "corner_post",
                        "l_corner",
                        "l_corner_post",
                        "t_corner",
                        "t_corner_post",
                        "y_corner",
                        "y_corner_post",
                        "x_corner",
                        "x_corner_post");

        private static final Map<String, List<String>> SHAPES = Map.of(
                        "corner", List.of("north"),
                        "l_corner", List.of("north", "east"),
                        "t_corner", List.of("north", "south"),
                        "y_corner", List.of("north", "east", "west"),
                        "x_corner", List.of("north", "east", "south", "west"));

        private static final VoxelShape POST_SHAPE = Shapes.box(
                        6 / 16f, 0, 6 / 16f,
                        10 / 16f, 16 / 16f, 10 / 16f);

        private static final VoxelShape HALF_POST_SHAPE = Shapes.box(
                        6 / 16f, 8 / 16f, 6 / 16f,
                        10 / 16f, 12 / 16f, 10 / 16f);

        private static final VoxelShape CORNER_PART_NORTH = Shapes.box(
                        6 / 16f, 0, 0,
                        10 / 16f, 12 / 16f, 10 / 16f);

        private static VoxelShape rotateShape(VoxelShape shape, int degrees) {
                degrees = ((degrees % 360) + 360) % 360;

                if (degrees == 0) {
                        return shape;
                }

                VoxelShape result = Shapes.empty();

                for (var box : shape.toAabbs()) {
                        double minX = box.minX;
                        double minY = box.minY;
                        double minZ = box.minZ;

                        double maxX = box.maxX;
                        double maxY = box.maxY;
                        double maxZ = box.maxZ;

                        double newMinX;
                        double newMaxX;
                        double newMinZ;
                        double newMaxZ;

                        switch (degrees) {
                                case 90 -> {
                                        newMinX = 1.0 - maxZ;
                                        newMaxX = 1.0 - minZ;
                                        newMinZ = minX;
                                        newMaxZ = maxX;
                                }

                                case 180 -> {
                                        newMinX = 1.0 - maxX;
                                        newMaxX = 1.0 - minX;
                                        newMinZ = 1.0 - maxZ;
                                        newMaxZ = 1.0 - minZ;
                                }

                                case 270 -> {
                                        newMinX = minZ;
                                        newMaxX = maxZ;
                                        newMinZ = 1.0 - maxX;
                                        newMaxZ = 1.0 - minX;
                                }

                                default -> throw new IllegalArgumentException("Unsupported rotation: " + degrees);
                        }

                        result = Shapes.or(result, Shapes.box(newMinX, minY, newMinZ, newMaxX, maxY, newMaxZ));
                }

                return result;
        }

        private static int directionRotation(String direction) {
                return switch (direction) {
                        case "north" -> 0;
                        case "east" -> 90;
                        case "south" -> 180;
                        case "west" -> 270;
                        default -> throw new IllegalArgumentException(
                                        "Unknown shape direction: " + direction);
                };
        }

        private static VoxelShape createCornerShape(List<String> directions, boolean post) {

                VoxelShape result = post ? POST_SHAPE : HALF_POST_SHAPE;

                for (String direction : directions) {
                        int rotation = directionRotation(direction);

                        VoxelShape part = rotateShape(CORNER_PART_NORTH, rotation);

                        result = Shapes.or(result, part);
                }

                return result;
        }

        private static Map<String, BlockTypeInfo> createTypeInfos() {

                Map<String, BlockTypeInfo> infos = new java.util.HashMap<>();

                /*
                 * Base blocks
                 */

                infos.put("light",
                                new BlockTypeInfo(BlockBehaviour.Properties.of().strength(2.0f).lightLevel(state -> 15),
                                                Shapes.or(Shapes.box(5.5 / 16f, 7 / 16f, 2.5 / 16f, 10.5 / 16f,
                                                                12.5 / 16f, 12 / 16f),
                                                                Shapes.box(6 / 16f, 8 / 16f, 12 / 16f, 10 / 16f,
                                                                                12 / 16f, 16 / 16f))));
                infos.put("post_lamp",
                                new BlockTypeInfo(BlockBehaviour.Properties.of().strength(2.0f).lightLevel(state -> 15),
                                                Shapes.box(3 / 16f, 0, 3 / 16f, 13 / 16f, 13 / 16f, 13 / 16f)));

                infos.put("post",
                                new BlockTypeInfo(BlockBehaviour.Properties.of().strength(2.0f), POST_SHAPE));

                infos.put("arm", new BlockTypeInfo(BlockBehaviour.Properties.of().strength(2.0f),
                                Shapes.box(6 / 16f, 8 / 16f, 0, 10 / 16f, 12 / 16f, 16 / 16f)));

                for (Map.Entry<String, List<String>> entry : SHAPES.entrySet()) {

                        String shapeName = entry.getKey();
                        List<String> directions = entry.getValue();

                        infos.put(shapeName, new BlockTypeInfo(BlockBehaviour.Properties.of().strength(2.0f),
                                        createCornerShape(directions, false)));

                        infos.put(shapeName + "_post", new BlockTypeInfo(BlockBehaviour.Properties.of().strength(2.0f),
                                        createCornerShape(directions, true)));
                }

                return Map.copyOf(infos);
        }

        private static final Map<String, BlockTypeInfo> TYPE_INFOS = createTypeInfos();

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
