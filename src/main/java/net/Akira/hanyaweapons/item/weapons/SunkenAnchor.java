package net.Akira.hanyaweapons.item.weapons;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class SunkenAnchor extends SwordItem {
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
            return 10.0F; // Additional damage
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

    public SunkenAnchor() {
        super(CUSTOM_TIER, 5, -4.0F, new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.hanyaweapons.sunkenanchor"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.sunkenanchor1"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.sunkenanchor2")); // Add the tooltip text
        super.appendHoverText(stack, world, tooltip, flag); // Ensure superclass method is called
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true; // Ensure the item is enchantable
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random random = new Random();
        if (random.nextDouble() < 1.0) {
            double knockbackStrength = 0.8;
            double xRatio = target.getX() - attacker.getX();
            double zRatio = target.getZ() - attacker.getZ();
            double distance = Math.sqrt(xRatio * xRatio + zRatio * zRatio);
            if (distance != 0.0D) {
                xRatio /= distance;
                zRatio /= distance;
                target.setDeltaMovement(target.getDeltaMovement().add(xRatio * knockbackStrength, 0, zRatio * knockbackStrength));
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }

}
