package rbneiman.ModNew.Client;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderPlayerEvent;


public class LimbHandler {
    
    public static boolean lastHeld = false;
    
    public static void armHandler(RenderPlayerEvent.Post event) {
    	EntityPlayer player = event.getEntityPlayer();
    	Boolean small       = ((AbstractClientPlayer) player).getSkinType().equals("slim");
    	float sneak         = player.isSneaking() ? 4.0F : 0.0F;
    	
    	ModelRenderer armR= event.getRenderer().getMainModel().bipedRightArm;
    	ModelRenderer armL= event.getRenderer().getMainModel().bipedLeftArm;
    	armR.isHidden=false;
		armL.isHidden=false;
    	event.getRenderer().bindTexture(event.getRenderer().getEntityTexture((AbstractClientPlayer) player));
    	
    	
    	if(player.getHeldItemMainhand().getItem().getUnlocalizedName().equals("item.modnew.fishgun")) {
    		if(small) {
    			armR.rotationPointZ =  MathHelper.sin((float) Math.toRadians(-player.renderYawOffset)) * 4.4F; //1.45
            	armR.rotationPointX = -MathHelper.cos((float) Math.toRadians(-player.renderYawOffset)) * 4.4F;
            	armL.rotationPointZ = -MathHelper.sin((float) Math.toRadians(-player.renderYawOffset)) * 4.4F; //1.45
            	armL.rotationPointX =  MathHelper.cos((float) Math.toRadians(-player.renderYawOffset)) * 4.4F;
    		}
    		else {
    			armR.rotationPointZ =  MathHelper.sin((float) Math.toRadians(-player.renderYawOffset)) * 4.6F; //1.6
            	armR.rotationPointX = -MathHelper.cos((float) Math.toRadians(-player.renderYawOffset)) * 4.6F;
            	armL.rotationPointZ = -MathHelper.sin((float) Math.toRadians(-player.renderYawOffset)) * 4.6F; //1.6
            	armL.rotationPointX =  MathHelper.cos((float) Math.toRadians(-player.renderYawOffset)) * 4.6F;
    		}
            armR.rotationPointY = 20.0F - sneak;
    		armR.rotateAngleZ = (float) Math.toRadians(90.0F); //move arm up/down 0 up 180 down
    		armR.rotateAngleX = (float) Math.toRadians(110.0F); //twist
    		armR.rotateAngleY = (float) -Math.toRadians(player.renderYawOffset-110.0F); //move forward/back - forward + back
    		armR.renderWithRotation(0.0625F);	// 5,9,10 correct translation
    		
    		armL.rotationPointY = 20.0F - sneak;
     		//armL.rotateAngleZ = (float) Math.toRadians(-80.0F); //move arm up/down 0 up 180 down
     		armL.rotateAngleZ = (float) Math.toRadians(-80.0F);
     		armL.rotateAngleX = (float) Math.toRadians(0.0F); //twist
     		armL.rotateAngleY = (float) -Math.toRadians(player.renderYawOffset+110.0F); //move forward/back - forward + back
     		armL.renderWithRotation(0.0625F);
     		lastHeld = true;
    	}
    	else if(player.getHeldItemMainhand().getItem().getUnlocalizedName().equals("item.modnew.minigun")) {
    		if(small) {
    			armR.rotationPointZ =  MathHelper.sin((float) Math.toRadians(-player.renderYawOffset-25.0F)) * 4.4F; //1.45
            	armR.rotationPointX = -MathHelper.cos((float) Math.toRadians(-player.renderYawOffset-25.0F)) * 4.4F;
            	armL.rotationPointZ = -MathHelper.sin((float) Math.toRadians(-player.renderYawOffset-25.0F)) * 4.4F; //1.45
            	armL.rotationPointX =  MathHelper.cos((float) Math.toRadians(-player.renderYawOffset-25.0F)) * 4.4F;
    		}
    		else {
            	armR.rotationPointX = -MathHelper.cos((float) Math.toRadians(-player.renderYawOffset-25.0F)) * 4.6F;
            	armR.rotationPointZ =  MathHelper.sin((float) Math.toRadians(-player.renderYawOffset-25.0F)) * 4.6F; //1.6
            	armL.rotationPointZ = -MathHelper.sin((float) Math.toRadians(-player.renderYawOffset-25.0F)) * 4.6F; //1.6
            	armL.rotationPointX =  MathHelper.cos((float) Math.toRadians(-player.renderYawOffset-25.0F)) * 4.6F;
    		}
    		
    		
            armR.rotationPointY = 22.0F - sneak;
    		armR.rotateAngleZ = (float)  Math.toRadians(150.0F); //move arm up/down 0 up 180 down
    		armR.rotateAngleX = (float)  Math.toRadians(0.0F); //twist
    		armR.rotateAngleY = (float) -Math.toRadians(player.renderYawOffset-10.0F); //move forward/back - forward + back
    		armR.renderWithRotation(0.0625F);	// 5,9,10 correct translation
    		
    		armL.rotationPointY = 20.0F - sneak;
     		armL.rotateAngleZ = (float)  Math.toRadians(-120.0F);
     		armL.rotateAngleX = (float)  Math.toRadians(0.0F); //twist
     		armL.rotateAngleY = (float) -Math.toRadians(player.renderYawOffset+150.0F); //move forward/back - forward + back
     		armL.renderWithRotation(0.0625F);
     		lastHeld=true;
     		
    	}
    	else if(small) {
    		armR.rotateAngleZ = (float) Math.toRadians(0.0F);
     		armR.rotateAngleX = (float) Math.toRadians(0.0F);
     		armR.rotateAngleY = (float) Math.toRadians(0.0F);
    		armL.rotateAngleZ = (float) Math.toRadians(0.0F);
     		armL.rotateAngleX = (float) Math.toRadians(0.0F);
     		armL.rotateAngleY = (float) Math.toRadians(0.0F);
    		armR.setRotationPoint(-5.0F, 2.5F, 0.0F);
    		armL.setRotationPoint(5.0F, 2.0F, 0.0F);
    		lastHeld = false;   		
    	}
    	else{
    		armR.rotateAngleZ = (float) Math.toRadians(0.0F);
     		armR.rotateAngleX = (float) Math.toRadians(0.0F);
     		armR.rotateAngleY = (float) Math.toRadians(0.0F);
    		armL.rotateAngleZ = (float) Math.toRadians(0.0F);
     		armL.rotateAngleX = (float) Math.toRadians(0.0F);
     		armL.rotateAngleY = (float) Math.toRadians(0.0F);
    		armR.setRotationPoint(-5.0F, 2.0F, 0.0F);
    		armL.setRotationPoint(5.0F, 2.0F, 0.0F);
    		lastHeld = false;
    		
    	}
    	
    }
    
    static boolean lastHeld2=false;
    
    public static void bodyHandler(RenderPlayerEvent.Post event) {
    	
    	EntityPlayer player = event.getEntityPlayer();
    	
    	ModelRenderer body= event.getRenderer().getMainModel().bipedBody;
    	body.isHidden=false;
    	event.getRenderer().bindTexture(event.getRenderer().getEntityTexture((AbstractClientPlayer) player));
    	
    	if(player.getHeldItemMainhand().getItem().getUnlocalizedName().equals("item.modnew.minigun")) {
    		
    		body.setRotationPoint(0.0F, 22.5F, 0.0F);
    		
    		//body.rotateAngleZ = (float) Math.toRadians(180.0F);
    		body.rotateAngleX = (float) Math.toRadians(180.0F);
    		body.rotateAngleY = (float) -Math.toRadians(player.renderYawOffset+25.0F);
    		body.renderWithRotation(0.0625F);   		
     		lastHeld2=true;
     		
    	}
    	
    	else if(lastHeld2){    

    		body.setRotationPoint(0.0F, 0.0F, 0.0F);
    		lastHeld2 = false;
   		
    	}
    	
    }
}
