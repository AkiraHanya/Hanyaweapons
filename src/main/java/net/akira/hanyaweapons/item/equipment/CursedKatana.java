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

public class CursedKatana extends SwordItem {
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
            return 2.0F; // Additional damage
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

    public CursedKatana() {
        super(CUSTOM_TIER, 5, -2.2F, new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.hanyaweapons.cursedkatana"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.cursedkatana1"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.cursedkatana2"));// Add the tooltip text
        super.appendHoverText(stack, world, tooltip, flag); // Ensure superclass method is called
    } //?

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true; // Ensure the item is enchantable
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random random = new Random();
        if (random.nextDouble() < 0.05) { // 5% chance
            // Apply Darkness and Wither effects
            target.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 0)); // 3 seconds
            target.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 3)); // 3 seconds
        }
        return super.hurtEnemy(stack, target, attacker); // Ensure superclass method is called
    }
}
