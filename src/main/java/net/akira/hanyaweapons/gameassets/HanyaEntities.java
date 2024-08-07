package net.akira.hanyaweapons.gameassets;

import net.akira.hanyaweapons.entity.mobs.AkiraHanya;
import net.akira.hanyaweapons.entity.mobs.Gluttony;
import net.akira.hanyaweapons.entity.mobs.PiglinKing;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HanyaEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "hanyaweapons");
    public static final RegistryObject<EntityType<PiglinKing>> PIGLINKING = register("piglin_king",
            EntityType.Builder.<PiglinKing>of(PiglinKing::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PiglinKing::new)
                    .sized(1.0f, 2.5f));

    public static final RegistryObject<EntityType<AkiraHanya>> AKIRAHANYA = register("akirahanya",
            EntityType.Builder.<AkiraHanya>of(AkiraHanya::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AkiraHanya::new)
                    .sized(1.2f, 2.5f));

    public static final RegistryObject<EntityType<Gluttony>> GLUTTONY = register("gluttony",
            EntityType.Builder.<Gluttony>of(Gluttony::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Gluttony::new)
                    .sized(1.2f, 2.5f));



    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PiglinKing.init();
            AkiraHanya.init();
            Gluttony.init();
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(PIGLINKING.get(), PiglinKing.createAttributes().build());
        event.put(AKIRAHANYA.get(), PiglinKing.createAttributes().build());
        event.put(GLUTTONY.get(), Gluttony.createAttributes().build());
    }
}
