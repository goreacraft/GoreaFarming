package farming.gorea.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAppleGold;
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
	public class GoldenTomato extends ItemFood
	{
		
		public GoldenTomato(int par1, int par2, float par3, boolean par4)
	    {
	        super(par1, par2, par3, par4);
	        this.setHasSubtypes(true);
	        setCreativeTab(GoreaFarming.tabGorea);
	        this.setAlwaysEdible();
	        setMaxStackSize(64);
	    }

	    @SideOnly(Side.CLIENT)
	    public boolean hasEffect(ItemStack par1ItemStack)
	    {
	        return par1ItemStack.getItemDamage() > 0;
	    }

	    @SideOnly(Side.CLIENT)

	    /**
	     * Return an item rarity from EnumRarity
	     */
	    public EnumRarity getRarity(ItemStack par1ItemStack)
	    {
	        return par1ItemStack.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
	    }

	    protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        if (!par2World.isRemote)
	        {
	            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 2400, 0));
	        }

	        if (par1ItemStack.getItemDamage() > 0)
	        {
	            if (!par2World.isRemote)
	            {
	                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
	                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 0));
	                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
	            }
	        }
	        else
	        {
	            super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
	        }
	    }
	    @SideOnly(Side.CLIENT)

	    /**
	     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	     */
	    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	    {
	        par3List.add(new ItemStack(par1, 1, 0));
	        par3List.add(new ItemStack(par1, 1, 1));
	    }
	   
	

			//private static final float potionEffectProbability = 1;
			//private static final int potionId = GoreaFarming.goldentomatoItemEffect; 
			//private static final int potionDuration = GoreaFarming.goldentomatoItemDuration;
			//private static final int potionAmplifier = GoreaFarming.goldentomatoItemEffectAmplifier;


/*
			public GoldenTomato(int par1, int par2, float par3, boolean par4) {
			super(par1, par2, par3, par4);
			setMaxStackSize(64);
			this.setAlwaysEdible();
			this.setHasSubtypes(false);
			setCreativeTab(GoreaFarming.tabGorea);
		}*/
			/*@Override
			protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
		    {
		        if (!par2World.isRemote && this.potionId > 0 && par2World.rand.nextFloat() < this.potionEffectProbability)
		        {
		        	par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 5, 1, 1.0F));
		           // par3EntityPlayer.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration, this.potionAmplifier));
		        }
		    }*/


			
			// TODO Auto-generated constructor stub
		

		
		//this.setAlwaysEdible();
		

	    
		//setUnlocalizedName("Tomato");
		

		@Override
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister ir){
	    	this.itemIcon = ir.registerIcon("GoreaFarming:goldentomato");
	    }

	    /*public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
	        if (!par2World.isRemote)
	        { 
	            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 60, 0));
	        }
	    }*/
	    
	   
	}


