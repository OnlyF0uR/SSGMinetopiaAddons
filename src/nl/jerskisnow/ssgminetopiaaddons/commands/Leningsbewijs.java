package nl.jerskisnow.ssgminetopiaaddons.commands;

import nl.jerskisnow.ssgminetopiaaddons.Main;
import nl.jerskisnow.ssgminetopiaaddons.utils.Boekjes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class Leningsbewijs implements CommandExecutor {

    Main main;

    public Leningsbewijs(Main plugin) {
    	main = plugin;
    }

	private Boekjes bj = new Boekjes();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		if (sender.hasPermission("ssgminetopia.bank")) {
			Player p = (Player) sender;

			if (args.length == 4) {
				String agr = "";
				for (int i = 3; i != args.length; i++) {
					agr = agr + args[i] + " ";
				}

				bj.lening(p, args[0], args[1], args[2], agr);;

				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Je hebt succesvol een huiszoekingsbevel aangemaakt voor &b" + args[0] + "&3!"));
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Gebruik: &b/Leningsbewijs <Speler> <Bedrag> <Rente> <EindeTermijn>"));
			}
		} else {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("NoPermissions")));
		}
		return true;
	}

}
