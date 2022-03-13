package me.VoxelYouTube.ParadoxCore.cmds;

import java.util.UUID;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.VoxelYouTube.ParadoxCore.main.Main;

public class Msg implements CommandExecutor{

    Main plugin;
    

    public Msg(Main m) {
        plugin = m;
        m.getCommand("msg").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
        Player p = (Player) sender;
        UUID puuid = p.getUniqueId();
        FileConfiguration conf = plugin.getConfig();

        if(args.length >= 2) {
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < args.length; i++) {
                sb.append(args[i]).append(conf.getString("msg.pausebetweenwords"));
            }

            String msg = sb.toString();

            Player cel = Bukkit.getPlayerExact(args[0]);
            UUID celuuid = cel.getUniqueId();

			List<String> celIgnored = conf.getStringList(celuuid + ".ignoredmessage");

            if(!celIgnored.contains(p.getDisplayName())) {
				//p.sendMessage("&8[&ety -> &6" + cel.getDisplayName() + "&8] &e" + msg);
				p.sendMessage(conf.getString("msg.msgtome").replace("&", "§").replace("{msg}", msg).replace("{recipient}", cel.getDisplayName()).replace("{sender}", p.getDisplayName()));
                //cel.sendMessage("&8[&e" + p.getDisplayName() + "&6 -> ty&8] &e" + msg);
                cel.sendMessage(conf.getString("msg.msgtoplayer").replace("&", "§").replace("{msg}", msg).replace("{recipient}", cel.getDisplayName()).replace("{sender}", p.getDisplayName()));
                conf.set(puuid + ".lastConversation", cel.getDisplayName());
                plugin.saveConfig();
            } else {
                p.sendMessage(conf.getString("msg.isignored").replace("&", "§").replace("{sender}", p.getDisplayName()).replace("{recipient}", cel.getDisplayName()));
            }
        } else {
            p.sendMessage(conf.getString("msg.badconstrutions").replace("&", "§"));
        }
        return false;
    }
    
}
