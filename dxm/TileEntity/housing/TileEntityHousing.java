package dxm.TileEntity.housing;

import java.util.ArrayList;
import java.util.HashMap;

import dxm.blocks.HousingBlock;
import dxm.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * 
 * @author oneman1999
 *
 */
public class TileEntityHousing extends TileEntity implements IHousing , IInventory{

	
	public boolean scanError = false;
	
	public int type;
	
	public static final int Empty = 0;
	public static final int Hovel = 1;
	public static final int Homstead = 2;
	public static final int House = 3;
	public static final int Apartment = 4;
	public static final int Null_Type = -1;
	public static final int HousingBlockScan = -2;
	
	public ItemStack[] slots = new ItemStack[18];
	
	public boolean isInputSlot(int slot){
		return slot < 9;
	}
	
	public int getBlockContained(Block block , HashMap<Block , Integer> map){
		if(map.containsKey(block)){
			return map.get(block);
		}
		
		return 0;
	}
	
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
			this.scanError = true;
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
		
		if(ScanningFor == this.Apartment){
			this.scanError = this.canBecomeApartment(blocks);
			return scanError;
		}
		if(ScanningFor == this.Homstead){
			this.scanError = this.canBecomeHomstead(blocks);
			return scanError;
		}
		if(ScanningFor == this.House){
			this.scanError = this.canBecomeHouse(blocks);
			return scanError;
		}
		if(ScanningFor == this.Hovel){
			this.scanError = this.canBecomeHovel(blocks);
			return scanError;
		}
		if(ScanningFor == this.HousingBlockScan){
			if(blocks.containsKey(ModBlocks.housingBlock1) || blocks.containsKey(ModBlocks.housingBlock2) || blocks.containsKey(ModBlocks.housingBlock3) || blocks.containsKey(ModBlocks.housingBlock4) || blocks.containsKey(ModBlocks.housingBlock5)){
				return false;
			}else {
				this.scanError = false;
				return true;
			}
		}
		
		
		return false;
	}
	
	public int getSumOfBlocksFound( HashMap<Block,Integer> map , Block ... block){
		
		int Sum = 0;
		
		for(Block b : block){
			if(map.containsKey(b)){
				Sum += map.get(b); 
			}
		}
		
		return Sum;
	}
	
	
	
	public boolean canBecomeApartment(HashMap map){
		if(this.getBlockContained(ModBlocks.blockConcrete, map) >= 4600){
			if(this.getBlockContained(Blocks.glass, map )>= 200){
				if(this.getBlockContained(Blocks.planks, map) >= 800){
					if(this.getBlockContained(Blocks.bed, map) >= 32){
						if(this.getBlockContained(Blocks.furnace, map) >= 8){
							if(this.getSumOfBlocksFound(map, Blocks.wooden_door , Blocks.iron_door) >= 12){
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean canBecomeHouse(HashMap map){
		if(this.getSumOfBlocksFound(map, Blocks.stonebrick , Blocks.brick_block) >= 2100){
			if(this.getSumOfBlocksFound(map, Blocks.glass , Blocks.glass_pane) >= 100){
				if(this.getSumOfBlocksFound(map, Blocks.log , Blocks.log2 , Blocks.planks) >= 600){
					if(this.getBlockContained(Blocks.bed, map) >= 16){
						if(this.getBlockContained(Blocks.furnace, map)>= 8){
							if(this.getSumOfBlocksFound(map, Blocks.wooden_door , Blocks.iron_door) >= 8){
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean canBecomeHomstead(HashMap map){
		if(this.getSumOfBlocksFound(map, Blocks.cobblestone , Blocks.brick_block , Blocks.stonebrick) >= 500){
			if(this.getSumOfBlocksFound(map, Blocks.log , Blocks.log2 , Blocks.planks) >= 300){
				if(this.getBlockContained(Blocks.farmland, map) >= 300){
					if(this.getBlockContained(Blocks.wheat, map) >= 300){
						if(this.getBlockContained(Blocks.bed, map) >= 4){
							if(this.getBlockContained(Blocks.furnace, map) >= 4){
								if(this.getSumOfBlocksFound(map, Blocks.wooden_door , Blocks.iron_door) >= 1){
									return true;
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean canBecomeHovel(HashMap map){
		if(this.getSumOfBlocksFound(map, Blocks.log , Blocks.log2 , Blocks.planks) >= 300){
			if(this.getSumOfBlocksFound(map, Blocks.stonebrick , Blocks.cobblestone , Blocks.brick_block , ModBlocks.blockMudbrick) >= 500){
				if(this.getBlockContained(Blocks.bed, map) >= 4){
					if(this.getBlockContained(Blocks.furnace , map) >= 4){
						if(this.getSumOfBlocksFound(map, Blocks.wooden_door , Blocks.iron_door) >= 1){
							return true;
						}
					}
				}
			}
		}
		return false;
	}


	
	
								/** HERE STARTS THE INVENTORY **/
	
	
	


	@Override
	public int getSizeInventory() {
		return this.type == 0? 0:2;
	}


	@Override
	public ItemStack getStackInSlot(int i) {
		return slots[i];
	}


	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		 if (this.slots[p_70298_1_] != null)
	        {
	            ItemStack itemstack;

	            if (this.slots[p_70298_1_].stackSize <= p_70298_2_)
	            {
	                itemstack = this.slots[p_70298_1_];
	                this.slots[p_70298_1_] = null;
	                this.markDirty();
	                return itemstack;
	            }
	            else
	            {
	                itemstack = this.slots[p_70298_1_].splitStack(p_70298_2_);

	                if (this.slots[p_70298_1_].stackSize == 0)
	                {
	                    this.slots[p_70298_1_] = null;
	                }

	                this.markDirty();
	                return itemstack;
	            }
	        }
	        else
	        {
	            return null;
	        }
	}


	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		if (this.slots[p_70304_1_] != null)
        {
            ItemStack itemstack = this.slots[p_70304_1_];
            this.slots[p_70304_1_] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
	}


	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		this.slots[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
        {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
	}


	@Override
	public String getInventoryName() {
		return "";
	}


	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}


	@Override
	public int getInventoryStackLimit() {
		return 64;
	}


	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
	    return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : p_70300_1_.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}


	@Override
	public void openInventory() {}


	@Override
	public void closeInventory() {}


	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return true;
	}



										/** CRAFTING **/
	
	static HashMap<ArrayList<ItemStack>,ArrayList<ItemStack>> recipes = new HashMap<ArrayList<ItemStack>,ArrayList<ItemStack>>();
	
	public static void registerRecipe(ArrayList<ItemStack> inputs , ArrayList<ItemStack> outputs){
		recipes.put(inputs, outputs);
	}
	
	public static ArrayList makeArray(ItemStack ... stacks){
		ArrayList al = new ArrayList<ItemStack>();
		
		for(int i = 0; i<stacks.length;i++){
			al.add(stacks[i]);
		}
		
		return al;
	}
	
	public static ItemStack makeStack( int Size , Item item){
		return new ItemStack(item , Size);
	}
	
	public boolean getRecipeMaches(){
		for(int i = 0; i<slots.length /2;i++){
			
		}
			
		
		
		return false;
	}
	
	
	
	
}

