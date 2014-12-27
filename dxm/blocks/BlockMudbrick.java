package dxm.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class BlockMudbrick extends Block {

	protected BlockMudbrick() {
		super(Material.gourd);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

}
