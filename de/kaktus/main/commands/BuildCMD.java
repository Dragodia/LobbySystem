package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class BuildCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (p.hasPermission("build.cmd")){
            if (!Main.build.contains(p)){
                Main.build.add(p);
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(Main.pre + "§7Baumodus §aaktiviert§7!");
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

                p.getInventory().remove(hide);
                p.getInventory().remove(social);
                p.getInventory().remove(itemStack);

            }else{
                Main.build.remove(p);
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
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(Main.pre + "§7Baumodus §cdeaktiviert§7!");
            }
        }else{
            p.sendMessage(Main.pre + "§7Dazu hast du §ckeine §7Rechte!");
        }
        return false;
    }
}
