package farming.gorea.proxy;



import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import farming.gorea.GoreaFarming;
import farming.gorea.entity.EntityPoop;
import farming.gorea.proxy.CommonProxy;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerRenderers() {
	
	RenderingRegistry.registerEntityRenderingHandler(EntityPoop.class, new RenderSnowball(GoreaFarming.poopItem));
	
	//RenderingRegistry.registerEntityRenderingHandler(EntityPoop.class , new RenderSnowball(GoreaFarming.poopItem));
	}
}
