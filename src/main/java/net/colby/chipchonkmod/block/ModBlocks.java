package net.colby.chipchonkmod.block;

import net.colby.chipchonkmod.ChipChonkMod;
import net.colby.chipchonkmod.block.custom.BlueberryBushBlock;
import net.colby.chipchonkmod.block.custom.PortalBlock;
import net.colby.chipchonkmod.item.ModItems;
import net.colby.chipchonkmod.world.ModConfiguredFeatures;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModBlocks {

    public static final Block ACORN_BLOCK = registerBlock("acorn_block",
            new Block(FabricBlockSettings.copyOf(Blocks.ROOTED_DIRT)));
    public static final Block ACORN_LEAVES = registerBlock("acorn_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.BLUE)));
    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_EMERALD_ORE).mapColor(MapColor.LAPIS_BLUE)));

    public static final Block BLUE_OAK_LOG = registerBlock("blue_oak_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block BLUE_OAK_WOOD = registerBlock("blue_oak_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_BLUE_OAK_LOG = registerBlock("stripped_blue_oak_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_BLUE_OAK_WOOD = registerBlock("stripped_blue_oak_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block BLUE_OAK_PLANKS = registerBlock("blue_oak_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block BLUE_OAK_LEAVES = registerBlock("blue_oak_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final SaplingBlock BLUE_OAK_SAPLING = registerWithItem("blue_oak_sapling",
            new SaplingBlock(
                    new SaplingGenerator(
                            ChipChonkMod.MOD_ID.toString(),
                            0.5f,
                            Optional.of(ModConfiguredFeatures.THICK_BLUE_OAK_KEY),
                            Optional.of(ModConfiguredFeatures.TALL_BLUE_OAK_KEY),
                            Optional.of(ModConfiguredFeatures.BLUE_OAK_KEY),
                            Optional.of(ModConfiguredFeatures.MEGA_BLUE_OAK_KEY),
                            Optional.empty(),
                            Optional.empty()
                    ),
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_GREEN)
                            .ticksRandomly()
                            .strength(0.0F)
                            .sounds(BlockSoundGroup.GRASS)
                            .nonOpaque()
                            .allowsSpawning(Blocks::canSpawnOnLeaves)
                            .suffocates(Blocks::never)
                            .blockVision(Blocks::never)
                            .burnable()
                            .pistonBehavior(PistonBehavior.DESTROY)
                            .solidBlock(Blocks::never)
                            .noCollision())
    );

    public static final Block BLUE_OAK_STAIRS = registerBlock("blue_oak_stairs",
            new StairsBlock(ModBlocks.BLUE_OAK_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).burnable()));
    public static final Block BLUE_OAK_SLAB = registerBlock("blue_oak_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).burnable()));

    public static final Block BLUE_OAK_BUTTON = registerBlock("blue_oak_button",
            new ButtonBlock(BlockSetType.OAK, 10, FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).noCollision().burnable()));
    public static final Block BLUE_OAK_PRESSURE_PLATE = registerBlock("blue_oak_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).burnable()));

    public static final Block BLUE_OAK_FENCE = registerBlock("blue_oak_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).burnable()));
    public static final Block BLUE_OAK_FENCE_GATE = registerBlock("blue_oak_fence_gate",
            new FenceGateBlock(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).burnable()));
    public static final Block BLUE_OAK_WALL = registerBlock("blue_oak_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));

    public static final Block BLUE_OAK_DOOR = registerBlock("blue_oak_door",
            new DoorBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_DOOR).burnable().nonOpaque()));
    public static final Block BLUE_OAK_TRAPDOOR = registerBlock("blue_oak_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).burnable().nonOpaque()));

    public static final Block ACORN_LAYER = registerBlock("acorn_layer",
            new CarpetBlock(FabricBlockSettings.copyOf(Blocks.MOSS_CARPET).nonOpaque().collidable(false).mapColor(MapColor.DIRT_BROWN)));
    public static final Block ACORN_LAYER_BLOCK = registerBlock("acorn_layer_block",
            new Block(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK).nonOpaque().mapColor(MapColor.DIRT_BROWN)));

    public static final Block SAPPHIRE_INFUSED_STEEL_BLOCK = registerBlock("sapphire_infused_steel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).strength(5).mapColor(MapColor.BLUE)));
    public static final Block COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK = registerBlock("compressed_sapphire_infused_steel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).strength(6).mapColor(MapColor.BLUE)));
    public static final Block DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK = registerBlock("double_compressed_sapphire_infused_steel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).strength(7).mapColor(MapColor.BLUE)));
    public static final Block TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK = registerBlock("triple_compressed_sapphire_infused_steel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).strength(8).mapColor(MapColor.BLUE)));
    public static final Block QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK = registerBlock("quadruple_compressed_sapphire_infused_steel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).strength(9).mapColor(MapColor.BLUE)));

    public static final Block QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE = registerBlock("quadruple_compressed_sapphire_infused_steel_block_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE).strength(9).sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.BLUE)));

    public static final Block CELESTIAL_NYLIUM = registerBlock("celestial_nylium",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).mapColor(MapColor.CYAN)));
    public static final Block CELESTIAL_MOSS = registerBlock("celestial_moss",
            new Block(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK).mapColor(MapColor.CYAN)));
    public static final Block CELESTIAL_MOSS_CARPET = registerBlock("celestial_moss_carpet",
            new CarpetBlock(FabricBlockSettings.copyOf(Blocks.MOSS_CARPET).mapColor(MapColor.CYAN)));

    public static final Block ASTRAL_NYLIUM = registerBlock("astral_nylium",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).mapColor(MapColor.MAGENTA)));
    public static final Block ASTRAL_MOSS = registerBlock("astral_moss",
            new Block(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK).mapColor(MapColor.MAGENTA)));
    public static final Block ASTRAL_MOSS_CARPET = registerBlock("astral_moss_carpet",
            new CarpetBlock(FabricBlockSettings.copyOf(Blocks.MOSS_CARPET).mapColor(MapColor.MAGENTA)));

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5).sounds(BlockSoundGroup.NETHERITE).mapColor(MapColor.DEEPSLATE_GRAY)));

    public static final Block PORTAL_BLOCK = registerBlock("portal_block",
            new PortalBlock(FabricBlockSettings.copyOf(Blocks.GLASS).noCollision().nonOpaque()));

    //public static final Block BLUEBERRY_BUSH = registerBlockWithoutBlockItem("blueberry_bush",
    //        new BlueberryBushBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH)));


    public static final Block BLUEBERRY_BUSH = register("blueberry_bush", new BlueberryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)), false);

    public static final Block HYDRANGEA = registerBlock("hydrangea",
            new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).mapColor(MapColor.WATER_BLUE)));
    public static final Block HELENIUMS = registerBlock("heleniums",
            new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).mapColor(MapColor.ORANGE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ChipChonkMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(ChipChonkMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ChipChonkMod.LOGGER.info("Registering ModBlocks for " + ChipChonkMod.MOD_ID);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(ChipChonkMod.MOD_ID, name), block);
    }

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, Identifier.of(ChipChonkMod.MOD_ID, name), block);
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block);
        ModItems.registerItem(name, new BlockItem(registered, settings));
        return registered;
    }

    public static <T extends Block> T registerWithItem(String name, T block) {
        return registerWithItem(name, block, new Item.Settings());
    }

    public static Block register(String name, Block block, boolean shouldRegisterItem) {
        // This creates an id consisting of the mod id and the name of the block.
        Identifier id = Identifier.of(ChipChonkMod.MOD_ID, name);
        // Some blocks may not have an item version of them, such as air. Use this boolean to control that.
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }
        return Registry.register(Registries.BLOCK, id, block);
    }
}
