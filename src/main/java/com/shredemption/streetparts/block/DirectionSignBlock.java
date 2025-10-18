package com.shredemption.streetparts.block;

import java.util.Arrays;
import java.util.UUID;

import javax.annotation.Nonnull;

import com.shredemption.streetparts.blockentity.DirectionSignBlockEntity;
import com.shredemption.streetparts.gui.DirectionSignEditScreen;
import com.shredemption.streetparts.template.AttachableHorizontalBlock;

import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.contents.PlainTextContents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SignApplicator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

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
    @SuppressWarnings("null")
    protected ItemInteractionResult useItemOn(
            @Nonnull ItemStack stack, @Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos,
            @Nonnull Player player, @Nonnull InteractionHand hand, @Nonnull BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof DirectionSignBlockEntity directionSignEntity) {
            SignApplicator usedItem = stack.getItem() instanceof SignApplicator applicator ? applicator
                    : null;
            boolean canApplyItem = usedItem != null && player.mayBuild();
            if (!level.isClientSide) {
                if (canApplyItem && !directionSignEntity.isWaxed()
                        && !this.otherPlayerIsEditingSign(player, directionSignEntity)) {
                    boolean isFrontText = directionSignEntity.isFacingFrontText(player);
                    if (usedItem.canApplyToSign(directionSignEntity.getText(isFrontText), player)
                            && usedItem.tryApplyToSign(level, directionSignEntity, isFrontText, player)) {
                        directionSignEntity.executeClickCommandsIfPresent(player, level, pos, isFrontText);
                        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                        level.gameEvent(
                                GameEvent.BLOCK_CHANGE, directionSignEntity.getBlockPos(),
                                GameEvent.Context.of(player, directionSignEntity.getBlockState()));
                        stack.consume(1, player);
                        return ItemInteractionResult.SUCCESS;
                    } else {
                        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                    }
                } else {
                    return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                }
            } else {
                return !canApplyItem && !directionSignEntity.isWaxed() ? ItemInteractionResult.CONSUME
                        : ItemInteractionResult.SUCCESS;
            }
        } else {
            return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
        }
    }

    @Override
    protected InteractionResult useWithoutItem(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos,
            @Nonnull Player player, @Nonnull BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof DirectionSignBlockEntity directionSignEntity) {
            if (level.isClientSide) {
                Util.pauseInIde(new IllegalStateException("Expected to only call this on server"));
            }

            boolean isFrontText = directionSignEntity.isFacingFrontText(player);
            boolean hadClickCommand = directionSignEntity.executeClickCommandsIfPresent(player, level, pos,
                    isFrontText);
            if (directionSignEntity.isWaxed()) {
                level.playSound(null, directionSignEntity.getBlockPos(),
                        directionSignEntity.getSignInteractionFailedSoundEvent(), SoundSource.BLOCKS);
                return InteractionResult.SUCCESS;
            } else if (hadClickCommand) {
                return InteractionResult.SUCCESS;
            } else if (!this.otherPlayerIsEditingSign(player, directionSignEntity)
                    && player.mayBuild()
                    && this.hasEditableText(player, directionSignEntity, isFrontText)) {
                this.openTextEdit(player, directionSignEntity, isFrontText);
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.PASS;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    private boolean otherPlayerIsEditingSign(Player player, DirectionSignBlockEntity directionSignEntity) {
        UUID uuid = directionSignEntity.getPlayerWhoMayEdit();
        return uuid != null && !uuid.equals(player.getUUID());
    }

    @OnlyIn(Dist.CLIENT)
    public void openTextEdit(Player player, DirectionSignBlockEntity directionSignEntity, boolean editingFrontText) {
        Minecraft mc = Minecraft.getInstance();

        mc.execute(() -> {
            Screen currentScreen = mc.screen;
            if (currentScreen != null)
                currentScreen.removed();

            mc.setScreen(new DirectionSignEditScreen(directionSignEntity, editingFrontText));
        });
    }

    private boolean hasEditableText(Player player, DirectionSignBlockEntity directionSignEntity, boolean isFrontText) {
        SignText signtext = directionSignEntity.getText(isFrontText);
        return Arrays.stream(signtext.getMessages(player.isTextFilteringEnabled()))
                .allMatch(p_339537_ -> p_339537_.equals(CommonComponents.EMPTY)
                        || p_339537_.getContents() instanceof PlainTextContents);
    }

    public Vec3 getSignHitboxCenterPosition(BlockState state) {
        return new Vec3(0.5, 0.5, 0.5);
    }

    public float getYRotationDegrees(BlockState state) {
        return state.getValue(FACING).toYRot() - 90.0F;
    }

}
