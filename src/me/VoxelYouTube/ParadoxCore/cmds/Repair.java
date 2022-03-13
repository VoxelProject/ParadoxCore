package me.VoxelYouTube.ParadoxCore.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.VoxelYouTube.ParadoxCore.main.Main;

public class Repair implements CommandExecutor{
    Main plugin;
    public Repair(Main m) {
        plugin = m;
        m.getCommand("repair").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lab, String[] args) {
        Player p = (Player)sender;
        FileConfiguration conf = plugin.getConfig();
        if(args.length == 1) {
            p.sendMessage(format(conf.getString("repair.messagesall")));
            if(args[0].equalsIgnoreCase("all")) {
                if(p.isOp() || p.hasPermission(conf.getString("repair.permisionall"))) {
                    p.sendMessage(format(conf.getString("repair.messagesall")));
                    ItemStack[] contents;
                    for(int length = (contents = p.getInventory().getContents()).length, i =0; i < length; ++i) {
                        ItemStack itemstack = contents[i];
                        if(itemstack != null) {
                            itemstack.setDurability((short) 0);
                        }
                    }
                    ItemStack[] armorContents;
                    for(int length2 = (armorContents = p.getEquipment().getArmorContents()).length, j = 0; j < length2; ++j) {
                        ItemStack itemstack2 = armorContents[j];
                        if(itemstack2 != null) {
                            itemstack2.setDurability((short) 0);
                        }
                    }
                } else {
                    p.sendMessage(format(conf.getString("repair.nopermisionall")));
                }
            } else {
                p.sendMessage(format(conf.getString("repair.baduse")));
            }
        } else {
            if(args.length == 0) {
                if(p.isOp() || p.hasPermission(conf.getString("repair.permision")) || p.hasPermission(conf.getString("repair.permisionall"))) {
                    p.sendMessage(format(conf.getString("repair.messages")));
                    if(p.getInventory().getItemInHand().getType() != null) {
                        p.getInventory().getItemInHand().setDurability((short) 0);
                    }
                } else {
                    p.sendMessage(format(conf.getString("repair.nopermision")));
                }
            } else {
                p.sendMessage(format(conf.getString("repair.baduse")));
            }
        }

        return false;
    }
    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
