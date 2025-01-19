package net.colby.chipchonkmod.datagen;

import net.colby.chipchonkmod.block.ModBlocks;
import net.colby.chipchonkmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.BLUE_OAK_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLUE_OAK_LOG.asItem())
                .add(ModBlocks.STRIPPED_BLUE_OAK_LOG.asItem())
                .add(ModBlocks.BLUE_OAK_WOOD.asItem())
                .add(ModBlocks.STRIPPED_BLUE_OAK_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.SAPPHIRE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.SAPPHIRE_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.SAPPHIRE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.SAPPHIRE_SWORD)
                .add(ModItems.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE_ON_A_STICK);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.SAPPHIRE_HOE);
    }
}
