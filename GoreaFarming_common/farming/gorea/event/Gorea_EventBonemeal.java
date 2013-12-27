package farming.gorea.event;

import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import farming.gorea.GoreaFarming;
import farming.gorea.block.GoreaTomatoPlant;

public class Gorea_EventBonemeal
{
	@ForgeSubscribe
    public void onUseEntityChickenpoop(BonemealEvent event)
    {
		if (event.ID == GoreaFarming.tomatoPlantBlock.blockID)
        {
                if (!event.world.isRemote)
                {
                        ((GoreaTomatoPlant)GoreaFarming.tomatoPlantBlock).fertilize(event.world, event.X, event.Y, event.Z);
                }
event.setResult(Result.ALLOW);//allow the bonemeal consumption and prevent other possible effects
        }
    }
	
}