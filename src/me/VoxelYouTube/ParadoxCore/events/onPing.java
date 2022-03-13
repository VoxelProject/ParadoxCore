package me.VoxelYouTube.ParadoxCore.events;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.VoxelYouTube.ParadoxCore.main.Main;

public class onPing implements Listener{
    Main plugin;
    
    public onPing(Main m) {
        plugin = m;
    }

    @EventHandler
    public void on(ServerListPingEvent e) {
        FileConfiguration conf = plugin.getConfig();
        int Maxp = conf.getInt("motd.maxplayers");
        String Motd = format(conf.getString("motd.motd"));
        e.setMotd(Motd);
        e.setMaxPlayers(Maxp);
        
    }
    
    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
