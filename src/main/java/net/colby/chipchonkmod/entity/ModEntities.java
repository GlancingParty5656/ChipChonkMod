package net.colby.chipchonkmod.entity;

import net.colby.chipchonkmod.ChipChonkMod;
import net.colby.chipchonkmod.entity.custom.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<MeeplesEntity> MEEPLES = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ChipChonkMod.MOD_ID, "meeples"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MeeplesEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.2f)).build());

    public static final EntityType<AcornProjectileEntity> ACORN_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ChipChonkMod.MOD_ID, "acorn_projectile"),
            FabricEntityTypeBuilder.<AcornProjectileEntity>create(SpawnGroup.MISC, AcornProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<BulletEntity> BULLET = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ChipChonkMod.MOD_ID, "bullet"),
            FabricEntityTypeBuilder.<BulletEntity>create(SpawnGroup.MISC, BulletEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<ChipmunkEntity> CHIPMUNK = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ChipChonkMod.MOD_ID, "chipmunk"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ChipmunkEntity::new)
                    .dimensions(EntityDimensions.fixed(0.3f, 0.3f)).build());

    public static final EntityType<GrenadeProjectileEntity> GRENADE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ChipChonkMod.MOD_ID, "grenade_projectile"),
            FabricEntityTypeBuilder.<GrenadeProjectileEntity>create(SpawnGroup.MISC, GrenadeProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

}
