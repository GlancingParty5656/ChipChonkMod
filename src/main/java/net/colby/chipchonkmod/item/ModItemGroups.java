package net.colby.chipchonkmod.item;

import net.colby.chipchonkmod.ChipChonkMod;
import net.colby.chipchonkmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CHIPCHONKMOD_ACORN_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ChipChonkMod.MOD_ID, "chipchonkmod_acorn"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.chipchonkmod_acorn"))
                    .icon(() -> new ItemStack(ModItems.ACORN)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ACORN);
                        entries.add(ModItems.ACORN_STEW);
                        entries.add(ModBlocks.ACORN_BLOCK);
                        entries.add(ModBlocks.ACORN_LEAVES);
                        entries.add(ModItems.COOKED_ACORN);
                        entries.add(ModItems.ACORN_BITS);

                        entries.add(ModBlocks.BLUE_OAK_LOG);
                        entries.add(ModBlocks.STRIPPED_BLUE_OAK_LOG);
                        entries.add(ModBlocks.BLUE_OAK_WOOD);
                        entries.add(ModBlocks.STRIPPED_BLUE_OAK_WOOD);
                        entries.add(ModBlocks.BLUE_OAK_PLANKS);
                        entries.add(ModBlocks.BLUE_OAK_LEAVES);
                        entries.add(ModBlocks.BLUE_OAK_SAPLING);

                        entries.add(ModBlocks.BLUE_OAK_STAIRS);
                        entries.add(ModBlocks.BLUE_OAK_SLAB);
                        entries.add(ModBlocks.BLUE_OAK_BUTTON);
                        entries.add(ModBlocks.BLUE_OAK_PRESSURE_PLATE);
                        entries.add(ModBlocks.BLUE_OAK_FENCE);
                        entries.add(ModBlocks.BLUE_OAK_FENCE_GATE);
                        entries.add(ModBlocks.BLUE_OAK_WALL);
                        entries.add(ModBlocks.BLUE_OAK_DOOR);
                        entries.add(ModBlocks.BLUE_OAK_TRAPDOOR);

                        entries.add(ModItems.MEEPLES_SPAWN_EGG);
                        entries.add(ModItems.CHIPMUNK_SPAWN_EGG);
                        entries.add(ModBlocks.ACORN_LAYER);
                        entries.add(ModBlocks.ACORN_LAYER_BLOCK);
                        entries.add(ModItems.THICK_OF_IT_MUSIC_DISC);

                        //entries.add(ModItems.BLUEBERRY);
                        entries.add(ModBlocks.HYDRANGEA);
                        entries.add(ModBlocks.HELENIUMS);

                    }).build());

    public static final ItemGroup CHIPCHONKMOD_SAPPHIRE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ChipChonkMod.MOD_ID, "chipchonkmod_sapphire"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.chipchonkmod_sapphire"))
                    .icon(() -> new ItemStack(ModItems.SAPPHIRE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.SAPPHIRE);
                        entries.add(ModItems.RAW_SAPPHIRE);
                        entries.add(ModItems.CUT_SAPPHIRE);
                        entries.add(ModBlocks.SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.SAPPHIRE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

                        entries.add(ModItems.SAPPHIRE_PICKAXE);
                        entries.add(ModItems.SAPPHIRE_AXE);
                        entries.add(ModItems.SAPPHIRE_SHOVEL);
                        entries.add(ModItems.SAPPHIRE_SWORD);
                        entries.add(ModItems.SAPPHIRE_HOE);

                        entries.add(ModItems.CARBON);
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModItems.SAPPHIRE_INFUSED_STEEL);

                        entries.add(ModBlocks.SAPPHIRE_INFUSED_STEEL_BLOCK);
                        entries.add(ModBlocks.COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);
                        entries.add(ModBlocks.DOUBLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);
                        entries.add(ModBlocks.TRIPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);
                        entries.add(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK);
                        entries.add(ModBlocks.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE);
                        entries.add(ModItems.QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE_ON_A_STICK);

                        entries.add(ModItems.GLOCK);
                        entries.add(ModItems.BULLET);
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModItems.RIFLE);
                        entries.add(ModItems.SNIPER);
                        entries.add(ModItems.SHOTGUN);
                        entries.add(ModItems.EXPLOSIVE_GLOCK);
                        entries.add(ModItems.GRENADE);
                        entries.add(ModItems.BLOCKY_SHOTGUN);

                        entries.add(ModItems.SAPPHIRE_HELMET);
                        entries.add(ModItems.SAPPHIRE_CHESTPLATE);
                        entries.add(ModItems.SAPPHIRE_LEGGINGS);
                        entries.add(ModItems.SAPPHIRE_BOOTS);

                    }).build());

    public static final ItemGroup CHIPCHONKMOD_END_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ChipChonkMod.MOD_ID, "chipchonkmod_end"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.chipchonkmod_end"))
                    .icon(() -> new ItemStack(ModBlocks.CELESTIAL_NYLIUM)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.CELESTIAL_NYLIUM);
                        entries.add(ModBlocks.CELESTIAL_MOSS);
                        entries.add(ModBlocks.CELESTIAL_MOSS_CARPET);
                        entries.add(ModBlocks.ASTRAL_NYLIUM);
                        entries.add(ModBlocks.ASTRAL_MOSS);
                        entries.add(ModBlocks.ASTRAL_MOSS_CARPET);

                    }).build());

    public static final ItemGroup CHIPCHONKMOD_PORTAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ChipChonkMod.MOD_ID, "chipchonkmod_portal"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.chipchonkmod_end"))
                    .icon(() -> new ItemStack(ModBlocks.PORTAL_BLOCK)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.PORTAL_BLOCK);
                        entries.add(ModItems.PORTAL_GUN);

                    }).build());

    public static void registerItemGroups() {
        ChipChonkMod.LOGGER.info("Registering Item Groups for " + ChipChonkMod.MOD_ID);
    }

}
