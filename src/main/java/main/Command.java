package main;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Command implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                Main.getPlugin().getPluginConfig().load();
                player.sendMessage(DeathTimerRunnable.translateAlternateColorCodes(
                        Main.getPlugin().getPluginConfig().getReloadMessage()
                ));
                return true;
            }
        }
        return false;
    }
}
