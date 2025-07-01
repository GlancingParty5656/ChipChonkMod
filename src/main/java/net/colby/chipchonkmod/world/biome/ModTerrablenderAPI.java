package net.colby.chipchonkmod.world.biome;

import net.colby.chipchonkmod.ChipChonkMod;
import net.colby.chipchonkmod.world.biome.region.ModOverworldRegion;
import net.colby.chipchonkmod.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(ChipChonkMod.MOD_ID, "overworld"), 3));
        //Regions.register(new ModEndRegion(Identifier.of(ChipChonkMod.MOD_ID, "end"), 3));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, ChipChonkMod.MOD_ID, ModMaterialRules.makeRules());
        //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END,ChipChonkMod.MOD_ID, ModMaterialRules.makeEndRules());
    }
}
