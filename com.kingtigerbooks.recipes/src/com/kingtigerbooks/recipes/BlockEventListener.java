package com.kingtigerbooks.recipes;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

/**
 * Change what happens when some blocks break
 * @author gibsons
 *
 */
public class BlockEventListener implements Listener {

	@EventHandler
	public void onBlockEvent(BlockBreakEvent e)
	{
		// TODO: TNT explosions seem to give both blocks
		// determine if stone block is what is broken
		Block block = e.getBlock();
		if (block.getType() == Material.SMOOTH_BRICK) {
			block.setType(Material.AIR);
			
			// check to see if this is by a player and if with the correct tool
			Player player = e.getPlayer();
			if (player == null || playerHoldingRightTool(player)) {
				MaterialData materialData = new MaterialData(Material.SMOOTH_BRICK, (byte) 2);
				ItemStack items = materialData.toItemStack(1);
				World world = block.getWorld();
				world.dropItem(block.getLocation(), items);
			}
		}
	}
	
	private boolean playerHoldingRightTool(Player player) {
		
		// returns true if player holding stone pick, iron pick, gold pick, diamond pick
		Material type  = player.getItemInHand().getType();
		return type == Material.STONE_PICKAXE || type == Material.IRON_PICKAXE || type == Material.GOLD_PICKAXE || type == Material.DIAMOND_PICKAXE;
	}
}