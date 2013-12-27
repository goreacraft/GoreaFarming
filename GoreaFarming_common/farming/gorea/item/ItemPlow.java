package farming.gorea.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemPlow extends ItemBlock {

	public ItemPlow(int par1) {
		super(par1);
		setHasSubtypes(true);
		
	}
	public String getUnlocalizedNanme(ItemStack itemstack)
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
	}
	
}
