package net.colby.chipchonkmod.datagen;

import net.colby.chipchonkmod.block.ModBlocks;
import net.colby.chipchonkmod.block.custom.BlueberryBushBlock;
import net.colby.chipchonkmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ACORN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        blockStateModelGenerator.registerLog(ModBlocks.BLUE_OAK_LOG).log(ModBlocks.BLUE_OAK_LOG).wood(ModBlocks.BLUE_OAK_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_BLUE_OAK_LOG).log(ModBlocks.STRIPPED_BLUE_OAK_LOG).wood(ModBlocks.STRIPPED_BLUE_OAK_WOOD);
        BlockStateModelGenerator.BlockTexturePool blueOakPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLUE_OAK_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.BLUE_OAK_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.BLUE_OAK_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blueOakPool.stairs(ModBlocks.BLUE_OAK_STAIRS);
        blueOakPool.slab(ModBlocks.BLUE_OAK_SLAB);
        blueOakPool.button(ModBlocks.BLUE_OAK_BUTTON);
        blueOakPool.pressurePlate(ModBlocks.BLUE_OAK_PRESSURE_PLATE);
        blueOakPool.fence(ModBlocks.BLUE_OAK_FENCE);
        blueOakPool.fenceGate(ModBlocks.BLUE_OAK_FENCE_GATE);
        blueOakPool.wall(ModBlocks.BLUE_OAK_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.BLUE_OAK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.BLUE_OAK_TRAPDOOR);

        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.ACORN_LAYER_BLOCK, ModBlocks.ACORN_LAYER);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);

        BlockStateModelGenerator.BlockTexturePool quadrupleCompressedSapphireInfusedSteelBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);
        quadrupleCompressedSapphireInfusedSteelBlockPool.pressurePlate(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE);

        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.CELESTIAL_MOSS, ModBlocks.CELESTIAL_MOSS_CARPET);
        blockStateModelGenerator.registerSingleton(ModBlocks.CELESTIAL_NYLIUM, TexturedModel.SIDE_TOP_BOTTOM_WALL);

        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.ASTRAL_MOSS, ModBlocks.ASTRAL_MOSS_CARPET);
        blockStateModelGenerator.registerSingleton(ModBlocks.ASTRAL_NYLIUM, TexturedModel.SIDE_TOP_BOTTOM_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);

        blockStateModelGenerator.registerSingleton(ModBlocks.ACORN_LEAVES, TexturedModel.LEAVES);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.BLUEBERRY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED,
                BlueberryBushBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ACORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_ACORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACORN_BITS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACORN_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SAPPHIRE, Models.GENERATED);

        itemModelGenerator.register(ModItems.SAPPHIRE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.MEEPLES_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.CHIPMUNK_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.CARBON, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_INFUSED_STEEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CUT_SAPPHIRE, Models.GENERATED);

        itemModelGenerator.register(ModItems.THICK_OF_IT_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.BULLET, Models.HANDHELD);

        itemModelGenerator.register(ModItems.GRENADE, Models.GENERATED);

    }
}
