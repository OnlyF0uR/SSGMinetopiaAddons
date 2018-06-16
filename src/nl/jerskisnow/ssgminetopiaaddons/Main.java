package nl.jerskisnow.ssgminetopiaaddons;

import nl.jerskisnow.ssgminetopiaaddons.commands.*;
import nl.jerskisnow.ssgminetopiaaddons.listeners.BlockBreak;
import nl.jerskisnow.ssgminetopiaaddons.listeners.BlockPlace;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        saveDefaultConfig();

        getCommand("aangifte").setExecutor(new Aangifte(this));
        getCommand("armorkleur").setExecutor(new ArmorKleur(this));
        getCommand("huiszoekingsbevel").setExecutor(new Huiszoekingsbevel(this));
        getCommand("nightvision").setExecutor(new Nightvision(this));
        getCommand("rename").setExecutor(new Rename(this));
        getCommand("setlore").setExecutor(new Setlore(this));
        getCommand("texturepack").setExecutor(new Texturepack(this));
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new BlockPlace(), this);
    }

    public void onDisable() {

    }
}
