package rbneiman.ModNew.Items;

import javax.annotation.Nullable;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class BulletBox extends Item{
	public BulletBox() {
		setCreativeTab(CreativeTabs.COMBAT);
		setMaxDamage(100);
		maxStackSize=16;
		this.addPropertyOverride(new ResourceLocation("number"), new IItemPropertyGetter()
        {
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
				float number = stack.getCount();
				return number;
			}
        });
        
	}

}
