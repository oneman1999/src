package dxm.blocks;

import cpw.mods.fml.common.registry.LanguageRegistry;
import dxm.DeusXMachina;
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
       
    	
    	registerBlock(housingBlock1, "Empty Housing");
    	registerBlock(housingBlock2 , "Apartment");
    	registerBlock(housingBlock3 , "Homstead");
    	registerBlock(housingBlock4 , "House");
    	registerBlock(housingBlock5 , "Hovel");
    	
    	
    }
    
    /**The new Way to register a block 
     * 
     * @param block defined in this class
     * @param name that will be rendered on the players Screen
     */
    public static void registerBlock(Block block , String name){
    	MinecraftHelper.registerBlock(block);
    	LanguageRegistry.addName(block, name);
    }
}