package de.kaktus.main;

import de.kaktus.main.commands.BuildCMD;
import de.kaktus.main.commands.SpawnCMD;
import de.kaktus.main.events.*;
import de.kaktus.main.utils.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    private static Main instance;
    public static String pre = "§c§lDragodia §8» ";
    public static ArrayList<Player> build = new ArrayList<>();
    public static ArrayList<Player> hidePlayer = new ArrayList<>();

    public static Inventory inventory;

    @Override
    public void onEnable() {
        instance = this;
        inventory = Bukkit.createInventory(null, 27, "§2§lNavigator");
        getCommand("build").setExecutor(new BuildCMD());
        getCommand("spawn").setExecutor(new SpawnCMD());
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Blocks(), this);
        pm.registerEvents(new PlayerHealth(), this);
        pm.registerEvents(new Inv(), this);
        pm.registerEvents(new Join(), this);
        pm.registerEvents(new Drop(), this);
        pm.registerEvents(new Chat(), this);
        pm.registerEvents(new DoubleJump(), this);

        Items.items();
    }

    public static Main getInstance() {
        return instance;
    }
}
