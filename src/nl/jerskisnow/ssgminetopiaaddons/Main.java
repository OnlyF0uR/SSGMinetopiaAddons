package nl.jerskisnow.ssgminetopiaaddons;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import nl.jerskisnow.ssgminetopiaaddons.commands.Nightvision;
import nl.jerskisnow.ssgminetopiaaddons.commands.Texturepack;
import nl.jerskisnow.ssgminetopiaaddons.commands.armorkleur;
import nl.jerskisnow.ssgminetopiaaddons.commands.rename;
import nl.jerskisnow.ssgminetopiaaddons.commands.setlore;
import nl.jerskisnow.ssgminetopiaaddons.listener.BlockBreak;
import nl.jerskisnow.ssgminetopiaaddons.listener.BlockPlace;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		System.out.println("SSGMinetopiaAddons is opgestart!");
		
		CommandExecutor armorkleurcommand = new armorkleur(this);
		getCommand("armorkleur").setExecutor(armorkleurcommand);
		CommandExecutor Nightvisioncommand = new Nightvision(this);
		getCommand("Nightvision").setExecutor(Nightvisioncommand);
		CommandExecutor renamecommand = new rename(this);
		getCommand("rename").setExecutor(renamecommand);
		CommandExecutor setlorecommand = new setlore(this);
		getCommand("setlore").setExecutor(setlorecommand);
		CommandExecutor Texturepackcommand = new Texturepack(this);
		getCommand("Texturepack").setExecutor(Texurepackcommand);
		
		getServer().getPluginManager().registerEvents(new BlockBreak(), this);
		getServer().getPluginManager().registerEvents(new BlockPlace(), this);
		
		saveDefaultConfig();
	}
	
	public void onDisable() {
		System.out.println("SSGMinetopiaAddons is afgesloten!");
	}
	
	public static String cc(String message) { 
		return org.bukkit.ChatColor.translateAlternateColorCodes('&', message);
	}

}
