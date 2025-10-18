package com.shredemption.streetparts.gui;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

import javax.annotation.Nonnull;

import org.joml.Vector3f;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.shredemption.streetparts.StreetParts;
import com.shredemption.streetparts.blockentity.DirectionSignBlockEntity;
import com.shredemption.streetparts.render.DirectionSignRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.font.TextFieldHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DirectionSignEditScreen extends Screen {

    private static final float TEXT_SCALE = 1.0f;
    private static final int MAX_LINES = 2;

    private final DirectionSignBlockEntity sign;
    private String[] messages;
    private int line = 0;
    private TextFieldHelper signField;
    private final boolean isFrontText;

    private DirectionSignModel signModel;

    public DirectionSignEditScreen(DirectionSignBlockEntity sign, boolean isFrontText) {
        super(Component.translatable("sign.edit"));
        this.sign = sign;
        this.isFrontText = isFrontText;

        this.messages = new String[MAX_LINES];
        for (int i = 0; i < MAX_LINES; i++) {
            this.messages[i] = sign.getText(isFrontText).getMessage(i, false).getString();
        }
    }

    @SuppressWarnings("null")
    @Override
    protected void init() {
        this.addRenderableWidget(Button.builder(Component.literal("Done"), b -> this.onDone())
                .bounds(this.width / 2 - 100, this.height / 4 + 144, 200, 20).build());

        this.signField = new TextFieldHelper(
                () -> this.messages[this.line],
                this::setMessage,
                TextFieldHelper.createClipboardGetter(this.minecraft),
                TextFieldHelper.createClipboardSetter(this.minecraft),
                s -> this.minecraft.font.width(s) <= this.sign.getMaxTextLineWidth());

        this.signModel = new DirectionSignModel(
                Minecraft.getInstance().getEntityModels().bakeLayer(DirectionSignModel.LAYER_LOCATION));
    }

    private void setMessage(String message) {
        this.messages[this.line] = message;
        this.sign.setText(sign.getText(this.isFrontText).setMessage(this.line, Component.literal(message)),
                this.isFrontText);
    }

    private void onDone() {
        this.minecraft.setScreen(null);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        switch (keyCode) {
            case 265 -> { // up
                this.line = (this.line - 1 + MAX_LINES) % MAX_LINES;
                this.signField.setCursorToEnd();
                return true;
            }
            case 264, 257, 335 -> { // down, enter, num enter
                this.line = (this.line + 1) % MAX_LINES;
                this.signField.setCursorToEnd();
                return true;
            }
        }
        return this.signField.keyPressed(keyCode) || super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean charTyped(char codePoint, int modifiers) {
        this.signField.charTyped(codePoint);
        return true;
    }

    @Override
    public void render(@Nonnull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        if (this.minecraft == null)
            return;

        super.render(guiGraphics, mouseX, mouseY, partialTick);

        Lighting.setupForFlatItems();

        // title
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 40, 0xFFFFFF);

        // sign

        float direction = isFrontText ? -1f : 1f;

        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(this.width / 2f + direction * 15f, 90f, 50f);
        guiGraphics.pose().scale(75f, 75f, 75f);

        guiGraphics.pose().mulPose(Axis.YP.rotationDegrees(direction * 89f));

        VertexConsumer vertex = guiGraphics.bufferSource()
                .getBuffer(RenderType.entityCutout(DirectionSignRenderer.TEXTURE));
        this.signModel.bb_main.render(guiGraphics.pose(), vertex, 0xFF00FF, OverlayTexture.NO_OVERLAY);
        guiGraphics.pose().popPose();

        // Render 2 lines of text on sign
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(this.width / 2f, 94f, 55f);
        Vector3f scale = new Vector3f(TEXT_SCALE, TEXT_SCALE, TEXT_SCALE);
        guiGraphics.pose().scale(scale.x(), scale.y(), scale.z());

        int color = sign.getText(this.isFrontText).getColor().getTextColor();
        int lineHeight = sign.getTextLineHeight();
        for (int i = 0; i < MAX_LINES; i++) {
            String text = this.messages[i];
            int x = -this.font.width(text) / 2;
            int y = i * lineHeight - lineHeight;
            guiGraphics.drawString(this.font, text, x, y, color, false);
        }
        guiGraphics.pose().popPose();

        Lighting.setupFor3DItems();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderTransparentBackground(guiGraphics);
    }
}

class DirectionSignModel extends Model {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            fromNamespaceAndPath(StreetParts.MOD_ID, "direction_sign"), "main");
    public final ModelPart bb_main;

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