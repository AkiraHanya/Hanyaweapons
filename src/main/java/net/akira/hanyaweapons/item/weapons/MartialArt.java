package net.akira.hanyaweapons.item.weapons;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class MartialArt extends SwordItem {
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
            return 1.0F; // Additional damage
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

    public MartialArt() {
        super(CUSTOM_TIER, 3, -1.0F, new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.hanyaweapons.martialart"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.martialart1"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.martialart2"));
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random random = new Random();
        if (random.nextDouble() < 0.18) {
            double knockbackStrength = 4.0;
            double xRatio = target.getX() - attacker.getX();
            double zRatio = target.getZ() - attacker.getZ();
            double distance = Math.sqrt(xRatio * xRatio + zRatio * zRatio);
            if (distance != 0.0D) {
                xRatio /= distance;
                zRatio /= distance;
                target.setDeltaMovement(target.getDeltaMovement().add(xRatio * knockbackStrength, 0, zRatio * knockbackStrength));
            }

            target.getCommandSenderWorld().playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.PLAYERS, 1.0F, 1.0F);


            target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 40, 2));
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 0));


            if (attacker instanceof Player) {
                Player player = (Player) attacker;
                MobEffectInstance currentEffect = player.getEffect(MobEffects.DIG_SPEED);
                int currentAmplifier = currentEffect != null ? currentEffect.getAmplifier() : -1;
                int newAmplifier = Math.min(currentAmplifier + 2, 2);
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 170, newAmplifier, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 170, newAmplifier, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 170, newAmplifier, false, true));
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void onUseTick(Level world, LivingEntity entity, ItemStack stack, int count) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (!player.getMainHandItem().equals(stack) && player.hasEffect(MobEffects.DIG_SPEED)) {
                player.removeEffect(MobEffects.DIG_SPEED);
            }
        }
        super.onUseTick(world, entity, stack, count);
    }
}
