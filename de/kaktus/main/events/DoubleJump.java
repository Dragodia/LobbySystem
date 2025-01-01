package de.kaktus.main.events;

import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class DoubleJump implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.setAllowFlight(true);
    }

    @EventHandler
    public void onJump(PlayerToggleFlightEvent e){
        Player p = e.getPlayer();

        if (p.getGameMode() != GameMode.CREATIVE){
            e.setCancelled(true);
            Block block = p.getWorld().getBlockAt(p.getLocation().subtract(0,2,0));
            Vector vector = p.getLocation().getDirection().multiply(1).setY(1);
            p.setVelocity(vector);
        }
    }
}
