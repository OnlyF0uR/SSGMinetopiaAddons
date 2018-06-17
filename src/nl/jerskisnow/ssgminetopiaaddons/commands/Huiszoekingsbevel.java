package nl.jerskisnow.ssgminetopiaaddons.commands;

import nl.jerskisnow.ssgminetopiaaddons.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.ChatColor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Huiszoekingsbevel implements CommandExecutor {

    Main main;

    public Huiszoekingsbevel(Main plugin) {

        main = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            return false;
        }
        if(sender.hasPermission("ssgminetopia.politie")) {
            Player p = (Player) sender;
            ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
            SimpleDateFormat datum = new SimpleDateFormat("dd-MM-yyyy");
            BookMeta meta = (BookMeta) book.getItemMeta();

            if (args.length >= 2) {
                String agr = "";
                for (int i = 1; i != args.length; i++) {
                    agr = agr + args[i] + " ";
                }

                meta.setTitle(ChatColor.DARK_AQUA + "Huiszoekingsbevel plot " + args[0]);
                meta.setAuthor(sender.getName());
                meta.addPage(
                        ChatColor.BLACK + "" + ChatColor.BOLD + "Huiszoekingsbevel\n" + ChatColor.BLUE + "===================" +
                                ChatColor.BLACK + "" + ChatColor.BOLD + "Uitgever: " + ChatColor.BLACK + p.getName() + "\n \n" +
                                ChatColor.BLACK + "" + ChatColor.BOLD + "Plotnummer: " + ChatColor.BLACK + args[0] + "\n \n" +
                                ChatColor.BLACK + "" + ChatColor.BOLD + "Reden: " + ChatColor.BLACK + agr + "\n \n" +
                                ChatColor.BLACK + "" + ChatColor.BOLD + "Datum Uitgave: " + ChatColor.BLACK + datum.format(Calendar.getInstance().getTime())
                                + ChatColor.BLUE + "===================");

                book.setItemMeta(meta);
                p.getInventory().addItem(book);
                p.sendMessage(ChatColor.BLUE + "Je hebt succesvol een huiszoekingsbevel voor plot " + ChatColor.DARK_AQUA + args[0] + ChatColor.BLUE + "aangemaakt!");
            } else {
                p.sendMessage(ChatColor.BLUE + "Gebruik: " + ChatColor.DARK_AQUA + "/huiszoekingsbevel <Plotnummer> <Reden>");
            }
        }
        return true;

    }

}
