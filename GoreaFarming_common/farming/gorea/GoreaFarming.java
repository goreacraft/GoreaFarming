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
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import farming.gorea.block.GoreaTomatoPlant;
import farming.gorea.creativetab.GoreaCreativeTab;
import farming.gorea.entity.EntityPoop;
import farming.gorea.event.Poo_DropEvent;
import farming.gorea.item.GoldenTomato;
import farming.gorea.item.GoreaItemTomato;
import farming.gorea.item.GoreaTomatoSeeds;
import farming.gorea.item.Poop;
import farming.gorea.lib.Reference;
import farming.gorea.proxy.CommonProxy;

/**
 * @author gorea
 * 
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERS, acceptedMinecraftVersions = Reference.MOD_MC)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class GoreaFarming {
	@SidedProxy(clientSide = "farming.gorea.proxy.ClientProxy", serverSide = "farming.gorea.proxy.CommonProxy")
	public static CommonProxy proxy;
	private static int modEntityID = 0;
	public static CreativeTabs tabGorea = new GoreaCreativeTab(
			CreativeTabs.getNextID(), "GoreaFarming");

	public static Block tomatoPlantBlock;
	public static int tomatoPlantBlock_ID;

	public static Item tomatoSeedsItem;
	public static int tomatoSeeds_ID;

	public static Item tomatoItem;
	public static int tomatoItem_ID;
	public static Item goldentomatoItem;
	public static int goldentomatoItem_ID;

	public static Item poopItem;
	public static int poop_ID;
	// public static Item GoreaFarmingIcon;

	/*public static Item GoreaFarmingIcon = (new Item(1008))
			.setUnlocalizedName("GoreaFarmingIcon")
			.setCreativeTab(GoreaFarming.tabGorea)
			.setTextureName("GoreaFarming:GoreaFarmingIcon128");*/
	public static String plow;

	public static int tomatoItemEffect;
	public static int tomatoItemDuration;
	public static int tomatoItemEffectAmplifier;

	public static int goldentomatoItemEffect;
	public static int goldentomatoItemDuration;
	public static int goldentomatoItemEffectAmplifier;

	public static String uglyItem;
	public static int uglyItemEffect;
	public static int uglyItemEffect2;
	public static int uglyItemDuration;
	public static int uglyItemDuration2;
	public static int uglyItemEffectAmplifier;
	public static int uglyItemEffectAmplifier2;

	public static int pooIhrowEffect;
	public static int pooIhrowEffectDuration;
	public static int pooIhrowEffectAmplifier;

	@EventHandler
	public void loadConfiguration(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(new File(
				"config/GoreaFarming.cfg"));
		config.load();
		tomatoPlantBlock_ID = config.get("Blocks", "Tomato Plant ", GoreaCore.tomatoPlantBlockID).getInt();
		tomatoSeeds_ID = config.get("Items", "Tomato seeds ", GoreaCore.tomatoSeedsID).getInt();
		tomatoItem_ID = config.get("Items", "Tomato ", GoreaCore.tomatoItemID).getInt();
		goldentomatoItem_ID = config.get("Items", "Golden Tomato ", GoreaCore.goldentomatoItemID).getInt();

		poop_ID = config.get("Items", "Poop ", GoreaCore.poopID).getInt();
		// plowItem_ID = config.get("Plow", "Plow Item (wip) ",
		// GoreaCore.plowItemID).getInt();
		// plowBlock_ID = config.get("Plow", "Plow Block (wip) ",
		// GoreaCore.plowBlockID).getInt();
	
		tomatoItemEffect = config.get("Extra","Tomato on Eat effect (http://minecraft.gamepedia.com/Status_effect) ", 1).getInt();
		tomatoItemDuration = config.get("Extra", "Tomato on eat effect duration (ticks) ", 60).getInt();
		tomatoItemEffectAmplifier = config.get("Extra", "Tomato item effect amplifier ", 1).getInt();

		// goldentomatoItemEffect = config.get("Extra",
		// "Golden Tomato on Eat effect (http://minecraft.gamepedia.com/Status_effect) ",
		// 10).getInt();
		// goldentomatoItemDuration = config.get("Extra",
		// "Golden Tomato on eat effect duration (ticks) ", 5).getInt();
		// goldentomatoItemEffectAmplifier = config.get("Extra",
		// "Golden Tomato item effect amplifier ", 1).getInt();

		uglyItem = config.get("Extra", "UglyIem name (wip) not working to change for now ", "carrot").getString();

		uglyItemEffect = config.get("Extra", "Ugly item eat effect 1 (http://minecraft.gamepedia.com/Status_effect) ", 19).getInt();
		uglyItemDuration = config.get("Extra", "Ugly item effect 1 duration (ticks) ", 40).getInt();
		uglyItemEffectAmplifier = config.get("Extra", "Ugly item effect 1 amplifier ", 0).getInt();

		uglyItemEffect2 = config.get("Extra", "Ugly item eat effect 2 (http://minecraft.gamepedia.com/Status_effect)", 9).getInt();
		uglyItemDuration2 = config.get("Extra", "Ugly item effect 2 duration (ticks) ", 200).getInt();
		uglyItemEffectAmplifier2 = config.get("Extra", "Ugly item effect 2 amplifier ", 0).getInt();

		pooIhrowEffect = config.get("Extra", "Poo Impact effect ", 19).getInt();
		pooIhrowEffectDuration = config.get("Extra", "Poo Impact effect duration ", 60).getInt();
		pooIhrowEffectAmplifier = config.get("Extra", "Poo Impact effect amplifier ", 0).getInt();

		config.save();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// MinecraftForge.EVENT_BUS.register(new CarrotEat_Event());
		
		
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		
		MinecraftForge.EVENT_BUS.register(new Poo_DropEvent());

		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.GoreaFarming", "en_US", "Gorea Farming");

		tomatoSeedsItem = new GoreaTomatoSeeds(tomatoSeeds_ID,
				tomatoPlantBlock_ID, Block.tilledField.blockID)
				.setUnlocalizedName("TomatoSeedsItem");
		GameRegistry.registerItem(tomatoSeedsItem, "tomatoseedsItem");
		LanguageRegistry.addName(tomatoSeedsItem, "Tomato Seeds");
		
		MinecraftForge.addGrassSeed(new ItemStack(tomatoSeedsItem), 10);
		MinecraftForge.addGrassPlant(tomatoPlantBlock, 0, 10);

		tomatoItem = new GoreaItemTomato(tomatoItem_ID, 2, 0.6F, false)
				.setUnlocalizedName("TomatoItem");
		GameRegistry.registerItem(tomatoItem, "tomatoItem");
		LanguageRegistry.addName(tomatoItem, "Tomato");

		goldentomatoItem = new GoldenTomato(goldentomatoItem_ID, 2, 0.6F, false)
				.setUnlocalizedName("GoldenTomatoItem");
		GameRegistry.registerItem(goldentomatoItem, "goldentomatoItem");
		LanguageRegistry.addName(goldentomatoItem, "Golden Tomato");

		tomatoPlantBlock = new GoreaTomatoPlant(1006)
				.setUnlocalizedName("tomatoplantblock");
		GameRegistry.registerBlock(tomatoPlantBlock, "tomatoplantBlock");
		LanguageRegistry.addName(tomatoPlantBlock, "Tomato plant");

		poopItem = new Poop(poop_ID).setUnlocalizedName("poop");
		GameRegistry.registerItem(poopItem, "poopItem");
		LanguageRegistry.addName(poopItem, "Poop");

		GoreaEventHandler.craftingRecipes();
		EntityRegistry.registerModEntity(EntityPoop.class, "poop",++modEntityID, this, 64, 10, true);
		//RenderingRegistry.registerEntityRenderingHandler(EntityPoop.class,
		//		new RenderSnowball(GoreaFarming.poopItem));
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}

}