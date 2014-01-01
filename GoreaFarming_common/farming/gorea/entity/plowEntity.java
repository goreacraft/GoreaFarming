package farming.gorea.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class plowEntity extends ModelBase
{
//fields
 ModelRenderer WolfHead;
 ModelRenderer plowhead;
 ModelRenderer Ear2;
 ModelRenderer Shape1; 
 ModelRenderer Shape2;

public plowEntity()
{
 textureWidth = 32;
 textureHeight = 32;
 
   WolfHead = new ModelRenderer(this, 0, 0);
   WolfHead.addBox(-3F, -3F, -2F, 3, 3, 14);
   WolfHead.setRotationPoint(-1F, 13.5F, -7F);
   WolfHead.setTextureSize(64, 32);
   WolfHead.mirror = true;
   setRotation(WolfHead, 0F, 0F, 0F);
   plowhead = new ModelRenderer(this, 0, 18);
   plowhead.addBox(-1F, 0F, -3F, 2, 8, 7);
   plowhead.setRotationPoint(-2.5F, 15F, -1F);
   plowhead.setTextureSize(64, 32);
   plowhead.mirror = true;
   setRotation(plowhead, 0F, -0.5205006F, 0F);
   Ear2 = new ModelRenderer(this, 16, 14);
   Ear2.addBox(0F, -1F, -1F, 1, 7, 2);
   Ear2.setRotationPoint(-3F, 9.5F, -1F);
   Ear2.setTextureSize(64, 32);
   Ear2.mirror = true;
   setRotation(Ear2, 0F, 0F, 0F);
   Shape1 = new ModelRenderer(this, 0, 0);
   Shape1.addBox(0F, 0F, -14F, 1, 1, 14);
   Shape1.setRotationPoint(-2F, 11F, -8F);
   Shape1.setTextureSize(64, 32);
   Shape1.mirror = true;
   setRotation(Shape1, -0.3717861F, -0.2230717F, 0F);
   Shape2 = new ModelRenderer(this, 0, 0);
   Shape2.addBox(0F, 0F, 0F, 1, 1, 14);
   Shape2.setRotationPoint(-3F, 11F, -8F);
   Shape2.setTextureSize(64, 32);
   Shape2.mirror = true;
   setRotation(Shape2, 0.3346075F, -2.9557F, 0F);
}

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, Entity par7Entity)
{
 super.render(entity, f, f1, f2, f3, f4, f5);
 setRotationAngles(f, f1, f2, f3, f4, f5, par7Entity);
 WolfHead.render(f5);
 plowhead.render(f5);
 Ear2.render(f5);
 Shape1.render(f5);
 Shape2.render(f5);
}

private void setRotation(ModelRenderer model, float x, float y, float z)
{
 model.rotateAngleX = x;
 model.rotateAngleY = y;
 model.rotateAngleZ = z;
}

public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par7Entity)
{
 super.setRotationAngles(f, f1, f2, f3, f4, f5, par7Entity);
}

}
