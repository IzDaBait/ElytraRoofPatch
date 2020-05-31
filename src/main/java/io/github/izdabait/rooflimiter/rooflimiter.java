package io.github.izdabait.rooflimiter;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World.Environment;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
		    File dir = new File("plugins/ElytraRoofPatch");
		    if (!dir.exists())
		      dir.mkdirs();
		    this.saveDefaultConfig(); 
		    this.getCommand("ep").setExecutor(this);
		  }
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		    if (!sender.isOp())
		      return false; 
		    if (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase("help"))) {
		      sender.sendMessage(ChatColor.GREEN + "Your server is running ElytraRoofPatch v" + this.getDescription().getVersion() + " by IzDaBait \nPlugin page: https://www.spigotmc.org/resources/roof-patch-patch-elytra-cheating-on-your-server.77175");
		      return true;
		    } 
		    if (args.length == 1 && 
		      args[0].equalsIgnoreCase("reload")) {
		      this.reloadConfig();
		      sender.sendMessage(ChatColor.GREEN + "Successfully reloaded the config!");
		      return true;
		    } 
		    return false;
		  }
	  @EventHandler(priority = EventPriority.NORMAL)
	  public void inElytra(PlayerMoveEvent playerMoveEvent) {
		  FileConfiguration config = this.getConfig();
		  double vdouble = config.getDouble("vdouble");
		  Player p = playerMoveEvent.getPlayer();
	if (p.isGliding()) {
		if (config.getBoolean("disable") == true) {
			playerMoveEvent.setCancelled(true);
			p.sendMessage(ChatColor.YELLOW + "Elytra Patch " + ChatColor.GRAY + "> " + ChatColor.RED + config.getString("disablemms"));
		}
		  Location loc = p.getLocation();
		if (loc.getBlockY() >= config.getInt("ycheck")) {
			if (config.getBoolean("onlynether") == true && playerMoveEvent.getPlayer().getWorld().getEnvironment() == Environment.NETHER) {
        		if (Math.abs(playerMoveEvent.getFrom().getX() - playerMoveEvent.getTo().getX()) > vdouble) {
        	        playerMoveEvent.setCancelled(true);
        	        if (config.getBoolean("tp") == true) {
        	        	double x = loc.getBlockX();
        	        	double y = loc.getBlockY();
        	        	y = (y-1);
        	        	double z = loc.getBlockZ();
        	        	Location loc1 = new Location(p.getWorld(), x, y, z);
        	        	p.teleport(loc1);
        	        }
        	        if (config.getBoolean("sendmessage") == true) {
        	        	p.sendMessage(ChatColor.YELLOW + "Elytra Patch " + ChatColor.GRAY + "> " + ChatColor.RED + config.getString("message"));
        	            if (config.getBoolean("sendspeed") == true) {
        	            	p.sendMessage("Velocity: " + (Math.abs(playerMoveEvent.getFrom().getX() - playerMoveEvent.getTo().getX())) + " " + (Math.abs(playerMoveEvent.getFrom().getZ() - playerMoveEvent.getTo().getZ())));
        	            }
        	        }
        		}
        	        if (Math.abs(playerMoveEvent.getFrom().getZ() - playerMoveEvent.getTo().getZ()) > vdouble) {
            	        playerMoveEvent.setCancelled(true);
            	        if (config.getBoolean("tp") == true) {
            	        	double x = loc.getBlockX();
            	        	double y = loc.getBlockY();
            	        	y = (y-1);
            	        	double z = loc.getBlockZ();
            	        	Location loc1 = new Location(p.getWorld(), x, y, z);
            	        	p.teleport(loc1);
            	        }
        	            if (config.getBoolean("sendmessage") == true) {
        	            	p.sendMessage(ChatColor.YELLOW + "Elytra Patch " + ChatColor.GRAY + "> " + ChatColor.RED + config.getString("message"));
        	            	if (config.getBoolean("sendspeed") == true) {
        	            		p.sendMessage("Velocity: " + (Math.abs(playerMoveEvent.getFrom().getX() - playerMoveEvent.getTo().getX())) + " " + (Math.abs(playerMoveEvent.getFrom().getZ() - playerMoveEvent.getTo().getZ())));
        	            	}
        	            }
        	        }

        	}
			if (config.getBoolean("onlynether") == false) {
        		if (Math.abs(playerMoveEvent.getFrom().getX() - playerMoveEvent.getTo().getX()) > vdouble) {
        	        playerMoveEvent.setCancelled(true);
        	        if (config.getBoolean("tp") == true) {
        	        	double x = loc.getBlockX();
        	        	double y = loc.getBlockY();
        	        	y = (y-1);
        	        	double z = loc.getBlockZ();
        	        	Location loc1 = new Location(p.getWorld(), x, y, z);
        	        	p.teleport(loc1);
        	        }
        	        if (config.getBoolean("sendmessage") == true) {
        	        	p.sendMessage(ChatColor.YELLOW + "Elytra Patch " + ChatColor.GRAY + "> " + ChatColor.RED + config.getString("message"));
        	            if (config.getBoolean("sendspeed") == true) {
        	            	p.sendMessage("Velocity: " + (Math.abs(playerMoveEvent.getFrom().getX() - playerMoveEvent.getTo().getX())) + " " + (Math.abs(playerMoveEvent.getFrom().getZ() - playerMoveEvent.getTo().getZ())));
        	            }
        	        }
        	    }
        	    if (Math.abs(playerMoveEvent.getFrom().getZ() - playerMoveEvent.getTo().getZ()) > vdouble) {
        	        playerMoveEvent.setCancelled(true);
        	        if (config.getBoolean("tp") == true) {
        	        	double x = loc.getBlockX();
        	        	double y = loc.getBlockY();
        	        	y = (y-1);
        	        	double z = loc.getBlockZ();
        	        	Location loc1 = new Location(p.getWorld(), x, y, z);
        	        	p.teleport(loc1);
        	        }
        	        if (config.getBoolean("sendmessage") == true) {
        	        	p.sendMessage(ChatColor.YELLOW + "Elytra Patch " + ChatColor.GRAY + "> " + ChatColor.RED + config.getString("message"));
        	            if (config.getBoolean("sendspeed") == true) {
        	            	p.sendMessage("Velocity: " + (Math.abs(playerMoveEvent.getFrom().getX() - playerMoveEvent.getTo().getX())) + " " + (Math.abs(playerMoveEvent.getFrom().getZ() - playerMoveEvent.getTo().getZ())));
        	            }
        	        }
        	    }
        	}

        }
        return;
		}
	  return;
	  }
}
