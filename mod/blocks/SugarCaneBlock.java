package net.DD.mod.blocks;

import net.DD.mod.lib.BlockConf;
import net.DD.mod.lib.Version;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

	public class SugarCaneBlock extends Block {
		
		public SugarCaneBlock (int id) {
			super(BlockConf.SUGARCANEBLOCK_ID, Material.ground);
			setResistance(2);
			setHardness(0.5F);
			setStepSound(Block.soundGrassFootstep);
		    setUnlocalizedName(BlockConf.SUGARCANEBLOCK_ULOC_NAME);
		    setCreativeTab(CreativeTabs.tabBlock);
		}
		
		//Declare the textures for use
		@SideOnly(Side.CLIENT)
		public static Icon topIcon;
		@SideOnly(Side.CLIENT)
		public static Icon bottomIcon;
		@SideOnly(Side.CLIENT)
		public static Icon sideIcon;
		
		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister icon) {
		topIcon = icon.registerIcon(Version.MOD_ID + ":" + BlockConf.SUGARCANEBLOCK_TEXTURE_TOP);
		bottomIcon = icon.registerIcon(Version.MOD_ID + ":" + BlockConf.SUGARCANEBLOCK_TEXTURE_TOP);
		sideIcon = icon.registerIcon(Version.MOD_ID + ":" + BlockConf.SUGARCANEBLOCK_TEXTURE_SIDE);
		}	
		
		
		//tell our block which texture to display on which side
		@Override
		@SideOnly(Side.CLIENT)
		public Icon getIcon(int side, int metadata) {
		if(side == 0) {
		return bottomIcon;
		} else if(side == 1) {
		return topIcon;
		} else {
		return sideIcon;
		}
		}
	}
	
	


