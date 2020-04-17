package rbneiman.ModNew.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BasicBlock extends Block {
	public BasicBlock() {
        super(Material.ROCK);
        setCreativeTab(CreativeTabs.MISC);
        System.out.println("added");
    }
}
