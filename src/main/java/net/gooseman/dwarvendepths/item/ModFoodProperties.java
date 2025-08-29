package net.gooseman.dwarvendepths.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoodProperties {
    public static final FoodProperties TASTY_MITHRIL_FOOD = new FoodProperties.Builder().nutrition(2).saturationModifier(0f).alwaysEdible().build();
    public static final Consumable TASTY_MITHRIL_CONSUMABLE =  Consumable.builder()
            .consumeSeconds(3f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.RESISTANCE, 6000, 2), 0.80f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 600, 4), 0.50f))
            .build();
    public static final Item.Properties TASTY_MITHRIL = new Item.Properties().fireResistant().food(TASTY_MITHRIL_FOOD).component(DataComponents.CONSUMABLE, TASTY_MITHRIL_CONSUMABLE);

    public static final FoodProperties OIL_BARREL_FOOD = new FoodProperties.Builder().nutrition(0).saturationModifier(0f).build();
    public static final Consumable OIL_BARREL_CONSUMABLE = Consumable.builder()
            .consumeSeconds(5f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 1200, 7)))
            .build();

    public static final Item.Properties OIL_BARREL = new Item.Properties().food(OIL_BARREL_FOOD).component(DataComponents.CONSUMABLE, OIL_BARREL_CONSUMABLE);
}
