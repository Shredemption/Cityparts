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
            Shapes.box(7, 9, 16, 9, 11, 22),
            Shapes.box(2, 4, 15, 14, 16, 16));

    private static final VoxelShape SHAPE_E = Shapes.or(
            Shapes.box(-6, 9, 7, 0, 11, 9),
            Shapes.box(0, 4, 2, 1, 16, 14));
    private static final VoxelShape SHAPE_S = Shapes.or(
            Shapes.box(7, 9, -6, 9, 11, 0),
            Shapes.box(2, 4, 0, 14, 16, 1));
    private static final VoxelShape SHAPE_W = Shapes.or(
            Shapes.box(16, 9, 7, 22, 11, 9),
            Shapes.box(15, 4, 2, 16, 16, 14));

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
