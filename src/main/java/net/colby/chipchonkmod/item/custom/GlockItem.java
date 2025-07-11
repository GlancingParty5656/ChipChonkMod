/**package net.colby.chipchonkmod.item.custom;

import net.colby.chipchonkmod.entity.custom.BulletEntity;
import net.colby.chipchonkmod.item.ModItems;
import net.colby.chipchonkmod.sound.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class GlockItem extends RangedWeaponItem {

    public static final Predicate<ItemStack> GUN_AMMO = (stack) -> stack.isOf(ModItems.BULLET);

    public GlockItem(Settings settings) {
        super(settings);
    }

    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            ItemStack itemStack = playerEntity.getProjectileType(stack);
            if (!itemStack.isEmpty()) {
                int i = this.getMaxUseTime(stack, user) - remainingUseTicks;
                float f = getPullProgress(i);
                if (!((double)f < 0.1)) {
                    List<ItemStack> list = load(stack, itemStack, playerEntity);
                    if (world instanceof ServerWorld) {
                        ServerWorld serverWorld = (ServerWorld)world;
                        if (!list.isEmpty()) {
                            BulletEntity bullet = new BulletEntity(world, playerEntity, itemStack.copyWithCount(1), null);
                            bullet.setOwner(playerEntity); // Set the shooter as the owner of the bullet
                            shootBullet(playerEntity, bullet);
                            serverWorld.spawnEntity(bullet);
                            //bullet.setYaw(playerEntity.getYaw());
                            //bullet.setPitch(playerEntity.getPitch());
                            //this.shootAll(serverWorld, playerEntity, playerEntity.getActiveHand(), stack, list, f * 3.0F, 1.0F, f == 1.0F, null);
                        }
                    }

                    world.playSound((PlayerEntity)null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), ModSounds.GUNSHOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
                }
            }
        }
    }

    /*protected void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target) {
        projectile.setVelocity(shooter, shooter.getPitch(), shooter.getYaw() + yaw, 0.0F, speed * 10, 0);
    }

    private void shootBullet(LivingEntity shooter, BulletEntity bullet) {
        // Adjust the bullet's velocity based on the shooter’s direction
        bullet.setVelocity(shooter, shooter.getPitch(), shooter.getYaw(), 0.0F, 15.0F, 0.0F); // Adjust velocity
    }

    public static float getPullProgress(int useTicks) {
        float f = (float)useTicks / 5.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target) {
        // This method is now implemented as required by RangedWeaponItem.
        // Apply the velocity to the projectile (bullet) based on the shooter and the provided parameters.
        if (projectile instanceof BulletEntity bullet) {
            bullet.setVelocity(shooter, shooter.getPitch(), shooter.getYaw() + yaw, 0.0F, speed * 15F, divergence); // Adjust bullet velocity
        }
    }



    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 0;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        boolean bl = !user.getProjectileType(itemStack).isEmpty();
        if (!user.isInCreativeMode() && !bl) {
            return TypedActionResult.fail(itemStack);
        } else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
    }

    public Predicate<ItemStack> getProjectiles() {
        return GUN_AMMO;
    }

    public int getRange() {
        return 150;
    }
}*/

package net.colby.chipchonkmod.item.custom;

import net.colby.chipchonkmod.entity.custom.BulletEntity;
import net.colby.chipchonkmod.item.ModItems;
import net.colby.chipchonkmod.sound.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import java.util.function.Predicate;

public class GlockItem extends RangedWeaponItem {
    public static final Predicate<ItemStack> GUN_AMMO = stack -> stack.isOf(ModItems.BULLET);
    private static final int COOLDOWN_TICKS = 10; // Cooldown like an Ender Pearl

    public GlockItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.getItemCooldownManager().isCoolingDown(this)) {
            return TypedActionResult.fail(user.getStackInHand(hand));
        }

        ItemStack itemStack = user.getStackInHand(hand);
        if (!user.getProjectileType(itemStack).isEmpty()) {
            BulletEntity bullet = new BulletEntity(world, user, new ItemStack(ModItems.BULLET), null);
            shoot(user, bullet, 0, 1.0F, 0.0F, 0.0F, null);
            user.getItemCooldownManager().set(this, COOLDOWN_TICKS);
            return TypedActionResult.success(itemStack, world.isClient());
        }
        return TypedActionResult.fail(itemStack);
    }

    @Override
    public void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, LivingEntity target) {
        if (shooter.getWorld() instanceof ServerWorld serverWorld && projectile instanceof BulletEntity bullet) {
            bullet.setOwner(shooter);
            bullet.setVelocity(shooter, shooter.getPitch(), shooter.getYaw(), 0.0F, 15.0F, 0.0F);
            serverWorld.spawnEntity(bullet);
        }
        shooter.getWorld().playSound(null, shooter.getX(), shooter.getY(), shooter.getZ(), ModSounds.GUNSHOT, SoundCategory.PLAYERS, 1.0F, 1.0F);
        if (shooter instanceof PlayerEntity player) {
            player.incrementStat(Stats.USED.getOrCreateStat(this));
        }
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return GUN_AMMO;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.NONE;
    }

    @Override
    public int getRange() {
        return 150;
    }
}
