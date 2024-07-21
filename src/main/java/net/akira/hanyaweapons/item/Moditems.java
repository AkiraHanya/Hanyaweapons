package net.akira.hanyaweapons.item;

import net.akira.hanyaweapons.item.equipment.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class Moditems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "hanyaweapons");
    public static final RegistryObject<Item> DULLBLADE;
    public static final RegistryObject<Item> PIGLINSTAFF;
    public static final RegistryObject<Item> INVERTEDSPEAR;
    public static final RegistryObject<Item> CURSEDKATANA;
    public static final RegistryObject<Item> DIMENSIONALKATANA;
    public static final RegistryObject<Item> MARTIALART; // Register the WheelOfPerfection
    public static final RegistryObject<Item> ENDERBLASTERPLUS;
    public static final RegistryObject<Item> SAKURARAPIER;
    public static final RegistryObject<Item> TACHYBLADE;
    public static final RegistryObject<Item> AETHERBREAKER;
    public static final RegistryObject<Item> KATANABASIC;
    public static final RegistryObject<Item> SUNKENANCHOR;
    public static final RegistryObject<Item> FROSTBITE;
    public static final RegistryObject<Item> JUMONJIYARI;
    public static final RegistryObject<Item> GLUTTONY;
    public static final RegistryObject<Item> PIGLINCROWN;
    public static final RegistryObject<Item> JUDGEMENTOFAETHER;
    public static final RegistryObject<Item> SAKURAINGOT;
    static {


        INVERTEDSPEAR = ITEMS.register("invertedspear", InvertedSpear::new);
        SUNKENANCHOR = ITEMS.register("sunkenanchor", SunkenAnchor::new);
        SAKURARAPIER = ITEMS.register("sakurarapier", SakuraRapier::new);
        ENDERBLASTERPLUS = ITEMS.register("enderblasterplus", EnderBlasterPlus::new);
        DIMENSIONALKATANA = ITEMS.register("dimensionalkatana", DimensionalKatana::new);
        MARTIALART = ITEMS.register("martialart", MartialArt::new);
        CURSEDKATANA = ITEMS.register("cursedkatana", CursedKatana::new);
        DULLBLADE = ITEMS.register("dullblade", DullBlade::new);
        PIGLINSTAFF = ITEMS.register("piglinstaff", PiglinStaff::new);
        TACHYBLADE = ITEMS.register("tachyblade", TachyBlade::new);
        AETHERBREAKER = ITEMS.register("aetherbreaker", AetherBreaker::new);
        KATANABASIC = ITEMS.register("katanabasic", KatanaBasic::new);
        FROSTBITE = ITEMS.register("frostbite", FrostBite::new);
        JUMONJIYARI = ITEMS.register("jumonjiyari", JumonjiYari::new);
        GLUTTONY = ITEMS.register("gluttony", Gluttony::new);
        PIGLINCROWN = ITEMS.register("piglincrown", PiglinCrown::new);
        JUDGEMENTOFAETHER = ITEMS.register("judgementofaether", JudgementOfAether::new);
        SAKURAINGOT = ITEMS.register("sakuraingot", SakuraIngot::new);

    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
