package de.kaktus.main.events;

import de.kaktus.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class Drop implements Listener {


    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();

        if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals("§2§lNavigator")){
            if (!Main.build.contains(p)){
                e.setCancelled(true);
            }
        }
        if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals("§2§lSocialMedia")){
            if (!Main.build.contains(p)){
                e.setCancelled(true);
            }
        }
        if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals("§6§lSpieler vestecken")){
            if (!Main.build.contains(p)){
                e.setCancelled(true);
            }
        }
    }
}
