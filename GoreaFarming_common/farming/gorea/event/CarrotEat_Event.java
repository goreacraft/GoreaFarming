package farming.gorea.event;

import static net.minecraftforge.event.Event.Result.DENY;
import farming.gorea.GoreaFarming;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.HarvestCheck;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;




/**
 * @author gorea
 *
 */
public class CarrotEat_Event {
	
	private static final float potionEffectProbability = 1;
	private static final int potionId = GoreaFarming.uglyItemEffect; 
	private static final int potionId2 = GoreaFarming.uglyItemEffect2;
	private static final int potionDuration = GoreaFarming.uglyItemDuration;
	private static final int potionDuration2 = GoreaFarming.uglyItemDuration2;
	private static final int potionAmplifier = GoreaFarming.uglyItemEffectAmplifier;
	private static final int potionAmplifier2 = GoreaFarming.uglyItemEffectAmplifier;
	
	
	//private static String xxx = GoreaFarming.uglyItem;
	//public static String xxx = Block.dirt.getUnlocalizedName();
	//public static int uglyitem1 = xxx;
	
		
	/*@ForgeSubscribe
	public void onHarvestCheck(HarvestCheck event)
	{
		EntityPlayer player = event.entityPlayer;
		
		if(event.block.blockID == Block.carrot.blockID)
 //Block.stone.blockID)
		{
		//System.out.println("--- You Pick up items ---");
	    //player.addChatMessage("Carrots has been cursed");
		player.addPotionEffect(new PotionEffect(this.potionId,this.potionDuration, this.potionAmplifier));
		player.addPotionEffect(new PotionEffect(this.potionId2, this.potionDuration2, this.potionAmplifier2));
	}
		//else {		System.out.println("--- Else You Pick up items ---");	} 
	}*/
	
	//banning items
	/*@ForgeSubscribe
	public void onItem(PlayerInteractEvent event)
	{
		EntityPlayer player = event.entityPlayer;
		
		
		//if(event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK || event.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR || event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)
		//{
			if(event.entityPlayer.getHeldItem().itemID == uglyitem)
			{
				//System.out.println("--- Item banned From placing ---");
				event.setCanceled(true);
				player.addChatMessage("Item " + uglyitem + " has been banned");
		//player.addPotionEffect(new PotionEffect(19, 40, 1));
		//player.addPotionEffect(new PotionEffect(9, 200, 1));
			//}
			//else { System.out.println("--- Else Last ---");	} 
		}
		//else { System.out.println("--- Else LAST 2 ---"); }
	}*/
	//On harvest carrots
	//bonemeal on carots	
	@ForgeSubscribe
	public void onBonemealEvent(BonemealEvent event)
	{
		EntityPlayer player = event.entityPlayer;
		
		if(event.ID == Block.carrot.blockID)
 //Block.stone.blockID)
		{
		//System.out.println("--- You Pick up items ---");
			player.addPotionEffect(new PotionEffect(this.potionId,this.potionDuration, this.potionAmplifier));
			player.addPotionEffect(new PotionEffect(this.potionId2, this.potionDuration2, this.potionAmplifier2));
	}
		//else {		System.out.println("--- Else You Pick up items ---");	}
	}
	

//picking up carrots
	/*@ForgeSubscribe
	public void onItemPickup(EntityItemPickupEvent event)
	{
		EntityPlayer player = event.entityPlayer;
		
		if(event.item.getEntityItem().itemID == Item.carrot.itemID)
		{
		System.out.println("--- You Pick up items ---");
		player.addPotionEffect(new PotionEffect(19, 40, 1));
		//player.addPotionEffect(new PotionEffect(9, 200, 1));
	}else {
		System.out.println("--- Else You Pick up items ---");
	}
	}*/
	
}
	