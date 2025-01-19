package net.colby.chipchonkmod.entity.client;

import net.colby.chipchonkmod.entity.custom.BulletEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;


// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BulletEntityModel<T extends BulletEntity> extends SinglePartEntityModel<T> {
    private final ModelPart bullet;

    public BulletEntityModel(ModelPart root) {
        this.bullet = root.getChild("bullet");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bullet = modelPartData.addChild("bullet", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.0F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        bullet.render(matrices, vertices, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return bullet;
    }

    @Override
    public void setAngles(BulletEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }


}
