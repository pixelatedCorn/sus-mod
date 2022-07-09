package net.pixelatedcorn.susmod.block;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.pixelatedcorn.susmod.sound.ModSounds;

public class CheggerBlock extends Block {
    public CheggerBlock(Settings settings) {
        super(settings);
    }


    public ActionResult onUse(World world, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            world.playSound(null, hit.getBlockPos(), ModSounds.THUD_EVENT, SoundCategory.BLOCKS, 1f, 1f);
        }
        return ActionResult.SUCCESS;
    }
}
