package me.VoxelYouTube.ParadoxCore.system;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TitleAPI {
	
	public static void sendTitle(Player p, String text) {
		p.sendTitle(text, "This is a test.", 0, 128, 0);
	}
	
	public static void sendActionbar(Player p, String text) {
        //p.sendRawMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(text));
    }
	
	public static void sendBroadCast(String text) {
		for(Player players : Bukkit.getOnlinePlayers()) {
			players.sendMessage(text);
		}
	}
	
}
