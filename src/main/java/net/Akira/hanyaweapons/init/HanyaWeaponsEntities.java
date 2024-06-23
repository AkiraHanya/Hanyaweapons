package net.Akira.hanyaweapons.init;

import net.Akira.hanyaweapons.entity.Mobs.PiglinKing;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(
        bus = Bus.MOD
)
public class HanyaWeaponsEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY;
    public static final RegistryObject<EntityType<PiglinKing>> PIGLINKING;

    public HanyaWeaponsEntities() {
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> {
            return entityTypeBuilder.build(registryname);
        });
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PIGLINKING.init();
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put((EntityType)PIGLINKING.get(), PIGLINKING.createAttributes().build());
    }

    static {
        REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "hanyaweapons");
        PIGLINKING = register("piglinking", Builder.of(PiglinKing::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(512).setUpdateInterval(3).setCustomClientFactory(PiglinKing::new).sized(0.6F, 1.8F));
    }
}
