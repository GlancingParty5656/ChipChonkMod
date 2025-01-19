package net.colby.chipchonkmod;

import net.colby.chipchonkmod.block.ModBlocks;
import net.colby.chipchonkmod.entity.ModEntities;
import net.colby.chipchonkmod.entity.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class ChipChonkModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACORN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_OAK_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_OAK_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_OAK_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACORN_LAYER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACORN_LAYER_BLOCK, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MEEPLES, MeeplesModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MEEPLES, MeeplesRenderer::new);
        EntityRendererRegistry.register(ModEntities.ACORN_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CHIPMUNK, ChipmunkModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CHIPMUNK, ChipmunkRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BULLET, BulletEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BULLET, BulletEntityRenderer::new);
    }
}
