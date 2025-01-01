package de.kaktus.main.events;

import de.kaktus.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Objects;

public class Join implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        e.setJoinMessage(null);

        p.setLevel(2025);

        p.setScoreboard(SBClass.setScoreboard(p));

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player all : Bukkit.getOnlinePlayers()){
                    Objects.requireNonNull(all.getScoreboard().getTeam("players")).setPrefix("§8» §7" + Bukkit.getOnlinePlayers().size() + "§8/§7" + Bukkit.getServer().getMaxPlayers());
                }
            }
        }.runTaskLater(Main.getInstance(), 1);

        p.setHealthScale(6);
        p.setHealthScaled(true);


        Location location = new Location(Bukkit.getWorld("world"), -147, -43, 185, 43, 1);
        p.teleport(location);
        p.sendTitle("§c§lWillkommen auf", "§4§lDragodia");

        p.sendMessage(Main.pre + "§7Du wurdest mit §aLobby-1 §7verbunden!");

        ItemStack itemStack = new ItemStack(Material.COMPASS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§2§lNavigator");
        itemMeta.setLore(List.of("§7Klicke um das Inventar zu öffnen!"));
        itemStack.setItemMeta(itemMeta);

        ItemStack social = new ItemStack(Material.BOOK);
        ItemMeta socialMeta = social.getItemMeta();
        assert socialMeta != null;
        socialMeta.setDisplayName("§2§lSocialMedia");
        social.setItemMeta(socialMeta);

        ItemStack hide = new ItemStack(Material.BLAZE_ROD);
        ItemMeta hideMeta = hide.getItemMeta();
        hideMeta.setDisplayName("§6§lSpieler vestecken");
        hide.setItemMeta(hideMeta);

        p.getInventory().setItem(4, hide);
        p.getInventory().setItem(8, social);
        p.getInventory().setItem(0, itemStack);



    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player all : Bukkit.getOnlinePlayers()){
                    Objects.requireNonNull(all.getScoreboard().getTeam("players")).setPrefix("§8» §7" + Bukkit.getOnlinePlayers().size() + "§8/§7" + Bukkit.getServer().getMaxPlayers());
                }
            }
        }.runTaskLater(Main.getInstance(), 1);

        e.setQuitMessage(null);
    }
}
