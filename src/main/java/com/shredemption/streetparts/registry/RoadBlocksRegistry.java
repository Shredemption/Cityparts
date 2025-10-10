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

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class RoadBlocksRegistry {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(StreetParts.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StreetParts.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StreetParts.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ROAD_BLOCKS_TAB =
            CREATIVE_TABS.register("road_blocks", () -> CreativeModeTab.builder()
                    .title(net.minecraft.network.chat.Component.translatable("itemGroup.streetparts.road_blocks"))
                    .icon(() -> net.minecraft.core.registries.BuiltInRegistries.ITEM
                            .get(fromNamespaceAndPath(StreetParts.MOD_ID, "asphalt"))
                            .getDefaultInstance())
                    .displayItems((params, output) -> {
                        BLOCKS.getEntries().forEach(entry -> output.accept(entry.get().asItem()));
                    })
                    .build());

    private static final List<DeferredBlock<RoadBlock>> REGISTERED_BLOCKS = new ArrayList<>();

    private record RoadBlockEntry(String name, VoxelShape shape) {
    }

    private static final List<RoadBlockEntry> ROAD_BLOCKS_ORDERED = new ArrayList<>();

    static {
        ROAD_BLOCKS_ORDERED.add(new RoadBlockEntry("asphalt", Shapes.block()));

        List<String> fullBlocks = List.of(
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
        for (String name : fullBlocks) {
            ROAD_BLOCKS_ORDERED.add(new RoadBlockEntry(name, Shapes.block()));
        }

        ROAD_BLOCKS_ORDERED.add(new RoadBlockEntry("asphalt_slab", Shapes.block()));

        List<String> slabBlocks = List.of(
                "roadlines_midline_slab",
                "roadlines_sideline_slab",
                "roadlines_halfline_slab",

                "roadlines_innercorner_slab",
                "roadlines_middlecorner_slab",
                "roadlines_outercorner_slab",
                "roadlines_cornercross_slab",

                "roadlines_tsplitmid_slab",
                "roadlines_tsplitshort_slab",

                "roadlines_jcorner_slab",
                "roadlines_lcorner_slab",

                "roadlines_straightarrow_slab",
                "roadlines_leftarrow_slab",
                "roadlines_rightarrow_slab",
                "roadlines_leftrightarrow_slab",
                "roadlines_leftsubarrow_slab",
                "roadlines_rightsubarrow_slab",
                "roadlines_leftrightsubarrow_slab",

                "roadlines_shortleftt_slab",
                "roadlines_shortrightt_slab",
                "roadlines_tallleftt_slab",
                "roadlines_tallrightt_slab",
                "roadlines_sharktooth_slab",
                "roadlines_pedestrian_crossing_slab"
        );
        for (String name : slabBlocks) {
            ROAD_BLOCKS_ORDERED.add(new RoadBlockEntry(name, Shapes.box(0, 0, 0, 1, 0.5, 1)));
        }
    }

    public static void registerRoadBlocks(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);

        for (RoadBlockEntry entry : ROAD_BLOCKS_ORDERED) {
            DeferredBlock<RoadBlock> block = BLOCKS.register(entry.name(), () ->
                    new RoadBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(2.0f), entry.shape()));
            ITEMS.register(entry.name(), () -> new BlockItem(block.get(), new Item.Properties()));
            REGISTERED_BLOCKS.add(block);
        }
    }
}
