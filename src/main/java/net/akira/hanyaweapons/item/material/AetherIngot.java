package net.akira.hanyaweapons.item.material;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AetherIngot extends Item {

    public AetherIngot() {
        super(new Item.Properties().stacksTo(64));
    }
    @OnlyIn(Dist.CLIENT)
    private List<Component> tooltipExpand;
}