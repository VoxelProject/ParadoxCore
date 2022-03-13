package me.VoxelYouTube.ParadoxCore.cmds;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.VoxelYouTube.ParadoxCore.main.Main;

public class Replay implements CommandExecutor{
    Main plugin;

    public Replay(Main m) {
        plugin = m;
        m.getCommand("r").setExecutor(this);;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
        FileConfiguration conf = plugin.getConfig();
        Player p = (Player)sender;
        UUID puuid = p.getUniqueId();
        
        if(args.length >= 1) {
            StringBuilder sb = new StringBuilder();
			for(int i = 0; i < args.length; ++i) {
				sb.append(args[i]).append(conf.getString("msg.pausebetweenwords"));
			}

            String msg = sb.toString();
            Player cel = Bukkit.getPlayer(conf.getString(puuid + ".lastConversation"));
            UUID celuuid = cel.getUniqueId();
			List<String> celIgnored = conf.getStringList(celuuid + ".ignoredmessage");

            if(!celIgnored.contains(p.getDisplayName())) {
                p.sendMessage(conf.getString("msg.msgtome").replace("&", "§").replace("{msg}", msg).replace("{recipient}", cel.getDisplayName()).replace("{sender}", p.getDisplayName()));
                cel.sendMessage(conf.getString("msg.msgtoplayer").replace("&", "§").replace("{msg}", msg).replace("{recipient}", cel.getDisplayName()).replace("{sender}", p.getDisplayName()));
            } else {
                p.sendMessage(conf.getString("msg.isignored").replace("&", "§").replace("{sender}", p.getDisplayName()).replace("{recipient}", cel.getDisplayName()));
            }
        } else {
            p.sendMessage(conf.getString("msg.badconstrutions").replace("&", "§"));
        }
        return false;
    }
}
