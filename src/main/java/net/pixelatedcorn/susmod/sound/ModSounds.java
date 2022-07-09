package net.pixelatedcorn.susmod.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.pixelatedcorn.susmod.SusMod;

public class ModSounds {

    public static final Identifier THUD_SOUND;
    public static final SoundEvent THUD_EVENT;
    public static final Identifier BING_CHILLING_SOUND;
    public static final SoundEvent BING_CHILLING_EVENT;
    public static final Identifier CHINA_SOUND;
    public static final SoundEvent CHINA_SOUND_EVENT;

    private static void RegisterSound(Identifier sound , SoundEvent event) {
        Registry.register(Registry.SOUND_EVENT, sound, event);
    }
    public static void RegisterSounds() {
        SusMod.LOGGER.info("Registering sounds...");
        RegisterSound(THUD_SOUND, THUD_EVENT);
        RegisterSound(BING_CHILLING_SOUND, BING_CHILLING_EVENT);
        RegisterSound(CHINA_SOUND, CHINA_SOUND_EVENT);
        SusMod.LOGGER.info("Sounds registered.");
    }

    static {
        THUD_SOUND = new Identifier(SusMod.MOD_ID, "thud");
        THUD_EVENT = new SoundEvent(THUD_SOUND);
        BING_CHILLING_SOUND = new Identifier(SusMod.MOD_ID, "bingchilling");
        BING_CHILLING_EVENT = new SoundEvent(BING_CHILLING_SOUND);
        CHINA_SOUND = new Identifier(SusMod.MOD_ID, "china");
        CHINA_SOUND_EVENT = new SoundEvent(CHINA_SOUND);
    }
}
