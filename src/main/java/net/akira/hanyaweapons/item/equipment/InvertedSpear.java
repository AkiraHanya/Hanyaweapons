package net.akira.hanyaweapons.item.equipment;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class InvertedSpear extends SwordItem {
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
            return 2.5F; // Additional damage
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

    public InvertedSpear() {
        super(CUSTOM_TIER, 3, -1.25F, new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.hanyaweapons.invertedspear"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.invertedspear1"));
        tooltip.add(Component.translatable("tooltip.hanyaweapons.invertedspear2"));
        // Add the tooltip text
        super.appendHoverText(stack, world, tooltip, flag); // Ensure superclass method is called
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true; // Ensure the item is enchantable
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target != null && !target.getActiveEffects().isEmpty()) {
            target.removeAllEffects(); // Remove all status effects from the target

            // Play the zombie curing sound
            target.getCommandSenderWorld().playSound(null, target.getX(), target.getY(), target.getZ(),
                    SoundEvents.ZOMBIE_VILLAGER_CURE, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
        return super.hurtEnemy(stack, target, attacker); // Ensure superclass method is called
    }
}
