package net.pixelatedcorn.susmod.item.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.pixelatedcorn.susmod.item.ModItems;

public class DwayneToolMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 3281;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 11.0f;
    }

    @Override
    public float getAttackDamage() {
        return 5.0f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.DWAYNE_INGOT);
    }
}
