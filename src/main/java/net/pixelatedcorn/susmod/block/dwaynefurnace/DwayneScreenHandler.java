package net.pixelatedcorn.susmod.block.dwaynefurnace;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.pixelatedcorn.susmod.block.ModScreens;
import net.pixelatedcorn.susmod.item.ModItems;
import net.pixelatedcorn.susmod.recipes.ModRecipes;

public class DwayneScreenHandler extends AbstractFurnaceScreenHandler {

    public DwayneScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModScreens.DWAYNE_SCREEN_HANDLER, ModRecipes.DWAYNE_FURNACE_RECIPE_TYPE, RecipeBookCategory.FURNACE, syncId, playerInventory);
    }

    public DwayneScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(ModScreens.DWAYNE_SCREEN_HANDLER, ModRecipes.DWAYNE_FURNACE_RECIPE_TYPE, RecipeBookCategory.FURNACE, syncId, playerInventory, inventory, propertyDelegate);
    }

    @Override
    protected boolean isFuel(ItemStack itemStack) {
        return itemStack.getItem() == ModItems.JAMBA_JUICE;
    }
}
