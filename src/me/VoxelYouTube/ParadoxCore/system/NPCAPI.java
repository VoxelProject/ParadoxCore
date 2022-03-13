package me.VoxelYouTube.ParadoxCore.system;

import com.mojang.authlib.GameProfile;

import net.minecraft.network.protocol.game.PacketPlayOutNamedEntitySpawn;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.WorldServer;
import net.minecraft.server.network.PlayerConnection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftServer;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;

import java.util.UUID;

public class NPCAPI {

    public static void createNPC(Player p, String npcName) {
        Location location = p.getLocation();
        MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        //WorldServer nmsWorld = ((CraftWorld) player.getWorld()).getHandle();
        WorldServer nmsWorld = ((CraftWorld)p.getWorld()).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "§a§l" + npcName);

        EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, gameProfile/*/, new PlayerInteractManager(nmsWorld)/*/);
        Player npcPlayer = npc.getBukkitEntity().getPlayer();
        npcPlayer.setPlayerListName("");

        npc.setLocation(location.getX(), location.getY(), location.getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());

        PlayerConnection connection = ((CraftPlayer) p).getHandle().b;
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a, npc));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.b, npc));


    }

    /*/private static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }/*/
}
