package com.shredemption.streetparts.render;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.shredemption.streetparts.block.DirectionSignBlock;
import com.shredemption.streetparts.blockentity.DirectionSignBlockEntity;

import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

public class DirectionSignRenderer implements BlockEntityRenderer<DirectionSignBlockEntity> {
    private static final ResourceLocation TEXTURE = fromNamespaceAndPath("streetparts",
            "textures/block/blue_bricks.png");
    private final Font font;
    private final float scale = 1.0f;

    public DirectionSignRenderer(BlockEntityRendererProvider.Context context) {
        this.font = context.getFont();
    }

    @Override
    public void render(@Nonnull DirectionSignBlockEntity sign, float partialTick, @Nonnull PoseStack pose,
            @Nonnull MultiBufferSource buffer,
            int packedLight, int packedOverlay) {
        BlockState state = sign.getBlockState();
        Direction facing = state.getValue(DirectionSignBlock.FACING);

        pose.pushPose();

        pose.translate(0.5, 0.5, 0.5);

        float rotation = -facing.toYRot();
        pose.mulPose(Axis.YP.rotationDegrees(rotation));

        pose.translate(0.0, 0.0, 0.4375);

        String text = sign.getText(false).getMessage(0, false).getString();

        pose.scale(scale, -scale, scale);
        float textWidth = font.width(text);
        font.drawInBatch(text, -textWidth / 2f, 0, 0x000000, false, pose.last().pose(), buffer, Font.DisplayMode.NORMAL,
                0, packedLight);
    }

    @Override
    public boolean shouldRenderOffScreen(@Nonnull DirectionSignBlockEntity blockEntity) {
        return true;
    }

}
