package farming.gorea;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.registry.GameRegistry;

public class GoreaEventHandler {
	
	public static void craftingRecipes(){
		GameRegistry.addShapelessRecipe(new ItemStack(GoreaFarming.tomatoSeedsItem, 4), new Object[] {GoreaFarming.tomatoItem});
		GameRegistry.addRecipe(new ItemStack(GoreaFarming.goldentomatoItem, 1), new Object[]{"ggg", "gtg","ggg",'g', Item.ingotGold,'t', GoreaFarming.tomatoItem});
		GameRegistry.addRecipe(new ItemStack(GoreaFarming.goldentomatoItem.itemID, 1, 1), new Object[]{"GGG", "GtG","GGG",'G', Block.blockGold,'t', GoreaFarming.tomatoItem});
	}

	



}
