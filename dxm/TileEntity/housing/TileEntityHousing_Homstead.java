package dxm.TileEntity.housing;

import dxm.blocks.Housing.HousingBlock;
import net.minecraft.tileentity.TileEntity;

public class TileEntityHousing_Homstead extends TileEntity implements IHousing {

	@Override
	public int getType() {
		return HousingBlock.Homstead;
	}

	@Override
	public int[] getAreaOfEffect() {
		// TODO Auto-generated method stub
		return null;
	}

}
