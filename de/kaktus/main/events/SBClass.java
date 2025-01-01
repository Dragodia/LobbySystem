package de.kaktus.main.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class SBClass {

    public static Scoreboard setScoreboard(Player p){
        Scoreboard scoreboard  = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("abc", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§c§lDragodia");
        objective.getScore("§0").setScore(11);
        objective.getScore("§cDein Server").setScore(10);
        objective.getScore("§8» §7Lobby-1").setScore(9);
        objective.getScore("§1").setScore(8);
        objective.getScore("§cSpieler").setScore(7);
        objective.getScore("§2").setScore(5);
        objective.getScore("§cDein Rang").setScore(4);
        objective.getScore(p.hasPermission("rank.owner") ? "§8» §4Owner" : p.hasPermission("rank.admin") ? "§8» §4Admin" :
                p.hasPermission("rank.tech") ? "§8» §bDev" : p.hasPermission("rank.mod") ? "§8» §5Mod" :
                        p.hasPermission("rank.streamer") ? "§8» §aStreamer" :
                        p.hasPermission("rank.premium") ? "§8» §6Premium" : "§8» §7Spieler").setScore(3);
        objective.getScore("§3").setScore(2);
        objective.getScore("§c§lDragodia.de").setScore(1);


        Team players = scoreboard.registerNewTeam("players");
        players.addEntry(ChatColor.AQUA + "" + ChatColor.RED);
        objective.getScore(ChatColor.AQUA + "" + ChatColor.RED).setScore(6);
        players.setPrefix("§8» §7" + Bukkit.getOnlinePlayers().size() + "§8/§7" + Bukkit.getServer().getMaxPlayers());

        return scoreboard;
    }
}
