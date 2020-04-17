package rbneiman.ModNew.Client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import rbneiman.ModNew.CommonProxy;
import rbneiman.ModNew.Blocks.ModBlocks;
import rbneiman.ModNew.Entities.ModEntities;
import rbneiman.ModNew.Items.ModItems;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
    	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    	ModEntities.initModels();
        super.preInit(e);
    }
    
    
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	ModBlocks.initModels();
    	ModItems.initModels();
    }
    
    @SubscribeEvent(priority=EventPriority.NORMAL)
    public static void renderPlayer(RenderPlayerEvent.Pre event) {
    	EntityPlayer player = event.getEntityPlayer();
    	if(player.getHeldItemMainhand().getItem().getUnlocalizedName().equals("item.modnew.fishgun")) {
    		event.getRenderer().getMainModel().bipedRightArm.isHidden = true;
    		event.getRenderer().getMainModel().bipedLeftArm.isHidden  = true;
    	}
    	else if(player.getHeldItemMainhand().getItem().getUnlocalizedName().equals("item.modnew.minigun")){
    		event.getRenderer().getMainModel().bipedRightArm.isHidden = true;
    		event.getRenderer().getMainModel().bipedLeftArm.isHidden  = true;
    		event.getRenderer().getMainModel().bipedBody.isHidden     = true;
    	}
    }
    
    @SubscribeEvent
    public static void renderPlayer(RenderPlayerEvent.Post event) {
    	LimbHandler.armHandler(event);
    	LimbHandler.bodyHandler(event);
    }
    

    
}