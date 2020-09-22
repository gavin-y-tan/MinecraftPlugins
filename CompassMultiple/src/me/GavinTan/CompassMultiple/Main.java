package me.GavinTan.CompassMultiple;

import org.bukkit.Bukkit;
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
	
	private Player[] plist=new Player[20];
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("hellotwo")) {
			for (int i=0; i<plist.length; i++) {
				if (plist[i]==null) {
					plist[i]=(Player) sender;

					Bukkit.broadcastMessage(sender.getName()+" is now being hunted");
					return (true);
				}
			}
		}

		return (false);
	}
	
	public Player[] getplist() {
		return (this.plist);
	}
	

	

}
	
	
	
