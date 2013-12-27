package farming.gorea;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import farming.gorea.block.GoreaTomatoPlant;
import farming.gorea.block.PlowBlock;
import farming.gorea.creativetab.GoreaCreativeTab;
import farming.gorea.event.Poo_DropEvent;
import farming.gorea.item.GoreaItemTomato;
import farming.gorea.item.GoreaTomatoSeeds;
import farming.gorea.item.PlowItem;
import farming.gorea.item.Poop;
import farming.gorea.lib.Reference;
import farming.gorea.proxy.CommonProxy;


@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERS, acceptedMinecraftVersions=Reference.MOD_MC)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GoreaFarming {
		@SidedProxy(clientSide="farming.gorea.proxy.ClientProxy", serverSide="farming.gorea.proxy.CommonProxy")
		public static CommonProxy proxy;
		
	    public static CreativeTabs tabGorea = new GoreaCreativeTab(CreativeTabs.getNextID(), "Gorea Farming");
	    	     
	   /* public static int tomatoSeedsID;
	    public static int tomatoPlantBlockID;*/
	    public static Item tomatoItem;
	    public static Item tomatoSeedsItem;
	    public static Block tomatoPlantBlock;
	    public static Item plowItem;
	    public static Item poopItem;
	    public static int tomatoPlantBlock_ID;
	    public static int tomatoSeeds_ID;
	    public static int tomatoItem_ID;
	    public static int poop_ID;
	    public static int plowItem_ID;
	    public static Block plowBlock;
	    public static int plowBlock_ID;

		

		
	    @EventHandler
		public void loadConfiguration(FMLPreInitializationEvent event) {
	    Configuration config = new Configuration(new File("config/GoreaFarming.cfg"));
     	    config.load();
     	    tomatoPlantBlock_ID = config.get("Blocks", "Tomato Plant ", GoreaCore.tomatoPlantBlockID).getInt();
	   		tomatoSeeds_ID = config.get("Items", "Tomato seeds ", GoreaCore.tomatoSeedsID).getInt();			
	   		tomatoItem_ID = config.get("Items", "Tomato ", GoreaCore.tomatoItemID).getInt();
	   		poop_ID = config.get("Items", "Poop ", GoreaCore.poopID).getInt();
	   		plowItem_ID = config.get("Item", "Plow ", GoreaCore.plowItemID).getInt();
	   		plowBlock_ID = config.get("Block", "Plow ", GoreaCore.plowBlockID).getInt();
     	    
     	   config.save();	
	    }
       
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        	
        	MinecraftForge.EVENT_BUS.register(new Poo_DropEvent());
        	} 
        	
		@EventHandler
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                tomatoSeedsItem = new GoreaTomatoSeeds(tomatoSeeds_ID, tomatoPlantBlock_ID, Block.tilledField.blockID).setUnlocalizedName("TomatoSeedsItem");
        		GameRegistry.registerItem(tomatoSeedsItem, "tomatoseedsItem");
                LanguageRegistry.addName(tomatoSeedsItem, "Tomato Seeds");
                MinecraftForge.addGrassSeed(new ItemStack(tomatoSeedsItem), 10);
                
                tomatoItem = new GoreaItemTomato(tomatoItem_ID).setUnlocalizedName("TomatoItem");
        		GameRegistry.registerItem(tomatoItem, "tomatoItem");
                LanguageRegistry.addName(tomatoItem, "Tomato");
        		
                
                tomatoPlantBlock = new GoreaTomatoPlant(tomatoPlantBlock_ID).setUnlocalizedName("tomatoplantblock");
        		GameRegistry.registerBlock(tomatoPlantBlock, "tomatoplantBlock");
                LanguageRegistry.addName(tomatoPlantBlock, "Tomato plant");
                
        		poopItem = new Poop(poop_ID).setUnlocalizedName("poop");
        		GameRegistry.registerItem(poopItem, "poopItem");
                LanguageRegistry.addName(poopItem, "Poop");
                
                plowItem = new PlowItem(plowItem_ID);
        		GameRegistry.registerItem(plowItem, "plowItemBlock");
                LanguageRegistry.addName(plowItem, "Plow Item");
                
                plowBlock = new PlowBlock(plowBlock_ID);
        		GameRegistry.registerBlock(plowBlock, "plowBlock");
                LanguageRegistry.addName(plowBlock, "Plow Block");
                
               
            
                //itemIcon = iconRegister.registerIcon("MyMod:MyItem")
                
         
        }
       
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }

}