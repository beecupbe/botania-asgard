package dev.beecube31.botaniaasgard.datagen.loot;

import dev.beecube31.botaniaasgard.core.AFB;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collections;

public class AFBBlockLootTables extends BlockLootSubProvider {

    public AFBBlockLootTables() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(AFB.ASGARD_DANDELION.get());
        this.dropSelf(AFB.ASGARD_DANDELION_FLOATING.get());

        this.add(AFB.ASGARD_DANDELION_POTTED.get(), (block) -> createPotFlowerItemTable(AFB.ASGARD_DANDELION.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return AFB.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
