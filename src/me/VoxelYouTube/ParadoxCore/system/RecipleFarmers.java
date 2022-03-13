package me.VoxelYouTube.ParadoxCore.system;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.VoxelYouTube.ParadoxCore.main.Main;

public class RecipleFarmers {
	
	static Main plugin;
	public static ItemStack boyFarmer;
	public static ItemStack sanderx;
	public static ItemStack koparka;
	
	public RecipleFarmers(Main m) {
		plugin = m;
	}
	
	public static void setRecipe() {
		//String conf = plugin.getConfig();
		ItemStack item = new ItemStack(Material.OBSIDIAN, 1);
		ItemMeta meta = item.getItemMeta();
		ItemStack item2 = new ItemStack(Material.SANDSTONE, 1);
		ItemMeta meta2 = item2.getItemMeta();
		ItemStack item3 = new ItemStack(Material.CLAY, 1);
		ItemMeta meta3 = item3.getItemMeta();
		
		meta.setDisplayName(ChatColor.GREEN + "BoyFarmer");
		meta2.setDisplayName(ChatColor.GREEN + "sand");
		meta3.setDisplayName(ChatColor.GREEN + "kopacz");
		
		ArrayList<String> lore = new ArrayList<String>();
		ArrayList<String> lore2 = new ArrayList<String>();
		ArrayList<String> lore3 = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Postaw ten przedmiot na ziemi\nelo");
		lore.add(ChatColor.GRAY + "by wygenerowac obsydian do samego dolu.");

		lore2.add(ChatColor.GRAY + "Postaw ten przedmiot na ziemi\nelo");
		lore2.add(ChatColor.GRAY + "by wygenerowac piasek do samego dolu.");

		lore3.add(ChatColor.GRAY + "Postaw ten przedmiot na ziemi\nelo");
		lore3.add(ChatColor.GRAY + "by wygenerowac powietrze do samego dolu.");
		
		meta.setLore(lore);
		item.setItemMeta(meta);

		meta2.setLore(lore2);
		item2.setItemMeta(meta2);

		meta3.setLore(lore3);
		item3.setItemMeta(meta3);
		
		boyFarmer = item;
		sanderx = item2;
		koparka = item3;

		ItemStack boyka = new ItemStack(item);
		ItemStack sander = new ItemStack(item2);
		ItemStack kop = new ItemStack(item3);

		ShapedRecipe rec = new ShapedRecipe(boyka);
		ShapedRecipe rec2 = new ShapedRecipe(sander);
		ShapedRecipe rec3 = new ShapedRecipe(kop);
		//rec.shape("%B%","%B%","%B%");

		//rec.setIngredient('%', Material.SUGAR);
		//rec.setIngredient('B', Material.GLASS_BOTTLE);
		
		rec.shape("123", "456", "789");
		rec2.shape("123", "456", "789");
		rec3.shape("123", "456", "789");
		
		rec.setIngredient('1', Material.OBSIDIAN);
		rec.setIngredient('2', Material.OBSIDIAN);
		rec.setIngredient('3', Material.OBSIDIAN);
		rec.setIngredient('4', Material.OBSIDIAN);
		rec.setIngredient('5', Material.GOLDEN_APPLE);
		rec.setIngredient('6', Material.OBSIDIAN);
		rec.setIngredient('7', Material.OBSIDIAN);
		rec.setIngredient('8', Material.OBSIDIAN);
		rec.setIngredient('9', Material.OBSIDIAN);

		rec2.setIngredient('1', Material.SAND);
		rec2.setIngredient('2', Material.SAND);
		rec2.setIngredient('3', Material.SAND);
		rec2.setIngredient('4', Material.SAND);
		rec2.setIngredient('5', Material.GOLDEN_APPLE);
		rec2.setIngredient('6', Material.SAND);
		rec2.setIngredient('7', Material.SAND);
		rec2.setIngredient('8', Material.SAND);
		rec2.setIngredient('9', Material.SAND);

		rec3.setIngredient('1', Material.STONE);
		rec3.setIngredient('2', Material.STONE);
		rec3.setIngredient('3', Material.STONE);
		rec3.setIngredient('4', Material.STONE);
		rec3.setIngredient('5', Material.GOLDEN_APPLE);
		rec3.setIngredient('6', Material.STONE);
		rec3.setIngredient('7', Material.STONE);
		rec3.setIngredient('8', Material.STONE);
		rec3.setIngredient('9', Material.STONE);
		
		plugin.getServer().addRecipe(rec);
		plugin.getServer().addRecipe(rec2);
		plugin.getServer().addRecipe(rec3);

	}
	
	public static ItemStack getBoyMeta() {
		return boyFarmer;
	}
	public static ItemStack getSandMeta() {
		return sanderx;
	}
	public static ItemStack getMineMeta() {
		return koparka;
	}
}
