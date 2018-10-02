package nl.jerskisnow.ssgminetopiaaddons.listeners;

import nl.jerskisnow.ssgminetopiaaddons.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    private Main main = Main.getPlugin(Main.class);

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();
        if (main.getConfig().getBoolean("NoBreak_Enabled") == true) {
          if ((!p.hasPermission("ssgminetopia.build")) && !p.isOp()) {
              p.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("NoBreakMessage")));
              event.setCancelled(true);
          }
        }
    }
}
