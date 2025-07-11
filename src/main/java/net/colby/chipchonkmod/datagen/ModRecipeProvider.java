package net.colby.chipchonkmod.datagen;

import net.colby.chipchonkmod.block.ModBlocks;
import net.colby.chipchonkmod.item.ModItems;
import net.colby.chipchonkmod.item.custom.GlockItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> ACORN_SMELTABLES = List.of(ModItems.ACORN);
    private static final List<ItemConvertible> SAPPHIRE_SMELTABLES = List.of(ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE);
    private static final List<ItemConvertible> COAL_SMELTABLES = List.of(Items.COAL);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //Acorn
        offerSmelting(exporter, ACORN_SMELTABLES, RecipeCategory.FOOD, ModItems.COOKED_ACORN,
                0.35f, 200, "acorn");

        offerBlasting(exporter, ACORN_SMELTABLES, RecipeCategory.FOOD, ModItems.COOKED_ACORN,
                0.35f, 100, "acorn");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ACORN, RecipeCategory.FOOD,
                ModBlocks.ACORN_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ACORN_STEW)
                .input(ModItems.ACORN_BITS)
                .input(Items.BOWL)
                .criterion(hasItem(ModItems.ACORN_BITS), conditionsFromItem(ModItems.ACORN_BITS))
                .offerTo(exporter);

        offerStonecuttingRecipe(exporter, RecipeCategory.FOOD, ModItems.ACORN_BITS, ModItems.COOKED_ACORN);

        //Saphire
        offerSmelting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE,
                0.35f, 200, "sapphire");
        offerBlasting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE,
                0.35f, 100, "sapphire");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE, RecipeCategory.MISC,
                ModBlocks.SAPPHIRE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAPPHIRE_PICKAXE, 1)
                .pattern("SSS")
                .pattern(" T ")
                .pattern(" T ")
                .input('S', ModItems.SAPPHIRE)
                .input('T', Items.STICK)
                .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SAPPHIRE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAPPHIRE_AXE, 1)
                .pattern("SS ")
                .pattern("ST ")
                .pattern(" T ")
                .input('S', ModItems.SAPPHIRE)
                .input('T', Items.STICK)
                .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SAPPHIRE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAPPHIRE_SHOVEL, 1)
                .pattern(" S ")
                .pattern(" T ")
                .pattern(" T ")
                .input('S', ModItems.SAPPHIRE)
                .input('T', Items.STICK)
                .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SAPPHIRE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAPPHIRE_SWORD, 1)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" T ")
                .input('S', ModItems.SAPPHIRE)
                .input('T', Items.STICK)
                .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SAPPHIRE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAPPHIRE_HOE, 1)
                .pattern("SS ")
                .pattern(" T ")
                .pattern(" T ")
                .input('S', ModItems.SAPPHIRE)
                .input('T', Items.STICK)
                .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SAPPHIRE_HOE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_PLANKS, 4)
                .input(ModBlocks.BLUE_OAK_LOG)
                .criterion(hasItem(ModBlocks.BLUE_OAK_LOG), conditionsFromItem(ModBlocks.BLUE_OAK_LOG))
                .offerTo(exporter, "blue_oak_planks_from_blue_oak_log");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_PLANKS, 4)
                .input(ModBlocks.STRIPPED_BLUE_OAK_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_BLUE_OAK_LOG), conditionsFromItem(ModBlocks.STRIPPED_BLUE_OAK_LOG))
                .offerTo(exporter, "blue_oak_planks_from_stripped_blue_oak_log");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_PLANKS, 4)
                .input(ModBlocks.BLUE_OAK_WOOD)
                .criterion(hasItem(ModBlocks.BLUE_OAK_WOOD), conditionsFromItem(ModBlocks.BLUE_OAK_WOOD))
                .offerTo(exporter, "blue_oak_planks_from_blue_oak_wood");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_PLANKS, 4)
                .input(ModBlocks.STRIPPED_BLUE_OAK_WOOD)
                .criterion(hasItem(ModBlocks.STRIPPED_BLUE_OAK_WOOD), conditionsFromItem(ModBlocks.STRIPPED_BLUE_OAK_WOOD))
                .offerTo(exporter, "blue_oak_planks_from_stripped_blue_oak_wood");

        offerBarkBlockRecipe(exporter, ModBlocks.BLUE_OAK_WOOD, ModBlocks.BLUE_OAK_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_BLUE_OAK_WOOD, ModBlocks.STRIPPED_BLUE_OAK_LOG);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_STAIRS, 4)
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .input('P', ModBlocks.BLUE_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.BLUE_OAK_PLANKS), conditionsFromItem(ModBlocks.BLUE_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.BLUE_OAK_STAIRS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("PPP")
                .input('P', ModBlocks.BLUE_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.BLUE_OAK_PLANKS), conditionsFromItem(ModBlocks.BLUE_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.BLUE_OAK_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_DOOR, 3)
                .pattern(" PP")
                .pattern(" PP")
                .pattern(" PP")
                .input('P', ModBlocks.BLUE_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.BLUE_OAK_PLANKS), conditionsFromItem(ModBlocks.BLUE_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.BLUE_OAK_DOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_TRAPDOOR, 2)
                .pattern("   ")
                .pattern("PPP")
                .pattern("PPP")
                .input('P', ModBlocks.BLUE_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.BLUE_OAK_PLANKS), conditionsFromItem(ModBlocks.BLUE_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.BLUE_OAK_TRAPDOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_WALL, 6)
                .pattern("   ")
                .pattern("SSS")
                .pattern("PPP")
                .input('P', ModBlocks.BLUE_OAK_PLANKS)
                .input('S', ModBlocks.BLUE_OAK_SLAB)
                .criterion(hasItem(ModBlocks.BLUE_OAK_PLANKS), conditionsFromItem(ModBlocks.BLUE_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.BLUE_OAK_WALL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_PRESSURE_PLATE, 1)
                .pattern("   ")
                .pattern("   ")
                .pattern(" PP")
                .input('P', ModBlocks.BLUE_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.BLUE_OAK_PLANKS), conditionsFromItem(ModBlocks.BLUE_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.BLUE_OAK_PRESSURE_PLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_FENCE, 3)
                .pattern("   ")
                .pattern("PSP")
                .pattern("PSP")
                .input('P', ModBlocks.BLUE_OAK_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.BLUE_OAK_PLANKS), conditionsFromItem(ModBlocks.BLUE_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.BLUE_OAK_FENCE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_FENCE_GATE, 1)
                .pattern("   ")
                .pattern("PSP")
                .pattern("PSP")
                .input('P', ModBlocks.BLUE_OAK_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.BLUE_OAK_PLANKS), conditionsFromItem(ModBlocks.BLUE_OAK_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.BLUE_OAK_FENCE_GATE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_OAK_BUTTON, 1)
                .input(ModBlocks.BLUE_OAK_PLANKS)
                .criterion(hasItem(ModBlocks.BLUE_OAK_PLANKS), conditionsFromItem(ModBlocks.BLUE_OAK_PLANKS))
                .offerTo(exporter);

        offerBlasting(exporter, COAL_SMELTABLES, RecipeCategory.MISC, ModItems.CARBON,
                0.35f, 1200, "coal");

        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.CUT_SAPPHIRE, ModItems.SAPPHIRE);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_INGOT, 1)
                .input(ModItems.CARBON)
                .input(Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SAPPHIRE_INFUSED_STEEL, 1)
                .input(ModItems.STEEL_INGOT)
                .input(ModItems.CUT_SAPPHIRE)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .criterion(hasItem(ModItems.CUT_SAPPHIRE), conditionsFromItem(ModItems.CUT_SAPPHIRE))
                .offerTo(exporter);

        //offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE_INFUSED_STEEL, RecipeCategory.MISC,
        //        ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK, 1)
                .input(ModItems.SAPPHIRE_INFUSED_STEEL, 9)
                .criterion(hasItem(ModItems.SAPPHIRE_INFUSED_STEEL), conditionsFromItem(ModItems.SAPPHIRE_INFUSED_STEEL))
                .offerTo(exporter, "sapphire_infused_steel_block_from_sapphire_infused_steel");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SAPPHIRE_INFUSED_STEEL, 9)
                .input(ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK)
                .criterion(hasItem(ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK), conditionsFromItem(ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK))
                .offerTo(exporter, "sapphire_infused_steel_from_sapphire_infused_steel_block");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK, 1)
                .input(ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK, 9)
                .criterion(hasItem(ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK), conditionsFromItem(ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK))
                .offerTo(exporter, "compressed_sapphire_infused_steel_block_from_sapphire_infused_steel_block");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK, 9)
                .input(ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK)
                .criterion(hasItem(ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK), conditionsFromItem(ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK))
                .offerTo(exporter, "sapphire_infused_steel_block_from_compressed_sapphire_infused_steel_block");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK, 1)
                .input(ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK, 9)
                .criterion(hasItem(ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK), conditionsFromItem(ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK))
                .offerTo(exporter, "double_compressed_sapphire_infused_steel_block_from_compressed_sapphire_infused_steel_block");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK, 9)
                .input(ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK)
                .criterion(hasItem(ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK), conditionsFromItem(ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK))
                .offerTo(exporter, "compressed_sapphire_infused_steel_block_from_double_compressed_sapphire_infused_steel_block");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK, 1)
                .input(ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK, 9)
                .criterion(hasItem(ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK), conditionsFromItem(ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK))
                .offerTo(exporter, "triple_compressed_sapphire_infused_steel_block_from_double_compressed_sapphire_infused_steel_block");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK, 9)
                .input(ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK)
                .criterion(hasItem(ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK), conditionsFromItem(ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK))
                .offerTo(exporter, "double_compressed_sapphire_infused_steel_block_from_triple_compressed_sapphire_infused_steel_block");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK, 1)
                .input(ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK, 9)
                .criterion(hasItem(ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK), conditionsFromItem(ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK))
                .offerTo(exporter, "quadruple_compressed_sapphire_infused_steel_block_from_triple_compressed_sapphire_infused_steel_block");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK, 9)
                .input(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK)
                .criterion(hasItem(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK), conditionsFromItem(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK))
                .offerTo(exporter, "triple_compressed_sapphire_infused_steel_block_from_quadruple_compressed_sapphire_infused_steel_block");

        offerPressurePlateRecipe(exporter, ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE, ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE_ON_A_STICK, 1)
                .pattern("Q ")
                .pattern("S ")
                .input('Q', ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE), conditionsFromItem(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE_ON_A_STICK)));

        offerCarpetRecipe(exporter, ModBlocks.CELESTIAL_MOSS_CARPET, ModBlocks.CELESTIAL_MOSS);
        offerCarpetRecipe(exporter, ModBlocks.ASTRAL_MOSS_CARPET, ModBlocks.ASTRAL_MOSS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GLOCK, 1)
                .pattern("   ")
                .pattern("TTT")
                .pattern("  T")
                .input('T', ModBlocks.STEEL_BLOCK)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.GLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RIFLE, 1)
                .pattern("SCC")
                .pattern("TTT")
                .pattern("  T")
                .input('T', ModBlocks.STEEL_BLOCK)
                .input('S', ModItems.CUT_SAPPHIRE)
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.RIFLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SNIPER, 1)
                .pattern("SCC")
                .pattern("TTT")
                .pattern(" TT")
                .input('T', ModBlocks.STEEL_BLOCK)
                .input('S', ModItems.CUT_SAPPHIRE)
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SNIPER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SHOTGUN, 1)
                .pattern("   ")
                .pattern("TTT")
                .pattern(" TT")
                .input('T', ModBlocks.STEEL_BLOCK)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SHOTGUN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BULLET, 4)
                        .pattern(" C ")
                        .pattern(" B ")
                        .pattern(" B ")
                        .input('C', Items.COPPER_INGOT)
                        .input('B', Blocks.COPPER_BLOCK)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BULLET)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_INGOT, 9)
                .input(ModBlocks.STEEL_BLOCK)
                .criterion(hasItem(ModBlocks.STEEL_BLOCK), conditionsFromItem(ModBlocks.STEEL_BLOCK))
                .offerTo(exporter, "steel_ingot_from_steel_block");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK, 1)
                .input(ModItems.STEEL_INGOT, 9)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter, "steel_block_from_steel_ingot");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.EXPLOSIVE_GLOCK, 1)
                .input(ModItems.GLOCK, 1)
                .input(Items.TNT, 1)
                .input(Items.END_CRYSTAL, 1)
                .input(Items.TNT_MINECART, 1)
                .input(Items.FIREWORK_ROCKET, 1)
                .criterion(hasItem(ModItems.GLOCK), conditionsFromItem(ModItems.GLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GRENADE, 1)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('C', Items.END_CRYSTAL)
                .input('S', ModItems.STEEL_INGOT)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.GRENADE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BLOCKY_SHOTGUN, 1)
                .input(ModItems.SHOTGUN, 1)
                .input(Blocks.BAMBOO_MOSAIC_SLAB, 1)
                .input(Blocks.ACTIVATOR_RAIL, 1)
                .input(Blocks.CALIBRATED_SCULK_SENSOR, 1)
                .input(Blocks.MAGENTA_GLAZED_TERRACOTTA, 1)
                .input(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, 1)
                .input(Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS, 1)
                .input(ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK, 1)
                .input(ModBlocks.ACORN_BLOCK, 1)
                .criterion(hasItem(ModItems.SHOTGUN), conditionsFromItem(ModItems.SHOTGUN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.BLUE_DYE, 2)
                .input(ModBlocks.HYDRANGEA)
                .criterion(hasItem(ModBlocks.HYDRANGEA), conditionsFromItem(ModBlocks.HYDRANGEA))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.ORANGE_DYE, 2)
                .input(ModBlocks.HELENIUMS)
                .criterion(hasItem(ModBlocks.HELENIUMS), conditionsFromItem(ModBlocks.HELENIUMS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAPPHIRE_HELMET, 1)
                .pattern("SSS")
                .pattern("S S")
                .input('S', ModItems.SAPPHIRE)
                .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SAPPHIRE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAPPHIRE_CHESTPLATE, 1)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.SAPPHIRE)
                .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SAPPHIRE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAPPHIRE_LEGGINGS, 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.SAPPHIRE)
                .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SAPPHIRE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAPPHIRE_BOOTS, 1)
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.SAPPHIRE)
                .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SAPPHIRE_BOOTS)));

    }
}
