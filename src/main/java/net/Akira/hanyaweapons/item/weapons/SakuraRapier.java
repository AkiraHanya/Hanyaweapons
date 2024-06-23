package net.Akira.hanyaweapons.item.weapons;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class SakuraRapier extends SwordItem {
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

    public SakuraRapier() {
        super(CUSTOM_TIER, 3, -2.45F, new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.hanyaweapons.sakurarapier"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.sakurarapier1"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.sakurarapier2"));
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player) {
            applyPoisonEffect(target);
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    private void applyPoisonEffect(LivingEntity target) {
        Random random = new Random();
        if (random.nextFloat() < 0.25) {
            int currentPoisonLevel = 0;
            for (MobEffectInstance effect : target.getActiveEffects()) {
                if (effect.getEffect() == MobEffects.POISON) {
                    currentPoisonLevel = effect.getAmplifier() + 1;
                    break;
                }
            }

            if (currentPoisonLevel < 3) {
                target.addEffect(new MobEffectInstance(MobEffects.POISON, 7 * 20, currentPoisonLevel));
            }
        }
    }
}
