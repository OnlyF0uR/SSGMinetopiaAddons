package nl.jerskisnow.ssgminetopiaaddons.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.jerskisnow.ssgminetopiaaddons.Main;

public class Texurepack implements CommandExecutor {

	Main main;

	public Texurepack(Main plugin) {

		main = plugin;

	}

	public String colorize(String msg) {
		String coloredMsg = "";
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == '&')
				coloredMsg += '§';
			else
				coloredMsg += msg.charAt(i);
		}
		return coloredMsg;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("Texurepack")) {
			p.sendMessage(colorize(main.getConfig().getString("texurepack")));
		}
		return true;
	}
}
