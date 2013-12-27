package farming.gorea.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import farming.gorea.GoreaFarming;

public final class GoreaCreativeTab extends CreativeTabs {

	public GoreaCreativeTab(int id, String icon) {
		super(id, icon);

	}
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return GoreaFarming.tomatoItem.itemID;
		//return GoreaFarming.tomatoItem.itemID;
	}
	public String getTranslatedtabLabel()
	{
		return "Realistic farming";
	}

}
