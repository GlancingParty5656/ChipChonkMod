package net.colby.chipchonkmod.item.custom;

import net.colby.chipchonkmod.entity.custom.BulletEntity;
import net.colby.chipchonkmod.item.ModItems;
import net.colby.chipchonkmod.sound.ModSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public abstract class GunItem extends Item {

    public static final Predicate<ItemStack> GUN_AMMO = stack -> stack.isOf(ModItems.BULLET);
    private static final int SHOT_COOLDOWN = 10;
    private static final float BULLET_SPEED = 10f;
    private static final float DIVERGENCE = 0.2f;
    private static final int NUM_OF_BULLETS = 1;

    public GunItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack gunStack = user.getStackInHand(hand);

        if (user.getItemCooldownManager().isCoolingDown(this)) {
            return TypedActionResult.fail(gunStack);
        }

        ItemStack ammoStack = findAmmo(user);
        boolean hasAmmo = !ammoStack.isEmpty();

        if (!user.isCreative() && !hasAmmo) {
            return TypedActionResult.fail(gunStack);
        }

        if (!world.isClient) {
            user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.GUNSHOT, SoundCategory.PLAYERS, 1.0F, 1.0F);
            ((ServerWorld) world).spawnParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, user.getX(), user.getY() + 1.25, user.getZ(), 10, 0, 0, 0, 0.05);

            for (int i = 0; i < getNumOfBullets(); i++) {
                BulletEntity bullet = new BulletEntity(world, user, gunStack, null);

                if (gunStack.isOf(ModItems.EXPLOSIVE_GLOCK)) {
                    bullet.EXPLOSIVE = true;
                }

                if (gunStack.isOf(ModItems.BLOCKY_SHOTGUN)) {
                    bullet.BLOCKY = true;
                }

                shoot(user, bullet, 0, getBulletSpeed(), getDivergence(), 0.0F, null);
            }

            if (!user.isCreative()) {
                ammoStack.decrement(1);
            }

            user.getItemCooldownManager().set(this, getShotCooldown());
        }

        return TypedActionResult.consume(gunStack);
    }

    protected void shoot(PlayerEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target) {

        if (shooter.getWorld() instanceof ServerWorld serverWorld && projectile instanceof BulletEntity) {
            projectile.setOwner(shooter);
            projectile.setVelocity(shooter, shooter.getPitch(), shooter.getYaw() + yaw, 0.0F, speed, divergence);
            serverWorld.spawnEntity(projectile);
        }

        shooter.getWorld().playSound(shooter, shooter.getX(), shooter.getY(), shooter.getZ(), ModSounds.GUNSHOT, SoundCategory.PLAYERS, 1.0F, 1.0F);
        if (shooter instanceof PlayerEntity player) {
            player.incrementStat(Stats.USED.getOrCreateStat(this));
        }

    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        super.postDamageEntity(stack, target, attacker);
        //target.getWorld().createExplosion(target, target.getX(), target.getY(), target.getZ(), 15f, World.ExplosionSourceType.TNT);
    }

    private ItemStack findAmmo(PlayerEntity player) {
        Predicate<ItemStack> isAmmo = GUN_AMMO;

        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (isAmmo.test(stack)) {
                return stack;
            }
        }

        return ItemStack.EMPTY;
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
