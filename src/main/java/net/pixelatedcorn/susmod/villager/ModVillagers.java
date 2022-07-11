package net.pixelatedcorn.susmod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.pixelatedcorn.susmod.SusMod;
import net.pixelatedcorn.susmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {

    public static final PointOfInterestType JAMBA_JUICER_POI;
    public static final VillagerProfession JAMBA_JUICER;
    public static final ImmutableSet<PointOfInterestType> TYPES_TO_INJECT;

    private static VillagerProfession getProfession(String id, RegistryKey<PointOfInterestType> heldWorkstation, @Nullable SoundEvent workSound) {
        return new VillagerProfession(id, (entry) -> entry.matchesKey(heldWorkstation), (entry) -> entry.matchesKey(heldWorkstation), ImmutableSet.of(), ImmutableSet.of(), workSound);
    }

    private static void RegisterProfession(String name, VillagerProfession profession) {
        Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(SusMod.MOD_ID, name), profession);
    }

    public static void RegisterProfessions() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SusMod.LOGGER.info("Registering professions...");
        RegisterProfession("jamba_juicer", JAMBA_JUICER);
        SusMod.LOGGER.info("Professions registered.");
    }

    static {
        JAMBA_JUICER_POI = PointOfInterestHelper.register(new Identifier(SusMod.MOD_ID, "jamba_juicer_poi"), 1, 1, ModBlocks.CHEGGER_BLOCK);
        JAMBA_JUICER = getProfession(SusMod.MOD_ID+":jamba_juicer", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(SusMod.MOD_ID, "jamba_juicer_poi")), SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER);
        TYPES_TO_INJECT = new ImmutableSet.Builder<PointOfInterestType>().add(JAMBA_JUICER_POI).build();
    }
}
