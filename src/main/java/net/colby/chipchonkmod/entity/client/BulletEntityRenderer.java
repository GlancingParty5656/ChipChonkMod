package net.colby.chipchonkmod.entity.client;

import net.colby.chipchonkmod.ChipChonkMod;
import net.colby.chipchonkmod.entity.custom.BulletEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;

public class BulletEntityRenderer extends EntityRenderer<BulletEntity> {
    public static final Identifier TEXTURE = Identifier.of(ChipChonkMod.MOD_ID, "textures/entity/bullet.png");
    private final BulletEntityModel<BulletEntity> model;

    public BulletEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new BulletEntityModel<>(context.getPart(ModModelLayers.BULLET));
    }

    @Override
    public Identifier getTexture(BulletEntity bulletEntity) {
        return TEXTURE;
    }

    @Override
    public void render(BulletEntity bulletEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {

        //matrixStack.push();

        super.render(bulletEntity, f, g, matrixStack, vertexConsumerProvider, i);
        model.render(matrixStack, vertexConsumerProvider.getBuffer(RenderLayer.getEntitySolid(TEXTURE)), i, OverlayTexture.DEFAULT_UV);
        //matrixStack.pop();
    }
}

