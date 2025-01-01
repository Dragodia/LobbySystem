package de.kaktus.main.events;

import de.kaktus.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Blocks implements Listener {


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();


            if (!Main.build.contains(p)){
                e.setCancelled(true);
            }

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Player p = e.getPlayer();


            if (!Main.build.contains(p)){
                e.setCancelled(true);
            }

    }
}
