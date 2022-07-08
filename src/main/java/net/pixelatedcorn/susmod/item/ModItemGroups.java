package net.pixelatedcorn.susmod;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.pixelatedcorn.susmod.block.ModBlocks;
import net.pixelatedcorn.susmod.item.ModItems;

public class ModItemGroup {
    public static final ItemGroup STANDARD;
    public static final ItemGroup DISCS;

    static {
        STANDARD = FabricItemGroupBuilder.build(new Identifier(SusMod.MOD_ID, "susmod.standard"), () -> new ItemStack(ModBlocks.CHEGGER_BLOCK));
    }
}
