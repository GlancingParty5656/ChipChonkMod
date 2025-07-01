package net.colby.chipchonkmod.world.biome.region;

import com.mojang.datafixers.util.Pair;
import net.colby.chipchonkmod.world.biome.ModBiomes;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.gen.noise.BuiltinNoiseParameters;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube,
            RegistryKey<Biome>>> mapper) {

        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.PLAINS, ModBiomes.ACORN_PLAINS);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.WINDSWEPT_SAVANNA, ModBiomes.WINDSWEPT_ACORN_PLAINS);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.FOREST, ModBiomes.ACORN_FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.WINDSWEPT_FOREST, ModBiomes.WINDSWEPT_ACORN_FOREST);
        });
    }
}
