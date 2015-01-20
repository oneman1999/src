package dxm.TileEntity.housing;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class HousingRecipes {

	HashMap<Integer , HashMap<ArrayList<ItemStack> , ArrayList<ItemStack>>> recipes = new HashMap<Integer , HashMap<ArrayList<ItemStack> , ArrayList<ItemStack>>>();
	
	public void registerRecipe(ArrayList<ItemStack> inputs, ArrayList<ItemStack> outputs, int type){
		HashMap<ArrayList<ItemStack> , ArrayList<ItemStack>>  hm = new HashMap<ArrayList<ItemStack>,ArrayList<ItemStack>>();
		hm.put(inputs, outputs);
		this.recipes.put(type, hm);
	}
	
	public static ArrayList makeArray(ItemStack ... stacks){
		ArrayList al = new ArrayList<ItemStack>();
		
		for(int i = 0; i<stacks.length;i++){
			al.add(stacks[i]);
		}
		
		return al;
	}
	
	
	
	
	public HousingRecipes(){
		//Add recipes like this
		//this recipe will search for 16 appples and 8 arrows and output 2 potatoes , this recipe can only be done in an Apartment block
		this.registerRecipe(makeArray(new ItemStack(Items.apple , 16) , new ItemStack(Items.arrow , 8)), makeArray(new ItemStack(Items.baked_potato , 2)), TileEntityHousing.Apartment);
		
	}

}
