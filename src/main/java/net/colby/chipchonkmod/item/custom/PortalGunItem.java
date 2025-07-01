package net.colby.chipchonkmod.item.custom;

import net.colby.chipchonkmod.entity.custom.BulletEntity;
import net.colby.chipchonkmod.item.ModItems;
import net.colby.chipchonkmod.sound.ModSounds;
import net.minecraft.component.Component;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Colors;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class PortalGunItem extends Item {
    private static final int SHOT_COOLDOWN = 10;
    private static final float BULLET_SPEED = 5f;
    private static final float DIVERGENCE = 0f;
    private static final int NUM_OF_BULLETS = 1;

    public String gunMode = "blue";

    public PortalGunItem(Settings settings) {
        super(settings);
    }

    /*@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack gunStack = user.getStackInHand(hand);

        if (user.getItemCooldownManager().isCoolingDown(this)) {
            return TypedActionResult.fail(gunStack);
        }

        if (!world.isClient) {
            user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_DECORATED_POT_INSERT, SoundCategory.PLAYERS, 1.0F, 1.0F);

            for (int i = 0; i < getNumOfBullets(); i++) {
                FallingBlockEntity fallingBlockEntity = new FallingBlockEntity(EntityType.FALLING_BLOCK, world);

                shoot(user, fallingBlockEntity, 0, getBulletSpeed(), getDivergence(), 0.0F, null);
            }

            user.getItemCooldownManager().set(this, getShotCooldown());
        }

        return TypedActionResult.consume(gunStack);
    }

    protected void shoot(PlayerEntity shooter, FallingBlockEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target) {

        if (shooter.getWorld() instanceof ServerWorld serverWorld && projectile instanceof BulletEntity) {
            projectile.setOwner(shooter);
            projectile.setVelocity(shooter, shooter.getPitch(), shooter.getYaw() + yaw, 0.0F, speed, divergence);
            serverWorld.spawnEntity(projectile);
        }

        shooter.getWorld().playSound(shooter, shooter.getX(), shooter.getY(), shooter.getZ(), ModSounds.GUNSHOT, SoundCategory.PLAYERS, 1.0F, 1.0F);
        if (shooter instanceof PlayerEntity player) {
            player.incrementStat(Stats.USED.getOrCreateStat(this));
        }

    }*/

    @Override
    public Text getName(ItemStack stack) {
        Formatting color;

        // Use gunMode field to pick a Formatting color
        if ("orange".equalsIgnoreCase(this.gunMode)) {
            color = Formatting.GOLD; // Close to orange
        } else if ("blue".equalsIgnoreCase(this.gunMode)) {
            color = Formatting.AQUA; // Close to cyan
        } else {
            color = Formatting.WHITE;
        }

        return Text.literal("Portal Gun").formatted(color, Formatting.BOLD);
    }

    public void toggleGunMode() {
        if ("blue".equalsIgnoreCase(this.gunMode)) {
            this.gunMode = "orange";
        } else {
            this.gunMode = "blue";
        }
    }

    public int getShotCooldown() {
        return SHOT_COOLDOWN;
    }

    public float getBulletSpeed() {
        return BULLET_SPEED;
    }

    public float getDivergence() {
        return DIVERGENCE;
    }

    public int getNumOfBullets() {
        return NUM_OF_BULLETS;
    }

}
