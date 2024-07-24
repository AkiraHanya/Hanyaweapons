package net.akira.hanyaweapons.loot;

import com.mojang.serialization.Codec;
import net.akira.hanyaweapons.item.Moditems;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import com.mojang.serialization.Codec;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistries;


@EventBusSubscriber(
        modid = "hanyaweapons"
)
public class HanyaWeaponsChestLootTables {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, "hanyaweapons");
    public HanyaWeaponsChestLootTables() {
    }

    @SubscribeEvent
    public static void modifyVanillaLootPools(LootTableLoadEvent event) {
        if (event.getName().equals(BuiltInLootTables.STRONGHOLD_CORRIDOR)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike) Moditems.CURSEDKATANA.get()).setWeight(5)).add(LootItem.lootTableItem(Items.AIR).setWeight(10)).build());
        }

        if (event.getName().equals(BuiltInLootTables.ANCIENT_CITY)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike) Moditems.DULLBLADE.get()).setWeight(5)).add(LootItem.lootTableItem(Items.AIR).setWeight(10)).build());
        }

    }
}
