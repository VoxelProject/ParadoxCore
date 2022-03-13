package me.VoxelYouTube.ParadoxCore.system;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import me.VoxelYouTube.ParadoxCore.main.Main;

public class BosBarAPI {
	
	Main plugin;
	
	private int taskID = -1;
	private BossBar bar;
	
	public BosBarAPI(Main m) {
		plugin = m;
	}
	
	public void addPlayer(Player p) {
		bar.addPlayer(p);
	}
	
	public BossBar getBar() {
		return bar;
	}
	
	public void createBar() {
		bar = Bukkit.createBossBar("§7Discord: §eHH6epS9", BarColor.YELLOW, BarStyle.SOLID);
		bar.setVisible(true);
		cast();
	}
	
	public void cast() {
		setTaskID(Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			int count = -1;
			double progress = 1.0;
			double time = 1.0/30;
			
			@Override
			public void run() {
				bar.setProgress(progress);
				
				switch(count) {
				case -1:
					break;
				case 0:
					bar.setColor(BarColor.YELLOW);
					bar.setTitle("§7Strona: §eTwojSerwer.pl");
					break;
				case 1:
					bar.setColor(BarColor.YELLOW);
					bar.setTitle("§7Komenda pomocy: §e/pomoc");
					break;
				case 2:
					bar.setColor(BarColor.YELLOW);
					bar.setTitle("§7Rangi: §e/ranks");
					break;
				case 3:
					break;
				default:
					bar.setColor(BarColor.YELLOW);
					bar.setTitle("§7Discord: §eHH6epS9");
					count = -1;
				}
				progress = progress - time;
				if(progress <= 0) {
					count++;
					progress = 1.0;
				}
			}
			
		}, 0L, 20L));
	}
	
	public int getTaskID() {
		return taskID;
	}
	
	public void setTaskID(int taskID2) {
		taskID2 = taskID;
	}

}