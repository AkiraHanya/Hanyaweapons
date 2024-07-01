package net.akira.hanyaweapons.entity.client;

import net.akira.hanyaweapons.entity.mobs.PiglinKing;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class PiglinKingRenderer extends HumanoidMobRenderer<PiglinKing, HumanoidModel<PiglinKing>> {
    public PiglinKingRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5F);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    public ResourceLocation getTextureLocation(PiglinKing entity) {
        return new ResourceLocation("hanyaweapons:textures/entity/piglinking.png");
    }
}