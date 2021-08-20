package main.yaml;

import main.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class PluginYamlObject {

    protected final File file;

    protected YamlConfiguration configuration;

    public PluginYamlObject(final @NotNull String filename) {
        final Main plugin = Main.getPlugin();

        this.file = new File(plugin.getDataFolder() , filename);

        if(!this.file.exists())
            plugin.saveResource(filename , false);

        this.configuration = YamlConfiguration.loadConfiguration(this.file);

    }

    public void load() {
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    public final void save() throws IOException {
        try {
            this.configuration.save(this.file);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void set(final @NotNull String path, final @NotNull Object obj) {
        this.configuration.set(path, obj);
    }

    @NotNull
    public final boolean exists() {
        return this.file.exists();
    }

    public YamlConfiguration getConfiguration() {
        return configuration;
    }
}
