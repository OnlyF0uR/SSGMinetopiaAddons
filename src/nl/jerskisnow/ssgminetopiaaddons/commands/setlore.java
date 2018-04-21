package nl.jerskisnow.ssgminetopiaaddons.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import nl.jerskisnow.ssgminetopiaaddons.Main;

public class setlore implements CommandExecutor {
	
	Main main;

	public setlore(Main plugin) {

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

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes", "unused" })
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		try {
			sender = main.getServer().getPlayer(sender.getName());
		} catch (Exception e) {
			Player p;
			e.printStackTrace();
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("setlore")) {
			if(sender.hasPermission("ssgminetopia.admin")) {
			if (args.length == 0) {
				sender.sendMessage(colorize("&f[&bSSG&f] &9Gebruik /rename of /setlore"));
				return true;
			}

			ItemStack item = ((HumanEntity) sender).getItemInHand();
			ItemMeta itemMeta = item.getItemMeta();
			String message = args[0];

			for (int i = 1; i < args.length; i++) {
				message = message + " " + args[i];
			}

			message = ChatColor.translateAlternateColorCodes('&', message);
			ArrayList itemLore = new ArrayList();
			itemLore.add(message);
			itemMeta.setLore(itemLore);

			item.setItemMeta(itemMeta);
			((HumanEntity) sender).getItemInHand().setItemMeta(itemMeta);

			sender.sendMessage(colorize("&f[&bSSG&f] &9Je hebt de lore van het item veranderd naar: &r" + message));
		}else {
			sender.sendMessage(colorize(main.getConfig().getString("NoPermissions")));
		}
		}

		return true;
	}

}
