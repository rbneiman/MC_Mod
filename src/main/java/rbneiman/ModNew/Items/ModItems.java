package rbneiman.ModNew.Items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import rbneiman.ModNew.ModNew;

@ObjectHolder(ModNew.MODID)
public class ModItems {
	
	public static final FishGun fishgun = null;
	public static final Minigun minigun = null;
	public static final BulletItem bullet = null;
	public static final BulletBox bulletBox = null;
	
	public static void initModels() {
		registerModel(fishgun);
    	registerModel(minigun);
	}
	
	private static void registerModel(Item item) {
    	ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    	
    }
}
