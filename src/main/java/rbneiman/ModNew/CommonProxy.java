package rbneiman.ModNew;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rbneiman.ModNew.Blocks.BasicBlock;
import rbneiman.ModNew.Blocks.MachineBlock;
import rbneiman.ModNew.Blocks.ModBlocks;
import rbneiman.ModNew.Entities.ModEntities;
import rbneiman.ModNew.Items.BulletBox;
import rbneiman.ModNew.Items.BulletItem;
import rbneiman.ModNew.Items.FishGun;
import rbneiman.ModNew.Items.Minigun;
import rbneiman.ModNew.TileEntity.MachineBlockTile;

@EventBusSubscriber
public class CommonProxy {
	
	@Mod.Instance
    public static ModNew instance;
	
    public void preInit(FMLPreInitializationEvent e) {
    	
    }

    public void init(FMLInitializationEvent e) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance , new GuiProxy());
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	final Block[] blocks = {
    			new BasicBlock().setUnlocalizedName(ModNew.MODID + "." + "basicblock").setRegistryName("basicblock"),
    			new MachineBlock().setUnlocalizedName(ModNew.MODID + "." + "machineblock").setRegistryName("machineblock"),
		};
    	event.getRegistry().registerAll(blocks); 
    	GameRegistry.registerTileEntity(MachineBlockTile.class, new ModelResourceLocation("modnew:_machineblock"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	final Item[] items = {
    			new ItemBlock(ModBlocks.basicBlock).setRegistryName(ModBlocks.basicBlock.getRegistryName()),
    			new FishGun().setRegistryName("fishgun").setUnlocalizedName(ModNew.MODID + "." + "fishgun"),
    			new BulletItem().setRegistryName("bullet").setUnlocalizedName(ModNew.MODID + "." + "bullet"),
    			new BulletBox().setRegistryName("bulletbox").setUnlocalizedName(ModNew.MODID + "." + "bulletbox"),
    			new Minigun().setRegistryName("minigun").setUnlocalizedName(ModNew.MODID + "." + "minigun"),
    			new ItemBlock(ModBlocks.machineBlock).setRegistryName(ModBlocks.machineBlock.getRegistryName()),
		};
    	event.getRegistry().registerAll(items);
    	
    	ModelLoader.setCustomModelResourceLocation(items[1], 0, new ModelResourceLocation("modnew:fishgun"));
    	ModelLoader.setCustomModelResourceLocation(items[2], 0, new ModelResourceLocation("modnew:bullet"));
    	ModelLoader.setCustomModelResourceLocation(items[3], 0, new ModelResourceLocation("modnew:bulletbox"));
    	ModelLoader.setCustomModelResourceLocation(items[4], 0, new ModelResourceLocation("modnew:minigun"));
    }
    
    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
    	ModEntities.init(event);
    }
    
}

