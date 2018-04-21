package nl.jerskisnow.ssgminetopiaaddons.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import nl.jerskisnow.ssgminetopiaaddons.Main;

public class BlockPlace implements Listener {
	
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
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if ((!p.hasPermission("ssgminetopia.build")) && !p.isOp()) {
			p.sendMessage(colorize(main.getConfig().getString("NoPlaceMessage")));
			e.setCancelled(true);
		}

	}

}
