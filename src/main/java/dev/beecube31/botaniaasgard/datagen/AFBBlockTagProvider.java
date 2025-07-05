package dev.beecube31.botaniaasgard.datagen;

import dev.beecube31.botaniaasgard.core.AFB;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import vazkii.botania.common.lib.BotaniaTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class AFBBlockTagProvider extends BlockTagsProvider {
    public AFBBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AFB.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(BotaniaTags.Blocks.SPECIAL_FLOWERS).add(AFB.ASGARD_DANDELION.get());
        this.tag(BotaniaTags.Blocks.GENERATING_SPECIAL_FLOWERS).add(AFB.ASGARD_DANDELION.get());
        this.tag(BlockTags.FLOWERS).add(AFB.ASGARD_DANDELION.get());

        this.tag(BotaniaTags.Blocks.SPECIAL_FLOWERS).add(AFB.ASGARD_DANDELION_FLOATING.get());
        this.tag(BotaniaTags.Blocks.FLOATING_FLOWERS).add(AFB.ASGARD_DANDELION_FLOATING.get());
        this.tag(BotaniaTags.Blocks.GENERATING_SPECIAL_FLOWERS).add(AFB.ASGARD_DANDELION_FLOATING.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(AFB.ASGARD_DANDELION_FLOATING.get());
    }
}
