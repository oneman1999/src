package dxm.gui.container;

import dxm.TileEntity.housing.TileEntityHousing;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

public class ContainerHousing extends Container {

	TileEntityHousing te;
	
	public ContainerHousing(InventoryPlayer inv, TileEntityHousing te) {
		this.te = te;
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}

}
