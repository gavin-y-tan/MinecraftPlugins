package me.GavinTan.Swap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import me.GavinTan.Swap.Main;

public class Main extends JavaPlugin implements Listener {

	public static Main plugin;

	
	@Override
	public void onEnable() {
		plugin=this;
		
	}
	
	public void onDisable() {
		plugin=null;
	}

	private Player[] plist=new Player[20]; //array of players in the game
	private Location[] llist=new Location[20]; //array of player list's players' locations
	private int playercount=0;
	

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("join")) { //adds the sender to the array of players
			playercount+=1;
			for (int i=0; i<plist.length; i++) {
				if (plist[i]==null) {
					plist[i]=(Player) sender;
					Bukkit.broadcastMessage(sender.getName()+" is now player number "+(i+1));
					return (true);
				}
			}
		}
		
		if (label.equalsIgnoreCase("leave")) {
			for (int i=0; i<playercount; i++) {
				if (plist[i].equals((Player) sender)) {
					
					plist[i]=null;
					llist[i]=null;
					if (plist[i+1]!=null) {
						for (int j=0; j<plist.length; j++) {
							if (llist[j+1]==null && (j+1)!=i) {
								llist[i]=llist[j];
								llist[j]=null;
								plist[i]=plist[j];
								plist[j]=null;
							}
						}
					}
				}
			}
			Bukkit.broadcastMessage(sender.getName()+" has now left the Swapping pool");
		}
		
		if (label.equalsIgnoreCase("order")) {
			for (int i=0; i<plist.length; i++) {
				if (plist[i]!=null) {
					Bukkit.broadcastMessage(plist[i].getName()+" is player number "+(i+1));
				}
			}
			Bukkit.broadcastMessage("----------------");
		}
		
		if (label.equalsIgnoreCase("start")) {
			Bukkit.broadcastMessage("Swapping has now started");
			BukkitScheduler scheduler=getServer().getScheduler();
			
			BukkitScheduler s1=getServer().getScheduler();
			BukkitScheduler s2=getServer().getScheduler();
			BukkitScheduler s3=getServer().getScheduler();
			BukkitScheduler s4=getServer().getScheduler();
			BukkitScheduler s5=getServer().getScheduler();
			BukkitScheduler s6=getServer().getScheduler();
			BukkitScheduler s7=getServer().getScheduler();
			BukkitScheduler s8=getServer().getScheduler();
			BukkitScheduler s9=getServer().getScheduler();
			BukkitScheduler s10=getServer().getScheduler();
			
			scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					
					
					
					
					for (int i=0; i<llist.length; i++) {
						if (plist[i]!=null) {
							llist[i]=plist[i].getLocation();
						}
					}
					
					for (int i=0; i<llist.length; i++) {
						if (llist[i]!=null && llist[i+1]!=null) {
							Bukkit.broadcastMessage(plist[i].getName()+" has been teleported to "+plist[i+1].getName()+"'s last location");
							Bukkit.broadcastMessage("----------------");
							plist[i].teleport(llist[i+1]);
						}
						if (llist[i]!=null && llist[i+1]==null) {
							Bukkit.broadcastMessage(plist[i].getName()+" has been teleported to "+plist[0].getName()+"'s last location");
							Bukkit.broadcastMessage("----------------");
							plist[i].teleport(llist[0]);
						}
					}
					

					
					
					
					
				}
			}, 0L, 12000L);
			
			s1.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					Bukkit.broadcastMessage("10 seconds left");
				}
			}, 11800L, 12000L);
			
			s2.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					Bukkit.broadcastMessage("9 seconds left");
				}
			}, 11820L, 12000L);
			
			s3.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					Bukkit.broadcastMessage("8 seconds left");
				}
			}, 11840L, 12000L);
			
			s4.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					Bukkit.broadcastMessage("7 seconds left");
				}
			}, 11860L, 12000L);
			
			s5.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					Bukkit.broadcastMessage("6 seconds left");
				}
			}, 11880L, 12000L);
			
			s6.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					Bukkit.broadcastMessage("5 seconds left");
				}
			}, 11900L, 12000L);
			
			s7.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					Bukkit.broadcastMessage("4 seconds left");
				}
			}, 11920L, 12000L);
			
			s8.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					Bukkit.broadcastMessage("3 seconds left");
				}
			}, 11940L, 12000L);
			
			s9.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					Bukkit.broadcastMessage("2 seconds left");
				}
			}, 11960L, 12000L);
	
			s10.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					Bukkit.broadcastMessage("1 second left");
				}
			}, 11980L, 12000L);
			
			BukkitScheduler sscramble=getServer().getScheduler();
			
			sscramble.scheduleSyncRepeatingTask(this, new Runnable() {
				@Override
				public void run() {
					Bukkit.broadcastMessage("Scrambling player list");
					for (int i=0; i<playercount/2; i++) {
						Player temp=plist[i];
						plist[i]=plist[i+playercount/2];

						plist[i+playercount/2]=temp;
					}
				}
			}, 1L, 12000L);
		}
		return (false);
	}
}
