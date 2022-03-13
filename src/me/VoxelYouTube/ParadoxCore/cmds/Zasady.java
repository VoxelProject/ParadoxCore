package me.VoxelYouTube.ParadoxCore.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.VoxelYouTube.ParadoxCore.main.Main;

public class Zasady implements CommandExecutor{

	Main plugin;
	
	public Zasady(Main m) {
		plugin = m;
		m.getCommand("zasady").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
		Player p = (Player) sender;
        if(args.length == 0) {
		    p.sendMessage(ChatColor.GREEN +  "---------------Zasady---------------");
			p.sendMessage(ChatColor.YELLOW +  "ustaw");
			p.sendMessage(ChatColor.YELLOW +  "ustaw");
			p.sendMessage(ChatColor.YELLOW +  "ustaw");
			p.sendMessage(ChatColor.YELLOW +  "ustaw");
			p.sendMessage(ChatColor.GREEN +  "---------------Zasady---------------");
        } else {
			p.sendMessage(plugin.getConfig().getString("zasady.baduse").replace("&", "§"));
		}
		return false;
	}

}