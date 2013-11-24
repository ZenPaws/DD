package net.DD.mod;

import net.DD.mod.lib.Version;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
	
	//Add a block (Golden Wood)
	public final static Block GoldenWood = new GoldenWood
			(500, Material.wood).setHardness(3)
			.setStepSound(Block.soundWoodFootstep)
			.setUnlocalizedName("Golden Wood")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setTextureName("woodmod:log_golden");
			

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
            
            //Blocks + crafting in the game goes in here
            ItemStack dirtStack = new ItemStack(Block.dirt,2); // This 2 doesn't do shit
            ItemStack redstoneStack = new ItemStack(Item.redstone,64);
            ItemStack WoolWhiteStack = new ItemStack(Block.cloth,1,2);
            
            GameRegistry.addShapelessRecipe(redstoneStack,dirtStack,dirtStack); // The 2 dirtStack's makes it so you need 2 dirt
            GameRegistry.addShapelessRecipe(redstoneStack,WoolWhiteStack,dirtStack);
            
            GameRegistry.registerBlock(GoldenWood, "Golden Wood");
            LanguageRegistry.addName(GoldenWood, "Golden Wood");
            
            
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }
}