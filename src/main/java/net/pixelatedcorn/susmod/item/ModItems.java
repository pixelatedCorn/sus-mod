package net.pixelatedcorn.susmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.pixelatedcorn.susmod.SusMod;
import net.pixelatedcorn.susmod.sound.ModSounds;

public class ModItems {
    public static final MusicDisc BING_CHILLING_DISC;
    public static final MusicDisc CHINA_DISC;
    public static final Item JAMBA_JUICE;
    public static final Item RAW_RUBBER;
    public static final Item VINYL_DISC;
    public static final MusicDisc DWAYNE_DISC;
    public static final Item DWAYNE_INGOT;

    private static void RegisterItem(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier(SusMod.MOD_ID, name), item);
    }

    private static void RegisterFuel(Item item, int burnTime) {
        FuelRegistry.INSTANCE.add(item, burnTime);
    }

    public static void RegisterItems() {
        SusMod.LOGGER.info("Registering items...");
        RegisterItem("disc_china", BING_CHILLING_DISC);
        RegisterItem("disc_china_2", CHINA_DISC);
        RegisterItem("jamba_juice", JAMBA_JUICE);
        RegisterItem("vinyl_disc", VINYL_DISC);
        RegisterItem("raw_rubber", RAW_RUBBER);
        RegisterFuel(JAMBA_JUICE, 800);
        RegisterItem("dwayne_ingot", DWAYNE_INGOT);
        RegisterItem("disc_dwayne", DWAYNE_DISC);
        SusMod.LOGGER.info("Items registered.");
    }

    static {
        BING_CHILLING_DISC = new MusicDisc(0, ModSounds.BING_CHILLING_EVENT, new FabricItemSettings().group(ModItemGroups.DISCS).maxCount(1).rarity(Rarity.RARE));
        CHINA_DISC = new MusicDisc(1, ModSounds.CHINA_SOUND_EVENT, new FabricItemSettings().group(ModItemGroups.DISCS).maxCount(1).rarity(Rarity.RARE));
        VINYL_DISC = new Item(new FabricItemSettings().group(ModItemGroups.DISCS).maxCount(1));
        RAW_RUBBER = new Item(new FabricItemSettings().group(ModItemGroups.STANDARD));
        DWAYNE_INGOT = new Item(new FabricItemSettings().group(ModItemGroups.STANDARD));
        DWAYNE_DISC = new MusicDisc(2, ModSounds.DWAYNE_SOUND_EVENT, new FabricItemSettings().group(ModItemGroups.DISCS).maxCount(1).rarity(Rarity.RARE));
        JAMBA_JUICE = new Item(new FabricItemSettings().group(ModItemGroups.STANDARD)
                .food(new FoodComponent.Builder().hunger(4).saturationModifier(4.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 2), 1.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 2), 1.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 2), 1.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 200, 2), 1.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 2), 1.0f)
                .alwaysEdible()
                .build()));
    }
}
