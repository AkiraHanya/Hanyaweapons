package net.akira.hanyaweapons.item.equipment;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class EnderBlasterPlus extends SwordItem {
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
            return 3.0F; // Additional damage
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

    public EnderBlasterPlus () {
        super(CUSTOM_TIER, 3, -1.5F, new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.hanyaweapons.enderblasterplus"));
        //tooltip.add(Component.translatable("tooltip.hanyaweapons.enderblasterplus1"));
        //tooltip.add(Component.translatable("tooltip.hanyaweapons.enderblasterplus2"));// Add the tooltip text
        super.appendHoverText(stack, world, tooltip, flag); // Ensure superclass method is called
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true; // Ensure the item is enchantable
    }

}