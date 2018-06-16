package nl.jerskisnow.ssgminetopiaaddons.commands;

import nl.jerskisnow.ssgminetopiaaddons.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Texturepack implements CommandExecutor {

    Main main;
    public Texturepack(Main plugin) { main = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Texturepack")));
        return true;
    }
}
