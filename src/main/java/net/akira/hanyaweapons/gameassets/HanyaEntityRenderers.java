package net.akira.hanyaweapons.gameassets;

import net.akira.hanyaweapons.entity.client.AkiraHanyaRenderer;
import net.akira.hanyaweapons.entity.client.PiglinKingRenderer;
import net.akira.hanyaweapons.entity.client.GluttonyRenderer;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HanyaEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(HanyaEntities.PIGLINKING.get(), PiglinKingRenderer::new);
        event.registerEntityRenderer(HanyaEntities.AKIRAHANYA.get(), AkiraHanyaRenderer::new);
        event.registerEntityRenderer(HanyaEntities.GLUTTONY.get(), GluttonyRenderer::new);
    }
}
