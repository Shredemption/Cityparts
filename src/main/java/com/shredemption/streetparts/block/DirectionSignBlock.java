package com.shredemption.streetparts.block;

import javax.annotation.Nonnull;

import com.shredemption.streetparts.blockentity.DirectionSignBlockEntity;
import com.shredemption.streetparts.template.AttachableHorizontalBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DirectionSignBlock extends AttachableHorizontalBlock implements EntityBlock {

    private static final VoxelShape baseShape = Shapes.or(
            Shapes.box(7 / 16f, 5 / 16f, -3 / 16f, 9 / 16f, 12 / 16f, 22 / 16f));

    public DirectionSignBlock(BlockBehaviour.Properties properties) {
        super(properties, baseShape);
    }

    @Override
    public RenderShape getRenderShape(@Nonnull BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new DirectionSignBlockEntity(pos, state);
    }

    @Override
    protected InteractionResult useWithoutItem(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos,
            @Nonnull Player player,
            @Nonnull BlockHitResult hitResult) {

        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            boolean editingFront;

            Direction clickedFace = hitResult.getDirection();
            Direction blockFacing = state.getValue(DirectionSignBlock.FACING);
            Direction frontSide = blockFacing.getClockWise();

            editingFront = (clickedFace == frontSide);

            if (be instanceof DirectionSignBlockEntity sign) {
                player.openTextEdit(sign, editingFront);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    protected ItemInteractionResult useItemOn(@Nonnull ItemStack stack, @Nonnull BlockState state, @Nonnull Level level,
            @Nonnull BlockPos pos,
            @Nonnull Player player, @Nonnull InteractionHand hand, @Nonnull BlockHitResult hitResult) {

        InteractionResult result = useWithoutItem(state, level, pos, player, hitResult);
        return switch (result) {
            case SUCCESS, CONSUME -> ItemInteractionResult.SUCCESS;
            case PASS -> ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            case FAIL -> ItemInteractionResult.FAIL;
            default -> ItemInteractionResult.FAIL;
        };
    }
}
