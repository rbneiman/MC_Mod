package rbneiman.ModNew.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import rbneiman.ModNew.ModNew;
import rbneiman.ModNew.TileEntity.MachineBlockTile;

public class MachineBlock extends Block implements ITileEntityProvider{
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final int GUI_ID = 1;
	
	public MachineBlock() {
        super(Material.IRON);
        setCreativeTab(CreativeTabs.MISC);
        System.out.println("added");
    }
	
	public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new MachineBlockTile();
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                EnumFacing side, float hitX, float hitY, float hitZ) {
		// Only execute on the server
        if (world.isRemote) {
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof MachineBlockTile)) {
            return false;
        }
        player.openGui(ModNew.instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
	
	@Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }
	
	@Override
    public IBlockState getStateFromMeta(int meta) {
        // Since we only allow horizontal rotation we need only 2 bits for facing. North, South, West, East start at index 2 so we have to add 2 here.
        return getDefaultState().withProperty(FACING, EnumFacing.getFront((meta & 3) + 2));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        // Since we only allow horizontal rotation we need only 2 bits for facing. North, South, West, East start at index 2 so we have to subtract 2 here.
        return state.getValue(FACING).getIndex()-2;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }
    
}
