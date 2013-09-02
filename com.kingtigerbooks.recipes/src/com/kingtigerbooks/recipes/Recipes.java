package com.kingtigerbooks.recipes;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * New recipes for bukkit servers
 * @author gibsons
 *
 */
public class Recipes extends JavaPlugin {

	@Override
	public void onEnable() {
		// register event listeners
		getServer().getPluginManager().registerEvents(new BlockEventListener(), this);

		// add recipes
		addRecipes();
		super.onEnable();
	}
	
	/**
	 * Add the new recipes
	 */
	private void addRecipes() {
		
		Server server = getServer();
		
		// mossy cobblestone
		ItemStack result = new ItemStack(Material.MOSSY_COBBLESTONE);
		ShapelessRecipe recipe = new ShapelessRecipe(result);
		recipe.addIngredient(Material.COBBLESTONE).addIngredient(Material.VINE);
		server.addRecipe(recipe);
		
		// mossy stonebricks
		MaterialData materialData = new MaterialData(Material.SMOOTH_BRICK, (byte) 1);
		result = materialData.toItemStack(1);
		recipe = new ShapelessRecipe(result);
		recipe.addIngredient(Material.SMOOTH_BRICK).addIngredient(Material.VINE);
		server.addRecipe(recipe);
		
		// saddle
		ShapedRecipe shapedRecipe = new ShapedRecipe(new ItemStack(Material.SADDLE));
		shapedRecipe.shape(new String[] { "lll", "l l", "s s" }).setIngredient('l', Material.LEATHER).setIngredient('s', Material.STRING);
		server.addRecipe(shapedRecipe);
		
		// stone bricks from cracked stone bricks
		MaterialData crackedBricks = new MaterialData(Material.SMOOTH_BRICK, (byte) 2);
		result = new ItemStack(Material.SMOOTH_BRICK);
		FurnaceRecipe furnaceRecipe = new FurnaceRecipe(result, crackedBricks);
		server.addRecipe(furnaceRecipe);
		
		// circle stone bricks
		MaterialData circleBricks = new MaterialData(Material.SMOOTH_BRICK, (byte) 3);
		shapedRecipe = new ShapedRecipe(circleBricks.toItemStack(12));
		shapedRecipe.shape(new String[] {"sss", "sbs", "sss" }).setIngredient('s', Material.STONE).setIngredient('b', Material.SMOOTH_BRICK);
		server.addRecipe(shapedRecipe);
		
		// fire from flint and steel
		result = new ItemStack(Material.FIRE, 64);
		recipe = new ShapelessRecipe(result);
		recipe.addIngredient(Material.FLINT_AND_STEEL);
		server.addRecipe(recipe);
	}
}
