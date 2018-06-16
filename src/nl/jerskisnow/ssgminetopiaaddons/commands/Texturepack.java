package nl.jerskisnow.ssgminetopiaaddons.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.jerskisnow.ssgminetopiaaddons.Main;

public class Texturepack implements CommandExecutor {

	Main main;

	public Texurepack(Main plugin) {
		main = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("texturepack")) {
			p.sendMessage(Main.cc(main.getConfig().getString("texturepack")));
		}
		return true;
	}
}
