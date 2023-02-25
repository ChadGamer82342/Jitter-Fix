package net.jitterfix.mixins;

import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(RenderBlocks.class)
public abstract class RenderBlocksMixin {

    @Shadow protected abstract void func_31076_a(double d, double d1, double d2, double d3, double d4, double d5, float f, double d6);

    @Shadow public abstract boolean renderStandardBlock(Block arg, int i, int j, int k);

    @Shadow private int field_31087_g;

    @Shadow private int field_31086_h;

    @Shadow private int field_31085_i;

    @Shadow private int field_31084_j;

    @Shadow protected abstract void func_31081_b(double d, double d1, double d2, double d3, double d4, double d5, float f, double d6);

    @Shadow protected abstract void func_31077_c(double d, double d1, double d2, double d3, double d4, double d5, float f, double d6);

    @Shadow private int field_31083_k;

    @Shadow private int field_31082_l;

    @Shadow private IBlockAccess blockAccess;

    @Shadow private int overrideBlockTexture;

    /**
     * @author You
     * @reason The only reason why I'm overriding this is that I would have to create changes to edit every single float
     * cast (There's a lot), so it doesn't cast to a float and doesn't lose precision
     */
    @Overwrite
    private boolean func_31080_c(Block arg, int i, int j, int k, boolean flag) {
        int var6 = this.blockAccess.getBlockMetadata(i, j, k);
        int var7 = BlockPistonExtension.func_31050_c(var6);
        float var11 = arg.getBlockBrightness(this.blockAccess, i, j, k);
        float var12 = flag ? 1.0F : 0.5F;
        double var13 = flag ? 16.0 : 8.0;
        switch (var7) {
            case 0:
                this.field_31087_g = 3;
                this.field_31086_h = 3;
                this.field_31085_i = 3;
                this.field_31084_j = 3;
                arg.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
                this.renderStandardBlock(arg, i, j, k);
                this.func_31076_a((i + 0.375), (i + 0.625), (j + 0.25), (j + 0.25 + var12), (k + 0.625), (k + 0.625), var11 * 0.8F, var13);
                this.func_31076_a((i + 0.625), (i + 0.375), (j + 0.25), (j + 0.25 + var12), (k + 0.375), (k + 0.375), var11 * 0.8F, var13);
                this.func_31076_a((i + 0.375), (i + 0.375), (j + 0.25), (j + 0.25 + var12), (k + 0.375), (k + 0.625), var11 * 0.6F, var13);
                this.func_31076_a((i + 0.625), (i + 0.625), (j + 0.25), (j + 0.25 + var12), (k + 0.625), (k + 0.375), var11 * 0.6F, var13);
                break;
            case 1:
                arg.setBlockBounds(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
                this.renderStandardBlock(arg, i, j, k);
                this.func_31076_a((i + 0.375), (i + 0.625), (j - 0.25 + 1.0F - var12), (j - 0.25 + 1.0F), (k + 0.625), (k + 0.625), var11 * 0.8F, var13);
                this.func_31076_a((i + 0.625), (i + 0.375), (j - 0.25 + 1.0F - var12), (j - 0.25 + 1.0F), (k + 0.375), (k + 0.375), var11 * 0.8F, var13);
                this.func_31076_a((i + 0.375), (i + 0.375), (j - 0.25 + 1.0F - var12), (j - 0.25 + 1.0F), (k + 0.375), (k + 0.625), var11 * 0.6F, var13);
                this.func_31076_a((i + 0.625), (i + 0.625), (j - 0.25 + 1.0F - var12), (j - 0.25 + 1.0F), (k + 0.625), (k + 0.375), var11 * 0.6F, var13);
                break;
            case 2:
                this.field_31085_i = 1;
                this.field_31084_j = 2;
                arg.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
                this.renderStandardBlock(arg, i, j, k);
                this.func_31081_b((i + 0.375), (i + 0.375), (j + 0.625), (j + 0.375), (k + 0.25), (k + 0.25 + var12), var11 * 0.6F, var13);
                this.func_31081_b((i + 0.625), (i + 0.625), (j + 0.375), (j + 0.625), (k + 0.25), (k + 0.25 + var12), var11 * 0.6F, var13);
                this.func_31081_b((i + 0.375), (i + 0.625), (j + 0.375), (j + 0.375), (k + 0.25), (k + 0.25 + var12), var11 * 0.5F, var13);
                this.func_31081_b((i + 0.625), (i + 0.375), (j + 0.625), (j + 0.625), (k + 0.25), (k + 0.25 + var12), var11, var13);
                break;
            case 3:
                this.field_31085_i = 2;
                this.field_31084_j = 1;
                this.field_31083_k = 3;
                this.field_31082_l = 3;
                arg.setBlockBounds(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
                this.renderStandardBlock(arg, i, j, k);
                this.func_31081_b((i + 0.375), (i + 0.375), (j + 0.625), (j + 0.375), (k - 0.25 + 1.0F - var12), (k - 0.25 + 1.0F), var11 * 0.6F, var13);
                this.func_31081_b((i + 0.625), (i + 0.625), (j + 0.375), (j + 0.625), (k - 0.25 + 1.0F - var12), (k - 0.25 + 1.0F), var11 * 0.6F, var13);
                this.func_31081_b((i + 0.375), (i + 0.625), (j + 0.375), (j + 0.375), (k - 0.25 + 1.0F - var12), (k - 0.25 + 1.0F), var11 * 0.5F, var13);
                this.func_31081_b((i + 0.625), (i + 0.375), (j + 0.625), (j + 0.625), (k - 0.25 + 1.0F - var12), (k - 0.25 + 1.0F), var11, var13);
                break;
            case 4:
                this.field_31087_g = 1;
                this.field_31086_h = 2;
                this.field_31083_k = 2;
                this.field_31082_l = 1;
                arg.setBlockBounds(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
                this.renderStandardBlock(arg, i, j, k);
                this.func_31077_c((i + 0.25), (i + 0.25 + var12), (j + 0.375), (j + 0.375), (k + 0.625), (k + 0.375), var11 * 0.5F, var13);
                this.func_31077_c((i + 0.25), (i + 0.25 + var12), (j + 0.625), (j + 0.625), (k + 0.375), (k + 0.625), var11, var13);
                this.func_31077_c((i + 0.25), (i + 0.25 + var12), (j + 0.375), (j + 0.625), (k + 0.375), (k + 0.375), var11 * 0.6F, var13);
                this.func_31077_c((i + 0.25), (i + 0.25 + var12), (j + 0.625), (j + 0.375), (k + 0.625), (k + 0.625), var11 * 0.6F, var13);
                break;
            case 5:
                this.field_31087_g = 2;
                this.field_31086_h = 1;
                this.field_31083_k = 1;
                this.field_31082_l = 2;
                arg.setBlockBounds(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                this.renderStandardBlock(arg, i, j, k);
                this.func_31077_c((i - 0.25 + 1.0F - var12), (i - 0.25 + 1.0F), (j + 0.375), (j + 0.375), (k + 0.625), (k + 0.375), var11 * 0.5F, var13);
                this.func_31077_c((i - 0.25 + 1.0F - var12), (i - 0.25 + 1.0F), (j + 0.625), (j + 0.625), (k + 0.375), (k + 0.625), var11, var13);
                this.func_31077_c((i - 0.25 + 1.0F - var12), (i - 0.25 + 1.0F), (j + 0.375), (j + 0.625), (k + 0.375), (k + 0.375), var11 * 0.6F, var13);
                this.func_31077_c((i - 0.25 + 1.0F - var12), (i - 0.25 + 1.0F), (j + 0.625), (j + 0.375), (k + 0.625), (k + 0.625), var11 * 0.6F, var13);
        }

        this.field_31087_g = 0;
        this.field_31086_h = 0;
        this.field_31085_i = 0;
        this.field_31084_j = 0;
        this.field_31083_k = 0;
        this.field_31082_l = 0;
        arg.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return true;
    }

    /**
     * @author You
     * @reason The only reason why I'm overriding this is that I would have to create changes to edit every single float
     * cast (There's a lot), so it doesn't cast to a float and doesn't lose precision
     */
    @Overwrite
    public boolean renderBlockFire(Block arg, int x, int y, int z) {
        final double topOffset = 0.2;
        final double bottomOffset = 0.0625;
        double sideOffset = 1.4F;

        Tessellator tessellator = Tessellator.instance;
        int var6 = arg.getBlockTextureFromSide(0);
        if (this.overrideBlockTexture >= 0) {
            var6 = this.overrideBlockTexture;
        }

        float var7 = arg.getBlockBrightness(this.blockAccess, x, y, z);
        tessellator.setColorOpaque_F(var7, var7, var7);
        int var8 = (var6 & 15) << 4;
        int var9 = var6 & 240;
        double var10 = var8 / 256.0F;
        double var12 = (var8 + 15.99F) / 256.0F;
        double var14 = var9 / 256.0F;
        double var16 = (var9 + 15.99F) / 256.0F;
        double var21;
        double var23;
        double var25;
        double var27;
        double var29;
        double var31;
        double var33;
        if (!this.blockAccess.isBlockNormalCube(x, y - 1, z) && !Block.fire.canBlockCatchFire(this.blockAccess, x, y - 1, z)) {
            if ((x + y + z & 1) == 1) {
                var10 = var8 / 256.0F;
                var12 = (var8 + 15.99F) / 256.0F;
                var14 = (var9 + 16) / 256.0F;
                var16 = (var9 + 15.99F + 16.0F) / 256.0F;
            }

            if ((x / 2 + y / 2 + z / 2 & 1) == 1) {
                var21 = var12;
                var12 = var10;
                var10 = var21;
            }

            if (Block.fire.canBlockCatchFire(this.blockAccess, x - 1, y, z)) {
                tessellator.addVertexWithUV((x + topOffset), (y + sideOffset + bottomOffset), (z + 1), var12, var14);
                tessellator.addVertexWithUV((x + 0), ((y + 0) + bottomOffset), (z + 1), var12, var16);
                tessellator.addVertexWithUV((x + 0), ((y + 0) + bottomOffset), (z + 0), var10, var16);
                tessellator.addVertexWithUV((x + topOffset), (y + sideOffset + bottomOffset), (z + 0), var10, var14);
                tessellator.addVertexWithUV((x + topOffset), (y + sideOffset + bottomOffset), (z + 0), var10, var14);
                tessellator.addVertexWithUV((x + 0), ((y + 0) + bottomOffset), (z + 0), var10, var16);
                tessellator.addVertexWithUV((x + 0), ((y + 0) + bottomOffset), (z + 1), var12, var16);
                tessellator.addVertexWithUV((x + topOffset), (y + sideOffset + bottomOffset), (z + 1), var12, var14);
            }

            if (Block.fire.canBlockCatchFire(this.blockAccess, x + 1, y, z)) {
                tessellator.addVertexWithUV(((x + 1) - topOffset), (y + sideOffset + bottomOffset), (z + 0), var10, var14);
                tessellator.addVertexWithUV((x + 1 - 0), ((y + 0) + bottomOffset), (z + 0), var10, var16);
                tessellator.addVertexWithUV((x + 1 - 0), ((y + 0) + bottomOffset), (z + 1), var12, var16);
                tessellator.addVertexWithUV(((x + 1) - topOffset), (y + sideOffset + bottomOffset), (z + 1), var12, var14);
                tessellator.addVertexWithUV(((x + 1) - topOffset), (y + sideOffset + bottomOffset), (z + 1), var12, var14);
                tessellator.addVertexWithUV((x + 1 - 0), ((y + 0) + bottomOffset), (z + 1), var12, var16);
                tessellator.addVertexWithUV((x + 1 - 0), ((y + 0) + bottomOffset), (z + 0), var10, var16);
                tessellator.addVertexWithUV(((x + 1) - topOffset), (y + sideOffset + bottomOffset), (z + 0), var10, var14);
            }

            if (Block.fire.canBlockCatchFire(this.blockAccess, x, y, z - 1)) {
                tessellator.addVertexWithUV((x + 0), (y + sideOffset + bottomOffset), (z + topOffset), var12, var14);
                tessellator.addVertexWithUV((x + 0), ((y + 0) + bottomOffset), (z + 0), var12, var16);
                tessellator.addVertexWithUV((x + 1), ((y + 0) + bottomOffset), (z + 0), var10, var16);
                tessellator.addVertexWithUV((x + 1), (y + sideOffset + bottomOffset), (z + topOffset), var10, var14);
                tessellator.addVertexWithUV((x + 1), (y + sideOffset + bottomOffset), (z + topOffset), var10, var14);
                tessellator.addVertexWithUV((x + 1), ((y + 0) + bottomOffset), (z + 0), var10, var16);
                tessellator.addVertexWithUV((x + 0), ((y + 0) + bottomOffset), (z + 0), var12, var16);
                tessellator.addVertexWithUV((x + 0), (y + sideOffset + bottomOffset), (z + topOffset), var12, var14);
            }

            if (Block.fire.canBlockCatchFire(this.blockAccess, x, y, z + 1)) {
                tessellator.addVertexWithUV((x + 1), (y + sideOffset + bottomOffset), ((z + 1) - topOffset), var10, var14);
                tessellator.addVertexWithUV((x + 1), ((y + 0) + bottomOffset), (z + 1 - 0), var10, var16);
                tessellator.addVertexWithUV((x + 0), ((y + 0) + bottomOffset), (z + 1 - 0), var12, var16);
                tessellator.addVertexWithUV((x + 0), (y + sideOffset + bottomOffset), ((z + 1) - topOffset), var12, var14);
                tessellator.addVertexWithUV((x + 0), (y + sideOffset + bottomOffset), ((z + 1) - topOffset), var12, var14);
                tessellator.addVertexWithUV((x + 0), ((y + 0) + bottomOffset), (z + 1 - 0), var12, var16);
                tessellator.addVertexWithUV((x + 1), ((y + 0) + bottomOffset), (z + 1 - 0), var10, var16);
                tessellator.addVertexWithUV((x + 1), (y + sideOffset + bottomOffset), ((z + 1) - topOffset), var10, var14);
            }

            if (Block.fire.canBlockCatchFire(this.blockAccess, x, y + 1, z)) {
                var21 = x + 0.5 + 0.5;
                var23 = x + 0.5 - 0.5;
                var25 = z + 0.5 + 0.5;
                var27 = z + 0.5 - 0.5;
                var29 = x + 0.5 - 0.5;
                var31 = x + 0.5 + 0.5;
                var33 = z + 0.5 - 0.5;
                double var35 = z + 0.5 + 0.5;
                var10 = (var8 / 256.0F);
                var12 = ((var8 + 15.99F) / 256.0F);
                var14 = (var9 / 256.0F);
                var16 = ((var9 + 15.99F) / 256.0F);
                ++y;
                sideOffset = -0.2F;
                if ((x + y + z & 1) == 0) {
                    tessellator.addVertexWithUV(var29, (y + sideOffset), (z + 0), var12, var14);
                    tessellator.addVertexWithUV(var21, (y + 0), (z + 0), var12, var16);
                    tessellator.addVertexWithUV(var21, (y + 0), (z + 1), var10, var16);
                    tessellator.addVertexWithUV(var29, (y + sideOffset), (z + 1), var10, var14);
                    var10 = (var8 / 256.0F);
                    var12 = ((var8 + 15.99F) / 256.0F);
                    var14 = ((var9 + 16) / 256.0F);
                    var16 = ((var9 + 15.99F + 16.0F) / 256.0F);
                    tessellator.addVertexWithUV(var31, (y + sideOffset), (z + 1), var12, var14);
                    tessellator.addVertexWithUV(var23, (y + 0), (z + 1), var12, var16);
                    tessellator.addVertexWithUV(var23, (y + 0), (z + 0), var10, var16);
                    tessellator.addVertexWithUV(var31, (y + sideOffset), (z + 0), var10, var14);
                } else {
                    tessellator.addVertexWithUV((x + 0), (y + sideOffset), var35, var12, var14);
                    tessellator.addVertexWithUV((x + 0), (y + 0), var27, var12, var16);
                    tessellator.addVertexWithUV((x + 1), (y + 0), var27, var10, var16);
                    tessellator.addVertexWithUV((x + 1), (y + sideOffset), var35, var10, var14);
                    var10 = (var8 / 256.0F);
                    var12 = ((var8 + 15.99F) / 256.0F);
                    var14 = ((var9 + 16) / 256.0F);
                    var16 = ((var9 + 15.99F + 16.0F) / 256.0F);
                    tessellator.addVertexWithUV((x + 1), (y + sideOffset), var33, var12, var14);
                    tessellator.addVertexWithUV((x + 1), (y + 0), var25, var12, var16);
                    tessellator.addVertexWithUV((x + 0), (y + 0), var25, var10, var16);
                    tessellator.addVertexWithUV((x + 0), (y + sideOffset), var33, var10, var14);
                }
            }
        } else {
            double var19 = x + 0.5 + 0.2;
            var21 = x + 0.5 - 0.2;
            var23 = z + 0.5 + 0.2;
            var25 = z + 0.5 - 0.2;
            var27 = x + 0.5 - 0.3;
            var29 = x + 0.5 + 0.3;
            var31 = z + 0.5 - 0.3;
            var33 = z + 0.5 + 0.3;
            tessellator.addVertexWithUV(var27, (y + sideOffset), (z + 1), var12, var14);
            tessellator.addVertexWithUV(var19, (y + 0), (z + 1), var12, var16);
            tessellator.addVertexWithUV(var19, (y + 0), (z + 0), var10, var16);
            tessellator.addVertexWithUV(var27, (y + sideOffset), (z + 0), var10, var14);
            tessellator.addVertexWithUV(var29, (y + sideOffset), (z + 0), var12, var14);
            tessellator.addVertexWithUV(var21, (y + 0), (z + 0), var12, var16);
            tessellator.addVertexWithUV(var21, (y + 0), (z + 1), var10, var16);
            tessellator.addVertexWithUV(var29, (y + sideOffset), (z + 1), var10, var14);
            var10 = (var8 / 256.0F);
            var12 = ((var8 + 15.99F) / 256.0F);
            var14 = ((var9 + 16) / 256.0F);
            var16 = ((var9 + 15.99F + 16.0F) / 256.0F);
            tessellator.addVertexWithUV((x + 1), (y + sideOffset), var33, var12, var14);
            tessellator.addVertexWithUV((x + 1), (y + 0), var25, var12, var16);
            tessellator.addVertexWithUV((x + 0), (y + 0), var25, var10, var16);
            tessellator.addVertexWithUV((x + 0), (y + sideOffset), var33, var10, var14);
            tessellator.addVertexWithUV((x + 0), (y + sideOffset), var31, var12, var14);
            tessellator.addVertexWithUV((x + 0), (y + 0), var23, var12, var16);
            tessellator.addVertexWithUV((x + 1), (y + 0), var23, var10, var16);
            tessellator.addVertexWithUV((x + 1), (y + sideOffset), var31, var10, var14);
            var19 = x + 0.5 - 0.5;
            var21 = x + 0.5 + 0.5;
            var23 = z + 0.5 - 0.5;
            var25 = z + 0.5 + 0.5;
            var27 = x + 0.5 - 0.4;
            var29 = x + 0.5 + 0.4;
            var31 = z + 0.5 - 0.4;
            var33 = z + 0.5 + 0.4;
            tessellator.addVertexWithUV(var27, (y + sideOffset), (z + 0), var10, var14);
            tessellator.addVertexWithUV(var19, (y + 0), (z + 0), var10, var16);
            tessellator.addVertexWithUV(var19, (y + 0), (z + 1), var12, var16);
            tessellator.addVertexWithUV(var27, (y + sideOffset), (z + 1), var12, var14);
            tessellator.addVertexWithUV(var29, (y + sideOffset), (z + 1), var10, var14);
            tessellator.addVertexWithUV(var21, (y + 0), (z + 1), var10, var16);
            tessellator.addVertexWithUV(var21, (y + 0), (z + 0), var12, var16);
            tessellator.addVertexWithUV(var29, (y + sideOffset), (z + 0), var12, var14);
            var10 = (var8 / 256.0F);
            var12 = ((var8 + 15.99F) / 256.0F);
            var14 = (var9 / 256.0F);
            var16 = ((var9 + 15.99F) / 256.0F);
            tessellator.addVertexWithUV((x + 0), (y + sideOffset), var33, var10, var14);
            tessellator.addVertexWithUV((x + 0), (y + 0), var25, var10, var16);
            tessellator.addVertexWithUV((x + 1), (y + 0), var25, var12, var16);
            tessellator.addVertexWithUV((x + 1), (y + sideOffset), var33, var12, var14);
            tessellator.addVertexWithUV((x + 1), (y + sideOffset), var31, var10, var14);
            tessellator.addVertexWithUV((x + 1), (y + 0), var23, var10, var16);
            tessellator.addVertexWithUV((x + 0), (y + 0), var23, var12, var16);
            tessellator.addVertexWithUV((x + 0), (y + sideOffset), var31, var12, var14);
        }

        return true;
    }

    /**
     * @author You
     * @reason The only reason why I'm overriding this is that I would have to create changes to edit every single float
     * cast (There's a lot), so it doesn't cast to a float and doesn't lose precision
     */
    @Overwrite
    public boolean renderBlockLadder(Block arg, int i, int j, int k) {
        Tessellator var5 = Tessellator.instance;
        int var6 = arg.getBlockTextureFromSide(0);
        if (this.overrideBlockTexture >= 0) {
            var6 = this.overrideBlockTexture;
        }

        float var7 = arg.getBlockBrightness(this.blockAccess, i, j, k);
        var5.setColorOpaque_F(var7, var7, var7);
        int var8 = (var6 & 15) << 4;
        int var9 = var6 & 240;
        double var10 = (var8 / 256.0F);
        double var12 = ((var8 + 15.99F) / 256.0F);
        double var14 = (var9 / 256.0F);
        double var16 = ((var9 + 15.99F) / 256.0F);
        int var18 = this.blockAccess.getBlockMetadata(i, j, k);
        double var19 = 0.0;
        double var20 = 0.05;
        if (var18 == 5) {
            var5.addVertexWithUV((i + var20), (j + 1) + var19, (k + 1) + var19, var10, var14);
            var5.addVertexWithUV((i + var20), (j + 0) - var19, (k + 1) + var19, var10, var16);
            var5.addVertexWithUV((i + var20), (j + 0) - var19, (k + 0) - var19, var12, var16);
            var5.addVertexWithUV((i + var20), (j + 1) + var19, (k + 0) - var19, var12, var14);
        }

        if (var18 == 4) {
            var5.addVertexWithUV(((i + 1) - var20), (j + 0) - var19, (k + 1) + var19, var12, var16);
            var5.addVertexWithUV(((i + 1) - var20), (j + 1) + var19, (k + 1) + var19, var12, var14);
            var5.addVertexWithUV(((i + 1) - var20), (j + 1) + var19, (k + 0) - var19, var10, var14);
            var5.addVertexWithUV(((i + 1) - var20), (j + 0) - var19, (k + 0) - var19, var10, var16);
        }

        if (var18 == 3) {
            var5.addVertexWithUV(((i + 1) + var19), (j + 0) - var19, k + var20, var12, var16);
            var5.addVertexWithUV(((i + 1) + var19), (j + 1) + var19, k + var20, var12, var14);
            var5.addVertexWithUV(((i + 0) - var19), (j + 1) + var19, k + var20, var10, var14);
            var5.addVertexWithUV(((i + 0) - var19), (j + 0) - var19, k + var20, var10, var16);
        }

        if (var18 == 2) {
            var5.addVertexWithUV(((i + 1) + var19), (j + 1) + var19, (k + 1) - var20, var10, var14);
            var5.addVertexWithUV(((i + 1) + var19), (j + 0) - var19, (k + 1) - var20, var10, var16);
            var5.addVertexWithUV(((i + 0) - var19), (j + 0) - var19, (k + 1) - var20, var12, var16);
            var5.addVertexWithUV(((i + 0) - var19), (j + 1) + var19, (k + 1) - var20, var12, var14);
        }

        return true;
    }

}
