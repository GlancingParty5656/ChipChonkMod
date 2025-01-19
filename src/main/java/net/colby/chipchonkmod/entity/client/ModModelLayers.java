package net.colby.chipchonkmod.entity.client;

import net.colby.chipchonkmod.ChipChonkMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer MEEPLES =
            new EntityModelLayer(Identifier.of(ChipChonkMod.MOD_ID, "meeples"), "main");
    public static final EntityModelLayer CHIPMUNK =
            new EntityModelLayer(Identifier.of(ChipChonkMod.MOD_ID, "chipmunk"), "main");
    public static final EntityModelLayer BULLET =
            new EntityModelLayer(Identifier.of(ChipChonkMod.MOD_ID, "bullet"), "main");
}
