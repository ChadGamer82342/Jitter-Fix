package net.jitterfix.mixins;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.BlockFurnace;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(BlockFurnace.class)
public class BlockFurnaceMixin {

    @Shadow @Final private boolean isActive;

    /**
     * @author You
     * @reason I think it would be easier to just remove all the float casts instead of figuring out a way to only use non overwrite methods
     */
    @Environment(EnvType.CLIENT)
    @Overwrite
    public void randomDisplayTick(World arg, int x, int y, int z, Random random) {
        if (this.isActive) {
            int var6 = arg.getBlockMetadata(x, y, z);
            double xOffset = (float)x + 0.5;
            double yOffset = (float)y + 0.0 + (double) random.nextFloat() * 6.0 / 16.0;
            double zOffset = (float)z + 0.5;
            double var10 = 0.52;
            double var11 = (double) random.nextFloat() * 0.6 - 0.3;
            if (var6 == 4) {
                arg.spawnParticle("smoke", (xOffset - var10), yOffset, (zOffset + var11), 0.0, 0.0, 0.0);
                arg.spawnParticle("flame", (xOffset - var10), yOffset, (zOffset + var11), 0.0, 0.0, 0.0);
            } else if (var6 == 5) {
                arg.spawnParticle("smoke", (xOffset + var10), yOffset, (zOffset + var11), 0.0, 0.0, 0.0);
                arg.spawnParticle("flame", (xOffset + var10), yOffset, (zOffset + var11), 0.0, 0.0, 0.0);
            } else if (var6 == 2) {
                arg.spawnParticle("smoke", (xOffset + var11), yOffset, (zOffset - var10), 0.0, 0.0, 0.0);
                arg.spawnParticle("flame", (xOffset + var11), yOffset, (zOffset - var10), 0.0, 0.0, 0.0);
            } else if (var6 == 3) {
                arg.spawnParticle("smoke", (xOffset + var11), yOffset, (zOffset + var10), 0.0, 0.0, 0.0);
                arg.spawnParticle("flame", (xOffset + var11), yOffset, (zOffset + var10), 0.0, 0.0, 0.0);
            }

        }
    }

}
