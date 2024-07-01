package net.akira.hanyaweapons.item.equipment;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import static yesman.epicfight.api.client.model.Meshes.HELMET;

public class PiglinCrown extends ArmorItem {
    public static final ArmorMaterial CUSTOM_MATERIAL = new ArmorMaterial() {
        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            return switch (type) {
                case HELMET -> 0;
                case CHESTPLATE -> 0;
                case LEGGINGS -> 0;
                case BOOTS -> 0;
            };
        }

        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return switch (type) {
                case HELMET -> 3;
                case CHESTPLATE -> 6;
                case LEGGINGS -> 5;
                case BOOTS -> 2;
            };
        }

        @Override
        public int getEnchantmentValue() {
            return 30;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_DIAMOND;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.DIAMOND);
        }

        @Override
        public String getName() {
            return "piglincrown";
        }

        @Override
        public float getToughness() {
            return 2.0F;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.1F;
        }
    };

    public PiglinCrown() {
        super(CUSTOM_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.hanyaweapons.piglincrown"));
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable("item.hanyaweapons.piglincrown");
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
}