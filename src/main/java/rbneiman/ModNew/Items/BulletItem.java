package rbneiman.ModNew.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BulletItem extends Item{
	public BulletItem() {
		setCreativeTab(CreativeTabs.COMBAT);
		setMaxDamage(100);
		maxStackSize=64;
	}

}
