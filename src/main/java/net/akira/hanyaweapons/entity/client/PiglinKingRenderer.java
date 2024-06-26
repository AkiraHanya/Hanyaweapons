package net.akira.hanyaweapons.entity.client;

import net.akira.hanyaweapons.entity.mobs.PiglinKing;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PiglinModel;

public class PiglinKingRenderer extends MobRenderer<PiglinKing, PiglinModel<PiglinKing>> {
    public PiglinKingRenderer(EntityRendererProvider.Context context) {
        super(context, new PiglinModel(context.bakeLayer(ModelLayers.PIGLIN)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(PiglinKing entity) {
        return new ResourceLocation("hanyaweapons:textures/entity/piglinking.png");
    }
}
