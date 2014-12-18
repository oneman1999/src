package dxm.blocks;

import dxm.blocks.Housing.HousingBlock;
import dxm.library.DeusXMachina;
import dxm.utils.MinecraftHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static Block housingBlock;
   
	
	public static void setup() {
        createBlocks();

        registerBlocks();
    }
	
	
    /** initializing the Deus-Ex-Machina Blocks**/
    private static void createBlocks() {
    	           
    	housingBlock = new HousingBlock(HousingBlock.Empty);
    	housingBlock = new HousingBlock(HousingBlock.Apartment);
    	housingBlock = new HousingBlock(HousingBlock.Homstead);
    	housingBlock = new HousingBlock(HousingBlock.House);
    	housingBlock = new HousingBlock(HousingBlock.Hovel);
    	
    }
    
    /** registring the Deus-Ex-Machina Blocks**/
    private static void registerBlocks() {
       
    	
    	MinecraftHelper.registerBlock(housingBlock);
    	
    }
}