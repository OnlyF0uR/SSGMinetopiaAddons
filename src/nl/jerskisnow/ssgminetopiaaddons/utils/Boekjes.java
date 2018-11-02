package nl.jerskisnow.ssgminetopiaaddons.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Boekjes {
	
	SimpleDateFormat datum = new SimpleDateFormat("dd-MM-yyyy");
	ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
	BookMeta meta = (BookMeta) book.getItemMeta();
	
	public void lening(Player p, String speler, String bedrag, String rente, String einddatum) {
		meta.setTitle("Lening " + speler);
		meta.setAuthor("Bank");
		meta.addPage(ChatColor.translateAlternateColorCodes('&', 
				"&0&lLeenContract"
				+ "\n&9==================="
				+ "&0&lSpeler: &0" + speler
				+ "\n\n&0&lBedrag: &0€" + bedrag + " (+" + rente + "%)"
				+ "\n\n&0&lTermijn: &0" + einddatum
				+ "\n\n&0&lUitgever: &0" + p.getName()
				+ "\n\n&0&lUitgave: &0" + datum.format(Calendar.getInstance().getTime())
				+ "\n&9==================="));

		book.setItemMeta(meta);
		p.getInventory().addItem(book);
		
		// Copy Version
		meta.setTitle("Lening " + speler + " [KOPIE]");
		meta.setAuthor("Bank");
		meta.addPage(ChatColor.translateAlternateColorCodes('&', 
				"&0&lLeenContract"
				+ "\n&9==================="
				+ "&0&lSpeler: &0" + speler
				+ "\n\n&0&lBedrag: &0€" + bedrag + " (+" + rente + "%)"
				+ "\n\n&0&lTermijn: &0" + einddatum
				+ "\n\n&0&lUitgever: &0" + p.getName()
				+ "\n\n&0&lUitgave: &0" + datum.format(Calendar.getInstance().getTime())
				+ "\n&9==================="));

		book.setItemMeta(meta);
		p.getInventory().addItem(book);
		
	}
	
	public void aangifte(Player p, String speler, String reden) {
		meta.setTitle("Aangifte " + speler);
		meta.setAuthor(p.getName());
		meta.addPage(ChatColor.translateAlternateColorCodes('&', 
				"&0&lAangifte"
				+ "\n&9==================="
				+ "&0&lAangifte van: &0" + p.getName()
				+ "\n\n&0&lAangifte tegen: &0" + speler
				+ "\n\n&0&lReden: &0" + reden
				+ "\n\n&0&lUitgave: &0" + datum.format(Calendar.getInstance().getTime())
				+ "\n&9==================="));

		book.setItemMeta(meta);
		p.getInventory().addItem(book);
		
		// Copy Version
		meta.setTitle("Aangifte " + speler + "[KOPIE]");
		meta.setAuthor(p.getName());
		meta.addPage(ChatColor.translateAlternateColorCodes('&', 
				"&0&lAangifte"
				+ "\n&9==================="
				+ "&0&lAangifte van: &0" + p.getName()
				+ "\n\n&0&lAangifte tegen: &0" + speler
				+ "\n\n&0&lReden: &0" + reden
				+ "\n\n&0&lUitgave: &0" + datum.format(Calendar.getInstance().getTime())
				+ "\n&9==================="));

		book.setItemMeta(meta);
		p.getInventory().addItem(book);
	}
	
	public void huiszoekingsbevel(Player p, String plot, String reden) {
		meta.setTitle("Bevel " + plot);
		meta.setAuthor("Politie");
		meta.addPage(ChatColor.translateAlternateColorCodes('&', 
				"&0&lHuiszoekingsbevel"
				+ "\n&9==================="
				+ "&0&lPlot: &0" + plot
				+ "\n\n&0&lReden: &0" + reden
				+ "\n\n&0&lUitgever: &0" + p.getName()
				+ "\n\n&0&lUitgave: &0" + datum.format(Calendar.getInstance().getTime())
				+ "\n&9==================="));

		book.setItemMeta(meta);
		p.getInventory().addItem(book);
		
		// Copy Version
		meta.setTitle("Bevel " + plot + "[KOPIE]");
		meta.setAuthor("Politie");
		meta.addPage(ChatColor.translateAlternateColorCodes('&', 
				"&0&lHuiszoekingsbevel"
				+ "\n&9==================="
				+ "&0&lPlot: &0" + plot
				+ "\n\n&0&lReden: &0" + reden
				+ "\n\n&0&lUitgever: &0" + p.getName()
				+ "\n\n&0&lUitgave: &0" + datum.format(Calendar.getInstance().getTime())
				+ "\n&9==================="));

		book.setItemMeta(meta);
		p.getInventory().addItem(book);
	}
}
