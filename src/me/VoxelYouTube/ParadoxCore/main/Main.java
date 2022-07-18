package me.VoxelYouTube.ParadoxCore.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.VoxelYouTube.ParadoxCore.cmds.BroadCast;
import me.VoxelYouTube.ParadoxCore.cmds.Ignore;
import me.VoxelYouTube.ParadoxCore.cmds.Msg;
import me.VoxelYouTube.ParadoxCore.cmds.NPC;
import me.VoxelYouTube.ParadoxCore.cmds.Pomoc;
import me.VoxelYouTube.ParadoxCore.cmds.Repair;
import me.VoxelYouTube.ParadoxCore.cmds.Replay;
import me.VoxelYouTube.ParadoxCore.cmds.Spawn;
import me.VoxelYouTube.ParadoxCore.cmds.Unlock;
import me.VoxelYouTube.ParadoxCore.cmds.Zasady;
import me.VoxelYouTube.ParadoxCore.events.onJoin;
import me.VoxelYouTube.ParadoxCore.events.onLeave;
import me.VoxelYouTube.ParadoxCore.events.onPing;
import me.VoxelYouTube.ParadoxCore.events.onPlaceFarmers;
import me.VoxelYouTube.ParadoxCore.events.onPlayerCommand;
import me.VoxelYouTube.ParadoxCore.system.NPCAPI;
import me.VoxelYouTube.ParadoxCore.system.RecipleFarmers;

public class Main extends JavaPlugin{

	public static Main main;
    public NPCAPI npcManager;

	public void onEnable() {
		getLogger().info("o pluigin sie włączył");
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		main = this;
		
		new Pomoc(this);
        new Zasady(this);
		new Spawn(this);
		new RecipleFarmers(this);
		new Msg(this);
		new Replay(this);
		new Unlock(this);
		new Ignore(this);
		new Repair(this);
		new NPC(this);
		new BroadCast(this);

		getServer().getPluginManager().registerEvents(new onPing(this), this);
		getServer().getPluginManager().registerEvents(new onJoin(this), this);
		getServer().getPluginManager().registerEvents(new onPlaceFarmers(this), this);
		getServer().getPluginManager().registerEvents(new onPlayerCommand(this), this);
		getServer().getPluginManager().registerEvents(new onLeave(this), this);

		RecipleFarmers.setRecipe();

		setMain(this);
        this.npcManager = new NPCAPI();
	}

	@Override
	public void onDisable() {
		getLogger().info("wyłanczam się xD");
	}
	
	public static Main getMain() {
		return main;
	}
	private void setMain(Main m) {
        m = main;
    }
	/*/ private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }/*/
}

    

    
