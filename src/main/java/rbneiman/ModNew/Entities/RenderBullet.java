package rbneiman.ModNew.Entities;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderBullet extends Render<Bullet> {
	private final float scale=(float) 0.2;
    private ResourceLocation texture = new ResourceLocation("modnew:textures/entity/bullet.png");

    public static final Factory FACTORY = new Factory();

    public RenderBullet(RenderManager rendermanagerIn) {
        super(rendermanagerIn);
    }


    public static class Factory implements IRenderFactory<Bullet> {

        @Override
        public Render<? super Bullet> createRenderFor(RenderManager manager) {
            return new RenderBullet(manager);
        }

    }
    
    public void doRender(Bullet entity, double x, double y, double z,
            float entityYaw, float partialTicks) {
    	GlStateManager.pushMatrix();
    	bindEntityTexture(entity);
    	GlStateManager.translate(x, y, z);
    	GlStateManager.enableRescaleNormal();
    	GlStateManager.scale(scale, scale, scale);
    	Tessellator tessellator = Tessellator.getInstance();
    	BufferBuilder bufferbuilder = tessellator.getBuffer();
    	GlStateManager.rotate(180.0F - renderManager.playerViewY,
    			0.0F, 1.0F, 0.0F);
    	GlStateManager.rotate(-renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

    	if (renderOutlines) {
    		GlStateManager.enableColorMaterial();
    		GlStateManager.enableOutlineMode(this.getTeamColor(entity));
    	}

    	bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
    	bufferbuilder.pos(-0.5D, -0.25D, 0.0D)
    	.tex(0.0, 1.0)
    	.normal(0.0F, 1.0F, 0.0F)
    	.endVertex();
    	bufferbuilder.pos(0.5D, -0.25D, 0.0D)
    	.tex(1.0, 1.0)
    	.normal(0.0F, 1.0F, 0.0F)
    	.endVertex();
    	bufferbuilder.pos(0.5D, 0.75D, 0.0D)
    	.tex(1.0, 0.0)
    	.normal(0.0F, 1.0F, 0.0F)
    	.endVertex();
    	bufferbuilder.pos(-0.5D, 0.75D, 0.0D)
    	.tex(0.0, 0.0)
    	.normal(0.0F, 1.0F, 0.0F)
    	.endVertex();
    	tessellator.draw();
    	
    	GlStateManager.disableRescaleNormal();
    	GlStateManager.popMatrix();
    	super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    @Override
	protected ResourceLocation getEntityTexture(Bullet entity) {
		return texture;
	}


}