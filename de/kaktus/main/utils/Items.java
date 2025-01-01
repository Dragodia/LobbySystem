package de.kaktus.main.utils;

import de.kaktus.main.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {


    public static void items(){
        ItemStack spawn = new ItemStack(Material.COMPASS);
        ItemMeta spawnMeta = spawn.getItemMeta();
        assert spawnMeta != null;
        spawnMeta.setDisplayName("§2§lSpawn");
        spawn.setItemMeta(spawnMeta);

        ItemStack smp = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta smpMeta = smp.getItemMeta();
        assert smpMeta != null;
        smpMeta.setDisplayName("§2§lCityBuild");
        smp.setItemMeta(smpMeta);

        ItemStack farm = new ItemStack(Material.MAP);
        ItemMeta farmMeta = farm.getItemMeta();
        assert farmMeta != null;
        farmMeta.setDisplayName("§b§lStoryMode");
        farmMeta.removeItemFlags(ItemFlag.HIDE_DYE);
        farm.setItemMeta(farmMeta);

        ItemStack gg = new ItemStack(Material.IRON_AXE);
        ItemMeta ggMeta = gg.getItemMeta();
        assert ggMeta != null;
        ggMeta.setDisplayName("§2§lRPG");
        ggMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        gg.setItemMeta(ggMeta);

        ItemStack place = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta placeMeta = place.getItemMeta();
        placeMeta.setDisplayName("§1");
        place.setItemMeta(placeMeta);

        Main.inventory.setItem(10, smp);
        Main.inventory.setItem(13, spawn);
        Main.inventory.setItem(16, gg);

        Main.inventory.setItem(0, place);
        Main.inventory.setItem(1, place);
        Main.inventory.setItem(2, place);
        Main.inventory.setItem(3, place);
        Main.inventory.setItem(4, place);
        Main.inventory.setItem(5, place);
        Main.inventory.setItem(6, place);
        Main.inventory.setItem(7, place);
        Main.inventory.setItem(8, place);
        Main.inventory.setItem(9, place);
        Main.inventory.setItem(11, place);
        Main.inventory.setItem(14, place);
        Main.inventory.setItem(12, place);
        Main.inventory.setItem(15, place);
        Main.inventory.setItem(17, place);
        Main.inventory.setItem(18, place);
        Main.inventory.setItem(19, place);
        Main.inventory.setItem(20, place);
        Main.inventory.setItem(21, place);
        Main.inventory.setItem(22, place);
        Main.inventory.setItem(23, place);
        Main.inventory.setItem(24, place);
        Main.inventory.setItem(25, place);
        Main.inventory.setItem(26, place);


    }
}
