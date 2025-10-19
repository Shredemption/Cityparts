package com.shredemption.cityparts.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shredemption.cityparts.CityParts;
import com.shredemption.cityparts.block.ModCeilingHangingSignBlock;
import com.shredemption.cityparts.block.ModStandingSignBlock;
import com.shredemption.cityparts.block.ModWallHangingSignBlock;
import com.shredemption.cityparts.block.ModWallSignBlock;
import com.shredemption.cityparts.template.StrippableRotatedPillarBlock;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class WoodBlocksRegistry {

        private static final List<String> TYPES = List.of(
                        "olive",
                        "verdant",
                        "moon",
                        "sky",
                        "wisteria",
                        "ebony");

        public static record Colors(MapColor log, MapColor wood, MapColor planks) {
        }

        public static final Map<String, Colors> WOOD_COLORS = new HashMap<>() {
                {
                        put("olive", new Colors(MapColor.COLOR_BROWN, MapColor.COLOR_GREEN, MapColor.TERRACOTTA_LIGHT_GREEN));
                        put("verdant", new Colors(MapColor.TERRACOTTA_BROWN, MapColor.TERRACOTTA_LIGHT_GREEN, MapColor.PLANT));
                        put("moon", new Colors(MapColor.COLOR_LIGHT_GRAY, MapColor.COLOR_CYAN, MapColor.DIAMOND));
                        put("sky", new Colors(MapColor.COLOR_BLUE, MapColor.COLOR_BLUE, MapColor.LAPIS));
                        put("wisteria", new Colors(MapColor.TERRACOTTA_PURPLE, MapColor.TERRACOTTA_LIGHT_BLUE, MapColor.TERRACOTTA_LIGHT_BLUE));
                        put("ebony", new Colors(MapColor.TERRACOTTA_GRAY, MapColor.TERRACOTTA_BLACK, MapColor.TERRACOTTA_BLACK));
                }
        };

        private static final Map<String, BlockSetType> BLOCK_SET_TYPES = new java.util.HashMap<>();
        public static final Map<String, WoodType> WOOD_TYPES = new java.util.HashMap<>();

        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CityParts.MOD_ID);
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CityParts.MOD_ID);
        public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, CityParts.MOD_ID);

        private static final List<DeferredBlock<? extends Block>> REGISTERED_BLOCKS = new ArrayList<>();

        private static final Map<DeferredBlock<? extends Block>, DeferredBlock<? extends Block>> DEFERRED_STRIPPABLES = new HashMap<>();
        private static final Map<Block, Block> STRIPPABLES = new HashMap<>();

        public static final List<DeferredBlock<? extends Block>> SIGN_BLOCKS = new ArrayList<>();
        public static final List<DeferredBlock<? extends Block>> HANGING_SIGN_BLOCKS = new ArrayList<>();

        public static List<? extends Block> getAllSignBlocks() {
                return SIGN_BLOCKS.stream().map(DeferredBlock::get).toList();
        }

        public static List<? extends Block> getAllHangingSignBlocks() {
                return HANGING_SIGN_BLOCKS.stream().map(DeferredBlock::get).toList();
        }

        public static void populateStrippables() {
                STRIPPABLES.clear();
                DEFERRED_STRIPPABLES.forEach((deferredUnstripped, deferredStripped) -> {
                        Block unstripped = deferredUnstripped.get();
                        Block stripped = deferredStripped.get();
                        if (unstripped != null && stripped != null) {
                                STRIPPABLES.put(unstripped, stripped);
                        }
                });
        }

        public static Map<Block, Block> getStrippables() {
                return STRIPPABLES;
        }

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WOOD_TAB = CREATIVE_TABS
                        .register("streetpartswood_blocks", () -> CreativeModeTab.builder()
                                        .title(net.minecraft.network.chat.Component
                                                        .translatable("itemGroup.cityparts.wood_blocks"))
                                        .icon(() -> net.minecraft.core.registries.BuiltInRegistries.ITEM
                                                        .get(fromNamespaceAndPath(CityParts.MOD_ID, "olive_log"))
                                                        .getDefaultInstance())
                                        .displayItems((params, output) -> {
                                                REGISTERED_BLOCKS.forEach(b -> output.accept(b.get().asItem()));
                                        })
                                        .build());

        public static void registerWoodTypes() {
                for (String type : TYPES) {
                        BlockSetType blockSetType = new BlockSetType(type);
                        BLOCK_SET_TYPES.put(type, blockSetType);

                        WoodType woodType = new WoodType(type, blockSetType);
                        WoodType.register(woodType);
                        WOOD_TYPES.put(type, woodType);
                }
        }

        public static void registerWoodBlocks(IEventBus modEventBus) {
                BLOCKS.register(modEventBus);
                ITEMS.register(modEventBus);
                CREATIVE_TABS.register(modEventBus);

                registerWoodTypes();

                for (String type : TYPES) {

                        String logName = type + "_log";
                        DeferredBlock<StrippableRotatedPillarBlock> logBlock = BLOCKS.register(logName,
                                        () -> new StrippableRotatedPillarBlock(
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)
                                                                        .mapColor(WOOD_COLORS.get(type).log)));
                        ITEMS.register(logName, () -> new BlockItem(logBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(logBlock);

                        String woodName = type + "_wood";
                        DeferredBlock<StrippableRotatedPillarBlock> woodBlock = BLOCKS.register(woodName,
                                        () -> new StrippableRotatedPillarBlock(
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
                                                                        .mapColor(WOOD_COLORS.get(type).log)));
                        ITEMS.register(woodName, () -> new BlockItem(woodBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(woodBlock);

                        String strippeLogName = "stripped_" + type + "_log";
                        DeferredBlock<StrippableRotatedPillarBlock> strippedLogBlock = BLOCKS.register(strippeLogName,
                                        () -> new StrippableRotatedPillarBlock(
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)
                                                                        .mapColor(WOOD_COLORS.get(type).wood)));
                        ITEMS.register(strippeLogName,
                                        () -> new BlockItem(strippedLogBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(strippedLogBlock);

                        String strippedWoodName = "stripped_" + type + "_wood";
                        DeferredBlock<StrippableRotatedPillarBlock> strippedWoodBlock = BLOCKS.register(
                                        strippedWoodName,
                                        () -> new StrippableRotatedPillarBlock(BlockBehaviour.Properties
                                                        .ofFullCopy(Blocks.STRIPPED_OAK_WOOD)
                                                        .mapColor(WOOD_COLORS.get(type).wood)));
                        ITEMS.register(strippedWoodName,
                                        () -> new BlockItem(strippedWoodBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(strippedWoodBlock);

                        DEFERRED_STRIPPABLES.put(logBlock, strippedLogBlock);
                        DEFERRED_STRIPPABLES.put(woodBlock, strippedWoodBlock);

                        String planksName = type + "_planks";
                        DeferredBlock<Block> planksBlock = BLOCKS.register(planksName,
                                        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                                                        .mapColor(WOOD_COLORS.get(type).planks)));
                        ITEMS.register(planksName, () -> new BlockItem(planksBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(planksBlock);

                        String stairsName = type + "_stairs";
                        DeferredBlock<StairBlock> stairsBlock = BLOCKS.register(stairsName,
                                        () -> new StairBlock(planksBlock.get().defaultBlockState(),
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)
                                                                        .mapColor(WOOD_COLORS.get(type).planks)));
                        ITEMS.register(stairsName, () -> new BlockItem(stairsBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(stairsBlock);

                        String slabName = type + "_slab";
                        DeferredBlock<SlabBlock> slabBlock = BLOCKS.register(slabName,
                                        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)
                                                        .mapColor(WOOD_COLORS.get(type).planks)));
                        ITEMS.register(slabName, () -> new BlockItem(slabBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(slabBlock);

                        String fenceName = type + "_fence";
                        DeferredBlock<FenceBlock> fenceBlock = BLOCKS.register(fenceName,
                                        () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)
                                                        .mapColor(WOOD_COLORS.get(type).planks)));
                        ITEMS.register(fenceName, () -> new BlockItem(fenceBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(fenceBlock);

                        String fenceGateName = type + "_fence_gate";
                        DeferredBlock<FenceGateBlock> fenceGateBlock = BLOCKS.register(fenceGateName,
                                        () -> new FenceGateBlock(WOOD_TYPES.get(type),
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)
                                                                        .mapColor(WOOD_COLORS.get(type).planks)));
                        ITEMS.register(fenceGateName, () -> new BlockItem(fenceGateBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(fenceGateBlock);

                        String doorName = type + "_door";
                        DeferredBlock<DoorBlock> doorBlock = BLOCKS.register(doorName,
                                        () -> new DoorBlock(BLOCK_SET_TYPES.get(type),
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)
                                                                        .mapColor(WOOD_COLORS.get(type).planks)));
                        ITEMS.register(doorName, () -> new BlockItem(doorBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(doorBlock);

                        String trapdoorName = type + "_trapdoor";
                        DeferredBlock<TrapDoorBlock> trapdoorBlock = BLOCKS.register(trapdoorName,
                                        () -> new TrapDoorBlock(BLOCK_SET_TYPES.get(type),
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)
                                                                        .mapColor(WOOD_COLORS.get(type).planks)));
                        ITEMS.register(trapdoorName, () -> new BlockItem(trapdoorBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(trapdoorBlock);

                        String pressurePlateName = type + "_pressure_plate";
                        DeferredBlock<PressurePlateBlock> pressurePlateBlock = BLOCKS.register(pressurePlateName,
                                        () -> new PressurePlateBlock(BLOCK_SET_TYPES.get(type),
                                                        BlockBehaviour.Properties
                                                                        .ofFullCopy(Blocks.OAK_PRESSURE_PLATE)
                                                                        .mapColor(WOOD_COLORS.get(type).planks)));
                        ITEMS.register(pressurePlateName,
                                        () -> new BlockItem(pressurePlateBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(pressurePlateBlock);

                        String buttonName = type + "_button";
                        DeferredBlock<ButtonBlock> buttonBlock = BLOCKS.register(buttonName,
                                        () -> new ButtonBlock(BLOCK_SET_TYPES.get(type), 30,
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
                        ITEMS.register(buttonName, () -> new BlockItem(buttonBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(buttonBlock);

                        String signName = type + "_sign";
                        DeferredBlock<ModStandingSignBlock> signBlock = BLOCKS.register(signName,
                                        () -> new ModStandingSignBlock(WOOD_TYPES.get(type),
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
                                                                        .mapColor(WOOD_COLORS.get(type).planks)));
                        REGISTERED_BLOCKS.add(signBlock);

                        String wallSignName = type + "_wall_sign";
                        DeferredBlock<ModWallSignBlock> wallSignBlock = BLOCKS.register(wallSignName,
                                        () -> new ModWallSignBlock(WOOD_TYPES.get(type),
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
                                                                        .mapColor(WOOD_COLORS.get(type).planks)));

                        ITEMS.register(signName, () -> new SignItem(new Item.Properties().stacksTo(16), signBlock.get(),
                                        wallSignBlock.get()));

                        SIGN_BLOCKS.add(signBlock);
                        SIGN_BLOCKS.add(wallSignBlock);

                        String ceilingHangingSignName = type + "_hanging_sign";
                        DeferredBlock<ModCeilingHangingSignBlock> ceilingHangingSignBlock = BLOCKS
                                        .register(ceilingHangingSignName,
                                                        () -> new ModCeilingHangingSignBlock(WOOD_TYPES.get(type),
                                                                        BlockBehaviour.Properties.ofFullCopy(
                                                                                        Blocks.OAK_HANGING_SIGN)
                                                                                        .mapColor(WOOD_COLORS.get(
                                                                                                        type).planks)));
                        REGISTERED_BLOCKS.add(ceilingHangingSignBlock);

                        String wallHangingSignName = type + "_wall_hanging_sign";
                        DeferredBlock<ModWallHangingSignBlock> wallHangingSignBlock = BLOCKS.register(
                                        wallHangingSignName,
                                        () -> new ModWallHangingSignBlock(WOOD_TYPES.get(type),
                                                        BlockBehaviour.Properties
                                                                        .ofFullCopy(Blocks.OAK_HANGING_SIGN)
                                                                        .mapColor(WOOD_COLORS.get(type).planks)));

                        ITEMS.register(ceilingHangingSignName, () -> new HangingSignItem(ceilingHangingSignBlock.get(),
                                        wallHangingSignBlock.get(), new Item.Properties().stacksTo(16)));

                        HANGING_SIGN_BLOCKS.add(ceilingHangingSignBlock);
                        HANGING_SIGN_BLOCKS.add(wallHangingSignBlock);

                        // chest boat

                        // boat

                        // String leavesName = type + "_leaves";
                        // DeferredBlock<LeavesBlock> leavesBlock = BLOCKS.register(leavesName,
                        // () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.XXX)
                        // ));
                        // ITEMS.register(leavesName, () -> new BlockItem(leavesBlock.get(), new
                        // Item.Properties()));
                        // REGISTERED_BLOCKS.add(leavesBlock);

                        // sapling
                }
        }
}