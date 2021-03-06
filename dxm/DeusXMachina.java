package dxm;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dxm.blocks.ModBlocks;
import dxm.gui.DXMGuiHandler;
import dxm.items.ModItems;
import dxm.library.DXM_Info;

@Mod(modid = DXM_Info.MOD_ID , version = DXM_Info.VERSION , name = DXM_Info.MOD_FULL_NAME)

/**
 *  @author The Deus-Ex-Machina Modding Team
 */
public class DeusXMachina {

    @Instance(DXM_Info.MOD_ID)
    public static DeusXMachina instance;

    public final WorldGen worldGen = new WorldGen();
    public DXMGuiHandler guiHandler = new DXMGuiHandler();

    /** Creating The Deus-Ex-Machina Creative Tab **/
    public final CreativeTabs tab = (new CreativeTabs(DXM_Info.MOD_ID) {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.cobblestone);
        }
    });

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.setup();
        ModItems.setup();
    }
    

    @EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(worldGen, 1);
        NetworkRegistry.INSTANCE.registerGuiHandler(this,guiHandler );
    }
}