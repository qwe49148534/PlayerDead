package main;

import main.yaml.PluginConfig;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Main plugin;

    private PluginConfig config;

    @Override
    public void onEnable() {
        Main.plugin = this;
        this.config = new PluginConfig();
        getServer().getPluginManager().registerEvents(new EventListener(),this);
        Objects.requireNonNull(this.getCommand("pd")).setExecutor(new Command());
    }

    public PluginConfig getPluginConfig() {
        return this.config;
    }

    public static Main getPlugin() { return plugin; }

}
