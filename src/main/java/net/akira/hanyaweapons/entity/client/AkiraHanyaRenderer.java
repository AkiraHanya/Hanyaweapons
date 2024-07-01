package net.akira.hanyaweapons.entity.client;

import net.akira.hanyaweapons.entity.mobs.AkiraHanya;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PiglinModel;

public class AkiraHanyaRenderer extends HumanoidMobRenderer<AkiraHanya, HumanoidModel<AkiraHanya>> {
    public AkiraHanyaRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(AkiraHanya entity) {
        return new ResourceLocation("hanyaweapons:textures/entity/akirahanya.png");
    }
}
