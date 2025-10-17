package com.shredemption.streetparts.render;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.shredemption.streetparts.block.DirectionSignBlock;
import com.shredemption.streetparts.blockentity.DirectionSignBlockEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DirectionSignRenderer implements BlockEntityRenderer<DirectionSignBlockEntity> {

    private static final ResourceLocation TEXTURE = fromNamespaceAndPath("streetparts",
            "textures/block/blue_bricks.png");

    public static final ModelLayerLocation DIRECTION_SIGN_LAYER = new ModelLayerLocation(
            fromNamespaceAndPath("streetparts", "direction_sign"), "main");

    private static final Vec3 TEXT_OFFSET = new Vec3(0.0, 0.25F, 0.05F);
    private static final float MODEL_SCALE = 1f;

    private final Font font;
    private final SignModel model;

    public DirectionSignRenderer(BlockEntityRendererProvider.Context context) {
        this.font = context.getFont();
        this.model = new SignModel(context.bakeLayer(DIRECTION_SIGN_LAYER));
    }

    public static LayerDefinition createDirectionSignLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        root.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(0, 0)
                .addBox(7, 4, -6, 2, 8, 22), PartPose.offset(-8f, -8f, -8f));

        return LayerDefinition.create(mesh, 16, 16);
    }

    @Override
    public void render(@Nonnull DirectionSignBlockEntity sign, float partialTick, @Nonnull PoseStack poseStack,
            @Nonnull MultiBufferSource buffer,
            int packedLight, int packedOverlay) {
        BlockState state = sign.getBlockState();
        if (!(state.getBlock() instanceof DirectionSignBlock))
            return;

        poseStack.pushPose();

        poseStack.translate(0.5, 0.5, 0.5);

        DirectionProperty FACING = DirectionSignBlock.FACING;
        float rotation = -state.getValue(FACING).toYRot();
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation));

        VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityCutout(TEXTURE));

        poseStack.pushPose();
        poseStack.scale(MODEL_SCALE, MODEL_SCALE, MODEL_SCALE);
        this.model.root.render(poseStack, vertexconsumer, packedLight, packedOverlay);
        poseStack.popPose();

        renderText(sign, poseStack, buffer, packedLight);

        poseStack.popPose();
    }

    private void renderText(DirectionSignBlockEntity sign, PoseStack poseStack, MultiBufferSource buffer,
            int packedLight) {
        SignText text = sign.getFrontText();
        FormattedCharSequence[] lines = text.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), s -> {
            var list = this.font.split(s, sign.getMaxTextLineWidth());
            return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
        });

        poseStack.pushPose();
        poseStack.translate(TEXT_OFFSET.x, TEXT_OFFSET.y, TEXT_OFFSET.z);
        poseStack.scale(0.015625F, -0.015625F, 0.015625F);

        int color = text.getColor().getTextColor();
        int darkColor = FastColor.ARGB32.color(0, (int) (FastColor.ARGB32.red(color) * 0.4),
                (int) (FastColor.ARGB32.green(color) * 0.4),
                (int) (FastColor.ARGB32.blue(color) * 0.4));

        for (int i = 0; i < 4; i++) {
            FormattedCharSequence line = lines[i];
            float x = -this.font.width(line) / 2f;
            this.font.drawInBatch(line, x, i * 10 - 20, color, false, poseStack.last().pose(), buffer,
                    Font.DisplayMode.POLYGON_OFFSET, 0, packedLight);

        }

        poseStack.popPose();
    }

    @Override
    public boolean shouldRenderOffScreen(@Nonnull DirectionSignBlockEntity blockEntity) {
        return true;
    }

    public static class SignModel extends net.minecraft.client.model.Model {
        public final ModelPart root;

        public SignModel(ModelPart root) {
            super(RenderType::entityCutoutNoCull);
            this.root = root.getChild("plate");
        }

        @Override
        public void renderToBuffer(@Nonnull PoseStack poseStack, @Nonnull VertexConsumer vertexConsumer,
                int packedLight,
                int packedOverlay, int color) {
            this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        }
    }

}
