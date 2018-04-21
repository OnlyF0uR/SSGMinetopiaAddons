package nl.jerskisnow.ssgminetopiaaddons.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import nl.jerskisnow.ssgminetopiaaddons.Main;

public class BlockBreak implements Listener {
	
	private Main main = Main.getPlugin(Main.class);
	
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
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		if ((!p.hasPermission("ssgminetopia.build")) && !p.isOp()) {
			p.sendMessage(colorize(main.getConfig().getString("NoBreakMessage")));
			event.setCancelled(true);
		}
	}

}
