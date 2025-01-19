package net.colby.chipchonkmod.entity.client;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

import net.colby.chipchonkmod.entity.animation.MeeplesAnimations;
import net.colby.chipchonkmod.entity.custom.MeeplesEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class MeeplesModel<T extends MeeplesEntity> extends SinglePartEntityModel<T> {
	private final ModelPart meeples;

	public MeeplesModel(ModelPart root) {
		this.meeples = root.getChild("meeples");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData meeples = modelPartData.addChild("meeples", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData face = meeples.addChild("face", ModelPartBuilder.create().uv(0, 6).cuboid(-0.25F, -0.75F, -6.25F, 0.5F, 0.5F, 0.5F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.525F, -0.6F, -6.3F, 0.25F, 0.25F, 0.25F, new Dilation(0.0F))
		.uv(3, 4).cuboid(-0.925F, -0.75F, -6.25F, 0.5F, 0.5F, 0.25F, new Dilation(0.0F))
		.uv(3, 6).cuboid(0.425F, -0.75F, -6.25F, 0.5F, 0.5F, 0.25F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-0.775F, -0.6F, -6.3F, 0.25F, 0.25F, 0.25F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData tail = meeples.addChild("tail", ModelPartBuilder.create().uv(12, 3).cuboid(-0.75F, -0.6F, 2.0F, 1.5F, 0.25F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData body = meeples.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -6.0F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData front_left_leg = meeples.addChild("front_left_leg", ModelPartBuilder.create().uv(4, 4).cuboid(0.9F, -0.75F, -0.5F, 1.0F, 0.5F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -4.0F));

		ModelPartData front_right_leg = meeples.addChild("front_right_leg", ModelPartBuilder.create().uv(0, 2).cuboid(-1.9F, -0.75F, -0.5F, 1.0F, 0.5F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -4.0F));

		ModelPartData back_right_leg = meeples.addChild("back_right_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-1.9F, -0.75F, -0.5F, 1.0F, 0.5F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData back_left_leg = meeples.addChild("back_left_leg", ModelPartBuilder.create().uv(0, 4).cuboid(0.9F, -0.75F, -0.5F, 1.0F, 0.5F, 0.75F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(MeeplesEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(MeeplesAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);

		this.updateAnimation(entity.idleAnimationState, MeeplesAnimations.IDLE, ageInTicks, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		meeples.render(matrices, vertexConsumer, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return meeples;
	}
}