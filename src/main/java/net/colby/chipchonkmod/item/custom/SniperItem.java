package net.colby.chipchonkmod.item.custom;

public class SniperItem extends GunItem implements ScopedGuns {

    private static final int SHOT_COOLDOWN = 80;
    private static final float BULLET_SPEED = 100f;
    private static final float DIVERGENCE = 0f;
    private static final int NUM_OF_BULLETS = 1;

    public SniperItem(Settings settings) {
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
