package rbneiman.ModNew.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Bullet extends EntityArrow{
	
	public Bullet(World worldIn) {
		super(worldIn);
	}
	
	public Bullet(World worldIn, double x, double y, double z)
    {
        this(worldIn);
        
    }

    public Bullet(World worldIn, EntityLivingBase shooter)
    {    	
        this(worldIn, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ);
        float rotX = shooter.rotationYaw;
        float rotY = shooter.rotationPitch;
    	double x = shooter.posX - MathHelper.sin((float) Math.toRadians(rotX))*Math.cos(Math.toRadians(-rotY))/1;
    	double y = shooter.posY + MathHelper.sin((float) Math.toRadians(-rotY))/1 + (double)shooter.getEyeHeight() - 0.10000000149011612D;
    	double z = shooter.posZ + MathHelper.cos((float) Math.toRadians(rotX))*Math.cos(Math.toRadians(-rotY))/1;
    	this.setPosition(x, y, z);
        this.shootingEntity = shooter;
    }

	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(Items.GUNPOWDER);
	}
	
	@Override
	public boolean hasNoGravity() {
		return false;		
	}
	
	@Override
	protected void onHit(RayTraceResult raytraceResultIn) {
		super.onHit(raytraceResultIn);
		Entity entity = raytraceResultIn.entityHit;
		if(entity==null) {
			this.world.newExplosion(this, this.posX, this.posY, this.posZ, 0.2F, false, true );	
//			this.world.newExplosion(this, this.posX, this.posY, this.posZ, 10.0F, false, true );	
		}
		this.setDead();
	}

}
