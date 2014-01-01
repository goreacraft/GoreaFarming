package farming.gorea.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import farming.gorea.GoreaFarming;

/**
 * @author gorea
 *
 */
public class GoreaItemTomato extends ItemFood
{
	
		
		private static final float potionEffectProbability = 1;
		private static final int potionId = GoreaFarming.tomatoItemEffect; 
		private static final int potionDuration = GoreaFarming.tomatoItemDuration;
		private static final int potionAmplifier = GoreaFarming.tomatoItemEffectAmplifier;



		public GoreaItemTomato(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		setMaxStackSize(64);
		this.setAlwaysEdible();
		setCreativeTab(GoreaFarming.tabGorea);
	}
		@Override
		protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        if (!par2World.isRemote && this.potionId > 0 && par2World.rand.nextFloat() < this.potionEffectProbability)
	        {
	            par3EntityPlayer.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration, this.potionAmplifier));
	        }
	    }


	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir){
    	this.itemIcon = ir.registerIcon("GoreaFarming:tomato");
    }

    
   
}
