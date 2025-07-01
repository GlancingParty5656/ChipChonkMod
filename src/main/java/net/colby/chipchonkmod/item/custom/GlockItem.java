
package net.colby.chipchonkmod.item.custom;

public class GlockItem extends GunItem {

    private static final int SHOT_COOLDOWN = 15;
    private static final float BULLET_SPEED = 8f;
    private static final float DIVERGENCE = 0.2f;
    private static final int NUM_OF_BULLETS = 1;

    public GlockItem(Settings settings) {
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
