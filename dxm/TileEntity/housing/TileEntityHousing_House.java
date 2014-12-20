package dxm.TileEntity.housing;

import dxm.blocks.Housing.HousingBlock;
import net.minecraft.tileentity.TileEntity;

public class TileEntityHousing_House extends TileEntity implements IHousing {

	@Override
	public int getType() {
		return HousingBlock.House;
	}

	@Override
	public int[] getAreaOfEffect() {
		return null;
	}

}
