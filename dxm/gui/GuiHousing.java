package dxm.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import dxm.TileEntity.housing.TileEntityHousing;
import dxm.gui.container.ContainerHousing;
import dxm.library.DXM_Info;

public class GuiHousing extends GuiContainer{

	ResourceLocation texture = new ResourceLocation(DXM_Info.MOD_ID , "/textures/gui/guiHousing");
	
	TileEntityHousing te;
	
	public GuiHousing(InventoryPlayer inv , IInventory te) {
		super(new ContainerHousing(inv , te));
		this.te = (TileEntityHousing) te;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		
	}

}
