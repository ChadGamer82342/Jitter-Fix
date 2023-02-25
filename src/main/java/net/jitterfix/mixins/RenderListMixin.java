package net.jitterfix.mixins;

import net.minecraft.src.RenderList;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.IntBuffer;
import java.nio.Buffer;

@Mixin(RenderList.class)
public class RenderListMixin {
    @Shadow private IntBuffer field_1236_g;
    @Shadow private boolean field_1235_h;
    @Shadow private int field_1242_a;
    @Shadow private int field_1241_b;
    @Shadow private int field_1240_c;
    double field_2483N;
    double field_2484N;
    double field_2485N;

    @Inject(at = @At("HEAD"), method = "func_861_a", cancellable = true)
    public void method_1912(int i, int j, int k, double d, double d1, double d2, CallbackInfo ci) {
        this.field_1235_h = true;
        ((Buffer)this.field_1236_g).clear();
        this.field_1242_a = i;
        this.field_1241_b = j;
        this.field_1240_c = k;
        this.field_2483N = d;
        this.field_2484N = d1;
        this.field_2485N = d2;
        ci.cancel();
    }

    @Redirect(at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL11;glTranslatef(FFF)V", remap = false), method = "func_860_a")
    public void translate(float x, float y, float z) {
        GL11.glTranslated(this.field_1242_a - this.field_2483N, this.field_1241_b - this.field_2484N, this.field_1240_c - this.field_2485N);
    }
}
