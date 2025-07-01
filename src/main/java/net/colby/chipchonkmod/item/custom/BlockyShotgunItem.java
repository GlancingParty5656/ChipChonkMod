package net.colby.chipchonkmod.item.custom;

import net.minecraft.item.Item;

public class BlockyShotgunItem extends GunItem {
    private static final int SHOT_COOLDOWN = 30;
    private static final float BULLET_SPEED = 15f;
    private static final float DIVERGENCE = 5f;
    private static final int NUM_OF_BULLETS = 25;

    public BlockyShotgunItem(Item.Settings settings) {
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
