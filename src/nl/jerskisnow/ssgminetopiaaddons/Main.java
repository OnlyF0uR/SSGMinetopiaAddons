package nl.jerskisnow.ssgminetopiaaddons;

import nl.jerskisnow.ssgminetopiaaddons.commands.*;
import nl.jerskisnow.ssgminetopiaaddons.listeners.BlockBreak;
import nl.jerskisnow.ssgminetopiaaddons.listeners.BlockPlace;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        if(checkFor113()) {
            System.out.println("---=[SSGMinetopiaAddons]=--");
            System.out.println("ERROR: Deze plugin support geen 1.13 of hoger!");
            System.out.println("---=[SSGMinetopiaAddons]=--");
            getServer().getPluginManager().disablePlugin(this);
        } else {
        	System.out.println("SSGMinetopiaAddons is opgestart, bedankt voor het gebruiken!");
        	
            loadCommands();
            loadEvents();
        }
        
        saveDefaultConfig();
    }

    public void onDisable() {
    	System.out.println("SSGMinetopiaAddons is afgesloten, bedankt voor het gebruiken!");
    }
    
    private boolean checkFor113() {
        String nmsver = Bukkit.getServer().getClass().getPackage().getName();
        nmsver = nmsver.substring(nmsver.lastIndexOf(".") + 1);
        return !nmsver.startsWith("v1_7_") && !nmsver.startsWith("v1_8_") && !nmsver.startsWith("v1_9_")
                && !nmsver.startsWith("v1_10_") && !nmsver.startsWith("v1_11_") && !nmsver.startsWith("v1_12_");
    }
    
    private void loadCommands() {
        getCommand("aangifte").setExecutor(new Aangifte(this));
        getCommand("armorkleur").setExecutor(new ArmorKleur(this));
        getCommand("huiszoekingsbevel").setExecutor(new Huiszoekingsbevel(this));
        getCommand("nightvision").setExecutor(new Nightvision(this));
        getCommand("rename").setExecutor(new Rename(this));
        getCommand("setlore").setExecutor(new Setlore(this));
        getCommand("texturepack").setExecutor(new Texturepack(this));
        getCommand("leningsbewijs").setExecutor(new Leningsbewijs(this));
    }
    
    private void loadEvents() {
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new BlockPlace(), this);
    }
}
