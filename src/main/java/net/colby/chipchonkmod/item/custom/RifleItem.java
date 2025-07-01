package net.colby.chipchonkmod.item.custom;

import net.colby.chipchonkmod.entity.custom.BulletEntity;
import net.colby.chipchonkmod.item.ModItems;
import net.colby.chipchonkmod.sound.ModSounds;
import net.minecraft.entity.Entity;
import net.colby.chipchonkmod.entity.custom.BulletEntity;
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

public class RifleItem extends GunItem implements ScopedGuns {

    private static final int SHOT_COOLDOWN = 0;
    private static final float BULLET_SPEED = 10f;
    private static final float DIVERGENCE = 0.2f;
    private static final int NUM_OF_BULLETS = 1;

    public RifleItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getShotCooldown() {
        return SHOT_COOLDOWN;
    }

    @Override
    public float getDivergence() {
        return DIVERGENCE;
    }

    @Override
    public int getNumOfBullets() {
        return NUM_OF_BULLETS;
    }

    @Override
    public float getBulletSpeed() {
        return BULLET_SPEED;
    }

}