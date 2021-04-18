package net.jitterfix.mixins;

import net.minecraft.client.render.RenderList;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.nio.IntBuffer;

@Mixin(RenderList.class)
public class RenderListMixin implements RenderListI {
    @Shadow private IntBuffer field_2486;
    @Shadow private boolean field_2487;
    @Shadow private int field_2480;
    @Shadow private int field_2481;
    @Shadow private int field_2482;
    @Shadow private boolean field_2488;
    double field_2483N;
    double field_2484N;
    double field_2485N;

    @Override
    public void method_1912(int i, int j, int k, double d, double d1, double d2) {
        this.field_2487 = true;
        this.field_2486.clear();
        this.field_2480 = i;
        this.field_2481 = j;
        this.field_2482 = k;
        this.field_2483N = d;
        this.field_2484N = d1;
        this.field_2485N = d2;
    }

    @Redirect(at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL11;glTranslatef(FFF)V"), method = "method_1909")
    public void translate(float x, float y, float z) {
        GL11.glTranslated(this.field_2480 - this.field_2483N, this.field_2481 - this.field_2484N, this.field_2482 - this.field_2485N);
    }
}
