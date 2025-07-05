package dev.beecube31.botaniaasgard.core;

import com.mojang.logging.LogUtils;
import dev.beecube31.botaniaasgard.datagen.AFBDatagen;
import dev.beecube31.botaniaasgard.item.AFBAsgardItem;
import dev.beecube31.botaniaasgard.tiles.AsgardandelionFloatingTile;
import dev.beecube31.botaniaasgard.tiles.AsgardandelionTile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import vazkii.botania.api.BotaniaRegistries;
import vazkii.botania.api.block_entity.SpecialFlowerBlockEntity;
import vazkii.botania.common.block.BotaniaBlocks;
import vazkii.botania.common.block.FloatingSpecialFlowerBlock;
import vazkii.botania.common.brew.BotaniaMobEffects;
import vazkii.botania.common.item.BotaniaItems;
import vazkii.botania.common.item.block.SpecialFlowerBlockItem;
import vazkii.botania.xplat.XplatAbstractions;

import java.util.function.Supplier;

@Mod(AFB.MODID)
public class AFB {
    public static final String MODID = "botaniaasgard";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    public static final RegistryObject<FlowerBlock> ASGARD_DANDELION = BLOCKS.register("asgardandelion",
            () -> createSpecialFlower(AFB.ASGARD_TILE::get));

    public static final RegistryObject<FloatingSpecialFlowerBlock> ASGARD_DANDELION_FLOATING = BLOCKS.register("asgardandelion_floating",
            () -> new FloatingSpecialFlowerBlock(BotaniaBlocks.FLOATING_PROPS, AFB.ASGARD_FLOATING_TILE::get));

    public static final RegistryObject<FlowerPotBlock> ASGARD_DANDELION_POTTED = BLOCKS.register("potted_asgardandelion",
            () -> new FlowerPotBlock(ASGARD_DANDELION.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Item> ASGARD_DANDELION_ITEM = ITEMS.register("asgardandelion",
            () -> new AFBAsgardItem(ASGARD_DANDELION.get(), BotaniaItems.defaultBuilder()));

    public static final RegistryObject<Item> ASGARD_DANDELION_FLOATING_ITEM = ITEMS.register("asgardandelion_floating",
            () -> new AFBAsgardItem(ASGARD_DANDELION_FLOATING.get(), BotaniaItems.defaultBuilder()));

    public static final RegistryObject<BlockEntityType<AsgardandelionTile>> ASGARD_TILE = BLOCK_ENTITY_TYPES.register("asgardandelion",
            () -> XplatAbstractions.INSTANCE.createBlockEntityType(
                    AsgardandelionTile::new,
                    ASGARD_DANDELION.get()
            ));

    public static final RegistryObject<BlockEntityType<AsgardandelionFloatingTile>> ASGARD_FLOATING_TILE = BLOCK_ENTITY_TYPES.register("asgardandelion_floating",
            () -> XplatAbstractions.INSTANCE.createBlockEntityType(
                    AsgardandelionFloatingTile::new,
                    ASGARD_DANDELION_FLOATING.get()
            ));


    public AFB() {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(bus);
        ITEMS.register(bus);
        BLOCK_ENTITY_TYPES.register(bus);

        bus.addListener(this::addCreative);

        AFBConfig.register(net.minecraftforge.fml.ModLoadingContext.get());
    }

    private static FlowerBlock createSpecialFlower(Supplier<BlockEntityType<? extends SpecialFlowerBlockEntity>> beType) {
        return XplatAbstractions.INSTANCE.createSpecialFlowerBlock(
                BotaniaMobEffects.clear,
                0,
                BlockBehaviour.Properties.copy(Blocks.POPPY),
                beType
        );
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == BotaniaRegistries.BOTANIA_TAB_KEY) {
            event.accept(ASGARD_DANDELION_ITEM);
            event.accept(ASGARD_DANDELION_FLOATING_ITEM);
        }
    }
}