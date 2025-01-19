package net.colby.chipchonkmod.entity.client;

import net.colby.chipchonkmod.entity.animation.ChipmunkAnimations;
import net.colby.chipchonkmod.entity.animation.MeeplesAnimations;
import net.colby.chipchonkmod.entity.custom.ChipmunkEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.11.0
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ChipmunkModel<T extends ChipmunkEntity> extends SinglePartEntityModel<T> {
	private final ModelPart chipmunk;
	private final ModelPart head;

	public ChipmunkModel(ModelPart root) {
		this.chipmunk = root.getChild("chipmunk");
		this.head = root.getChild("chipmunk").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData chipmunk = modelPartData.addChild("chipmunk", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData body = chipmunk.addChild("body", ModelPartBuilder.create().uv(0, 9).cuboid(-2.0F, -5.0F, -2.0F, 4.0F, 4.0F, 3.0F, new Dilation(0.0F))
				.uv(15, 8).cuboid(-1.5F, -4.0F, 1.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(18, 20).cuboid(-1.25F, -3.0F, 4.0F, 2.5F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = chipmunk.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -7.0F, 2.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData face = head.addChild("face", ModelPartBuilder.create().uv(10, 25).cuboid(-0.5F, -5.35F, 6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(9, 20).cuboid(-1.0F, -5.25F, 4.75F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(15, 15).cuboid(-2.0F, -5.0F, 4.5F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData ears = head.addChild("ears", ModelPartBuilder.create().uv(9, 17).cuboid(-1.5F, -8.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 22).cuboid(0.5F, -8.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData legs = chipmunk.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leg1 = legs.addChild("leg1", ModelPartBuilder.create().uv(5, 25).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -1.0F, 3.5F));

		ModelPartData leg2 = legs.addChild("leg2", ModelPartBuilder.create().uv(0, 25).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -1.0F, 3.5F));

		ModelPartData leg3 = legs.addChild("leg3", ModelPartBuilder.create().uv(23, 23).cuboid(-3.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -1.0F, -0.5F));

		ModelPartData leg4 = legs.addChild("leg4", ModelPartBuilder.create().uv(18, 23).cuboid(2.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -1.0F, -0.5F));

		ModelPartData tail = chipmunk.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData tail_connector_r1 = tail.addChild("tail_connector_r1", ModelPartBuilder.create().uv(0, 17).cuboid(-1.0F, -2.25F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, -3.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(15, 0).cuboid(-2.0F, -3.25F, -3.5F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -3.25F, -4.5F, -0.5672F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(ChipmunkEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(ChipmunkAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);

		this.updateAnimation(entity.idleAnimationState, ChipmunkAnimations.IDLE, ageInTicks, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		chipmunk.render(matrices, vertexConsumer, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return chipmunk;
	}
}