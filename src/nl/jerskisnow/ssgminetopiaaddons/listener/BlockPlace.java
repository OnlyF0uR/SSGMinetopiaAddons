package nl.jerskisnow.ssgminetopiaaddons.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import nl.jerskisnow.ssgminetopiaaddons.Main;

public class BlockPlace implements Listener {
	
	private Main main = Main.getPlugin(Main.class);
	

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if ((!p.hasPermission("ssgminetopia.build")) && !p.isOp()) {
			p.sendMessage(Main.cc(main.getConfig().getString("NoPlaceMessage")));
			e.setCancelled(true);
		}

	}

}
