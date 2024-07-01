package net.akira.hanyaweapons.item.equipment;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class JumonjiYari extends SwordItem {
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

    public JumonjiYari() {
        super(CUSTOM_TIER, 6, -1.6F, new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.hanyaweapons.jumonjiyari"));
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

}
