package farming.gorea.creativetab;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.StringTranslate;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import farming.gorea.GoreaFarming;

public final class GoreaCreativeTab extends CreativeTabs {

	private Icon itemIcon;
	public GoreaCreativeTab(int id, String icon) {
		super(id, icon);
		
		//this.iconIndex = iconRegister.registerIcon("mod:superpickaxe");
	}	
	
	/*@SideOnly(Side.CLIENT)   
	public int getTabIconItemIndex()
    {
        return 20;
    }*/
	/*@SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
	{
		return GoreaFarming.goldentomatoItem.itemID;
		
		//return GoreaFarming.tomatoItem.itemID;
	}*/
	/*@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister)
	{
	this.itemIcon = par1IconRegister.registerIcon("GoreaFarming:GoreaFarmingIcon128");
	}*/
	
	@SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
            return GoreaFarming.tomatoItem.itemID;
            //return GoreaFarming.tomatoItem.itemID;
    }
    /*public String getTranslatedtabLabel()
    {
            return "Realistic farming";
    }*/
	static StringTranslate getInstance()
    {
        return getInstance();
    }
	public String getTranslatedTabLabel()
	{
	return getInstance().translateKey("" + this.getTabLabel());
	}
	public String getTabLabel()
	{
	return "MyTab";
	}

}
