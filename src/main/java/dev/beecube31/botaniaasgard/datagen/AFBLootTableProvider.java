package dev.beecube31.botaniaasgard.datagen;

import dev.beecube31.botaniaasgard.datagen.loot.AFBBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;


public class AFBLootTableProvider extends LootTableProvider {
    public AFBLootTableProvider(PackOutput output) {
        super(output, Set.of(), List.of(new SubProviderEntry(AFBBlockLootTables::new, LootContextParamSets.BLOCK)));
    }

    @Override
    protected void validate(java.util.@NotNull Map<net.minecraft.resources.ResourceLocation,
                    net.minecraft.world.level.storage.loot.LootTable> map, @NotNull ValidationContext validationcontext) {
        // NO-OP
    }
}
