package net.colby.chipchonkmod.world.biome;

import com.google.common.collect.ImmutableList;
import net.colby.chipchonkmod.ChipChonkMod;
import net.colby.chipchonkmod.entity.ModEntities;
import net.colby.chipchonkmod.world.ModConfiguredFeatures;
import net.colby.chipchonkmod.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.client.sound.Sound;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.structure.PlainsVillageData;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.structure.EndCityStructure;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.Structures;

public class ModBiomes {

    public static final RegistryKey<Biome> ACORN_PLAINS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ChipChonkMod.MOD_ID, "acorn_plains"));

    public static final RegistryKey<Biome> WINDSWEPT_ACORN_PLAINS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ChipChonkMod.MOD_ID, "windswept_acorn_plains"));

    public static final RegistryKey<Biome> ACORN_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ChipChonkMod.MOD_ID, "acorn_forest"));

    public static final RegistryKey<Biome> WINDSWEPT_ACORN_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(ChipChonkMod.MOD_ID, "windswept_acorn_forest"));

    //public static final RegistryKey<Biome> CELESTIAL_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            //Identifier.of(ChipChonkMod.MOD_ID, "celestial_forest"));

    public static void bootstrap(Registerable<Biome> context) {
        context.register(ACORN_PLAINS, acornPlains(context));
        context.register(WINDSWEPT_ACORN_PLAINS, windsweptAcornPlains(context));
        context.register(ACORN_FOREST, acornForest(context));
        context.register(WINDSWEPT_ACORN_FOREST, windsweptAcornForest(context));
        //context.register(CELESTIAL_FOREST, celestialForest(context));

    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    /**public static void globalEndGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
    }*/

    public static Biome acornPlains(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.CHIPMUNK, 75, 3, 5));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.MEEPLES, 15, 1, 2));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);


        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
                globalOverworldGeneration(biomeBuilder);
                DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
                DefaultBiomeFeatures.addDefaultFlowers(biomeBuilder);
                DefaultBiomeFeatures.addDefaultGrass(biomeBuilder);
                DefaultBiomeFeatures.addPlainsTallGrass(biomeBuilder);
                DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUE_OAK_PLACED_KEY);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x3F76E4)
                        .waterFogColor(329011)
                        .skyColor(12638463)
                        .grassColor(0x91BD59)
                        .foliageColor(0x77AB2F)
                        .fogColor(0xc0d9e9)
                        .music(MusicType.GAME)
                        .build())
                .build();
    }

    public static Biome windsweptAcornPlains(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.CHIPMUNK, 75, 3, 5));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.MEEPLES, 15, 1, 2));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(
                context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER)
        );

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addDefaultFlowers(biomeBuilder);
        DefaultBiomeFeatures.addDefaultGrass(biomeBuilder);
        DefaultBiomeFeatures.addPlainsTallGrass(biomeBuilder);
        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUE_OAK_PLACED_KEY);

        biomeBuilder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE);
        biomeBuilder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CANYON);
        biomeBuilder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE_EXTRA_UNDERGROUND);
        biomeBuilder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x3F76E4)
                        .waterFogColor(329011)
                        .skyColor(12638463)
                        .grassColor(0x91BD59)
                        .foliageColor(0x77AB2F)
                        .fogColor(0xc0d9e9)
                        .music(MusicType.GAME)
                        .build())
                .build();
    }

    public static Biome acornForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.CHIPMUNK, 75, 3, 5));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.MEEPLES, 15, 1, 2));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
                globalOverworldGeneration(biomeBuilder);
                DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
                DefaultBiomeFeatures.addExtraDefaultFlowers(biomeBuilder);
                DefaultBiomeFeatures.addJungleGrass(biomeBuilder);
                DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUE_OAK_FOREST_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MEGA_BLUE_OAK_FOREST_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.THICK_BLUE_OAK_FOREST_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TALL_BLUE_OAK_FOREST_PLACED_KEY);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x3F76E4)
                        .waterFogColor(329011)
                        .skyColor(12638463)
                        .grassColor(0x79C05A)
                        .foliageColor(0x59AE30)
                        .fogColor(0xc0d9e9)
                        .music(MusicType.GAME)
                        .build())
                .build();
    }

    public static Biome windsweptAcornForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.CHIPMUNK, 75, 3, 5));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.MEEPLES, 15, 1, 2));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);


        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
                globalOverworldGeneration(biomeBuilder);
                DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
                DefaultBiomeFeatures.addExtraDefaultFlowers(biomeBuilder);
                DefaultBiomeFeatures.addJungleGrass(biomeBuilder);
                DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUE_OAK_FOREST_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MEGA_BLUE_OAK_FOREST_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.THICK_BLUE_OAK_FOREST_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TALL_BLUE_OAK_FOREST_PLACED_KEY);

        biomeBuilder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE);
        biomeBuilder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CANYON);
        biomeBuilder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE_EXTRA_UNDERGROUND);
        biomeBuilder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x3F76E4)
                        .waterFogColor(329011)
                        .skyColor(12638463)
                        .grassColor(0x79C05A)
                        .foliageColor(0x59AE30)
                        .fogColor(0xc0d9e9)
                        .music(MusicType.GAME)
                        .build())
                .build();
    }

    /**public static Biome celestialForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        DefaultBiomeFeatures.addEndMobs(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder = new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
        globalEndGeneration(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CELESTIAL_MOSS_PLACED_KEY);

        return new Biome.Builder()
                .precipitation(false)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x3F76E4)
                        .waterFogColor(329011)
                        .skyColor(12638463)
                        .grassColor(0x8EB971)
                        .foliageColor(0x71A74D)
                        .fogColor(0xa080a0)
                        .music(MusicType.GAME)
                        .build())
                .build();
    }*/


}
