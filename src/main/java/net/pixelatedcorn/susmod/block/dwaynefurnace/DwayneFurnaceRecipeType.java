package net.pixelatedcorn.susmod.block.dwaynefurnace;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.pixelatedcorn.susmod.item.ModItems;
import net.pixelatedcorn.susmod.recipes.ModRecipes;

public class DwayneFurnaceRecipeType extends AbstractCookingRecipe {
    public DwayneFurnaceRecipeType(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(ModRecipes.DWAYNE_FURNACE_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }

    public ItemStack getRecipeKindIcon() {
        return new ItemStack(ModItems.JAMBA_JUICE);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.DWAYNE_FURNACE_RECIPE_TYPE_SERIALIZER;
    }
}
