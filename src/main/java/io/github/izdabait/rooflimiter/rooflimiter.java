package io.github.izdabait.rooflimiter;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World.Environment;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class rooflimiter extends JavaPlugin implements Listener {
	
	  public void onEnable() {
		    getServer().getLogger().info("Elytra Patch by IzDaBait successfully loaded.");
		    Bukkit.getServer().getPluginManager().registerEvents(this, (Plugin)this);
		  }
	  

	  
	  
	  @EventHandler(priority = EventPriority.NORMAL)
	  public void inElytra(PlayerMoveEvent playerMoveEvent) {
		  Player p = playerMoveEvent.getPlayer();
		  if (p.isGliding()) {
        			if (Math.abs(playerMoveEvent.getFrom().getX() - playerMoveEvent.getTo().getX()) > 1.3D) {
        	            playerMoveEvent.setCancelled(true);
        			}
        	        if (Math.abs(playerMoveEvent.getFrom().getZ() - playerMoveEvent.getTo().getZ()) > 1.3D) {
        	            playerMoveEvent.setCancelled(true);
        	        }
        	}
	  }
}
