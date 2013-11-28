package net.DD.mod;

import net.DD.mod.blocks.SugarCaneBlock;
import net.DD.mod.lib.BlockConf;
import net.DD.mod.lib.Version;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = Version.MOD_ID,
name = Version.MOD_NAME,
version = Version.MOD_VERSION)

@NetworkMod(clientSideRequired=true)
public class WoodModConf {
	
	//Set the SugarCaneBlock In forge + any parameters
	public final static Block SugarCaneBlock = new SugarCaneBlock(BlockConf.SUGARCANEBLOCK_ID);
	
	 // The instance of your mod that Forge uses.
    @Instance(Version.MOD_ID)
    public static WoodModConf instance;
   
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="net.DD.mod.client.ClientProxy", serverSide="net.DD.mod.CommonProxy")
    public static CommonProxy proxy;
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    	
    	
    }
   
    @EventHandler
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();
            
            
            MinecraftForge.EVENT_BUS.register(new CustomDrops());
            
          //register the Sugar Cane block with MC forge
            GameRegistry.registerBlock(SugarCaneBlock, BlockConf.SUGARCANEBLOCK_ULOC_NAME);
           LanguageRegistry.addName(SugarCaneBlock, BlockConf.SUGARCANEBLOCK_NAME);
            
            
            //ender dragon egg recipe
            ItemStack dragonEggStack = new ItemStack(Block.dragonEgg);
            GameRegistry.addRecipe(dragonEggStack, "XXX" ,"XYX", "XXX",
            		'X',Block.obsidian , 'Y',Item.netherStar);
            
            //Block of melon to slices
            ItemStack MelonSlice = new ItemStack(Item.melon,9);
            GameRegistry.addShapelessRecipe(MelonSlice, Block.melon);
            
            //SugarCane Block to Sugarcane
            ItemStack Sugarcane = new ItemStack(Item.reed,9);
            GameRegistry.addShapelessRecipe(Sugarcane, SugarCaneBlock);
            
            // SugarCane block
            ItemStack sugarblockStack = new ItemStack(SugarCaneBlock,1);
            GameRegistry.addRecipe(sugarblockStack, "XXX", "XXX", "XXX",
            		'X', Item.reed); //Where the fuck is sugarcane aka Reed

    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }
}