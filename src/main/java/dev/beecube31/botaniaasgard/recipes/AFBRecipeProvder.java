package dev.beecube31.botaniaasgard.recipes;


import committee.nova.mods.avaritia.init.data.provider.recipe.ModShapedRecipeBuilder;
import committee.nova.mods.avaritia.init.registry.ModItems;
import dev.beecube31.botaniaasgard.core.AFB;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import vazkii.botania.common.item.BotaniaItems;

import java.util.function.Consumer;

public class AFBRecipeProvder extends RecipeProvider {

    public AFBRecipeProvder(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
         ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AFB.ASGARD_DANDELION_FLOATING_ITEM.get())
                 .pattern(" A ")
                 .pattern(" S ")
                 .pattern(" D ")
                 .define('A', AFB.ASGARD_DANDELION_ITEM.get())
                 .define('S', BotaniaItems.grassSeeds)
                 .define('D', Items.DIRT)
                 .unlockedBy("has_item", has(AFB.ASGARD_DANDELION_ITEM.get()))
                 .save(consumer, new ResourceLocation(AFB.MODID, "asgard_to_floating"));

         if (ModList.get().isLoaded("avaritia")) {
             ModShapedRecipeBuilder
                     .shaped(RecipeCategory.TOOLS, AFB.ASGARD_DANDELION_ITEM.get())
                     .pattern("   III   ")
                     .pattern("  IIIII  ")
                     .pattern("  IISII  ")
                     .pattern("  IIIII  ")
                     .pattern("   III   ")
                     .pattern(" NN G NN ")
                     .pattern("NNNNGNNNN")
                     .pattern(" NN G NN ")
                     .pattern("    G    ")
                     .define('I', ModItems.infinity_ingot.get())
                     .define('S', ModItems.infinity_catalyst.get())
                     .define('N', ModItems.neutron_nugget.get())
                     .define('G', ModItems.neutron_ingot.get())
                     .showNotification(true)
                     .unlockedBy("has_item", has(ModItems.infinity_ingot.get()))
                     .save(consumer, new ResourceLocation(AFB.MODID, "extreme_asgardandelion"));
         }
    }
}
