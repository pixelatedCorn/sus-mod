package net.pixelatedcorn.susmod.mixins;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super((EntityType<? extends LivingEntity>)EntityType.PLAYER, world);
    }

    private static boolean shouldIWriteTheMessageToTheConsole = true;

    @Inject(at = @At("HEAD"), method="updateTurtleHelmet")
    private void updateTurtleHelmet(CallbackInfo info) {
        if (shouldIWriteTheMessageToTheConsole) {
            System.out.println("update turtle helmet");
            shouldIWriteTheMessageToTheConsole = false;
        }
    }
}
