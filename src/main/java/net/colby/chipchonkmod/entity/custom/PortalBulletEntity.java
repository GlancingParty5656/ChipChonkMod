package net.colby.chipchonkmod.entity.custom;

import net.colby.chipchonkmod.block.ModBlocks;
import net.colby.chipchonkmod.block.custom.PortalBlock;
import net.colby.chipchonkmod.block.custom.PortalBlockColor;
import net.colby.chipchonkmod.entity.ModEntities;
import net.colby.chipchonkmod.item.ModItems;
import net.colby.chipchonkmod.item.custom.PortalGunItem;
import net.colby.chipchonkmod.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PortalBulletEntity extends PersistentProjectileEntity {

    public ItemStack gunShotFrom;

    public PortalBulletEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public PortalBulletEntity(World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(ModEntities.BULLET, x, y, z, world, stack, shotFrom);
    }

    public PortalBulletEntity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(ModEntities.BULLET, owner, world, stack, shotFrom);
    }

    @Override
    protected void onBlockHit(BlockHitResult hitResult) {
        if(!this.getWorld().isClient()) {

            //if gunShotFrom.
            this.getWorld().setBlockState(getBlockPos(), ModBlocks.PORTAL_BLOCK.getDefaultState().with(PortalBlock.COLOR, PortalBlockColor.ORANGE));
        }
        this.discard();
        super.onBlockHit(hitResult);
    }

    @Override
    protected void onHit(LivingEntity target) {

        this.discard();
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return null;
    }
}
