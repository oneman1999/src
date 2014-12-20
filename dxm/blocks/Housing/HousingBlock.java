package dxm.blocks.Housing;

import java.util.Random;

import dxm.TileEntity.housing.TileEntityHousing_Apartment;
import dxm.TileEntity.housing.TileEntityHousing_Homstead;
import dxm.TileEntity.housing.TileEntityHousing_House;
import dxm.TileEntity.housing.TileEntityHousing_Hovel;
import dxm.blocks.ModBlock;
import dxm.blocks.ModBlocks;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class HousingBlock extends BlockContainer {
	
	public static int type;
	
	public static final int Empty = 0;
	public static final int Hovel = 1;
	public static final int Homstead = 2;
	public static final int House = 3;
	public static final int Apartment = 4;
	

	public HousingBlock(int type) {
		super(Material.iron);
		this.type = type;
	}
	
	/** Creating a seperate TileEntity for every type of housing **/
	public TileEntity createNewTileEntity(World world , int i){
		if(this.type == this.Hovel){
			return new TileEntityHousing_Hovel();
		}
		if(this.type == this.Homstead){
			return new TileEntityHousing_Homstead();
		}
		if(this.type == this.House){
			return new TileEntityHousing_House();
		}
		if(this.type == this.Apartment){
			return new TileEntityHousing_Apartment();
		}
		return null;
	}
	
	/** Makes any housing block drop the empty housing block **/
	 public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){
	        return Item.getItemFromBlock(ModBlocks.housingBlock1);
	 }

}
