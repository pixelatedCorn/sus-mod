package net.pixelatedcorn.susmod.block.dwaynefurnace;

import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.recipebook.FurnaceRecipeBookScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DwayneScreen extends AbstractFurnaceScreen<DwayneScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("minecraft", "textures/gui/container/furnace.png");

    public DwayneScreen(DwayneScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, new FurnaceRecipeBookScreen(), inventory, title, TEXTURE);
    }
}
