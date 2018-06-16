package nl.jerskisnow.ssgminetopiaaddons.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import nl.jerskisnow.ssgminetopiaaddons.Main;

public class Nightvision implements CommandExecutor {

	Main main;

	public Nightvision(Main plugin) {
		main = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if ((sender instanceof Player)) {
			if (p.hasPermission("ssgminetopia.nightvision")) {
				if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
					p.sendMessage(Main.cc(main.getConfig().getString("NightVisionOff")));
					p.removePotionEffect(PotionEffectType.NIGHT_VISION);
					return true;
				}

				p.sendMessage(Main.cc(main.getConfig().getString("NightVisionOn")));
				p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 2));
				return true;
			}

			p.sendMessage(Main.cc(main.getConfig().getString("NoPermissions")));
		}

		return true;

	}
}
