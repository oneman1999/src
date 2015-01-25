package dxm.blocks;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import dxm.TileEntity.housing.HousingRecipes;

public class ModBlocks {

	public static Block housingBlock1;
	public static Block housingBlock2;
	public static Block housingBlock3;
	public static Block housingBlock4;
	public static Block housingBlock5;
	public static Block blockConcrete;
	public static Block blockMudbrick;
	
	   
	
	public static void setup() {
        createBlocks();
        registerMachineRecipes();
        registerBlocks();
    }
	
	private static void registerMachineRecipes(){
		new HousingRecipes();
	}
	
	
	
    /** initializing the Deus-Ex-Machina Blocks**/
    private static void createBlocks() {
    	           
    	housingBlock1 = new HousingBlock(HousingBlock.Empty);
    	housingBlock2 = new HousingBlock(HousingBlock.Apartment);
    	housingBlock3 = new HousingBlock(HousingBlock.Homstead);
    	housingBlock4 = new HousingBlock(HousingBlock.House);
    	housingBlock5 = new HousingBlock(HousingBlock.Hovel);
    	blockConcrete = new BlockConcrete();
    	blockMudbrick = new BlockMudbrick();
    }
    
    /** registring the Deus-Ex-Machina Blocks**/
    private static void registerBlocks() {
       
    	
    	registerBlock(housingBlock1, "Empty Housing");
    	registerBlock(housingBlock2 , "Apartment");
    	registerBlock(housingBlock3 , "Homstead");
    	registerBlock(housingBlock4 , "House");
    	registerBlock(housingBlock5 , "Hovel");
   // 	registerBlock(blockConcrete , "Concrete Block");
  // 	registerBlock(blockMudbrick , "Mudbrick");
    }
    
    /**The new Way to register a block 
     * 
     * @param block defined in this class
     * @param name that will be rendered on the players Screen
     */
    public static void registerBlock(Block block , String name){
    	GameRegistry.registerBlock(block, block.getUnlocalizedName());
    	LanguageRegistry.addName(block, name);
    }
}