package net.colby.chipchonkmod.item;

import net.colby.chipchonkmod.ChipChonkMod;
import net.colby.chipchonkmod.entity.ModEntities;
import net.colby.chipchonkmod.item.custom.AcornItem;
import net.colby.chipchonkmod.item.custom.BulletItem;
import net.colby.chipchonkmod.item.custom.GlockItem;
import net.colby.chipchonkmod.item.custom.RifleItem;
import net.colby.chipchonkmod.sound.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item ACORN = registerItem("acorn", new AcornItem(new Item.Settings()));
    public static final Item ACORN_STEW = registerItem("acorn_stew", new Item(new Item.Settings().food(ModFoodComponents.ACORN_STEW)));
    public static final Item COOKED_ACORN = registerItem("cooked_acorn", new Item(new Item.Settings()));
    public static final Item ACORN_BITS = registerItem("acorn_bits", new Item(new Item.Settings()));

    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings()));
    public static final Item RAW_SAPPHIRE = registerItem("raw_sapphire", new Item(new Item.Settings()));
    public static final Item CUT_SAPPHIRE = registerItem("cut_sapphire", new Item(new Item.Settings()));

    public static final Item SAPPHIRE_PICKAXE = registerItem("sapphire_pickaxe",
            new PickaxeItem(ModToolMaterial.SAPPHIRE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
                    ModToolMaterial.SAPPHIRE, 1.0f, -2.8f))));
    public static final Item SAPPHIRE_AXE = registerItem("sapphire_axe",
            new AxeItem(ModToolMaterial.SAPPHIRE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(
                    ModToolMaterial.SAPPHIRE, 5f, -3.0f))));
    public static final Item SAPPHIRE_SHOVEL = registerItem("sapphire_shovel",
            new ShovelItem(ModToolMaterial.SAPPHIRE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(
                    ModToolMaterial.SAPPHIRE, 1.5f, -3.0f))));
    public static final Item SAPPHIRE_SWORD = registerItem("sapphire_sword",
            new SwordItem(ModToolMaterial.SAPPHIRE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
                    ModToolMaterial.SAPPHIRE, 3, -2.4f))));
    public static final Item SAPPHIRE_HOE = registerItem("sapphire_hoe",
            new HoeItem(ModToolMaterial.SAPPHIRE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(
                    ModToolMaterial.SAPPHIRE, -4.0f, 0.0f))));

    public static final Item MEEPLES_SPAWN_EGG = registerItem("meeples_spawn_egg",
            new SpawnEggItem(ModEntities.MEEPLES, 0x1a1717, 0xf7f2f1, new Item.Settings()));
    public static final Item CHIPMUNK_SPAWN_EGG = registerItem("chipmunk_spawn_egg",
            new SpawnEggItem(ModEntities.CHIPMUNK, 0xeab274, 0x3e2723, new Item.Settings()));

    public static final Item CARBON = registerItem("carbon", new Item(new Item.Settings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));
    public static final Item SAPPHIRE_INFUSED_STEEL = registerItem("sapphire_infused_steel", new Item(new Item.Settings()));

    public static final Item QUADRUPLE_COMPRESSED_SAPPHIRE_INFUSED_STEEL_BLOCK_PRESSURE_PLATE_ON_A_STICK = registerItem("quadruple_compressed_sapphire_infused_steel_block_pressure_plate_on_a_stick",
            new SwordItem(ModToolMaterial.SAPPHIRE_INFUSED_STEEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
                    ModToolMaterial.SAPPHIRE_INFUSED_STEEL, 15, -2f))));

    public static final Item THICK_OF_IT_MUSIC_DISC = registerItem("thick_of_it_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.THICK_OF_IT_KEY).maxCount(1)));

    public static final Item GLOCK = registerItem("glock", new GlockItem(new Item.Settings().maxCount(1)));
    public static final Item BULLET = registerItem("bullet", new BulletItem(new Item.Settings()));
    public static final Item RIFLE = registerItem("rifle", new RifleItem(new Item.Settings().maxCount(1)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ChipChonkMod.MOD_ID, name), item);
    }

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(ACORN);
        entries.add(ACORN_STEW);
        entries.add(COOKED_ACORN);
    }

    public static void registerModItems() {
        ChipChonkMod.LOGGER.info("Registering Mod Items for " + ChipChonkMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}