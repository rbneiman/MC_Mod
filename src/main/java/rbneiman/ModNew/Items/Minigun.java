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

public class Minigun extends Item{
	
	int current=10;
	boolean fired=false;
	
	public Minigun() {
		setCreativeTab(CreativeTabs.TOOLS);
		setMaxDamage(100);
		maxStackSize=1;
	}
	
	int ticks = 0;
	int speed = 20;
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		//worldIn.
		playerIn.setActiveHand(handIn);
		ticks = 0;
		speed = 25;
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }
	
	@Override
	public void onUsingTick(ItemStack stack, EntityLivingBase player, int count){
		
		World world = player.world;
//		stack.damageItem(1, player);
		float f = getArrowVelocity(current);
		//System.out.println(ticks++);
		if(speed>2&&count%3==0) {
			speed-=1;
		}
        if((count%speed)==0&&(!world.isRemote))
        {	      	
        	for(int i=0;i<1;i++) {
        		EntityPlayer entityplayer = (EntityPlayer)player;
            	EntityArrow entitybullet = new Bullet(world,player);
            	entitybullet.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 3.0F);
        		world.spawnEntity(entitybullet);
        		fired=true;
        	}
        }
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