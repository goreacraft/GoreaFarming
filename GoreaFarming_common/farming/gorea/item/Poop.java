package farming.gorea.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockStem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import farming.gorea.GoreaFarming;
import farming.gorea.block.GoreaTomatoPlant;
import farming.gorea.entity.EntityPoop;

public class Poop extends Item
{
	public Poop(int par1){
		super (par1);
		//this.setAlwaysEdible();
		this.setMaxStackSize(64);
		this.setCreativeTab(GoreaFarming.tabGorea);
		//setUnlocalizedName("Tomato");
		}
	  
		@Override
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister ir){
	    	this.itemIcon = ir.registerIcon("GoreaFarming:poop");
	    }
		public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        if (!par3EntityPlayer.capabilities.isCreativeMode)
	        {
	            --par1ItemStack.stackSize;
	        }

	        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

	       // if (!par2World.isRemote)
	       // {
	           par2World.spawnEntityInWorld(new EntityPoop(par2World, par3EntityPlayer));
	      //  }

	        return par1ItemStack;
	    }
		 public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
		    {
		        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
		        {
		            return false;
		        }
		        else
		        {		           
		             if (applyBonemeal(par1ItemStack, par3World, par4, par5, par6, par2EntityPlayer))
		                {
		                    if (!par3World.isRemote)
		                    {
		                        par3World.playAuxSFX(2005, par4, par5, par6, 0);
		                       
		                    }

		                    return true;
		                }
		             return false;
		        }
				//return false;
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

		        if (l == Block.sapling.blockID)
		        {
		            if (!par1World.isRemote)
		            {
		                if ((double)par1World.rand.nextFloat() < 0.45D)
		                {
		                    ((BlockSapling)Block.sapling).markOrGrowMarked(par1World, par2, par3, par4, par1World.rand);
		                }

		                --par0ItemStack.stackSize;
		            }

		            return true;
		        }
		        else if (l != Block.mushroomBrown.blockID && l != Block.mushroomRed.blockID)
		        {
		            if (l != Block.melonStem.blockID && l != Block.pumpkinStem.blockID)
		            {
		                if (l > 0 && Block.blocksList[l] instanceof BlockCrops)
		                {
		                    if (par1World.getBlockMetadata(par2, par3, par4) == 7)
		                    {
		                        return false;
		                    }
		                    else
		                    {
		                        if (!par1World.isRemote)
		                        {
		                            ((BlockCrops)Block.blocksList[l]).fertilize(par1World, par2, par3, par4);
		                            --par0ItemStack.stackSize;
		                        }

		                        return true;
		                    }
		                }
		                else
		                {
		                    int i1;
		                    int j1;
		                    int k1;

		                    if (l == Block.cocoaPlant.blockID)
		                    {
		                        i1 = par1World.getBlockMetadata(par2, par3, par4);
		                        j1 = BlockDirectional.getDirection(i1);
		                        k1 = BlockCocoa.func_72219_c(i1);

		                        if (k1 >= 2)
		                        {
		                            return false;
		                        }
		                        else
		                        {
		                            if (!par1World.isRemote)
		                            {
		                                ++k1;
		                                par1World.setBlockMetadataWithNotify(par2, par3, par4, k1 << 2 | j1, 2);
		                                --par0ItemStack.stackSize;
		                            }

		                            return true;
		                        }
		                    }
		                    else if (l != Block.grass.blockID)
		                    {
		                        return false;
		                    }
		                    else
		                    {
		                        if (!par1World.isRemote)
		                        {
		                            --par0ItemStack.stackSize;
		                            label102:

		                            for (i1 = 0; i1 < 128; ++i1)
		                            {
		                                j1 = par2;
		                                k1 = par3 + 1;
		                                int l1 = par4;

		                                for (int i2 = 0; i2 < i1 / 16; ++i2)
		                                {
		                                    j1 += itemRand.nextInt(3) - 1;
		                                    k1 += (itemRand.nextInt(3) - 1) * itemRand.nextInt(3) / 2;
		                                    l1 += itemRand.nextInt(3) - 1;

		                                    if (par1World.getBlockId(j1, k1 - 1, l1) != Block.grass.blockID || par1World.isBlockNormalCube(j1, k1, l1))
		                                    {
		                                        continue label102;
		                                    }
		                                }

		                                if (par1World.getBlockId(j1, k1, l1) == 0)
		                                {
		                                    if (itemRand.nextInt(10) != 0)
		                                    {
		                                        if (Block.tallGrass.canBlockStay(par1World, j1, k1, l1))
		                                        {
		                                            par1World.setBlock(j1, k1, l1, Block.tallGrass.blockID, 1, 3);
		                                        }
		                                    }
		                                    else
		                                    {
		                                        ForgeHooks.plantGrass(par1World, j1, k1, l1);
		                                    }
		                                }
		                            }
		                        }

		                        return true;
		                    }
		                }
		            }
		            else if (par1World.getBlockMetadata(par2, par3, par4) == 7)
		            {
		                return false;
		            }
		            else
		            {
		                if (!par1World.isRemote)
		                {
		                    ((BlockStem)Block.blocksList[l]).fertilizeStem(par1World, par2, par3, par4);
		                    --par0ItemStack.stackSize;
		                }

		                return true;
		            }
		        }
		        else
		        {
		            if (!par1World.isRemote)
		            {
		                if ((double)par1World.rand.nextFloat() < 0.4D)
		                {
		                    ((BlockMushroom)Block.blocksList[l]).fertilizeMushroom(par1World, par2, par3, par4, par1World.rand);
		                }

		                --par0ItemStack.stackSize;
		            }

		            return true;
		        }
		    }
		 /*public static boolean applyBonemeal(ItemStack par0ItemStack, World par1World, int par2, int par3, int par4, EntityPlayer player)
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
                        (GoreaFarming.tomatoPlantBlock).fertilize(par1World, par2, par3, par4);
                        --par0ItemStack.stackSize;
                    }

                    return false;
                }
		    }*/
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