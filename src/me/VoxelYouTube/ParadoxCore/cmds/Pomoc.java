package me.VoxelYouTube.ParadoxCore.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.VoxelYouTube.ParadoxCore.main.Main;

public class Pomoc implements CommandExecutor{

	Main plugin;
	
	public Pomoc(Main m) {
		plugin = m;
		m.getCommand("pomoc").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
		Player p = (Player) sender;
        if(args.length == 0) {
		    p.sendMessage(ChatColor.GREEN +  "---------------Pomoc---------------");
			p.sendMessage(ChatColor.YELLOW +  "/drop - otwiera drop z kamienia");
			p.sendMessage(ChatColor.YELLOW +  "/fly - latanie bez gm1");
			p.sendMessage(ChatColor.YELLOW +  "/gm1 - zmienia gm z 0 na 1");
			p.sendMessage(ChatColor.YELLOW +  "/drop - drop z kamienia");
			p.sendMessage(ChatColor.GREEN +  "---------------Pomoc---------------");
        } else {
			p.sendMessage(plugin.getConfig().getString("pomoc.baduse").replace("&", "§"));
		}
		return false;
	}

}