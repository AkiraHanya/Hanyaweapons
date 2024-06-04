package net.Akira.hanyaweapons.item;

import net.Akira.hanyaweapons.hanyaweapons;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, hanyaweapons.MOD_ID);

    public static final RegistryObject<CreativeModeTab> HANYA_WEAPONS = CREATIVE_MODE_TABS.register("hanyaweapons",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(Moditems.DIMENSIONALBLADE.get()))
                    .title(Component.translatable("creativetab.hanyaweapons"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Moditems.DIMENSIONALKATANA.get());
                        output.accept(Moditems.WHEELOFPERFECTION.get());
                        output.accept(Moditems.DULLBLADE.get());
                        output.accept(Moditems.PIGLINSTAFF.get());
                        output.accept(Moditems.INVERTEDSPEAR.get());
                        output.accept(Moditems.CURSEDKATANA.get());
                        output.accept(Moditems.FASTFIST.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
