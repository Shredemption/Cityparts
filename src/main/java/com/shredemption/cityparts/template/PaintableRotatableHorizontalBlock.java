package com.shredemption.cityparts.template;

import com.shredemption.cityparts.registry.DataComponentsRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PaintableRotatableHorizontalBlock extends RotatableHorizontalBlock {

    public static final EnumProperty<DyeColor> COLOR = EnumProperty.create("color", DyeColor.class);

    public PaintableRotatableHorizontalBlock(Properties properties, VoxelShape shape) {
        super(properties, shape);
        this.registerDefaultState(this.stateDefinition.any().setValue(COLOR, DyeColor.WHITE));
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(COLOR);
    }

    public static DyeColor getDyeColor(BlockState state) {
        return state.getValue(COLOR);
    }

    public static int getColor(BlockState state) {
        return getDyeColor(state).getTextureDiffuseColor();
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player,
            InteractionHand hand, BlockHitResult hit) {

        if (stack.isDamageableItem() && stack.getDamageValue() >= stack.getMaxDamage()) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        DyeColor color = stack.get(DataComponentsRegistry.PAINT_COLOR.get());

        if (color != null && state.getValue(COLOR) != color) {

            level.setBlock(pos, state.setValue(COLOR, color), 3);

            if (!level.isClientSide && !player.getAbilities().instabuild) {
                stack.setDamageValue(stack.getDamageValue() + 1);
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}