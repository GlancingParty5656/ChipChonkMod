package net.colby.chipchonkmod.datagen;

import net.colby.chipchonkmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
                .add(ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK)
                .add(ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK)
                .add(ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK)
                .add(ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK)
                .add(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK)
                .add(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE)
                .add(ModBlocks.CELESTIAL_NYLIUM)
                .add(ModBlocks.ASTRAL_NYLIUM)
                .add(ModBlocks.STEEL_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.BLUE_OAK_PLANKS);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.ACORN_LEAVES)
                .add(ModBlocks.BLUE_OAK_LEAVES)
                .add(ModBlocks.CELESTIAL_MOSS)
                .add(ModBlocks.CELESTIAL_MOSS_CARPET)
                .add(ModBlocks.ASTRAL_MOSS)
                .add(ModBlocks.ASTRAL_MOSS_CARPET);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
                .add(ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK)
                .add(ModBlocks.STEEL_BLOCK);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLUE_OAK_LOG)
                .add(ModBlocks.STRIPPED_BLUE_OAK_LOG)
                .add(ModBlocks.BLUE_OAK_WOOD)
                .add(ModBlocks.STRIPPED_BLUE_OAK_WOOD);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK)
                .add(ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK)
                .add(ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK)
                .add(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK)
                .add(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")));

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.BLUE_OAK_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.BLUE_OAK_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.BLUE_OAK_WALL);

        getOrCreateTagBuilder(BlockTags.TALL_FLOWERS)
                .add(ModBlocks.HYDRANGEA)
                .add(ModBlocks.HELENIUMS);

    }
}
