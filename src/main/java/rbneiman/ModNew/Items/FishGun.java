package rbneiman.ModNew.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rbneiman.ModNew.Entities.Bullet;



public class FishGun extends Item{
	
	int current=10;
	boolean fired=false;
	
	public FishGun() {
		setCreativeTab(CreativeTabs.TOOLS);
		setMaxDamage(100);
		maxStackSize=1;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		playerIn.setActiveHand(handIn);
		ItemStack stack=playerIn.getHeldItem(handIn);
		stack.damageItem(1, playerIn);
		float f = getArrowVelocity(current);

        if(!worldIn.isRemote)
        {	
        	for(int i=0;i<9;i++) {
        		EntityPlayer entityplayer = (EntityPlayer)playerIn;
            	EntityArrow entitybullet = new Bullet(worldIn, (EntityLivingBase) playerIn);
            	entitybullet.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 5.0F);
        		worldIn.spawnEntity(entitybullet);
        		fired=true;
        	}
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }
	
	@Override
	 public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		 fired=false;
	 }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }
	
	public static float getArrowVelocity(int charge)
    {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;

        if (f > 1.0F)
        {
            f = 1.0F;
        }

        return 1.5F;
    }
	
	@SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

	public String[] compileRender(ItemStack stack) {
		return null;
	}
	
}
