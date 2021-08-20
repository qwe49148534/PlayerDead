package main;

import main.yaml.PluginConfig;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class DeathTimerRunnable
        extends TimerRunnable {

    private final Player player;

    private final String title;
    private final String subTitle;
    private final String scoreMessage;

    public DeathTimerRunnable(final @NotNull Player player, final @NotNull PluginConfig config) {
        super(config.getScore());
        this.player = player;

        this.title = config.getDeadTitleMessage();
        this.subTitle = config.getDeadSubTitle();
        this.scoreMessage = config.getScoreMessage();
    }

    @Override
    public void run() {
        if (this.source <= 0) {
            player.sendTitle(
                    DeathTimerRunnable.translateAlternateColorCodes(this.title),
                    DeathTimerRunnable.translateAlternateColorCodes(this.subTitle),
                    0, 50, 0
            );

            this.stop();
            return;
        }

        String scoreMessageTemp = this.scoreMessage.replace("%s", "" + this.source--);
        player.sendTitle(
                DeathTimerRunnable.translateAlternateColorCodes(this.title),
                DeathTimerRunnable.translateAlternateColorCodes(scoreMessageTemp),
                0, 50, 0
        );
    }

    public static String translateAlternateColorCodes(final @NotNull String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    @Override
    public void start() {
        player.setGameMode(GameMode.SPECTATOR);
        this.runTaskTimer(Main.getPlugin(), 0L, 20L);
    }

    @Override
    public void stop() {
        player.setGameMode(GameMode.SURVIVAL);
        this.cancel();
    }

    public Player getPlayer() {
        return player;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getScoreMessage() {
        return scoreMessage;
    }

}
