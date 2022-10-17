package net.teamuni.killlog.bar;

import net.kyori.adventure.bossbar.BossBar;
import net.teamuni.killlog.KillLog;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class DisappearLogTask implements Runnable {
    private final BossBar bar;
    private final Player audience;
    private final String killerName;
    private final KillLog main = KillLog.getPlugin(KillLog.class);

    public DisappearLogTask(Player player, String killerName, BossBar bar) {
        this.audience = player;
        this.killerName = killerName;
        this.bar = bar;
    }

    @Override
    public void run() {
        audience.hideBossBar(bar);
        main.getLogBar().getBarMap().remove(killerName);
    }

    public void register(KillLog plugin, long delay) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, this, delay);
    }
}
