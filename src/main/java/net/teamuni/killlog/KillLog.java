package net.teamuni.killlog;

import lombok.Getter;
import net.teamuni.killlog.bar.LogBar;
import net.teamuni.killlog.command.CommandTabCompleter;
import net.teamuni.killlog.command.KillLogCmd;
import net.teamuni.killlog.event.EntityDeath;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class KillLog extends JavaPlugin {
    private LogBar logBar;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.logBar = new LogBar(this);
        Bukkit.getPluginManager().registerEvents(new EntityDeath(this), this);
        getCommand("killlog").setExecutor(new KillLogCmd(this));
        getCommand("killlog").setTabCompleter(new CommandTabCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
