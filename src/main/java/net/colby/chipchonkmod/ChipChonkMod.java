package net.colby.chipchonkmod;

import net.colby.chipchonkmod.block.ModBlocks;
import net.colby.chipchonkmod.entity.ModEntities;
import net.colby.chipchonkmod.entity.custom.ChipmunkEntity;
import net.colby.chipchonkmod.entity.custom.MeeplesEntity;
import net.colby.chipchonkmod.item.ModItemGroups;
import net.colby.chipchonkmod.item.ModItems;
import net.colby.chipchonkmod.world.biome.ModBiomes;
import net.colby.chipchonkmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.impl.biome.TheEndBiomeData;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.EndBiomeRegistry;

import java.awt.*;

public class ChipChonkMod implements ModInitializer {
	public static final String MOD_ID = "chipchonkmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModWorldGeneration.generateModWorldGen();

		StrippableBlockRegistry.register(ModBlocks.BLUE_OAK_LOG, ModBlocks.STRIPPED_BLUE_OAK_LOG);
		StrippableBlockRegistry.register(ModBlocks.BLUE_OAK_WOOD, ModBlocks.STRIPPED_BLUE_OAK_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_BLUE_OAK_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_BLUE_OAK_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACORN_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_LEAVES, 30, 60);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_BUTTON, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_PRESSURE_PLATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_FENCE_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_WALL, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_DOOR, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_OAK_TRAPDOOR, 5, 20);

		FabricDefaultAttributeRegistry.register(ModEntities.MEEPLES, MeeplesEntity.createMeeplesAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CHIPMUNK, ChipmunkEntity.createChipmunkAttributes());

		CompostingChanceRegistry.INSTANCE.add(ModItems.ACORN, 0.25f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.BLUEBERRY, 0.15f);

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.ACORN_BLOCK)
				.lightWithItem(ModItems.ACORN)
				.destDimID(Identifier.of(ChipChonkMod.MOD_ID, "chipmunkdim"))
				.tintColor(0, 100, 225)
				.registerPortal();

		//RegistryKey<Biome> celestialForestKey = ModBiomes.CELESTIAL_FOREST;
		//TheEndBiomes.addHighlandsBiome(celestialForestKey, 3.0d);
		//TheEndBiomeData.addEndBiomeReplacement(BiomeKeys.END_HIGHLANDS, ModBiomes.CELESTIAL_FOREST, 50.0);

		//EndBiomeRegistry.registerHighlandsBiome(ModBiomes.CELESTIAL_FOREST, 3);
		/**ServerWorldEvents.LOAD.register((server, world) -> {
			// Ensure it's the End world to register biomes for the End
			if (world.getRegistryKey() == World.END) {
				// Now register the biome, since the world is loaded and all configs are ready
				EndBiomeRegistry.registerHighlandsBiome(ModBiomes.CELESTIAL_FOREST, 3);
			}
		});*/
	}
}