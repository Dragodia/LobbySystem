package de.kaktus.main.events;

import com.sun.source.tree.LambdaExpressionTree;
import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Inv implements Listener {


    @EventHandler
    public void onInv(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) return;
        if (!e.getCurrentItem().hasItemMeta()) return;

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2§lSocialMedia")){
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2§lNavigator")){
            if (!Main.build.contains(p)){
                e.setCancelled(true);
            }
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lSpieler vestecken")){
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2§lSpawn")){
            Location location = new Location(p.getWorld(), -147, -43, 185, 43, 1);
            p.teleport(location);
            p.sendMessage(Main.pre + "§7Du wurdest §ateleportiert§7!");
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 2, 1);
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2§lCityBuild")){
            Location location = new Location(p.getWorld(), -173, -44, 206, 45, 3);
            p.teleport(location);
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 2, 1);
            p.closeInventory();
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§b§lStoryMode")){
            Location location = new Location(p.getWorld(), -176, -44, 203, 45, 1);
            p.teleport(location);
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 2, 1);
            p.closeInventory();
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2§lRPG")){
            Location location = new Location(p.getWorld(), -177, -44, 201, 48, 1);
            p.teleport(location);
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 2, 1);
            p.closeInventory();
            e.setCancelled(true);
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§1")){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if (e.hasItem()){
            if (e.getItem().hasItemMeta()){
                if (e.getItem().getItemMeta().getDisplayName().equals("§2§lNavigator")){
                    if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
                        p.openInventory(Main.inventory);
                        p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 2F, 1F);
                    }
                }
                if (e.getItem().getItemMeta().getDisplayName().equals("§2§lSocialMedia")){
                    if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
                        p.closeInventory();
                        p.sendMessage("§8» \n §1 \n §c§lYOUTUBE§7 https://www.youtube.com/@DragoBasler \n §2 \n §5§lDiscord§7 https://discord.gg/dD3gZS3yQB \n §8 \n§8»");
                        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 2F, 1F);
                    }
                }
                if (e.getItem().getItemMeta().getDisplayName().equals("§6§lSpieler vestecken")){
                    if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
                        if (Main.hidePlayer.contains(p)){
                            Main.hidePlayer.remove(p);
                            for (Player all : Bukkit.getOnlinePlayers()){
                                p.showPlayer(all);
                            }
                            p.sendMessage(Main.pre + "§7Alle Spieler sind nun §asichtbar§7!");
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 2, 1);
                        }else{
                            Main.hidePlayer.add(p);
                            for (Player all : Bukkit.getOnlinePlayers()){
                                p.hidePlayer(all);
                            }
                            p.sendMessage(Main.pre + "§7Alle Spieler sind nun §aunsichtbar§7!");
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 2, 1);
                        }
                    }
                }
            }
        }
    }
}
