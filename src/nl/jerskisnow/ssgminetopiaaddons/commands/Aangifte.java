package nl.jerskisnow.ssgminetopiaaddons.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.jerskisnow.ssgminetopiaaddons.Main;
import nl.jerskisnow.ssgminetopiaaddons.utils.Boekjes;

public class Aangifte implements CommandExecutor {

	Main main;

	public Aangifte(Main plugin) {

		main = plugin;
	}

	private Boekjes bj = new Boekjes();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player p = (Player) sender;

		if (args.length >= 2) {
			String agr = "";
			for (int i = 1; i != args.length; i++) {
				agr = agr + args[i] + " ";
			}

			bj.aangifte(p, args[0], agr);

			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Je hebt succesvol aangifte gedaan tegen &b" + args[0] + "&3!"));
		} else {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Gebruik: &b/aangifte <Speler> <Reden>"));
		}
		return true;
	}
}