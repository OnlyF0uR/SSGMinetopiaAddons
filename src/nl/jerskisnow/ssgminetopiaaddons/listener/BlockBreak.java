package nl.jerskisnow.ssgminetopiaaddons.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import nl.jerskisnow.ssgminetopiaaddons.Main;

public class BlockBreak implements Listener {
	
	private Main main = Main.getPlugin(Main.class);
	

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		if ((!p.hasPermission("ssgminetopia.build")) && !p.isOp()) {
			p.sendMessage(Main.cc(main.getConfig().getString("NoBreakMessage")));
			event.setCancelled(true);
		}
	}

}
