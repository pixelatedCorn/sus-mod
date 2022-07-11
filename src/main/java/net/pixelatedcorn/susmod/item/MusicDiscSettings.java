package net.pixelatedcorn.susmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Rarity;

public class MusicDiscSettings extends FabricItemSettings {
    public MusicDiscSettings() {
        this.group(ModItemGroups.DISCS);
        this.maxCount(1);
        this.rarity(Rarity.RARE);
    }
}
