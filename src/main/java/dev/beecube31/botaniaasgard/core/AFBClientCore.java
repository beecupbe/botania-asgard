package dev.beecube31.botaniaasgard.core;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import vazkii.botania.client.render.block_entity.SpecialFlowerBlockEntityRenderer;

@Mod.EventBusSubscriber(modid = AFB.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AFBClientCore {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(AFB.ASGARD_DANDELION.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(AFB.ASGARD_DANDELION_FLOATING.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(AFB.ASGARD_DANDELION_POTTED.get(), RenderType.cutout());

            BlockEntityRenderers.register(AFB.ASGARD_TILE.get(), SpecialFlowerBlockEntityRenderer::new);

            BlockEntityRenderers.register(AFB.ASGARD_FLOATING_TILE.get(), SpecialFlowerBlockEntityRenderer::new);
        });
    }
}
