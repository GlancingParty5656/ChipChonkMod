package net.colby.chipchonkmod.datagen;

import net.colby.chipchonkmod.block.ModBlocks;
//import net.colby.chipchonkmod.block.custom.BlueberryBushBlock;
import net.colby.chipchonkmod.block.custom.BlueberryBushBlock;
import net.colby.chipchonkmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        addDrop(ModBlocks.ACORN_BLOCK);
        addDrop(ModBlocks.ACORN_LEAVES, oreDrops(ModBlocks.ACORN_LEAVES, ModItems.ACORN));
        addDrop(ModBlocks.SAPPHIRE_BLOCK);
        addDrop(ModBlocks.SAPPHIRE_ORE, oreDrops(ModBlocks.SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE));
        addDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, oreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE));

        addDrop(ModBlocks.BLUE_OAK_LOG);
        addDrop(ModBlocks.STRIPPED_BLUE_OAK_LOG);
        addDrop(ModBlocks.BLUE_OAK_WOOD);
        addDrop(ModBlocks.STRIPPED_BLUE_OAK_WOOD);
        addDrop(ModBlocks.BLUE_OAK_PLANKS);
        addDrop(ModBlocks.BLUE_OAK_SAPLING);
        addDrop(ModBlocks.BLUE_OAK_LEAVES, leavesDrops(ModBlocks.BLUE_OAK_LEAVES, ModBlocks.BLUE_OAK_SAPLING, 0.05f));

        addDrop(ModBlocks.BLUE_OAK_STAIRS);
        addDrop(ModBlocks.BLUE_OAK_SLAB, slabDrops(ModBlocks.BLUE_OAK_SLAB));
        addDrop(ModBlocks.BLUE_OAK_BUTTON);
        addDrop(ModBlocks.BLUE_OAK_PRESSURE_PLATE);
        addDrop(ModBlocks.BLUE_OAK_FENCE);
        addDrop(ModBlocks.BLUE_OAK_FENCE_GATE);
        addDrop(ModBlocks.BLUE_OAK_WALL);
        addDrop(ModBlocks.BLUE_OAK_DOOR, doorDrops(ModBlocks.BLUE_OAK_DOOR));
        addDrop(ModBlocks.BLUE_OAK_TRAPDOOR);

        addDrop(ModBlocks.ACORN_LAYER, oreDrops(ModBlocks.ACORN_LAYER, ModItems.ACORN));

        addDrop(ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK);
        addDrop(ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);
        addDrop(ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);
        addDrop(ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);
        addDrop(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);
        addDrop(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE);

        addDrop(ModBlocks.CELESTIAL_MOSS);
        addDrop(ModBlocks.CELESTIAL_MOSS_CARPET);
        addDrop(ModBlocks.ASTRAL_MOSS);
        addDrop(ModBlocks.ASTRAL_MOSS_CARPET);
        addDrop(ModBlocks.CELESTIAL_NYLIUM, oreDrops(ModBlocks.CELESTIAL_NYLIUM, Blocks.END_STONE.asItem()));
        addDrop(ModBlocks.ASTRAL_NYLIUM, oreDrops(ModBlocks.ASTRAL_NYLIUM, Blocks.END_STONE.asItem()));

        addDrop(ModBlocks.STEEL_BLOCK);

        this.addDrop(ModBlocks.BLUEBERRY_BUSH,
                block -> this.applyExplosionDecay(
                        block,LootTable.builder().pool(LootPool.builder().conditionally(
                                                BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BlueberryBushBlock.AGE, 3))
                                        )
                                        .with(ItemEntry.builder(ModItems.BLUEBERRY))
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                        ).pool(LootPool.builder().conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BlueberryBushBlock.AGE, 2))
                                ).with(ItemEntry.builder(ModItems.BLUEBERRY))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));

        addDrop(ModBlocks.HYDRANGEA, doorDrops(ModBlocks.HYDRANGEA));
        addDrop(ModBlocks.HELENIUMS, doorDrops(ModBlocks.HELENIUMS));
    }
}
