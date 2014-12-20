package dxm.TileEntity.housing;

import dxm.blocks.Housing.HousingBlock;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

/**
 * @category TileEntityHousing
 */
public class TileEntityHousing extends TileEntity implements IHousing{

	public int type;
	
	public static final int Empty = 0;
	public static final int Hovel = 1;
	public static final int Homstead = 2;
	public static final int House = 3;
	public static final int Apartment = 4;
	
	
	
	@Override
	public int getType() {
		return this.type;
	}

	@Override
	public int[] getAreaOfEffect() {
		return new int[]{20 , 60 ,20};
	}

	@SuppressWarnings("null")
	@Override
	public boolean scan(int[] d) {
		int fakeX = (int) Math.floor(d[0]/2);
		int fakeY = 0;
		int fakeZ = (int) Math.floor(d[2]/2);
		
		Block[][][] blocksScanned = null;
		
		for(int y = 0; y < d[1]; y++ ){
			for(int x = 0; x < d[0]; x++ ){
				for(int z = 0; z < d[2]; z++ ){
					blocksScanned[x][y][z] = this.worldObj.getBlock(this.xCoord - (int) Math.floor(d[0]/2) + x, this.yCoord + y, this.zCoord - (int) Math.floor(d[2]/2) + z);
				}
			}
		}
		
		
		
		return true;
	}

}

