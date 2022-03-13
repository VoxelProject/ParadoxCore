package me.VoxelYouTube.ParadoxCore.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

import me.VoxelYouTube.ParadoxCore.main.Main;

public class onPlayerCommand implements Listener {
	Main plugin;
	public onPlayerCommand(Main plugin) {
		this.plugin = plugin;
    }

    @EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        Player p =e.getPlayer();
		String msg = e.getMessage().split(" ") [0];
		FileConfiguration conf = plugin.getConfig();
		HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
		if(topic == null) {
			p.sendMessage(format(conf.getString("nothiscommand")).replace("{command}", msg));
			e.setCancelled(true);
		}
	}
	private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
