package net.akira.hanyaweapons.item;

import net.akira.hanyaweapons.HanyaWeapons;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HanyaWeapons.MOD_ID);

    public static final RegistryObject<CreativeModeTab> HANYA_WEAPONS = CREATIVE_MODE_TABS.register("hanyaweapons",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(Moditems.DIMENSIONALKATANA.get()))
                    .title(Component.translatable("creativetab.hanyaweapons"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Moditems.DIMENSIONALKATANA.get());
                        output.accept(Moditems.MARTIALART.get());
                        output.accept(Moditems.DULLBLADE.get());
                        output.accept(Moditems.PIGLINSTAFF.get());
                        output.accept(Moditems.INVERTEDSPEAR.get());
                        output.accept(Moditems.ENDERBLASTERPLUS.get());
                        output.accept(Moditems.SAKURARAPIER.get());
                        output.accept(Moditems.TACHYBLADE.get());
                        output.accept(Moditems.AETHERBREAKER.get());
                        output.accept(Moditems.KATANABASIC.get());
                        output.accept(Moditems.FROSTBITE.get());
                        output.accept(Moditems.JUMONJIYARI.get());
                        output.accept(Moditems.GLUTTONY.get());
                        output.accept(Moditems.CURSEDKATANA.get());
                        output.accept(Moditems.SUNKENANCHOR.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
