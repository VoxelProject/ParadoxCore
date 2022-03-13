package me.VoxelYouTube.ParadoxCore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.VoxelYouTube.ParadoxCore.main.Main;
import me.VoxelYouTube.ParadoxCore.system.TitleAPI;

public class BroadCast implements CommandExecutor{    
    Main plugin;

    public BroadCast(Main m) {
        plugin = m;
        m.getCommand("broadcast").setExecutor(this);;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
        Player p = (Player) sender;
        //UUID puuid = p.getUniqueId();
        FileConfiguration conf = plugin.getConfig();
        Player target = Bukkit.getPlayer(args[1]);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for(int i = 1; i < args.length; i++) {
            sb.append(args[i] + conf.getString("titlebar.command.pausebetweenwords").replace("&", "§"));
        }
        for(int e = 2; e < args.length; e++) {
            sb1.append(args[e] + conf.getString("titlebar.command.pausebetweenwords").replace("&", "§"));
        }
        String msg = sb.toString().replace("&", "§");
        String msg1 = sb1.toString().replace("&", "§");
        String er = args[1];
        if(args.length > 2) {
            if(args[0].equalsIgnoreCase("sendtitle")) {
                if(target == null) {
                    p.sendMessage(conf.getString("titlebar.command.noplayer").replace("&", "§").replace("{target}", er));
                } else {
                    TitleAPI.sendTitle(target , msg1);
                }
            } else {
                if(args[0].equalsIgnoreCase("sendactionbar")) {
                    if(target == null) {
                        p.sendMessage(conf.getString("titlebar.command.noplayer").replace("&", "§").replace("{target}", er));
                    } else {
                        TitleAPI.sendActionbar(target, msg1);
                    }
                } else {
                    if(args[0].equalsIgnoreCase("sendserver")) {
                        if(target == null) {
                            p.sendMessage(conf.getString("titlebar.command.noplayer").replace("&", "§").replace("{target}", er));
                        } else {
                            TitleAPI.sendBroadCast(msg);
                        }
                    } else {
                        p.sendMessage(conf.getString("titlebar.command.badconstrution").replace("&", "§"));
                    }
                }
            }
        } else {
            p.sendMessage(conf.getString("titlebar.command.badconstrution").replace("&", "§"));
        }
        return false;
    }
}
