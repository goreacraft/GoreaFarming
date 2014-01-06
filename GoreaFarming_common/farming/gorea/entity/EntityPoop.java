package farming.gorea.entity;

import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import farming.gorea.GoreaFarming;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPoop extends EntityThrowable// implements IProjectile
{
    public EntityPoop(World par1World)
    {
        super(par1World);
        
    }
  //  @SideOnly(Side.CLIENT)
    /*public boolean isInRangeToRenderDist(double par1)
    {
        double d1 = this.boundingBox.getAverageEdgeLength() * 4.0D;
        d1 *= 64.0D;
        return par1 < d1 * d1;
    }*/
   
    public EntityPoop(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
   
    public EntityPoop(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    protected float getGravityVelocity()
    {
        return 0.05F;
    }

    protected float func_70182_d()
    {
        return 0.7F;
    }

    protected float func_70183_g()
    {
        return -30.0F;
    }
    
 
    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @SideOnly(Side.CLIENT)
    @Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        	{
            	par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.5F);
            	
        	}

        /*if (!this.worldObj.isRemote){*/
      
            AxisAlignedBB axisalignedbb = this.boundingBox.expand(4.0D, 2.0D, 4.0D);
            List list1 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

            if (list1 != null && !list1.isEmpty())
            {
                Iterator iterator = list1.iterator();

                while (iterator.hasNext())
                {
                    EntityLivingBase entitylivingbase = (EntityLivingBase)iterator.next();
                    double d0 = this.getDistanceSqToEntity(entitylivingbase);

                    if (d0 < 16.0D)
                    {
                        double d1 = 1.0D - Math.sqrt(d0) / 4.0D;

                        if (entitylivingbase == par1MovingObjectPosition.entityHit)
                        {
                            d1 = 1.0D;
                        }

                                    entitylivingbase.addPotionEffect(new PotionEffect(GoreaFarming.pooIhrowEffect, GoreaFarming.pooIhrowEffectDuration, GoreaFarming.pooIhrowEffectAmplifier));
                                    this.playSound("mob.villager.hit", 1.0F, 0.5F + (this.getRand().nextFloat() - this.getRand().nextFloat()));
                    	}
                	}
            	}
        
        	
        
        

        for (int j = 0; j < 4; ++j)
        {
            this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            this.worldObj.spawnParticle("dripLava", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            this.playSound("mob.slime.big", 1.0F, 1.0F + (this.getRand().nextFloat() - this.getRand().nextFloat()) * 0.4F);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}
