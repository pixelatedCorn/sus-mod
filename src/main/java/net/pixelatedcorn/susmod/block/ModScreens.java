package net.pixelatedcorn.susmod.block;

import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.pixelatedcorn.susmod.SusMod;
import net.pixelatedcorn.susmod.block.dwaynefurnace.DwayneScreenHandler;

public class ModScreens {
    public static final ScreenHandlerType<DwayneScreenHandler> DWAYNE_SCREEN_HANDLER;

    private void RegisterScreenHandler(String name, ScreenHandlerType handler) {
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(SusMod.MOD_ID, name), handler);
    }

    public void RegisterScreens() {
        SusMod.LOGGER.info("Registering GUIs...");
        RegisterScreenHandler("dwayne_furnace.json", DWAYNE_SCREEN_HANDLER);
        SusMod.LOGGER.info("GUIs registered.");
    }

    static {
        DWAYNE_SCREEN_HANDLER = new ScreenHandlerType<>(DwayneScreenHandler::new);
    }
}
