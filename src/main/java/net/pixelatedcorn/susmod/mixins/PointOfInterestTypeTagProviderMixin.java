package net.pixelatedcorn.susmod.mixins;

import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.data.server.AbstractTagProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractTagProvider.class)
public abstract class PointOfInterestTypeTagProviderMixin implements DataProvider {
    // protected PointOfInterestTypeTagProviderMixin(DataGenerator root) {
    //     super(root, Registry.POINT_OF_INTEREST_TYPE);
    // }

    //@Inject(at=@At("TAIL"), method="configure")
    //private void configure(CallbackInfo ci) {
        //System.out.println("hacking...");
        // ObjectBuilder<PointOfInterestType> tagBuilder = this.getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE);
        //for (PointOfInterestType type : ModVillagers.TYPES_TO_INJECT) {
       //     tagBuilder.add(type);
        //}
        //System.out.println("hacked.");
    //}

    @Inject(at=@At("HEAD"), method="run")
    private void run(DataWriter par1, CallbackInfo ci) {
        System.out.println("in abstract tag writer");
    }
}
