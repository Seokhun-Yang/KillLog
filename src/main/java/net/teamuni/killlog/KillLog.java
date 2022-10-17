package net.teamuni.killlog;

import lombok.Getter;
import net.teamuni.killlog.event.EntityDeath;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class KillLog extends JavaPlugin {
    private BossBar bossBar;

    @Override
    public void onEnable() {
        this.bossBar = new BossBar();
        Bukkit.getPluginManager().registerEvents(new EntityDeath(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
