package net.pixelatedcorn.susmod.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.pixelatedcorn.susmod.SusMod;
import net.pixelatedcorn.susmod.block.ModBlocks;

import java.util.Arrays;

public class ModFeatures {
    public static final ConfiguredFeature<?, ?> OVERWORLD_ROCK_ORE_CONFIGURED_FEATURE;
    public static final PlacedFeature OVERWORLD_ROCK_ORE_PLACED_FEATURE;
    public static final ConfiguredFeature<?, ?> NETHER_JAMBA_JUICE_CONFIGURED_FEATURE;
    public static final PlacedFeature NETHER_JAMBA_JUICE_PLACED_FEATURE;
    public static final ConfiguredFeature<?, ?> OVERWORLD_RUBBER_ORE_CONFIGURED_FEATURE;
    public static final PlacedFeature OVERWORLD_RUBBER_ORE_PLACED_FEATURE;

    private static void RegisterFeature(String name, ConfiguredFeature<?, ?> configuredFeature, PlacedFeature placedFeature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(SusMod.MOD_ID, name), configuredFeature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(SusMod.MOD_ID, name), placedFeature);
    }

    private static void RegisterOverworldOre(String name, ConfiguredFeature<?, ?> configuredFeature, PlacedFeature placedFeature) {
        RegisterFeature(name, configuredFeature, placedFeature);
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                        Registry.PLACED_FEATURE_KEY,
                        new Identifier(SusMod.MOD_ID, name
                        )));
    }

    private static void RegisterNetherOre(String name, ConfiguredFeature<?, ?> configuredFeature, PlacedFeature placedFeature) {
        RegisterFeature(name, configuredFeature, placedFeature);
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                        Registry.PLACED_FEATURE_KEY,
                        new Identifier(SusMod.MOD_ID, name
                        )));
    }

    public static void RegisterFeatures() {
        SusMod.LOGGER.info("Registering features...");
        RegisterOverworldOre("overworld_rock_ore", OVERWORLD_ROCK_ORE_CONFIGURED_FEATURE, OVERWORLD_ROCK_ORE_PLACED_FEATURE);
        RegisterNetherOre("nether_jamba_ore", NETHER_JAMBA_JUICE_CONFIGURED_FEATURE, NETHER_JAMBA_JUICE_PLACED_FEATURE);
        RegisterOverworldOre("overworld_rubber_ore", OVERWORLD_RUBBER_ORE_CONFIGURED_FEATURE, OVERWORLD_RUBBER_ORE_PLACED_FEATURE);
        SusMod.LOGGER.info("Features registered.");
    }

    static {
        OVERWORLD_ROCK_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
                Feature.ORE,
                new OreFeatureConfig(
                        OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                        ModBlocks.THE_ROCK_ORE.getDefaultState(),
                        12
                ));
        OVERWORLD_ROCK_ORE_PLACED_FEATURE = new PlacedFeature(
                RegistryEntry.of(OVERWORLD_ROCK_ORE_CONFIGURED_FEATURE),
                Arrays.asList(
                        CountPlacementModifier.of(3),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(-52))
                ));

        NETHER_JAMBA_JUICE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
                Feature.ORE,
                new OreFeatureConfig(
                        OreConfiguredFeatures.NETHERRACK,
                        ModBlocks.JAMBA_BLOCK.getDefaultState(),
                        5
                ));
        NETHER_JAMBA_JUICE_PLACED_FEATURE = new PlacedFeature(
                RegistryEntry.of(NETHER_JAMBA_JUICE_CONFIGURED_FEATURE),
                Arrays.asList(
                        CountPlacementModifier.of(60),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())
                ));

        OVERWORLD_RUBBER_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
                Feature.ORE,
                new OreFeatureConfig(
                        OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                        ModBlocks.RUBBER_ORE.getDefaultState(),
                        8
                ));
        OVERWORLD_RUBBER_ORE_PLACED_FEATURE = new PlacedFeature(
                RegistryEntry.of(OVERWORLD_RUBBER_ORE_CONFIGURED_FEATURE),
                Arrays.asList(
                        CountPlacementModifier.of(60),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(72))
                ));
    }
}
