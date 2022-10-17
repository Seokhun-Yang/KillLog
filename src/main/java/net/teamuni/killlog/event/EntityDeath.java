package net.teamuni.killlog.event;

import net.kyori.adventure.bossbar.BossBar;
import net.teamuni.killlog.bar.DisappearLogTask;
import net.teamuni.killlog.KillLog;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Map;

public class EntityDeath implements Listener {
    private final KillLog main;
    public EntityDeath(KillLog instance) {
        this.main = instance;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity victim = event.getEntity();
        LivingEntity killer = victim.getKiller();

        if (killer != null) {
            Map<String, BossBar> barMap = main.getLogBar().getBarMap();
            String victimName = victim.getName();
            String killerName = killer.getName();
            long delay = main.getConfig().getLong("delay");

            for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
                main.getLogBar().showBossBar(onlinePlayer, killerName, victimName);
                new DisappearLogTask(onlinePlayer, killerName, barMap.get(killerName)).register(main, delay);
            }
        }
    }
}
