package dxm.blocks.Housing;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import dxm.DeusXMachina;
import dxm.TileEntity.housing.TileEntityHousing;
import dxm.blocks.ModBlocks;
import dxm.gui.GuiIDs;
import dxm.library.DXM_Info;

public class HousingBlock extends BlockContainer {
	
	public static int meta;
	
	public static final int Empty = 0;
	public static final int Hovel = 1;
	public static final int Homstead = 2;
	public static final int House = 3;
	public static final int Apartment = 4;
	
	private DataWatcher dw;
	
	/**
	 * Constructor for initializing the block
	 * @param type
	 */
	public HousingBlock(int type) {
		super(Material.iron);
		this.meta = type;
		this.setBlockName("blockHousing" + type);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	/** Creating a seperate TileEntity for every type of housing **/
	public TileEntity createNewTileEntity(World world , int meta){
		return new TileEntityHousing(this.meta);
	}
	
	/** Makes any housing block drop the empty housing block **/
	 public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){
	        return Item.getItemFromBlock(ModBlocks.housingBlock1);
	 }
	 
	 /**
	  * Opens The Gui when the block is right-clicked.
	  * returns false if the block is an Empty Housing
	  */
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float a, float b, float c){
		 if(!world.isRemote){
			if(meta != 0){
				 player.openGui(DeusXMachina.instance, GuiIDs.Housing, world, x, y, z);
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 /**
	  * IIcons!!
	  * @param icon register
	  */
	 public void registerIIcons(IIconRegister ir){
		 this.blockIcon = ir.registerIcon(DXM_Info.MOD_ID + ":" + "Housing_" + "meta");
	 }

}
