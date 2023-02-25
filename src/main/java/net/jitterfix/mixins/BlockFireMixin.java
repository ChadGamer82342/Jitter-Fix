package net.jitterfix.mixins;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFire;
import net.minecraft.src.BlockTorch;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

// This fixes the particles on torches faraway from the origin of the world
@Mixin(BlockFire.class)
public class BlockFireMixin {
    @Unique
    int storedX, storedY, storedZ; // used to store the x, y, z values

    @Inject(method = "randomDisplayTick", at = @At(value = "HEAD"))
    public void randomDisplayTick(World world, int x, int y, int z, Random random, CallbackInfo ci) {
        this.storedX = x;
        this.storedY = y;
        this.storedZ = z;
    }

    /**
     * @author You
     * @reason I think it would be easier to just remove all the float casts instead of figuring out a way to only use non overwrite methods
     */
    @Environment(EnvType.CLIENT)
    @Overwrite
    public void randomDisplayTick(World arg, int i, int j, int k, Random random) {
        if (random.nextInt(24) == 0) {
            arg.playSoundEffect((i + 0.5F), (j + 0.5F), (k + 0.5F), "fire.fire", 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F);
        }

        int var6;
        double var7;
        double var8;
        double var9;
        if (!arg.isBlockNormalCube(i, j - 1, k) && !Block.fire.canBlockCatchFire(arg, i, j - 1, k)) {
            if (Block.fire.canBlockCatchFire(arg, i - 1, j, k)) {
                for(var6 = 0; var6 < 2; ++var6) {
                    var7 = i + (double) random.nextFloat() * 0.1;
                    var8 = j + (double) random.nextFloat();
                    var9 = k + (double) random.nextFloat();
                    arg.spawnParticle("largesmoke", var7, var8, var9, 0.0, 0.0, 0.0);
                }
            }

            if (Block.fire.canBlockCatchFire(arg, i + 1, j, k)) {
                for(var6 = 0; var6 < 2; ++var6) {
                    var7 = (i + 1) - (double) random.nextFloat() * 0.1;
                    var8 = j + (double) random.nextFloat();
                    var9 = k + (double) random.nextFloat();
                    arg.spawnParticle("largesmoke", var7, var8, var9, 0.0, 0.0, 0.0);
                }
            }

            if (Block.fire.canBlockCatchFire(arg, i, j, k - 1)) {
                for(var6 = 0; var6 < 2; ++var6) {
                    var7 = i + (double) random.nextFloat();
                    var8 = j + (double) random.nextFloat();
                    var9 = k + (double) random.nextFloat() * 0.1;
                    arg.spawnParticle("largesmoke", var7, var8, var9, 0.0, 0.0, 0.0);
                }
            }

            if (Block.fire.canBlockCatchFire(arg, i, j, k + 1)) {
                for(var6 = 0; var6 < 2; ++var6) {
                    var7 = i + (double) random.nextFloat();
                    var8 = j + (double) random.nextFloat();
                    var9 = (k + 1) - (double) random.nextFloat() * 0.1;
                    arg.spawnParticle("largesmoke", var7, var8, var9, 0.0, 0.0, 0.0);
                }
            }

            if (Block.fire.canBlockCatchFire(arg, i, j + 1, k)) {
                for(var6 = 0; var6 < 2; ++var6) {
                    var7 = i + (double) random.nextFloat();
                    var8 = (j + 1) - (double) random.nextFloat() * 0.1;
                    var9 = k + (double) random.nextFloat();
                    arg.spawnParticle("largesmoke", var7, var8, var9, 0.0, 0.0, 0.0);
                }
            }
        } else {
            for(var6 = 0; var6 < 3; ++var6) {
                var7 = i + (double) random.nextFloat();
                var8 = j + (double) random.nextFloat() * 0.5 + 0.5;
                var9 = k + (double) random.nextFloat();
                arg.spawnParticle("largesmoke", var7, var8, var9, 0.0, 0.0, 0.0);
            }
        }

    }
}
