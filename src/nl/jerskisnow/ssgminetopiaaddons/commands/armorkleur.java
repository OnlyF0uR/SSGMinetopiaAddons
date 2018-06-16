package nl.jerskisnow.ssgminetopiaaddons.commands;

import nl.jerskisnow.ssgminetopiaaddons.Main;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ArmorKleur implements CommandExecutor {

    Main main;

    public ArmorKleur(Main plugin) {
        main = plugin;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if ((sender instanceof Player)) {
            if(sender.hasPermission("ssgminetopia.armorkleur")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cGebruik /armorkleur <HEX-Code>"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cHier kan je HEX-Codes vinden: https://htmlcolorcodes.com/"));
                    return true;
                }

                if (args.length == 1) {
                    int number = tryParse(args[0]);
                    if (number >= 0) {
                        if ((((Player)sender).getInventory().getItemInHand().getType().equals(Material.LEATHER_HELMET)) ||
                                (((Player)sender).getInventory().getItemInHand().getType().equals(Material.LEATHER_CHESTPLATE)) ||
                                (((Player)sender).getInventory().getItemInHand().getType().equals(Material.LEATHER_LEGGINGS)) ||
                                (((Player)sender).getInventory().getItemInHand().getType().equals(Material.LEATHER_BOOTS))) {

                            ItemStack item = ((Player)sender).getInventory().getItemInHand();
                            LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
                            meta.setColor(Color.fromRGB(number));
                            item.setItemMeta(meta);
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("KleurSuccesvol").replaceAll("<hexcode>", args[0])));
                            return true;
                        }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("GeenArmorInHand")));
                        return true;
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("FouteArgumenten")));
                    return true;
                }
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("FouteArgumenten")));
                return true;
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("NoPermissions")));
        }

        return false;
    }



    private static int tryParse(String toParse) {
        try {
            return Integer.parseInt(toParse, 16);
        } catch (NumberFormatException e) {}
        return 65036;
    }

}
