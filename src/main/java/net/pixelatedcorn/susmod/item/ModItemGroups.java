package net.pixelatedcorn.susmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.pixelatedcorn.susmod.SusMod;
import net.pixelatedcorn.susmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup STANDARD;
    public static final ItemGroup DISCS;

    static {
        STANDARD = FabricItemGroupBuilder.build(new Identifier(SusMod.MOD_ID, "standard"), () -> new ItemStack(ModBlocks.CHEGGER_BLOCK));
        DISCS = FabricItemGroupBuilder.build(new Identifier(SusMod.MOD_ID, "discs"), () -> new ItemStack(ModItems.BING_CHILLING_DISC));
    }
}
