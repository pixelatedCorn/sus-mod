package net.pixelatedcorn.susmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.pixelatedcorn.susmod.block.dwaynefurnace.DwayneFurnace;
import net.pixelatedcorn.susmod.block.dwaynefurnace.DwayneFurnaceEntity;
import net.pixelatedcorn.susmod.item.ModItemGroups;
import net.pixelatedcorn.susmod.SusMod;

public class ModBlocks {
    public static final CheggerBlock CHEGGER_BLOCK;
    public static final ModOreBlock THE_ROCK_ORE;
    public static final ModOreBlock RUBBER_ORE;
    public static final ModOreBlock JAMBA_BLOCK;
    public static final DwayneFurnace DWAYNE_FURNACE;
    public static final BlockEntityType<DwayneFurnaceEntity> DWAYNE_FURNACE_ENTITY;

    private static void RegisterBlock(String name, Block block, ItemGroup group) {
        Registry.register(Registry.ITEM, new Identifier(SusMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));
        Registry.register(Registry.BLOCK, new Identifier(SusMod.MOD_ID, name), block);
    }

    private static void RegisterBlockWithEntity(String name, Block block, BlockEntityType entity, ItemGroup group  ) {
        RegisterBlock(name, block, group);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(SusMod.MOD_ID, name), entity);
    }

    public static void RegisterBlocks() {
        SusMod.LOGGER.info("Registering blocks...");
        RegisterBlock("chegger_block", CHEGGER_BLOCK, ModItemGroups.STANDARD);
        RegisterBlock("rock_ore", THE_ROCK_ORE, ModItemGroups.STANDARD);
        RegisterBlockWithEntity("dwayne_furnace", DWAYNE_FURNACE, DWAYNE_FURNACE_ENTITY, ModItemGroups.STANDARD);
        RegisterBlock("jamba_block", JAMBA_BLOCK, ModItemGroups.STANDARD);
        RegisterBlock("rubber_ore", RUBBER_ORE, ModItemGroups.STANDARD);
        SusMod.LOGGER.info("Blocks registered.");
    }

    static {
        CHEGGER_BLOCK = new CheggerBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool());
        THE_ROCK_ORE = new ModOreBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool());
        JAMBA_BLOCK = new ModOreBlock(FabricBlockSettings.of(Material.METAL).strength(3.0f).requiresTool());
        DWAYNE_FURNACE = new DwayneFurnace(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool());
        DWAYNE_FURNACE_ENTITY = FabricBlockEntityTypeBuilder.create(DwayneFurnaceEntity::new, DWAYNE_FURNACE).build(null);
        RUBBER_ORE = new ModOreBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool());
    }
}
