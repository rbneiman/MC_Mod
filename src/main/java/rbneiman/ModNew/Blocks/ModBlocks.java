package rbneiman.ModNew.Blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import rbneiman.ModNew.ModNew;

@ObjectHolder(ModNew.MODID)
public class ModBlocks {
	
	public static final BasicBlock basicBlock = null;
	public static final MachineBlock machineBlock = null;
	
	public static void initModels() {
    	registerModel(basicBlock);
    	registerModel(machineBlock);
	}
	
    private static void registerModel(Block block) {
    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    	
    }
}
