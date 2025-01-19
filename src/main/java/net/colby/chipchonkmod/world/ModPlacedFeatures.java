package net.colby.chipchonkmod.world;

import net.colby.chipchonkmod.ChipChonkMod;
import net.colby.chipchonkmod.block.ModBlocks;
import net.colby.chipchonkmod.world.biome.ModBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.datafixer.fix.BiomeFormatFix;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");

    public static final RegistryKey<PlacedFeature> BLUE_OAK_PLACED_KEY = registerKey("blue_oak_placed");

    public static final RegistryKey<PlacedFeature> BLUE_OAK_FOREST_PLACED_KEY = registerKey("blue_oak_forest_placed");

    //public static final RegistryKey<PlacedFeature> CELESTIAL_MOSS_PLACED_KEY = registerKey("celestial_moss_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        //RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SAPPHIRE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPPHIRE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(4, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(64))));

        register(context, BLUE_OAK_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(3, 0.1f, 0), Blocks.VOID_AIR));

        register(context, BLUE_OAK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.1f, 1),
                        ModBlocks.BLUE_OAK_SAPLING));

        /**register(context, CELESTIAL_MOSS_PLACED_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CELESTIAL_MOSS_KEY), // Use RegistryEntry for the ConfiguredFeature
                List.of(
                        CountPlacementModifier.of(32), // Number of placements per chunk
                        SquarePlacementModifier.of(),  // Spread the placements in a square shape
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)), // Height range from bottom to y=64
                        BiomePlacementModifier.of()
                )
        );*/



    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(ChipChonkMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
