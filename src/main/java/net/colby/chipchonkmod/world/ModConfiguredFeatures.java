package net.colby.chipchonkmod.world;

import com.google.common.collect.ImmutableList;
import net.colby.chipchonkmod.ChipChonkMod;
import net.colby.chipchonkmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.RandomSeed;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.root.RootPlacer;
import net.minecraft.world.gen.stateprovider.*;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import javax.sound.midi.MidiChannel;
import java.util.List;

import static net.minecraft.world.gen.feature.VegetationConfiguredFeatures.PATCH_GRASS;
import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.PATCH_GRASS_NORMAL;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_OAK_KEY = registerKey("blue_oak");

    //public static final RegistryKey<ConfiguredFeature<?, ?>> CELESTIAL_MOSS_KEY = registerKey("celestial_moss");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CELESTIAL_MOSS_KEY = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ChipChonkMod.MOD_ID, "celestial_moss"));

    public class TwoLeavesBlueOakFeature {

        // WeightedBlockStateProvider for random leaves with varying weights
        public static final BlockStateProvider TWO_LEAVES_BLUE_OAK_FEATURE = new WeightedBlockStateProvider(
                DataPool.<BlockState>builder()
                        .add(ModBlocks.BLUE_OAK_LEAVES.getDefaultState(), 3)  // 80% chance for Oak Leaves
                        .add(ModBlocks.ACORN_LEAVES.getDefaultState(), 1) // 20% chance for Birch Leaves
                        .build()
        );
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneOreReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateOreReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldSapphireOres =
                List.of(OreFeatureConfig.createTarget(stoneOreReplaceables, ModBlocks.SAPPHIRE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateOreReplaceables, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.getDefaultState()));

        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSapphireOres, 6));

        register(context, BLUE_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                SimpleBlockStateProvider.of(ModBlocks.BLUE_OAK_LOG), // log
                new StraightTrunkPlacer(4, 1, 1), // baseHeight, firstRandomHeight, secondRandomHeight

                //BlockStateProvider.of(ModBlocks.BLUE_OAK_LEAVES),
                TwoLeavesBlueOakFeature.TWO_LEAVES_BLUE_OAK_FEATURE,
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), // radius, offset, height //Change back to 2, 0, 3

                new TwoLayersFeatureSize(0, 0, 0) // limit, lowerSize, upperSize
        ).build());


        //register(context, ACORN_BIOMES_VEGETATION_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.SHORT_GRASS)));

        //register(context, CELESTIAL_MOSS_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
        //        BlockStateProvider.of(ModBlocks.CELESTIAL_MOSS)
        //));

        /**register(context, CELESTIAL_MOSS_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        16,
                        5,
                        2,
                        //context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.CELESTIAL_MOSS_PLACED_KEY)
                        RegistryEntry.of(ModPlacedFeatures.CELESTIAL_MOSS_PLACED_KEY)
                )
        );*/



    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ChipChonkMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
