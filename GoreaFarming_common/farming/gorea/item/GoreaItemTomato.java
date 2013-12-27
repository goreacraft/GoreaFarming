package farming.gorea.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import farming.gorea.GoreaFarming;

public class GoreaItemTomato extends Item {
	public GoreaItemTomato(int par1){
	super (par1);
	//this.setAlwaysEdible();
	setMaxStackSize(64);
	setCreativeTab(GoreaFarming.tabGorea);
	//setUnlocalizedName("Tomato");
	}
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir){
    	this.itemIcon = ir.registerIcon("GoreaFarming:tomato");
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
