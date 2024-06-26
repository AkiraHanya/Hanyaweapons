package net.akira.hanyaweapons.item.weapons;

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

public class PiglinStaff extends SwordItem {
    public static final Tier CUSTOM_TIER = new Tier() {
        @Override
        public int getUses() {
            return 0;
        }

        @Override
        public float getSpeed() {
            return 9.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 3.0F;
        }

        @Override
        public int getLevel() {
            return 4;
        }

        @Override
        public int getEnchantmentValue() {
            return 30;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.DIAMOND);
        }
    };

    public PiglinStaff() {
        super(CUSTOM_TIER, 5, -1.8F, new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.hanyaweapons.piglinstaff"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.piglinstaff1"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.piglinstaff2"));
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random random = new Random();
        if (random.nextDouble() < 0.13) {
            if (attacker instanceof LivingEntity) {
                attacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 1, false, true));
                attacker.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0, false, true));
                attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0, false, true));
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
