package dxm.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import dxm.TileEntity.housing.TileEntityHousing;
import dxm.gui.container.ContainerHousing;

public class DXMGuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null){
			switch(ID){
			case GuiIDs.Housing :
				return new ContainerHousing(player.inventory , (TileEntityHousing) te);
			}
		}
		return null; 
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		
		switch(ID){
		case GuiIDs.Housing :
			return new GuiHousing(player.inventory , (TileEntityHousing) te);
		
		}
		
		return null;
	}

}
