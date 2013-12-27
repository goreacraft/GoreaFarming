package farming.gorea.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import farming.gorea.GoreaFarming;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class PlowItem extends Item {

	public PlowItem(int par1) {
		super(par1);
		setMaxStackSize(64);
		setCreativeTab(GoreaFarming.tabGorea);
		
	}
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir){
    	this.itemIcon = ir.registerIcon("GoreaFarming:plow");
	}
	/*public String getUnlocalizedNanme(ItemStack itemstack)
	{
		String name = "";
		
		switch(itemstack.getItemDamage())
		{
			case 0:
			{
				name = "world";
				break;
			}
			case 1:
			{
				name = "nether";
				break;
			}
			//dafault: name = "broken";
		}
		return getUnlocalizedName() + "." + name;
	
	}
	public int getMetadata(int par1)
	{
		return par1;
	}*/
	
}
