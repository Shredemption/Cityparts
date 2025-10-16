package com.shredemption.streetparts.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shredemption.streetparts.StreetParts;
import com.shredemption.streetparts.custom.block.StrippableRotatedPillarBlock;
import com.shredemption.streetparts.custom.sign.CustomCeilingHangingSignBlock;
import com.shredemption.streetparts.custom.sign.CustomStandingSignBlock;
import com.shredemption.streetparts.custom.sign.CustomWallHangingSignBlock;
import com.shredemption.streetparts.custom.sign.CustomWallSignBlock;

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
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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

        private static final Map<String, BlockSetType> BLOCK_SET_TYPES = new java.util.HashMap<>();
        private static final Map<String, WoodType> WOOD_TYPES = new java.util.HashMap<>();

        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StreetParts.MOD_ID);
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StreetParts.MOD_ID);
        public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, StreetParts.MOD_ID);

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
                                                        .translatable("itemGroup.streetparts.wood_blocks"))
                                        .icon(() -> net.minecraft.core.registries.BuiltInRegistries.ITEM
                                                        .get(fromNamespaceAndPath(StreetParts.MOD_ID, "olive_log"))
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
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
                        ITEMS.register(logName, () -> new BlockItem(logBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(logBlock);

                        String woodName = type + "_wood";
                        DeferredBlock<StrippableRotatedPillarBlock> woodBlock = BLOCKS.register(woodName,
                                        () -> new StrippableRotatedPillarBlock(
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
                        ITEMS.register(woodName, () -> new BlockItem(woodBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(woodBlock);

                        String strippeLogName = "stripped_" + type + "_log";
                        DeferredBlock<RotatedPillarBlock> strippedLogBlock = BLOCKS.register(strippeLogName,
                                        () -> new RotatedPillarBlock(
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
                        ITEMS.register(strippeLogName,
                                        () -> new BlockItem(strippedLogBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(strippedLogBlock);

                        String strippedWoodName = "stripped_" + type + "_wood";
                        DeferredBlock<RotatedPillarBlock> strippedWoodBlock = BLOCKS.register(strippedWoodName,
                                        () -> new RotatedPillarBlock(BlockBehaviour.Properties
                                                        .ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
                        ITEMS.register(strippedWoodName,
                                        () -> new BlockItem(strippedWoodBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(strippedWoodBlock);

                        DEFERRED_STRIPPABLES.put(logBlock, strippedLogBlock);
                        DEFERRED_STRIPPABLES.put(woodBlock, strippedWoodBlock);

                        String planksName = type + "_planks";
                        DeferredBlock<Block> planksBlock = BLOCKS.register(planksName,
                                        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
                        ITEMS.register(planksName, () -> new BlockItem(planksBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(planksBlock);

                        String stairsName = type + "_stairs";
                        DeferredBlock<StairBlock> stairsBlock = BLOCKS.register(stairsName,
                                        () -> new StairBlock(planksBlock.get().defaultBlockState(),
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
                        ITEMS.register(stairsName, () -> new BlockItem(stairsBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(stairsBlock);

                        String slabName = type + "_slab";
                        DeferredBlock<SlabBlock> slabBlock = BLOCKS.register(slabName,
                                        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
                        ITEMS.register(slabName, () -> new BlockItem(slabBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(slabBlock);

                        String fenceName = type + "_fence";
                        DeferredBlock<FenceBlock> fenceBlock = BLOCKS.register(fenceName,
                                        () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
                        ITEMS.register(fenceName, () -> new BlockItem(fenceBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(fenceBlock);

                        String fenceGateName = type + "_fence_gate";
                        DeferredBlock<FenceGateBlock> fenceGateBlock = BLOCKS.register(fenceGateName,
                                        () -> new FenceGateBlock(WOOD_TYPES.get(type),
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
                        ITEMS.register(fenceGateName, () -> new BlockItem(fenceGateBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(fenceGateBlock);

                        String doorName = type + "_door";
                        DeferredBlock<DoorBlock> doorBlock = BLOCKS.register(doorName,
                                        () -> new DoorBlock(BLOCK_SET_TYPES.get(type),
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
                        ITEMS.register(doorName, () -> new BlockItem(doorBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(doorBlock);

                        String trapdoorName = type + "_trapdoor";
                        DeferredBlock<TrapDoorBlock> trapdoorBlock = BLOCKS.register(trapdoorName,
                                        () -> new TrapDoorBlock(BLOCK_SET_TYPES.get(type),
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
                        ITEMS.register(trapdoorName, () -> new BlockItem(trapdoorBlock.get(), new Item.Properties()));
                        REGISTERED_BLOCKS.add(trapdoorBlock);

                        String pressurePlateName = type + "_pressure_plate";
                        DeferredBlock<PressurePlateBlock> pressurePlateBlock = BLOCKS.register(pressurePlateName,
                                        () -> new PressurePlateBlock(BLOCK_SET_TYPES.get(type),
                                                        BlockBehaviour.Properties
                                                                        .ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
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
                        DeferredBlock<CustomStandingSignBlock> signBlock = BLOCKS.register(signName,
                                        () -> new CustomStandingSignBlock(WOOD_TYPES.get(type),
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
                        REGISTERED_BLOCKS.add(signBlock);

                        String wallSignName = type + "_wall_sign";
                        DeferredBlock<CustomWallSignBlock> wallSignBlock = BLOCKS.register(wallSignName,
                                        () -> new CustomWallSignBlock(WOOD_TYPES.get(type),
                                                        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));

                        ITEMS.register(signName, () -> new SignItem(new Item.Properties().stacksTo(16), signBlock.get(),
                                        wallSignBlock.get()));

                        SIGN_BLOCKS.add(signBlock);
                        SIGN_BLOCKS.add(wallSignBlock);

                        String ceilingHangingSignName = type + "_hanging_sign";
                        DeferredBlock<CustomCeilingHangingSignBlock> ceilingHangingSignBlock = BLOCKS
                                        .register(ceilingHangingSignName,
                                                        () -> new CustomCeilingHangingSignBlock(WOOD_TYPES.get(type),
                                                                        BlockBehaviour.Properties.ofFullCopy(
                                                                                        Blocks.OAK_HANGING_SIGN)));
                        REGISTERED_BLOCKS.add(ceilingHangingSignBlock);

                        String wallHangingSignName = type + "_wall_hanging_sign";
                        DeferredBlock<CustomWallHangingSignBlock> wallHangingSignBlock = BLOCKS.register(
                                        wallHangingSignName,
                                        () -> new CustomWallHangingSignBlock(WOOD_TYPES.get(type),
                                                        BlockBehaviour.Properties
                                                                        .ofFullCopy(Blocks.OAK_HANGING_SIGN)));

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
