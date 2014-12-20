package dxm.blocks.Housing;

import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import dxm.DeusXMachina;
import dxm.TileEntity.housing.TileEntityHousing_Apartment;
import dxm.TileEntity.housing.TileEntityHousing_Homstead;
import dxm.TileEntity.housing.TileEntityHousing_House;
import dxm.TileEntity.housing.TileEntityHousing_Hovel;
import dxm.blocks.ModBlock;
import dxm.blocks.ModBlocks;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class HousingBlock extends BlockContainer {
	
	public static int meta;
	
	public static final int Empty = 0;
	public static final int Hovel = 1;
	public static final int Homstead = 2;
	public static final int House = 3;
	public static final int Apartment = 4;
	

	public HousingBlock(int type) {
		super(Material.iron);
		this.meta = type;
		this.setBlockName("blockHousing" + type);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	/** Creating a seperate TileEntity for every type of housing **/
	public TileEntity createNewTileEntity(World world , int meta){
		if(meta == this.Hovel){
			return new TileEntityHousing_Hovel();
		}
		if(meta == this.Homstead){
			return new TileEntityHousing_Homstead();
		}
		if(meta == this.House){
			return new TileEntityHousing_House();
		}
		if(meta == this.Apartment){
			return new TileEntityHousing_Apartment();
		}
		return null;
	}
	
	/** Makes any housing block drop the empty housing block **/
	 public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){
	        return Item.getItemFromBlock(ModBlocks.housingBlock1);
	 }
	 
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float a, float b, float c){
		 if(!world.isRemote){
			 int guiID = (meta == this.Apartment? 0 : ( meta == this.Homstead ? 1 : (meta == this.Hovel ? 2 :( meta == this.House? 3 : -1))));
			 if(guiID != -1){
				 player.openGui(DeusXMachina.instance, guiID, world, x, y, z);
			 }
		 }
		 return false;
	 }
	 

}
