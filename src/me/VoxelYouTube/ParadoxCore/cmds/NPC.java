package me.VoxelYouTube.ParadoxCore.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.VoxelYouTube.ParadoxCore.main.Main;
import me.VoxelYouTube.ParadoxCore.system.NPCAPI;

public class NPC implements CommandExecutor {

    Main plugin;

    public NPC(Main m) {
        plugin = m;;
        m.getCommand("npc").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        FileConfiguration conf = plugin.getConfig();
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("create")) {
                    String npcName = args[1];
                    NPCAPI.createNPC(player, npcName);
                } else {
                    player.sendMessage(conf.getString("npc.badconstrution").replace("&", "§"));
                }
            } else {
                player.sendMessage(conf.getString("npc.badconstrution").replace("&", "§"));
            }
        } else {
            sender.sendMessage(conf.getString("noplayer").replace("&", "§"));
        }
        return true;
    }
}