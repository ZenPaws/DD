package net.DD.mod;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.item.Item;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class CustomDrops {

	 public static double rand;
	   
	   @ForgeSubscribe
	   public void onEntityDrop(LivingDropsEvent event) {
	         if (event.entityLiving instanceof EntityBat){
	        	 
	            rand = Math.random();
	                            
	            if (rand < 0.3D) {
	               event.entityLiving.dropItem(Item.brick.itemID, 2);
	            }
	            else if (rand < 0.4D)
	            {
	            	event.entityLiving.dropItem(Item.brick.itemID, 1);
	            }
	         }
	      }

}
