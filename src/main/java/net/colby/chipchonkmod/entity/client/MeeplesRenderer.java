package net.colby.chipchonkmod.entity.client;

import net.colby.chipchonkmod.ChipChonkMod;
import net.colby.chipchonkmod.entity.custom.MeeplesEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MeeplesRenderer extends MobEntityRenderer<MeeplesEntity, MeeplesModel<MeeplesEntity>> {
    private static final Identifier TEXTURE = Identifier.of(ChipChonkMod.MOD_ID, "textures/entity/meeples.png");

    public MeeplesRenderer(EntityRendererFactory.Context context) {
        super(context, new MeeplesModel<>(context.getPart(ModModelLayers.MEEPLES)), 0.1f);
    }

    @Override
    public Identifier getTexture(MeeplesEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(MeeplesEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(1f, 1f, 1f);
        } else {
            matrixStack.scale(4f, 4f, 4f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
