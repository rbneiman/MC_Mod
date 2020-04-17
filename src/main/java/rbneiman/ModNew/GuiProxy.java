package rbneiman.ModNew;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import rbneiman.ModNew.Containers.MachineBlockContainer;
import rbneiman.ModNew.Gui.MachineBlockGui;
import rbneiman.ModNew.TileEntity.MachineBlockTile;

public class GuiProxy implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof MachineBlockTile) {
            return new MachineBlockContainer(player.inventory, (MachineBlockTile) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof MachineBlockTile) {
        	MachineBlockTile containerTileEntity = (MachineBlockTile) te;
            return new MachineBlockGui(containerTileEntity, new MachineBlockContainer(player.inventory, containerTileEntity));
        }
        return null;
    }
}
