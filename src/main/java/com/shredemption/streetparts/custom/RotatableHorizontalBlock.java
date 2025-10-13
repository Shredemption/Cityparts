package com.shredemption.streetparts.custom;

import java.util.EnumMap;
import java.util.Map;

import javax.annotation.Nonnull;

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

public class RotatableHorizontalBlock extends HorizontalDirectionalBlock {
    private final Map<Direction, VoxelShape> shapes;

    public RotatableHorizontalBlock(BlockBehaviour.Properties properties, VoxelShape baseShape) {
        super(properties);
        this.shapes = new EnumMap<>(Direction.class);
        this.shapes.put(Direction.NORTH, baseShape);
        this.shapes.put(Direction.EAST, rotateShape(baseShape, Direction.EAST));
        this.shapes.put(Direction.SOUTH, rotateShape(baseShape, Direction.SOUTH));
        this.shapes.put(Direction.WEST, rotateShape(baseShape, Direction.WEST));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        Direction playerFacing = context.getHorizontalDirection().getOpposite();
        return this.defaultBlockState().setValue(FACING, playerFacing);
    }

    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter world, @Nonnull BlockPos pos,
            @Nonnull CollisionContext context) {
        return shapes.getOrDefault(state.getValue(FACING), shapes.get(Direction.NORTH));
    }

    private VoxelShape rotateShape(VoxelShape shape, Direction direction) {
        VoxelShape rotated = shape;
        int times = switch (direction) {
            case EAST -> 1;
            case SOUTH -> 2;
            case WEST -> 3;
            default -> 0;
        };
        for (int i = 0; i < times; i++) {
            VoxelShape newShape = Shapes.empty();
            for (var box : rotated.toAabbs()) {
                newShape = Shapes.or(newShape, Shapes.box(
                        1 - box.maxZ, box.minY, box.minX,
                        1 - box.minZ, box.maxY, box.maxX));
            }
            rotated = newShape;
        }
        return rotated;
    }

    @Override
    public com.mojang.serialization.MapCodec<? extends RotatableHorizontalBlock> codec() {
        throw new UnsupportedOperationException("RotatableHorizontalBlock does not support codec deserialization.");
    }
}