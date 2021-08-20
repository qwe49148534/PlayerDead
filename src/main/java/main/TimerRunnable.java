package main;

import org.bukkit.scheduler.BukkitRunnable;

public abstract class TimerRunnable
        extends BukkitRunnable {

    protected int source = 0;

    public TimerRunnable(final int source) {
        this.source = source;
    }

    public final int getSource() {
        return source;
    }

    public abstract void start();

    public abstract void stop();

}
