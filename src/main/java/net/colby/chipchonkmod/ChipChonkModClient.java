package net.colby.chipchonkmod;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.colby.chipchonkmod.block.ModBlocks;
import net.colby.chipchonkmod.entity.ModEntities;
import net.colby.chipchonkmod.entity.client.*;
import net.colby.chipchonkmod.item.ModItems;
import net.colby.chipchonkmod.item.custom.GunItem;
import net.colby.chipchonkmod.item.custom.PortalGunItem;
import net.colby.chipchonkmod.item.custom.ScopedGuns;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.font.GlyphRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.BlockLocating;
import net.minecraft.world.biome.FoliageColors;
import org.lwjgl.glfw.GLFW;
import org.w3c.dom.css.Rect;

import java.util.HashSet;
import java.util.Set;

public class ChipChonkModClient implements ClientModInitializer {

    private boolean isScoped = false;
    private Double previousFov = null;
    private boolean wasAttacking = false;

    @Override
    public void onInitializeClient() {
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACORN_LEAVES, RenderLayer.getCutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_OAK_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_OAK_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_OAK_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACORN_LAYER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACORN_LAYER_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBERRY_BUSH, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MEEPLES, MeeplesModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MEEPLES, MeeplesRenderer::new);
        EntityRendererRegistry.register(ModEntities.ACORN_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.GRENADE_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CHIPMUNK, ChipmunkModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CHIPMUNK, ChipmunkRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BULLET, BulletEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BULLET, BulletEntityRenderer::new);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            boolean holdingGun = client.player.getMainHandStack().getItem() instanceof ScopedGuns;
            boolean isSneaking = client.player.isSneaking();

            // Zoom in when holding gun and sneaking
            if (isSneaking && holdingGun) {
                if (!isScoped) {
                    isScoped = true;
                    previousFov = client.options.getFov().getValue().doubleValue();  // Store previous FOV
                    client.options.getFov().setValue(30);  // Set FOV for scoped
                }
            } else if (isScoped) {
                isScoped = false;
                client.options.getFov().setValue(previousFov.intValue());  // Restore previous FOV
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.world == null) return;

            long window = MinecraftClient.getInstance().getWindow().getHandle();
            boolean isAttacking = GLFW.glfwGetMouseButton(window, GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS;

            if (isAttacking && !wasAttacking) {
                ItemStack stack = client.player.getMainHandStack();
                if (stack.getItem() instanceof PortalGunItem portalGun) {
                    portalGun.toggleGunMode();

                    client.inGameHud.setOverlayMessage(stack.getName(), false);

                }
            }

            wasAttacking = isAttacking;
        });


        // Register the HUD rendering event to draw custom scope overlay
        HudRenderCallback.EVENT.register(this::onHudRender);
    }

    private void onHudRender(DrawContext context, RenderTickCounter tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (!isScoped || !client.options.getPerspective().isFirstPerson()) return;

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        int screenWidth = context.getScaledWindowWidth();
        int screenHeight = context.getScaledWindowHeight();

        int textureSize = 256; // actual texture file is 256x256
        int scopeDrawSize = screenHeight; // fill screen height

        int x = (screenWidth - scopeDrawSize) / 2;
        int y = (screenHeight - scopeDrawSize) / 2;

        // Now draw the scaled scope texture
        context.drawTexture(
                Identifier.of("chipchonkmod", "textures/misc/gun_scope.png"),
                x, y,
                0f, 0f,
                scopeDrawSize, scopeDrawSize, // Use draw size here too
                scopeDrawSize, scopeDrawSize  // Match textureSize to draw size to prevent UV wrap
        );

        // Draw black bars first (left and right of scope)
        context.fill(0, 0, x, screenHeight, 0xFF000000); // Left
        context.fill(x + scopeDrawSize, 0, screenWidth, screenHeight, 0xFF000000); // Right

        RenderSystem.disableBlend();
    }
}