package me.VoxelYouTube.ParadoxCore.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.VoxelYouTube.ParadoxCore.main.Main;
import me.VoxelYouTube.ParadoxCore.system.BosBarAPI;

public class onJoin implements Listener {
	
	BosBarAPI bar;
	Main plugin;
	
	public onJoin(Main m) {
		plugin = m;
		bar = new BosBarAPI(plugin);
		bar.createBar();
	}
	
	//@SuppressWarnings("static-access")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		e.setJoinMessage(format(plugin.getConfig().getString("joinserver.messages").replace("{player}", p.getDisplayName())));
		
		if(!bar.getBar().getPlayers().contains(p)) {
			bar.addPlayer(p);
		}
	}
	private String format(String msg) {
        return msg.replace("&", "§");
    }
}
