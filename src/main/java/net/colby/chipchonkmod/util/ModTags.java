package net.colby.chipchonkmod.util;

import net.colby.chipchonkmod.ChipChonkMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ChipChonkMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> GUN_ITEMS = createTag("gun_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ChipChonkMod.MOD_ID, name));
        }
    }

}
