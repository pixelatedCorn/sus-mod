package net.pixelatedcorn.susmod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;
import net.pixelatedcorn.susmod.SusMod;
import net.pixelatedcorn.susmod.block.ModBlocks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class ModVillagers {

    public static PointOfInterestType JAMBA_JUICER_POI;
    public static final VillagerProfession JAMBA_JUICER;
    private static void RegisterProfession(String name, VillagerProfession profession) {
        Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(SusMod.MOD_ID, name), profession);
    }

    public static void RegisterProfessions() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SusMod.LOGGER.info("Registering professions...");
        Method RegisterPOI = PointOfInterestTypes.class.getDeclaredMethod("register", Registry.class, RegistryKey.class, Set.class, int.class, int.class);
        RegisterPOI.setAccessible(true);
        JAMBA_JUICER_POI = (PointOfInterestType)RegisterPOI.invoke(PointOfInterestTypes.class, Registry.POINT_OF_INTEREST_TYPE, RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(SusMod.MOD_ID, "jamba_juicer_poi")), ImmutableSet.copyOf(ModBlocks.JAMBA_BLOCK.getStateManager().getStates()), 1, 1);
        RegisterProfession("jamba_juicer", JAMBA_JUICER);
        RegisterPOI.setAccessible(false);
        SusMod.LOGGER.info("Professions registered.");
    }

    static {
        JAMBA_JUICER = VillagerProfessionBuilder.create()
                .id(new Identifier(SusMod.MOD_ID, "jamba_juicer_poi"))
                .workstation(RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(SusMod.MOD_ID, "jamba_juicer_poi")))
                .jobSite((entry) -> entry.matchesKey(RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(SusMod.MOD_ID, "jamba_juicer_poi"))))
                .workSound(SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER)
                .build();

    }
}
