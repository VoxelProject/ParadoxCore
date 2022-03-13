package me.VoxelYouTube.ParadoxCore.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.VoxelYouTube.ParadoxCore.main.Main;

public class onLeave implements Listener {
    Main plugin;
    public onLeave(Main m) {
        m = plugin;
    }
    @EventHandler
	public void onPlayerJoin() {
		//Player p = e.getPlayer();
		
		//e.setJoinMessage(format(plugin.getConfig().getString("leaveserver.messages").replace("{player}", p.getDisplayName())));
		
		
	}
	/*/private String format(String msg) {
        return msg.replace("&", "§");
    }/*/
}
