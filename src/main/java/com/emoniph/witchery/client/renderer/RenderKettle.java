package com.emoniph.witchery.client.renderer;

import com.emoniph.witchery.blocks.BlockKettle;
import com.emoniph.witchery.client.model.ModelKettle;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderKettle extends TileEntitySpecialRenderer {

   final ModelKettle model = new ModelKettle();
   private static final ResourceLocation TEXTURE_URL = new ResourceLocation("witchery", "textures/blocks/kettle.png");


   public void renderTileEntityAt(TileEntity tileEntity, double d, double d1, double d2, float f) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)d, (float)d1, (float)d2);
      BlockKettle.TileEntityKettle tileEntityKettle = (BlockKettle.TileEntityKettle)tileEntity;
      this.renderKettle(tileEntityKettle, tileEntity.getWorldObj(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
      GL11.glPopMatrix();
   }

   public void renderKettle(BlockKettle.TileEntityKettle tileEntityKettle, World world, int x, int y, int z) {
      GL11.glPushMatrix();
      GL11.glTranslatef(0.5F, 0.5F, 0.5F);
      this.bindTexture(TEXTURE_URL);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(0.0F, -1.0F, 0.0F);
      if(world != null) {
         int meta = world.getBlockMetadata(x, y, z);
         float rotation = 0.0F;
         switch(meta) {
         case 2:
            rotation = 0.0F;
            break;
         case 3:
            rotation = 180.0F;
            break;
         case 4:
            rotation = 270.0F;
            break;
         case 5:
            rotation = 90.0F;
         }

         GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
      }

      this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, tileEntityKettle);
      GL11.glPopMatrix();
   }

}
