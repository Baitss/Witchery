package com.emoniph.witchery.client.renderer;

import com.emoniph.witchery.client.model.ModelLordOfTorment;
import com.emoniph.witchery.entity.EntityLordOfTorment;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderLordOfTorment extends RenderLiving {

   private static final ResourceLocation TEXTURE_URL = new ResourceLocation("witchery", "textures/entities/lordoftorment.png");


   public RenderLordOfTorment() {
      super(new ModelLordOfTorment(), 0.5F);
   }

   public void doRenderDemon(EntityLordOfTorment entity, double par2, double par4, double par6, float par8, float par9) {
      BossStatus.setBossStatus(entity, true);
      super.doRender(entity, par2, par4, par6, par8, par9);
   }

   protected void rotateDemonCorpse(EntityLordOfTorment entity, float par2, float par3, float par4) {
      super.rotateCorpse(entity, par2, par3, par4);
   }

   public void doRender(EntityLiving entity, double par2, double par4, double par6, float par8, float par9) {
      this.doRenderDemon((EntityLordOfTorment)entity, par2, par4, par6, par8, par9);
   }

   protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
      this.rotateDemonCorpse((EntityLordOfTorment)par1EntityLivingBase, par2, par3, par4);
   }

   public void doRender(EntityLivingBase par1, double par2, double par4, double par6, float par8, float par9) {
      this.doRenderDemon((EntityLordOfTorment)par1, par2, par4, par6, par8, par9);
   }

   public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9) {
      this.doRenderDemon((EntityLordOfTorment)entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation getEntityTexture(Entity par1Entity) {
      return this.func_110832_a((EntityLordOfTorment)par1Entity);
   }

   protected ResourceLocation func_110832_a(EntityLordOfTorment par1Entity) {
      return TEXTURE_URL;
   }

}
