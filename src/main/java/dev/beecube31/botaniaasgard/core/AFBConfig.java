package dev.beecube31.botaniaasgard.core;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod.EventBusSubscriber(modid = "botaniaasgard", bus = Mod.EventBusSubscriber.Bus.MOD)
public class AFBConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger("AFB::Config");

    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static class CommonConfig {

        public final ForgeConfigSpec.IntValue asgardManaStorage;
        public final ForgeConfigSpec.IntValue asgardManaGenerationPerTick;
        public final ForgeConfigSpec.IntValue asgardLinkationRadius;


        public CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Asgard configuration").push("asgard");

            asgardManaStorage = builder
                    .defineInRange("asgardManaStorage", 1000000, 0, Integer.MAX_VALUE);

            asgardManaGenerationPerTick = builder
                    .defineInRange("asgardManaGenerationPerTick", 1000000, 0, Integer.MAX_VALUE);

            asgardLinkationRadius = builder
                    .defineInRange("asgardLinkationRadius", 32, 0, Integer.MAX_VALUE);


            builder.pop();
        }
    }

    public static void register(net.minecraftforge.fml.ModLoadingContext context) {
        context.registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, COMMON_SPEC, "botania_asgard-common.toml");
        LOGGER.info("Registered COMMON config");
    }

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == COMMON_SPEC) {
            LOGGER.info("Loading COMMON config file: {}", event.getConfig().getFileName());
        }
    }

    @SubscribeEvent
    public static void onReload(final ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == COMMON_SPEC) {
            LOGGER.info("Reloading COMMON config file: {}", event.getConfig().getFileName());
        }
    }
}
