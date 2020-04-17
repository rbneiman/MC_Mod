package rbneiman.ModNew;

import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModNew.MODID, name = ModNew.NAME, version = ModNew.VERSION)
public class ModNew
{
    public static final String MODID = "modnew";
    public static final String NAME = "Test Mod";
    public static final String VERSION = "1.0";
    
    @SidedProxy(clientSide = "rbneiman.ModNew.Client.ClientProxy", serverSide = "rbneiman.ModNew.Server.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static ModNew instance;

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        logger = e.getModLog();
        OBJLoader.INSTANCE.addDomain(MODID);
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
