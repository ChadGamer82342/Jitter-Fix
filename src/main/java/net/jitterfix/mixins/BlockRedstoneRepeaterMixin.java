package net.jitterfix.mixins;

import net.minecraft.src.BlockLadder;
import net.minecraft.src.BlockRedstoneRepeater;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(BlockRedstoneRepeater.class)
public class BlockRedstoneRepeaterMixin {
    @Unique
    int storedX, storedY, storedZ; // used to store the x, y, z values


    @Inject(method = "randomDisplayTick", at = @At(value = "HEAD"))
    public void randomDisplayTick(World world, int x, int y, int z, Random random, CallbackInfo ci) {
        this.storedX = x;
        this.storedY = y;
        this.storedZ = z;
    }

    // TODO maybe theres a way to get the constant for the offsets so that other mods can modify it?
    @ModifyVariable(method = "randomDisplayTick", at = @At(value = "STORE"), ordinal = 0)
    public double modifyX(double value) {
        double randomOffset = value - ((float)storedX + 0.5F);
        return (double) storedX + 0.5d + randomOffset;
    }

    @ModifyVariable(method = "randomDisplayTick", at = @At(value = "STORE"), ordinal = 1)
    public double modifyY(double value) {
        double randomOffset = value - ((float)storedY + 0.5F);
        return (double) storedY + 0.7d + randomOffset;
    }

    @ModifyVariable(method = "randomDisplayTick", at = @At(value = "STORE"), ordinal = 2)
    public double modifyZ(double value) {
        double randomOffset = value - ((float)storedZ + 0.5F);
        return (double) storedZ + 0.5d + randomOffset;
    }
}
