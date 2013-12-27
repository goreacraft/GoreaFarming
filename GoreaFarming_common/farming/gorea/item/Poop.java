package farming.gorea.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import farming.gorea.GoreaFarming;
import farming.gorea.block.GoreaTomatoPlant;

public class Poop extends Item
{
	public Poop(int par1){
		super (par1);
		//this.setAlwaysEdible();
		setMaxStackSize(64);
		setCreativeTab(GoreaFarming.tabGorea);
		//setUnlocalizedName("Tomato");
		}
		@Override
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister ir){
	    	this.itemIcon = ir.registerIcon("GoreaFarming:chicken-poop32");
	    }
		 public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
		    {
		        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
		        {
		            return false;
		        }
		        else
		        {
		            if (par1ItemStack.getItemDamage() == 0)
		            {
		                if (applyBonemeal(par1ItemStack, par3World, par4, par5, par6, par2EntityPlayer))
		                {
		                    if (!par3World.isRemote)
		                    {
		                        par3World.playAuxSFX(2005, par4, par5, par6, 0);
		                    }

		                    return true;
		                }
		            }
		        }
				return false;
		    }
		 public static boolean applyBonemeal(ItemStack par0ItemStack, World par1World, int par2, int par3, int par4, EntityPlayer player)
		    {
		        int l = par1World.getBlockId(par2, par3, par4);

		        BonemealEvent event = new BonemealEvent(player, par1World, l, par2, par3, par4);
		        if (MinecraftForge.EVENT_BUS.post(event))
		        {
		            return false;
		        }

		        if (event.getResult() == Result.ALLOW)
		        {
		            if (!par1World.isRemote)
		            {
		                par0ItemStack.stackSize--;
		            }
		            return true;
		        }
		        if (par1World.getBlockMetadata(par2, par3, par4) == 7)
                {
                    return false;
                }
                else
                {
                    if (!par1World.isRemote)
                    {
                        ((GoreaTomatoPlant)GoreaFarming.tomatoPlantBlock).fertilize(par1World, par2, par3, par4);
                        --par0ItemStack.stackSize;
                    }

                    return true;
                }
		    }
		/*public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        if (!par3EntityPlayer.capabilities.isCreativeMode)
	        {
	            --par1ItemStack.stackSize;
	        }

	        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

	        if (!par2World.isRemote)
	        {
	            par2World.spawnEntityInWorld(new EntityEgg(par2World, par3EntityPlayer));
	        }

	        return par1ItemStack;
	    }*/
}