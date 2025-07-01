package net.colby.chipchonkmod.entity.custom;

import net.colby.chipchonkmod.block.ModBlocks;
import net.colby.chipchonkmod.entity.ModEntities;
import net.colby.chipchonkmod.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GravityField;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class GrenadeProjectileEntity extends ThrownItemEntity {
    public GrenadeProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public GrenadeProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.GRENADE_PROJECTILE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.GRENADE;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry entityTrackerEntry) {
        return super.createSpawnPacket(entityTrackerEntry);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if(!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 5f, false, World.ExplosionSourceType.TNT);
        }
        this.discard();
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if(!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 5f, false, World.ExplosionSourceType.TNT);
        }
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i = 1;
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), (float)i);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }
}
