package net.colby.chipchonkmod.world.dimension;

import net.colby.chipchonkmod.ChipChonkMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> CHIPMUNKDIM_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(ChipChonkMod.MOD_ID, "chipmunkdim"));
    public static final RegistryKey<World> CHIPMUNKDIM_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(ChipChonkMod.MOD_ID, "chipmunkdim"));
    public static final RegistryKey<DimensionType> CHIPMUNK_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(ChipChonkMod.MOD_ID, "chipmunkdim_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(CHIPMUNK_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -256, // minY
                768, // height
                768, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }
}
