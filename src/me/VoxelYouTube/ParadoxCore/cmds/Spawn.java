package me.VoxelYouTube.ParadoxCore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import me.VoxelYouTube.ParadoxCore.main.Main;

public class Spawn implements CommandExecutor{
    Main plugin;
    public Spawn(Main m){
        plugin = m;
        m.getCommand("spawn").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
        Player p = (Player)sender;
        Location loc = p.getLocation();
        Configuration conf = plugin.getConfig();

        
        if(args.length == 1 || args.length == 0) {
            if(args.length == 0) {
                double x = conf.getDouble("spawn.x");
                double y = conf.getDouble("spawn.y");
                double z = conf.getDouble("spawn.z");

                String world = conf.getString("spawn.world");

                p.sendMessage(conf.getString("spawn.teleportmessage").replace("&", "§").replace("{player}", p.getName()));
                p.teleport(new Location(Bukkit.getWorld(world), x, y, z));
            }
            if(args.length == 1) {
                
                double x = loc.getX();
                double y = loc.getY();
                double z = loc.getZ();

                String world = loc.getWorld().getName();
                
                if(args[0].equalsIgnoreCase("set")) {
                    if(p.hasPermission(conf.getString("spawn.setpermision")) || p.isOp()) {
                        p.sendMessage(conf.getString("spawn.setmessage").replace("&", "§")/*/.replace( "{x}" , x)/*/);
                        
                        conf.set("spawn.z", z);
                        conf.set("spawn.y", y);
                        conf.set("spawn.x", x);
                        conf.set("spawn.world", world);
                        plugin.saveConfig();

                    } else {
                        p.sendMessage(conf.getString("spawn.nopermision").replace("&", "§"));
                    }
                } else {
                    p.sendMessage(conf.getString("spawn.baduse").replace("&", "§"));
                }
            }
        } else {
            p.sendMessage(conf.getString("spawn.baduse").replace("&", "§"));
        }

        return false;
    }

    
}
