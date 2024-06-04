package net.Akira.hanyaweapons.item;

import net.Akira.hanyaweapons.item.weapons.DimensionalKatana;
import net.Akira.hanyaweapons.item.armor.WheelOfPerfection;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "hanyaweapons");
    public static final RegistryObject<Item> DIMENSIONALBLADE;
    public static final RegistryObject<Item> DULLBLADE;
    public static final RegistryObject<Item> PIGLINSTAFF;
    public static final RegistryObject<Item> INVERTEDSPEAR;
    public static final RegistryObject<Item> CURSEDKATANA;
    public static final RegistryObject<Item> FASTFIST;
    public static final RegistryObject<Item> DIMENSIONALKATANA;
    public static final RegistryObject<Item> WHEELOFPERFECTION; // Register the WheelOfPerfection

    static {
        DIMENSIONALBLADE = ITEMS.register("dimensionalblade",
                () -> new SwordItem(Tiers.DIAMOND, 6, -2.5F, new Item.Properties()));
        DULLBLADE = ITEMS.register("dullblade",
                () -> new SwordItem(Tiers.DIAMOND, 4, -3F, new Item.Properties()));
        FASTFIST = ITEMS.register("fastfist",
                () -> new SwordItem(Tiers.DIAMOND, 5, -1.5F, new Item.Properties()));
        PIGLINSTAFF = ITEMS.register("piglinstaff",
                () -> new SwordItem(Tiers.DIAMOND, 5, -1.8F, new Item.Properties()));
        CURSEDKATANA = ITEMS.register("cursedkatana",
                () -> new SwordItem(Tiers.DIAMOND, 4, -2.75F, new Item.Properties()));
        INVERTEDSPEAR = ITEMS.register("invertedspear",
                () -> new SwordItem(Tiers.DIAMOND, 5, -2.0F, new Item.Properties()));
        DIMENSIONALKATANA = ITEMS.register("dimensionalkatana", DimensionalKatana::new);
        WHEELOFPERFECTION = ITEMS.register("wheelofperfection", WheelOfPerfection::new); // Register the WheelOfPerfection
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
