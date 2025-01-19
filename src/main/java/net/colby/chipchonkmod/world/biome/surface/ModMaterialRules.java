package net.colby.chipchonkmod.world.biome.surface;

import net.colby.chipchonkmod.block.ModBlocks;
import net.colby.chipchonkmod.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    //private static final MaterialRules.MaterialRule CELESTIAL_NYLIUM = makeStateRule(ModBlocks.CELESTIAL_NYLIUM);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    /**public static MaterialRules.MaterialRule makeEndRules() {

        return MaterialRules.sequence(

                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, CELESTIAL_NYLIUM)

        );
    }*/

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
