package rbneiman.ModNew.Gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import rbneiman.ModNew.ModNew;
import rbneiman.ModNew.Containers.MachineBlockContainer;
import rbneiman.ModNew.TileEntity.MachineBlockTile;

public class MachineBlockGui extends GuiContainer {
	public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private static final ResourceLocation background = new ResourceLocation(ModNew.MODID, "textures/gui/MachineBlockContainer.png");

    public MachineBlockGui(MachineBlockTile tileEntity, MachineBlockContainer container) {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
