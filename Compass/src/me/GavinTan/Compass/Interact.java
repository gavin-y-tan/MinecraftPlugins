package me.GavinTan.Compass;

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


	@EventHandler(priority=EventPriority.HIGH)
	public void onInteract(PlayerInteractEvent event) {
		if (event.getMaterial().equals(Material.COMPASS)) {
			event.getPlayer().setCompassTarget(Main.plugin.getPrey().getLocation());
			event.getPlayer().sendMessage("Compass is now pointing to "+Main.plugin.getPrey().getName());
		}

	}
}
