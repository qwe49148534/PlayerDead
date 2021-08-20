package main;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerDead(PlayerDeathEvent event) {
        final Player entity = event.getEntity();
        final DeathTimerRunnable deathRunnable = new DeathTimerRunnable(entity, Main.getPlugin().getPluginConfig());
        deathRunnable.start();
    }

    @EventHandler
    public void MoveEvent(PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.SPECTATOR) {
            event.setCancelled(true);
        }
    }

}
