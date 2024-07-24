package net.akira.hanyaweapons.item.equipment;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class TachyBlade extends SwordItem {
    public static final Tier CUSTOM_TIER = new Tier() {
        @Override
        public int getUses() {
            return 0; // Durability
        }

        @Override
        public float getSpeed() {
            return 9.0F; // Mining speed
        }

        @Override
        public float getAttackDamageBonus() {
            return 1.5F; // Additional damage
        }

        @Override
        public int getLevel() {
            return 4; // Mining level
        }

        @Override
        public int getEnchantmentValue() {
            return 30; // Enchantability
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.DIAMOND); // Repair material
        }
    };

    public TachyBlade() {
        super(CUSTOM_TIER, 5, -2.0F, new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.hanyaweapons.tachyblade"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.tachyblade1"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.tachyblade2"));// Add the tooltip text
        super.appendHoverText(stack, world, tooltip, flag); // Ensure superclass method is called
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true; // Ensure the item is enchantable
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random random = new Random();
        if (random.nextFloat() < 0.25) { // 20% chance
            MobEffectInstance currentEffect = attacker.getEffect(MobEffects.DIG_SPEED);
            int currentLevel = (currentEffect != null) ? currentEffect.getAmplifier() : -1;
            if (currentLevel < 4) {
                attacker.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, currentLevel + 1, true, false ,true)); // 600 ticks = 30 seconds
            } else {
                attacker.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, currentLevel, true, false,true )); // Refresh duration if already at max level
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
