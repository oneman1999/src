package dxm.blocks;

import dxm.blocks.Housing.HousingBlock;
import dxm.library.DeusXMachina;
import dxm.utils.MinecraftHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static Block housingBlock1;
	public static Block housingBlock2;
	public static Block housingBlock3;
	public static Block housingBlock4;
	public static Block housingBlock5;
	   
	
	public static void setup() {
        createBlocks();

        registerBlocks();
    }
	
	
    /** initializing the Deus-Ex-Machina Blocks**/
    private static void createBlocks() {
    	           
    	housingBlock1 = new HousingBlock(HousingBlock.Empty);
    	housingBlock2 = new HousingBlock(HousingBlock.Apartment);
    	housingBlock3 = new HousingBlock(HousingBlock.Homstead);
    	housingBlock4 = new HousingBlock(HousingBlock.House);
    	housingBlock5 = new HousingBlock(HousingBlock.Hovel);
    	
    }
    
    /** registring the Deus-Ex-Machina Blocks**/
    private static void registerBlocks() {
       
    	
    	MinecraftHelper.registerBlock(housingBlock1);
    	MinecraftHelper.registerBlock(housingBlock2);
    	MinecraftHelper.registerBlock(housingBlock3);
    	MinecraftHelper.registerBlock(housingBlock4);
    	MinecraftHelper.registerBlock(housingBlock5);
    	
    }
}