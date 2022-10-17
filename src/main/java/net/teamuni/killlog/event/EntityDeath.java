package net.teamuni.killlog.event;

import net.teamuni.killlog.KillLog;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath implements Listener {
    private final KillLog main;
    public EntityDeath(KillLog instance) {
        this.main = instance;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        String name = event.getEntity().getName();

    }
}
