package me.VoxelYouTube.ParadoxCore.cmds;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.VoxelYouTube.ParadoxCore.main.Main;

public class Unlock implements CommandExecutor {
    Main plugin;

    public Unlock(Main m) {
        plugin = m;
        m.getCommand("unlock").setExecutor(this);;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
        Player p = (Player) sender;
        UUID puuid = p.getUniqueId();
        FileConfiguration conf = plugin.getConfig();
        
        if(args.length == 1) {
            Player cel = Bukkit.getPlayer(args[0]);
            List<String> ignored = conf.getStringList(puuid + ".ignoredmessage");

            if(ignored == null) {
                ignored = new ArrayList<String>();
            }
            if(ignored.contains(cel.getDisplayName())) {
                ignored.remove(cel.getDisplayName());
                conf.set(puuid + ".ignoredmessage", ignored);
                p.sendMessage(conf.getString("msg.unlock.removeplayer").replace("&", "§").replace("{sender}", p.getDisplayName()).replace("{player}", cel.getDisplayName()));
                plugin.saveConfig();
            } else {
                p.sendMessage(conf.getString("msg.unlock.noplayeronlist").replace("&", "§").replace("{sender}", p.getDisplayName()).replace("{player}", cel.getDisplayName()));
            }
        } else {
            p.sendMessage(conf.getString("msg.unlock.baduse").replace("&", "§").replace("{sender}", p.getDisplayName()));
        }
        return false;
    }
}
