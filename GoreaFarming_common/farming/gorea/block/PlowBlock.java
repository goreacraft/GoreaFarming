package farming.gorea.block;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import farming.gorea.GoreaFarming;
import farming.gorea.lib.Reference;

public class PlowBlock extends BlockSand {

	public PlowBlock(int par1, String textureName) {
		super(par1, Material.wood);
		this.setLightOpacity(1);
		setCreativeTab(GoreaFarming.tabGorea);
		this.textureName = textureName;
		// TODO Auto-generated constructor stub
	}
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	 public boolean isOpaqueCube()
	    {
	        return false;
	    }
	 
	 @SideOnly(Side.CLIENT)
	 private Icon topTexture;	 
	 @SideOnly(Side.CLIENT)
	 private Icon botTexture;
	 @SideOnly(Side.CLIENT)
	 private Icon rightTexture;
	 @SideOnly(Side.CLIENT)
	 private Icon leftTexture;
	 @SideOnly(Side.CLIENT)
	 private Icon frontTexture;
	 @SideOnly(Side.CLIENT)
	 private Icon backTexture;
	 
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister reg)
	 {
		 this.blockIcon = reg.registerIcon(Reference.MOD_ID + ":" + textureName);
		 this.topTexture = reg.registerIcon(Reference.MOD_ID + ":" + "top");
		 this.botTexture = reg.registerIcon(Reference.MOD_ID + ":" + "bot");
		 this.leftTexture = reg.registerIcon(Reference.MOD_ID + ":" + "left");
		 this.rightTexture = reg.registerIcon(Reference.MOD_ID + ":" + "right");
		 this.frontTexture = reg.registerIcon(Reference.MOD_ID + ":" + "front");
		 this.backTexture = reg.registerIcon(Reference.MOD_ID + ":" + "back");
		 
				 
	 }
	 /**
	     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	     */
	 public Icon getIcon(int par1, int par2)
	    {
	        if (par1 == 0)
	        {
	            
	            return this.botTexture;
	        }	      
	        if (par1 == 1)
	        {
	            
	            return this.topTexture;
	        }	
	        if (par1 == 2)
	        {
	            
	            return this.frontTexture;
	        }
	        if (par1 == 3)
	        {
	            
	            return this.backTexture;
	        }
	        if (par1 == 4)
	        {
	            
	            return this.rightTexture;
	        }
	        if (par1 == 5)
	        {
	            
	            return this.leftTexture;
	        }
	        else
	        {
	            return this.blockIcon;
	        }
	    }
	 public int getRenderType()
	    {
	        return 6;
	    }
	/*@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir){
    	this.blockIcon = ir.registerIcon("GoreaFarming:plow");
	}*/

}
