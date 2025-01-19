package net.colby.chipchonkmod.item.custom;

import net.colby.chipchonkmod.entity.custom.AcornProjectileEntity;
import net.colby.chipchonkmod.entity.custom.BulletEntity;
import net.colby.chipchonkmod.item.ModItems;
import net.colby.chipchonkmod.sound.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Predicate;

public class RifleItem extends RangedWeaponItem {

    public static final Predicate<ItemStack> GUN_AMMO = (stack) -> stack.isOf(ModItems.BULLET);
    private static final int FIRE_RATE_DELAY = 5; // Delay in ticks between shots (adjustable)
    private int ticksSinceLastShot = 0;

    public RifleItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        boolean hasAmmo = !user.getProjectileType(itemStack).isEmpty();

        if (!user.isInCreativeMode() && !hasAmmo) {
            return TypedActionResult.fail(itemStack);
        } else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity playerEntity && playerEntity.isUsingItem()) {
            // We only want to shoot when the player is holding the item and the item is usable
            if (ticksSinceLastShot >= FIRE_RATE_DELAY) {
                shootWhileHolding(stack, world, playerEntity);
                ticksSinceLastShot = 0; // Reset the tick counter
            } else {
                ticksSinceLastShot++;
            }
        }
    }

    // Called when the player holds right-click and is continuously shooting
    private void shootWhileHolding(ItemStack stack, World world, PlayerEntity playerEntity) {
        ItemStack itemStack = playerEntity.getProjectileType(stack);
        if (!itemStack.isEmpty()) { // Ensure the itemStack is not empty before proceeding
            List<ItemStack> list = load(stack, itemStack, playerEntity);
            if (world instanceof ServerWorld serverWorld) {
                if (!list.isEmpty()) {
                    // Create and shoot a bullet
                    BulletEntity bullet = new BulletEntity(world, playerEntity, itemStack.copyWithCount(1), null);
                    bullet.setOwner(playerEntity); // Set the shooter as the owner of the bullet
                    shootBullet(playerEntity, bullet); // Call the unchanged shootBullet method
                    serverWorld.spawnEntity(bullet);

                    // Play sound and increment stats
                    world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), ModSounds.GUNSHOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F));
                    playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
                }
            }
        }
    }

    // The original shootBullet method, unchanged
    private void shootBullet(LivingEntity shooter, BulletEntity bullet) {
        // Adjust the bullet's velocity based on the shooter’s direction
        bullet.setVelocity(shooter, shooter.getPitch(), shooter.getYaw(), 0.0F, 15.0F, 0.0F); // Adjust velocity
    }

    // The original shoot method, unchanged
    @Override
    public void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target) {
        // This method is now implemented as required by RangedWeaponItem.
        // Apply the velocity to the projectile (bullet) based on the shooter and the provided parameters.
        if (projectile instanceof BulletEntity bullet) {
            bullet.setVelocity(shooter, shooter.getPitch(), shooter.getYaw() + yaw, 0.0F, speed * 15F, divergence); // Adjust bullet velocity
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 0; // Instant use for rapid fire
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    public Predicate<ItemStack> getProjectiles() {
        return GUN_AMMO;
    }

    @Override
    public int getRange() {
        return 156;
    }
}
