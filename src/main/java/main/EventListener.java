package main;

import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class EventListener implements Listener {


    @EventHandler
    public void onPlayerDead(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();

        assert player != null;
        World world = player.getWorld();

        if (!Boolean.TRUE.equals(world.getGameRuleValue(GameRule.DO_IMMEDIATE_RESPAWN))) {
            world.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN , true);
        }

        if (player.isDead()) {

            Location location = player.getLocation();
            player.setGameMode(GameMode.SPECTATOR);

            player.teleport(new Location(player.getWorld(), location.getBlockX() , location.getBlockY() , location.getBlockZ()));

            new BukkitRunnable() {
                @Override
                public void run() {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.teleport(new Location(player.getWorld(), location.getBlockX() , location.getBlockY() , location.getBlockZ()));
                }
            }.runTaskLater(Main.getPlugin(), 5*20L);

            player.sendTitle("你死亡了" , "" , 1,20,1 );
            player.sendMessage("你死亡了");
        }

    }

    @EventHandler
    public void MoveEvent(PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.SPECTATOR) {
            event.setCancelled(true);
        }
    }

}
