package com.shredemption.streetparts.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import javax.annotation.Nonnull;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import com.mojang.serialization.MapCodec;

public class SignBlock extends HorizontalDirectionalBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private static final VoxelShape SHAPE_N = Shapes.or(
            Shapes.box(7 / 16f, 9 / 16f, 1.0f, 9 / 16f, 11 / 16f, 1.375f),
            Shapes.box(2 / 16f, 4 / 16f, 15 / 16f, 14 / 16f, 1.0f, 1.0f));

    private static final VoxelShape SHAPE_E = Shapes.or(
            Shapes.box(-6 / 16f, 9 / 16f, 7 / 16f, 0.0f, 11 / 16f, 9 / 16f),
            Shapes.box(0.0f, 4 / 16f, 2 / 16f, 1 / 16f, 1.0f, 14 / 16f));

    private static final VoxelShape SHAPE_S = Shapes.or(
            Shapes.box(7 / 16f, 9 / 16f, -6 / 16f, 9 / 16f, 11 / 16f, 0.0f),
            Shapes.box(2 / 16f, 4 / 16f, 0.0f, 14 / 16f, 1.0f, 1 / 16f));

    private static final VoxelShape SHAPE_W = Shapes.or(
            Shapes.box(1.0f, 9 / 16f, 7 / 16f, 1.375f, 11 / 16f, 9 / 16f),
            Shapes.box(15 / 16f, 4 / 16f, 2 / 16f, 1.0f, 1.0f, 14 / 16f));

    public SignBlock(BlockBehaviour.Properties properties, VoxelShape shape) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        // Make the block face the player when placed
        Direction playerFacing = context.getHorizontalDirection().getOpposite();
        return this.defaultBlockState().setValue(FACING, playerFacing);
    }

    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter world, @Nonnull BlockPos pos,
            @Nonnull CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> SHAPE_N;
            case EAST -> SHAPE_E;
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            default -> SHAPE_N;
        };
    }

    @Override
    public MapCodec<? extends SignBlock> codec() {
        // This block cannot be deserialized via codec due to custom shape.
        throw new UnsupportedOperationException("SignBlock does not support codec deserialization.");
    }
}
