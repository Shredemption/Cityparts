package com.shredemption.cityparts.render;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.shredemption.cityparts.CityParts;
import com.shredemption.cityparts.block.DirectionSignBlock;
import com.shredemption.cityparts.blockentity.DirectionSignBlockEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DirectionSignRenderer implements BlockEntityRenderer<DirectionSignBlockEntity> {

    public static final ResourceLocation TEXTURE = fromNamespaceAndPath("cityparts",
            "textures/entity/signs/direction.png");

    public static final ModelLayerLocation DIRECTION_SIGN_LAYER = new ModelLayerLocation(
            fromNamespaceAndPath("cityparts", "direction_sign"), "main");

    private static final Vec3 TEXT_OFFSET = new Vec3(0.073f, -0.125f, -0.2f);
    private static final float TEXT_SCALE = 0.014f;
    private static final float MODEL_SCALE = 1f;

    private final Font font;
    private final DirectionSignModel model;

    public DirectionSignRenderer(BlockEntityRendererProvider.Context context) {
        this.font = context.getFont();
        this.model = new DirectionSignModel(context.bakeLayer(DirectionSignModel.LAYER_LOCATION));
    }

    public static LayerDefinition createDirectionSignLayer() {
        return DirectionSignModel.createBodyLayer();
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

        Direction facing = state.getValue(DirectionSignBlock.FACING);
        float rotation = -facing.toYRot();
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation));

        VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityCutout(TEXTURE));

        poseStack.pushPose();
        poseStack.scale(MODEL_SCALE, MODEL_SCALE, MODEL_SCALE);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, packedOverlay);
        poseStack.popPose();

        renderText(sign, poseStack, buffer, packedLight, facing);

        poseStack.popPose();
    }

    private void renderText(DirectionSignBlockEntity sign, PoseStack poseStack, MultiBufferSource buffer,
            int packedLight, Direction facing) {

        for (int side = 0; side < 2; side++) {
            boolean isFront = (side == 0);
            SignText text = isFront ? sign.getFrontText() : sign.getBackText();

            poseStack.pushPose();

            Vec3 offset = TEXT_OFFSET;
            if (!isFront) {
                offset = new Vec3(-TEXT_OFFSET.x, TEXT_OFFSET.y, TEXT_OFFSET.z);
            }

            poseStack.translate(offset.x, offset.y, offset.z);

            poseStack.mulPose(Axis.YP.rotationDegrees(90f));

            if (!isFront) {
                poseStack.mulPose(Axis.YP.rotationDegrees(180f));
            }

            poseStack.scale(TEXT_SCALE, -TEXT_SCALE, TEXT_SCALE);

            renderTextLines(sign, text, poseStack, buffer, packedLight);
            poseStack.popPose();
        }
    }

    private void renderTextLines(DirectionSignBlockEntity sign, SignText text, PoseStack poseStack,
            MultiBufferSource buffer, int packedLight) {
        FormattedCharSequence[] lines = text.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), s -> {
            var list = this.font.split(s, sign.getMaxTextLineWidth());
            return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
        });

        int color = text.getColor().getTextColor();

        for (int i = 0; i < 2; i++) {
            FormattedCharSequence line = lines[i];
            float x = -this.font.width(line) / 2f;
            this.font.drawInBatch(line, x, i * 10 - 20, color, false, poseStack.last().pose(), buffer,
                    Font.DisplayMode.POLYGON_OFFSET, 0, packedLight);

        }
    }

    @Override
    public boolean shouldRenderOffScreen(@Nonnull DirectionSignBlockEntity blockEntity) {
        return true;
    }
}

class DirectionSignModel extends Model {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            fromNamespaceAndPath(CityParts.MOD_ID, "direction_sign"), "main");
    private final ModelPart bb_main;

    public DirectionSignModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(),
                PartPose.offset(0.0F, -3.0F, 0.0F));

        bb_main.addOrReplaceChild("cube_r1",
                CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 5.0F, 5.0F,
                        new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.7854F, 0.0F, 0.0F));

        bb_main.addOrReplaceChild("cube_r2",
                CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -3.5F, -1.0F, 22.0F, 7.0F, 2.0F,
                        new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 3.535F, -6.0F, 0.0F, -1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(@Nonnull PoseStack poseStack, @Nonnull VertexConsumer vertexConsumer, int packedLight,
            int packedOverlay, int color) {
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }
}