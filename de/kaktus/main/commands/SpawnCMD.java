package de.kaktus.main.commands;

import de.kaktus.main.Main;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        Location location = new Location(p.getWorld(), -147, -43, 185, 43, 1);
        p.teleport(location);
        p.sendMessage(Main.pre + "§7Du wurdest §ateleportiert§7!");
        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 2, 1);
        return false;
    }
}
