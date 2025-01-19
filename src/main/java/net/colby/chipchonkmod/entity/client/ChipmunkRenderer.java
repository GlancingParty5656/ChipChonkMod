package net.colby.chipchonkmod.entity.client;

import net.colby.chipchonkmod.ChipChonkMod;
import net.colby.chipchonkmod.entity.custom.ChipmunkEntity;
import net.colby.chipchonkmod.entity.custom.MeeplesEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ChipmunkRenderer extends MobEntityRenderer<ChipmunkEntity, ChipmunkModel<ChipmunkEntity>> {
    private static final Identifier TEXTURE = Identifier.of(ChipChonkMod.MOD_ID, "textures/entity/chipmunk.png");

    public ChipmunkRenderer(EntityRendererFactory.Context context) {
        super(context, new ChipmunkModel<>(context.getPart(ModModelLayers.CHIPMUNK)), 0.1f);
    }

    @Override
    public Identifier getTexture(ChipmunkEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(ChipmunkEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
