package dxm.TileEntity.housing;

import java.util.HashMap;

import dxm.blocks.HousingBlock;
import dxm.blocks.ModBlocks;
import dxm.utils.Error.ErrorHandler;
import dxm.utils.Error.IError;
import dxm.utils.Error.ScanProblemError;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * 
 * @author Alex
 *
 */
public class TileEntityHousing extends TileEntity implements IHousing , IInventory{

	public int type;
	
	public static final int Empty = 0;
	public static final int Hovel = 1;
	public static final int Homstead = 2;
	public static final int House = 3;
	public static final int Apartment = 4;
	public static final int Null_Type = -1;
	public static final int HousingBlockScan = -2;
	
	public int[] availableTypes = {};
	
	public TileEntityHousing(int type){
		this.type = type;
	}
	
	
	
	public void updateEntity(){
		
		
		
		
		
		
	}
	
	
	
	

	
	@Override
	public int getType() {
		return this.type;
	}
	
	

	@Override
	public int[] getAreaOfEffect(int type) {
		if(type == this.Apartment){
			return new int[]{41,60,41};
		}
		if(type == this.House){
			return new int[]{41,60,41};
		}
		if(type == this.Homstead){
			return new int[]{41,60,41};
		}
		if(type == this.Hovel){
			return new int[]{15,15,15};
		}
		return new int[]{0,0,0};
	}
	
	
	@Override
	public void checkForUpdate() {
		if(this.scan(this.getAreaOfEffect(this.Apartment), HousingBlockScan)){
			 if(this.scan(HousingType.Apartment.getDimensionsToScan(), Apartment)){
				 this.type = this.Apartment;
			 } 
		}else if(this.scan(getAreaOfEffect(this.House), HousingBlockScan)){
			if(this.scan(HousingType.House.getDimensionsToScan(), House)){
				this.type = this.House;
			}
		}else if(this.scan(getAreaOfEffect(Homstead), HousingBlockScan)){
			if(this.scan(HousingType.Homstead.getDimensionsToScan(), Homstead)){
				this.type = this.Homstead;
			}
		}else if(this.scan(this.getAreaOfEffect(Hovel), HousingBlockScan)){
			if(this.scan(HousingType.Hovel.getDimensionsToScan(), Hovel)){
				this.type = Hovel;
			}
		}else{
			this.type = this.Empty;
			ErrorHandler.displayError(new ScanProblemError("ScanProblemError" , IError.ScanError_Category , "Error: Please check if there are housing blocks nearby or if u have all the blocks required for this operation"));
		}
	}
	
	
	
	@Override
	public boolean scan(int[] d , int ScanningFor) {
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
		if(this.yCoord >= 64){
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
		}
		if(ScanningFor == this.HousingBlockScan){
			if(blocks.containsKey(ModBlocks.housingBlock1) || blocks.containsKey(ModBlocks.housingBlock2) || blocks.containsKey(ModBlocks.housingBlock3) || blocks.containsKey(ModBlocks.housingBlock4) || blocks.containsKey(ModBlocks.housingBlock5)){
				return false;
			}else return true;
		}
		
		
		return false;
	}
	
	
	
	
	
	public boolean canBecomeApartment(HashMap map){
		//TODO
		return false;
	}
	
	public boolean canBecomeHomstead(HashMap map){
		//TODO
		return false;
	}
	
	public boolean canBecomeHouse(HashMap map){
		//TODO
		return false;
	}
	
	public boolean canBecomeHovel(HashMap map){
		//TODO
		return false;
	}


	
	
								/** HERE STARTS THE INVENTORY **/
	
	
	


	@Override
	public int getSizeInventory() {
		return this.type == 0? 0:2;
	}


	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO Auto-generated method stub
		return false;
	}



	
	
	
	
	
}

