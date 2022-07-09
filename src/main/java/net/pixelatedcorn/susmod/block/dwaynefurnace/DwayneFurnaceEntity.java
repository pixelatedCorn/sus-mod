package net.pixelatedcorn.susmod.block.dwaynefurnace;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.pixelatedcorn.susmod.block.ModBlocks;
import net.pixelatedcorn.susmod.recipes.ModRecipes;

public class DwayneFurnaceEntity extends AbstractFurnaceBlockEntity {
    public DwayneFurnaceEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.DWAYNE_FURNACE_ENTITY, pos, state, ModRecipes.DWAYNE_FURNACE_RECIPE_TYPE);
    }

    protected Text getContainerName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new DwayneScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
