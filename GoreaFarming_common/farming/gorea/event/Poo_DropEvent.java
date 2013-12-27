package farming.gorea.event;

import java.util.Random;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import farming.gorea.GoreaFarming;

public class Poo_DropEvent {

          public static double rand;
          public Random r = new Random();
		  public int timeUntilNextPoop = 6000;

          @ForgeSubscribe
          public void onEntityDrop(LivingDropsEvent event) {
        	  if(event.entityLiving instanceof EntityChicken) {
        		  event.entityLiving.dropItem(GoreaFarming.poopItem.itemID, r.nextInt(2));
        	  }
          }
		  /*@ForgeSubscribe
		  public void EntityChicken(){
			  this.timeUntilNextPoop = this.rand.nextInt(6000) + 6000;
		  }*/
          @ForgeSubscribe
          public void onEntityDrop(LivingUpdateEvent ev)
          { 
        	  if(ev.entityLiving instanceof EntityChicken) {
        		  ev.entityLiving.dropItem(GoreaFarming.poopItem.itemID, 0);
        		  this.timeUntilNextPoop = this.timeUntilNextPoop + 6000;
        		  
        	  }
              /*if (!this.isChild() && !this.worldObj.isRemote && --this.timeUntilNextEgg <= 0)
              {
                  this.playSound("mob.chicken.plop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
                  this.dropItem(Item.egg.itemID, 1);
                  this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
              }*/
          }
                  
}