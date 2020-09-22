package me.GavinTan.Compass;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {

	public static Main plugin;
	@Override
	public void onEnable() {
		plugin=this;
		PluginManager pm=this.getServer().getPluginManager();
		pm.registerEvents(new Interact(this), this);
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		plugin=null;
	}
	
	private Player prey;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("hello")) {
			sender.sendMessage("You are now being hunted");
			prey=(Player) sender;
			return (true);
		}

		return (false);
	}
	
	public Player getPrey() {
		return(this.prey);
	}
	

}
	
	
	
