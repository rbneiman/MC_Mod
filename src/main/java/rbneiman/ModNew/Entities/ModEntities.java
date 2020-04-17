package rbneiman.ModNew.Entities;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import rbneiman.ModNew.ModNew;
import rbneiman.ModNew.Entities.RenderBullet.Factory;

public class ModEntities {
	public static void init(RegistryEvent.Register<EntityEntry> event) {
		EntityEntryBuilder<Bullet> builder = EntityEntryBuilder.create();
    	builder.name("bullet");
    	builder.entity(Bullet.class);
    	builder.tracker(80, 3, true);
    	builder.id(new ResourceLocation(ModNew.MODID,"bullet"), 0);
    	EntityEntry entry=builder.build();
    	event.getRegistry().register(entry);
	}
	
	public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(Bullet.class, (Factory) RenderBullet.FACTORY);
    }
	
}
