package me.GavinTan.CompassMultiple;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interact implements Listener {
	YamlConfiguration config=(YamlConfiguration) Main.plugin.getConfig();
	


	public Interact(Main main) {
		// TODO Auto-generated constructor stub
	}


	int i=0;
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onInteract(PlayerInteractEvent event) {
		if (event.getMaterial().equals(Material.COMPASS)) {
			event.getPlayer().setCompassTarget(Main.plugin.getplist()[i].getLocation());
			event.getPlayer().sendMessage("Compass is now pointing to "+Main.plugin.getplist()[i].getName());
			if (Main.plugin.getplist()[i+1]!=null) {
				i++;
			}
			else {
				i=0;
			}

		}

	}
}
