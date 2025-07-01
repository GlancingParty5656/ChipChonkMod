package net.colby.chipchonkmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent ACORN_STEW = new FoodComponent.Builder().nutrition(7).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 2), 1.0f).build();
    public static final FoodComponent BLUEBERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.25f).snack().build();

}
