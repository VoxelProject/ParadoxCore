package me.VoxelYouTube.ParadoxCore.events;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import me.VoxelYouTube.ParadoxCore.main.Main;
import me.VoxelYouTube.ParadoxCore.system.RecipleFarmers;

public class onPlaceFarmers implements Listener {
	Main plugin;
	public onPlaceFarmers(Main m) {
		plugin = m;
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlaceboyfarmerekx(BlockPlaceEvent e) {
		FileConfiguration conf = plugin.getConfig();
		Player p = e.getPlayer();
		Block b = e.getBlock();
		UUID uuid = p.getUniqueId();
		
		if(e.getItemInHand().getItemMeta().equals(RecipleFarmers.getBoyMeta().getItemMeta())) {
			p.sendMessage(format(conf.getString("boyfarmer.placemessage")));
			
			// x = 1 y = 100 z = 1 
			
			for(int i = b.getY(); i > 0; i--) {
				Location loc = new Location(p.getLocation().getWorld(), b.getX(), i, b.getZ());
				loc.getBlock().setType(Material.OBSIDIAN);
			}
		} else {
			if(e.getItemInHand().getItemMeta().equals(RecipleFarmers.getSandMeta().getItemMeta())) {
				p.sendMessage(format(conf.getString("sandfarmer.placemessage")));
				for(int i2 = b.getY(); i2 > 0; i2--) {
					Location loc2 = new Location(p.getLocation().getWorld(), b.getX(), i2, b.getZ());
					loc2.getBlock().setType(Material.SAND);
				}
			} else {
				if(e.getItemInHand().getItemMeta().equals(RecipleFarmers.getMineMeta().getItemMeta())) {
					p.sendMessage(format(conf.getString("kopaczfosy.placemessage")));
					p.sendMessage(uuid);
					for(int i3 = b.getY(); i3 > 0; i3--) {
						Location loc3 = new Location(p.getLocation().getWorld(), b.getX(), i3, b.getZ());
						loc3.getBlock().setType(Material.AIR);
					}
				}
			}
		}

		
	}
	private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

