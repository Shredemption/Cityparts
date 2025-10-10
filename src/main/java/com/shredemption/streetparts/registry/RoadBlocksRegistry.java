package com.shredemption.streetparts.registry;

import com.shredemption.streetparts.StreetParts;
import com.shredemption.streetparts.custom.RoadBlock;
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

public class RoadBlocksRegistry {

    private static final List<String> ROAD_BLOCK_NAMES = List.of(
            "roadlines_midline",
            "roadlines_sideline",
            "roadlines_halfline",

            "roadlines_innercorner",
            "roadlines_middlecorner",
            "roadlines_outercorner",
            "roadlines_cornercross",

            "roadlines_tsplitmid",
            "roadlines_tsplitshort",

            "roadlines_jcorner",
            "roadlines_lcorner",

            "roadlines_straightarrow",
            "roadlines_leftarrow",
            "roadlines_rightarrow",
            "roadlines_leftrightarrow",
            "roadlines_leftsubarrow",
            "roadlines_rightsubarrow",
            "roadlines_leftrightsubarrow",

            "roadlines_shortleftt",
            "roadlines_shortrightt",
            "roadlines_tallleftt",
            "roadlines_tallrightt",
            "roadlines_sharktooth",
            "roadlines_pedestrian_crossing"
    );

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StreetParts.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StreetParts.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StreetParts.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ROAD_BLOCKS_TAB =
            CREATIVE_TABS.register("road_blocks", () -> CreativeModeTab.builder()
                    .title(net.minecraft.network.chat.Component.translatable("itemGroup.streetparts.road_blocks"))
                    .icon(() -> BuildingBlocksRegistry.ASPHALT.get().asItem().getDefaultInstance())
                    .displayItems((params, output) -> {
                        output.accept(BuildingBlocksRegistry.ASPHALT.asItem());
                        BLOCKS.getEntries().forEach(entry -> output.accept(entry.get().asItem()));
                    })
                    .build());

    private static final List<DeferredBlock<RoadBlock>> REGISTERED_BLOCKS = new ArrayList<>();

    public static void registerRoadBlocks(List<String> names, VoxelShape shape) {
        for (String name : names) {
            // Use `register` with a supplier for custom block class
            DeferredBlock<RoadBlock> block = BLOCKS.register(name, () ->
                    new RoadBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f), shape));

            // Register the block item
            ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

            REGISTERED_BLOCKS.add(block);
        }
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);

        registerRoadBlocks(ROAD_BLOCK_NAMES, Shapes.block());
    }
}
