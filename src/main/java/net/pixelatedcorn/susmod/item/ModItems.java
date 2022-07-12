package net.pixelatedcorn.susmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.pixelatedcorn.susmod.SusMod;
import net.pixelatedcorn.susmod.item.armor.DwayneArmorMaterial;
import net.pixelatedcorn.susmod.item.tools.*;
import net.pixelatedcorn.susmod.sound.ModSounds;

public class ModItems {
    public static final MusicDisc BING_CHILLING_DISC;
    public static final MusicDisc CHINA_DISC;
    public static final Item JAMBA_JUICE;
    public static final Item RAW_RUBBER;
    public static final Item VINYL_DISC;
    public static final MusicDisc DWAYNE_DISC;
    public static final Item DWAYNE_INGOT;
    public static final ArmorMaterial DWAYNE_ARMOR_MATERIAL;
    public static final Item DWAYNE_HELMET;
    public static final Item DWAYNE_CHESTPLATE;
    public static final Item DWAYNE_LEGGINGS;
    public static final Item DWAYNE_BOOTS;
    public static final DwayneSword DWAYNE_SWORD;
    public static final PickaxeItem DWAYNE_PICKAXE;
    public static final AxeItem DWAYNE_AXE;
    public static final ShovelItem DWAYNE_SHOVEL;
    public static final HoeItem DWAYNE_HOE;
    public static final ToolMaterial DWAYNE_TOOL_MATERIAL;

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
        RegisterItem("dwayne_helmet", DWAYNE_HELMET);
        RegisterItem("dwayne_chestplate", DWAYNE_CHESTPLATE);
        RegisterItem("dwayne_leggings", DWAYNE_LEGGINGS);
        RegisterItem("dwayne_boots", DWAYNE_BOOTS);
        RegisterItem("dwayne_sword", DWAYNE_SWORD);
        RegisterItem("dwayne_pickaxe", DWAYNE_PICKAXE);
        RegisterItem("dwayne_axe", DWAYNE_AXE);
        RegisterItem("dwayne_shovel", DWAYNE_SHOVEL);
        RegisterItem("dwayne_hoe", DWAYNE_HOE);
        SusMod.LOGGER.info("Items registered.");
    }

    static {
        BING_CHILLING_DISC = new MusicDisc(1, ModSounds.BING_CHILLING_EVENT, new MusicDiscSettings());
        CHINA_DISC = new MusicDisc(2, ModSounds.CHINA_SOUND_EVENT, new MusicDiscSettings());
        VINYL_DISC = new Item(new FabricItemSettings().group(ModItemGroups.DISCS).maxCount(1));
        RAW_RUBBER = new Item(new FabricItemSettings().group(ModItemGroups.STANDARD));
        DWAYNE_INGOT = new Item(new FabricItemSettings().group(ModItemGroups.STANDARD));
        DWAYNE_DISC = new MusicDisc(3, ModSounds.DWAYNE_SOUND_EVENT, new MusicDiscSettings());
        JAMBA_JUICE = new Item(new FabricItemSettings().group(ModItemGroups.STANDARD)
                .food(new FoodComponent.Builder().hunger(4).saturationModifier(4.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 2), 1.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 2), 1.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 2), 1.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 200, 2), 1.0f)
                .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 2), 1.0f)
                .alwaysEdible()
                .build()));
        DWAYNE_ARMOR_MATERIAL = new DwayneArmorMaterial();
        DWAYNE_HELMET = new ArmorItem(DWAYNE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroups.STANDARD));
        DWAYNE_CHESTPLATE = new ArmorItem(DWAYNE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroups.STANDARD));
        DWAYNE_LEGGINGS = new ArmorItem(DWAYNE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroups.STANDARD));
        DWAYNE_BOOTS = new ArmorItem(DWAYNE_ARMOR_MATERIAL, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroups.STANDARD));
        DWAYNE_TOOL_MATERIAL = new DwayneToolMaterial();
        DWAYNE_SWORD = new DwayneSword(new FabricItemSettings().group(ModItemGroups.STANDARD));
        DWAYNE_PICKAXE = new ModPickaxeItem(DWAYNE_TOOL_MATERIAL, 1, -2.8f, new FabricItemSettings().group(ModItemGroups.STANDARD));
        DWAYNE_AXE = new ModAxeItem(DWAYNE_TOOL_MATERIAL, 7.f, -3.2f, new FabricItemSettings().group(ModItemGroups.STANDARD));
        DWAYNE_SHOVEL = new ModShovelItem(DWAYNE_TOOL_MATERIAL, 1, -2.8f, new FabricItemSettings().group(ModItemGroups.STANDARD));
        DWAYNE_HOE = new ModHoeItem(DWAYNE_TOOL_MATERIAL, 0, -0.2f, new FabricItemSettings().group(ModItemGroups.STANDARD));

    }
}
