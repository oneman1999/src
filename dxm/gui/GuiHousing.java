package dxm.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import dxm.TileEntity.housing.TileEntityHousing;
import dxm.gui.container.ContainerHousing;
import dxm.library.DXM_Info;

public class GuiHousing extends GuiContainer{

	private static final ResourceLocation texture = new ResourceLocation(DXM_Info.MOD_ID , "textures/gui/guiHousing.png");
	
	TileEntityHousing te;
	
	public GuiHousing(InventoryPlayer inv , TileEntityHousing te) {
		super(new ContainerHousing(inv , te));
		this.te = te;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float a, int b, int c) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture );
		drawTexturedModalRect(guiLeft , guiTop , 0 , 0 , xSize , ySize);
	}

}
