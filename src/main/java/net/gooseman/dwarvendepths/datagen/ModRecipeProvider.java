package net.gooseman.dwarvendepths.datagen;

import net.gooseman.dwarvendepths.DwarvenDepths;
import net.gooseman.dwarvendepths.block.ModBlocks;
import net.gooseman.dwarvendepths.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    protected ModRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
        super(lookupProvider, output);
    }

    @Override
    protected void buildRecipes() {
        // Ingots <--> Blocks
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_IMPURE_MITHRIL, RecipeCategory.MISC, ModBlocks.RAW_IMPURE_MITHRIL_BLOCK);
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.IMPURE_MITHRIL, RecipeCategory.MISC, ModBlocks.IMPURE_MITHRIL_BLOCK);

        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RAW_WROUGHT_MITHRIL, RecipeCategory.MISC, ModBlocks.RAW_WROUGHT_MITHRIL_BLOCK);
        this.nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.WROUGHT_MITHRIL, RecipeCategory.MISC, ModBlocks.WROUGHT_MITHRIL_BLOCK);

        // Ores/Raw ---> Ingots
        this.oreSmelting(List.of(ModBlocks.IMPURE_MITHRIL_ORE, ModItems.RAW_IMPURE_MITHRIL), RecipeCategory.MISC, ModItems.IMPURE_MITHRIL, 27, 320, "impure_mithril");
        this.oreBlasting(List.of(ModBlocks.IMPURE_MITHRIL_ORE, ModItems.RAW_IMPURE_MITHRIL), RecipeCategory.MISC, ModItems.IMPURE_MITHRIL, 27, 160, "impure_mithril");

        this.oreSmelting(List.of(ModBlocks.WROUGHT_MITHRIL_ORE, ModItems.RAW_WROUGHT_MITHRIL), RecipeCategory.MISC, ModItems.IMPURE_MITHRIL, 55, 400, "wrought_mithril");
        this.oreBlasting(List.of(ModBlocks.WROUGHT_MITHRIL_ORE, ModItems.RAW_WROUGHT_MITHRIL), RecipeCategory.MISC, ModItems.IMPURE_MITHRIL, 55, 200, "wrought_mithril");
    }

    public static class Runner extends RecipeProvider.Runner {

        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Dwarven Depths Recipes";
        }
    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(RecipeSerializer<T> serializer, AbstractCookingRecipe.Factory<T> recipeFactory, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group, String suffix) {
        for(ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, serializer, recipeFactory).group(group).unlockedBy(getHasName(itemlike), this.has(itemlike)).save(this.output, DwarvenDepths.MOD_ID + ":" + getItemName(result) + suffix + "_" + getItemName(itemlike));
        }
    }

    @Override
    protected void nineBlockStorageRecipes(RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed, String packedName, @Nullable String packedGroup, String unpackedName, @Nullable String unpackedGroup) {
        this.shapeless(unpackedCategory, unpacked, 9).requires(packed).group(unpackedGroup).unlockedBy(getHasName(packed), this.has(packed)).save(this.output, ResourceKey.create(Registries.RECIPE, ResourceLocation.parse(DwarvenDepths.MOD_ID + ":" + unpackedName)));
        this.shaped(packedCategory, packed).define('#', unpacked).pattern("###").pattern("###").pattern("###").group(packedGroup).unlockedBy(getHasName(unpacked), this.has(unpacked)).save(this.output, ResourceKey.create(Registries.RECIPE, ResourceLocation.parse(DwarvenDepths.MOD_ID + ":" + packedName)));
    }
}
