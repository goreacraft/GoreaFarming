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
	}	
       
	@SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
            return GoreaFarming.poopItem.itemID;
           
    }

}
