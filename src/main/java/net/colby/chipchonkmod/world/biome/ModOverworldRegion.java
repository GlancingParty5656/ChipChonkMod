package net.colby.chipchonkmod.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.EndBiomeRegistry;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.awt.*;
import java.util.List;
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
