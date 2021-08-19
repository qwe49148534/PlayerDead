package main;

import org.bukkit.GameRule;
import org.bukkit.plugin.java.JavaPlugin;
import main.yaml.PluginConfig;

public final class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {

        Main.plugin = this;
        getServer().getPluginManager().registerEvents(new EventListener(),this);

        PluginConfig config = new PluginConfig();

        final Class<?> aClass = GameRule.DO_IMMEDIATE_RESPAWN.getClass();

    }

    public static Main getPlugin() { return plugin; }

}
