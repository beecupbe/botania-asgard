package dev.beecube31.botaniaasgard.datagen;

import dev.beecube31.botaniaasgard.core.AFB;
import dev.beecube31.botaniaasgard.recipes.AFBRecipeProvder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = AFB.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AFBDatagen {

    public AFBDatagen() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        if (event.includeServer()) {
            generator.addProvider(true, new AFBRecipeProvder(output));
            generator.addProvider(true, new AFBBlockTagProvider(output, lookupProvider, existingFileHelper));
            generator.addProvider(true, new AFBLootTableProvider(output));
        }
    }
}
