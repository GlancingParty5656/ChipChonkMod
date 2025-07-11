package net.colby.chipchonkmod.world;

import net.colby.chipchonkmod.ChipChonkMod;
import net.colby.chipchonkmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");

    public static final RegistryKey<PlacedFeature> BLUE_OAK_PLACED_KEY = registerKey("blue_oak_placed");

    public static final RegistryKey<PlacedFeature> BLUE_OAK_FOREST_PLACED_KEY = registerKey("blue_oak_forest_placed");

    public static final RegistryKey<PlacedFeature> MEGA_BLUE_OAK_FOREST_PLACED_KEY = registerKey("mega_blue_oak_forest_placed");

    public static final RegistryKey<PlacedFeature> THICK_BLUE_OAK_FOREST_PLACED_KEY = registerKey("thick_blue_oak_forest_placed");

    public static final RegistryKey<PlacedFeature> TALL_BLUE_OAK_FOREST_PLACED_KEY = registerKey("tall_blue_oak_forest_placed");

    //public static final RegistryKey<PlacedFeature> CELESTIAL_MOSS_PLACED_KEY = registerKey("celestial_moss_placed");

    public static final RegistryKey<PlacedFeature> HYDRANGEA_PLACED_KEY = registerKey("hydrangea_placed");

    public static final RegistryKey<PlacedFeature> HELENIUMS_PLACED_KEY = registerKey("heleniums_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        //RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SAPPHIRE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPPHIRE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(4, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(64))));

        register(context, BLUE_OAK_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(5, 1f, 0), ModBlocks.BLUE_OAK_SAPLING));

        register(context, MEGA_BLUE_OAK_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MEGA_BLUE_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(5, 1f, 0), ModBlocks.BLUE_OAK_SAPLING));

        register(context, THICK_BLUE_OAK_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.THICK_BLUE_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(5, 1f, 0), ModBlocks.BLUE_OAK_SAPLING));

        register(context, TALL_BLUE_OAK_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TALL_BLUE_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(5, 1f, 0), ModBlocks.BLUE_OAK_SAPLING));

        register(context, BLUE_OAK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.1f, 1),
                        ModBlocks.BLUE_OAK_SAPLING));

        register(context, HYDRANGEA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HYDRANGEA_KEY),
                RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, HELENIUMS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HELENIUMS_KEY),
                RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

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

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

}
