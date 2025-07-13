package net.colby.chipchonkmod.entity.custom;

import net.colby.chipchonkmod.entity.ModEntities;
import net.colby.chipchonkmod.item.ModItems;
import net.colby.chipchonkmod.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.EntityEffectParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

public class BulletEntity extends PersistentProjectileEntity {

    public boolean EXPLOSIVE = false;
    public boolean BLOCKY = false;

    public BulletEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public BulletEntity(World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(ModEntities.BULLET, x, y, z, world, stack, shotFrom);
    }

    public BulletEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(ModEntities.BULLET, owner, world, stack, shotFrom);
    }

    private BlockState getRandomBlock() {
        int randomIndex = Random.create().nextInt(Registries.BLOCK.size());
        Block block = Registries.BLOCK.get(randomIndex);
        return block.getDefaultState();
    }

    @Override
    protected void onBlockHit(BlockHitResult hitResult) {
        if (this.EXPLOSIVE) {
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 5f, World.ExplosionSourceType.TNT);
        }

        if (this.BLOCKY) {
            this.getWorld().setBlockState(hitResult.getBlockPos(), getRandomBlock());
        }
        this.discard();
    }

    @Override
    protected void onHit(LivingEntity target) {
        if (this.EXPLOSIVE) {
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 5f, World.ExplosionSourceType.TNT);
        }
        this.discard();
    }

    @Override
    protected SoundEvent getHitSound() {
        return ModSounds.BULLET_LAND;
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.BULLET);
    }
}