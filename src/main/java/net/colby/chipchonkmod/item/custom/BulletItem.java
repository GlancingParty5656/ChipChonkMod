package net.colby.chipchonkmod.item.custom;

import net.colby.chipchonkmod.entity.custom.BulletEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class BulletItem extends Item implements ProjectileItem {
    public BulletItem(Item.Settings settings) {
        super(settings);
    }
    public static PersistentProjectileEntity createBullet(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        return new BulletEntity(world, shooter, stack.copyWithCount(1), shotFrom);
    }

    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        BulletEntity bulletEntity = new BulletEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1), (ItemStack)null);
        bulletEntity.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
        return bulletEntity;
    }
}
