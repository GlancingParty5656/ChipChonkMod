package net.colby.chipchonkmod.world.gen;

import net.colby.chipchonkmod.world.ModPlacedFeatures;
import net.colby.chipchonkmod.world.biome.ModBiomes;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModFlowerGeneration {

    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ACORN_FOREST, ModBiomes.ACORN_PLAINS,
                ModBiomes.WINDSWEPT_ACORN_FOREST, ModBiomes.WINDSWEPT_ACORN_PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HYDRANGEA_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.ACORN_FOREST, ModBiomes.ACORN_PLAINS,
                ModBiomes.WINDSWEPT_ACORN_FOREST, ModBiomes.WINDSWEPT_ACORN_PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HELENIUMS_PLACED_KEY);
    }

}
