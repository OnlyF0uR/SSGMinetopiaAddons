package nl.jerskisnow.ssgminetopiaaddons.listeners;

import nl.jerskisnow.ssgminetopiaaddons.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

    private Main main = Main.getPlugin(Main.class);

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (main.getConfig().getBoolean("NoPlace_Enabled")) {
          if ((!p.hasPermission("ssgminetopia.build")) && !p.isOp()) {
              p.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("NoPlaceMessage")));
              e.setCancelled(true);
          }
        }

    }
}
