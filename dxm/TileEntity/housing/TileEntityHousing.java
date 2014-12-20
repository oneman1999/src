package dxm.TileEntity.housing;

import java.util.HashMap;

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
	
	private int CheckTimer = 0;
	
	public TileEntityHousing(int type){
		this.type = type;
	}
	
	/**
	 * Update Entity!!
	 */
	public void updateEntity(){
		this.CheckTimer++;
		if(this.CheckTimer == 200){
			this.CheckTimer = 0;
			this.checkForUpdate();
		}
	}
	
	@Override
	public int getType() {
		return this.type;
	}
	
	

	@Override
	public int[] getAreaOfEffect() {
		return null;
	}
	
	
	@Override
	public void checkForUpdate() {
		for(HousingType h : HousingType.values()){
			this.scan(h.getDimensionsToScan(), h.type);
		}
	}
	
	
	@Override
	public boolean scan(int[] d , int ScanningFor) {
		int fakeX = (int) Math.floor(d[0]/2);
		int fakeY = 0;
		int fakeZ = (int) Math.floor(d[2]/2);
		HashMap blocks = new HashMap<Block , Integer>();
		
		
		for(int y = 0; y < d[1]; y++ ){
			for(int x = 0; x < d[0]; x++ ){
				for(int z = 0; z < d[2]; z++ ){
					Block block = this.worldObj.getBlock(this.xCoord - (int) Math.floor(d[0]/2) + x, this.yCoord + y, this.zCoord - (int) Math.floor(d[2]/2) + z);
					if(blocks.containsKey(block)){
						int num = (Integer) blocks.get(block);
						blocks.remove(block);
						blocks.put(block, num + 1);
					}else{
						blocks.put(block, 1);
					}
				}
			}
		}
		
		if(ScanningFor == this.Apartment){
			return this.canBecomeApartment(blocks);
		}
		if(ScanningFor == this.Homstead){
			return this.canBecomeHomstead(blocks);
		}
		if(ScanningFor == this.House){
			return this.canBecomeHouse(blocks);
		}
		if(ScanningFor == this.Hovel){
			return this.canBecomeHovel(blocks);
		}
		
		return false;
	}
	
	
	
	public boolean canBecomeApartment(HashMap map){
		/*
		 * WIP
		 */
		
		return false;
	}
	
	public boolean canBecomeHomstead(HashMap map){
		/*
		 * WIP
		 */
		
		return false;
	}
	
	public boolean canBecomeHouse(HashMap map){
		/*
		 * WIP
		 */
		
		return false;
	}
	
	public boolean canBecomeHovel(HashMap map){
		/*
		 * WIP
		 */
		
		return false;
	}

	

	
	
	
	
}

