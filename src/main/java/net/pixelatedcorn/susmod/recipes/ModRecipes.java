package net.pixelatedcorn.susmod.recipes;

import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.pixelatedcorn.susmod.SusMod;
import net.pixelatedcorn.susmod.block.dwaynefurnace.DwayneFurnaceRecipeType;

public class ModRecipes {
    public static final RecipeType<DwayneFurnaceRecipeType> DWAYNE_FURNACE_RECIPE_TYPE;
    public static final RecipeSerializer<DwayneFurnaceRecipeType> DWAYNE_FURNACE_RECIPE_TYPE_SERIALIZER;

    private static void RegisterRecipeType(String name, RecipeType recipeType, RecipeSerializer recipeSerializer) {
        Registry.register(Registry.RECIPE_TYPE, new Identifier(SusMod.MOD_ID, name), recipeType);
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(SusMod.MOD_ID, name), recipeSerializer);
    }

    public static void RegisterRecipeTypes() {
        SusMod.LOGGER.info("Registering recipe types...");
        RegisterRecipeType("dwayne_epic_cooking_recipe", DWAYNE_FURNACE_RECIPE_TYPE, DWAYNE_FURNACE_RECIPE_TYPE_SERIALIZER);
        SusMod.LOGGER.info("Recipe types registered");
    }

    static {
        DWAYNE_FURNACE_RECIPE_TYPE = new RecipeType<>() {
            @Override
            public String toString() { return "dwayne_furnace_recipe_type"; }
        };
        DWAYNE_FURNACE_RECIPE_TYPE_SERIALIZER = new CookingRecipeSerializer<>(DwayneFurnaceRecipeType::new, 200);
    }
}
