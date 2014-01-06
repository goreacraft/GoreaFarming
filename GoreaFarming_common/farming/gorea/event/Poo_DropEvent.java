package farming.gorea.event;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import farming.gorea.GoreaFarming;

public class Poo_DropEvent {
	
		private static Random rand = new Random();
		
          @ForgeSubscribe
          public void mobDrops(LivingDropsEvent event)
          {
        	  
        	  EntityLivingBase mob = event.entityLiving;
        	  if (mob instanceof EntityChicken)
      			{         		  
        		  mob.dropItem(GoreaFarming.poopItem.itemID, rand.nextInt(2));
        		 // System.out.println(rand.nextInt(2));
        		  
      			}
        	 
        	  if (mob instanceof EntityCow)
      			{         		  
        		  mob.dropItem(GoreaFarming.poopItem.itemID, rand.nextInt(2));
        		 // System.out.println(rand.nextInt(2));
        		  
      			}
        	 
        	  if (mob instanceof EntitySheep)
      			{         		  
        		  mob.dropItem(GoreaFarming.poopItem.itemID, rand.nextInt(2));
        		 // System.out.println(rand.nextInt(2));
        		  
      			}
        	 
        	  if (mob instanceof EntityCreeper)
      			{         		  
        		  mob.dropItem(GoreaFarming.poopItem.itemID, rand.nextInt(2));
        		 // System.out.println(rand.nextInt(2));
        		  
      			}
        	  
        	  if (mob instanceof EntityVillager)
    			{         		  
      		  mob.dropItem(GoreaFarming.poopItem.itemID, rand.nextInt(2));
      		 // System.out.println(rand.nextInt(2));
      		  
    			}
        	  
        	  if (mob instanceof EntityPig)
  			{         		  
    		  mob.dropItem(GoreaFarming.poopItem.itemID, rand.nextInt(2));
    		 // System.out.println(rand.nextInt(2));
    		  
  			}
        	  
        	  if (mob instanceof EntityHorse)
    			{         		  
      		  mob.dropItem(GoreaFarming.poopItem.itemID, rand.nextInt(2));
      		 // System.out.println(rand.nextInt(2));
      		  
    			}
        	  
          }
 
}
