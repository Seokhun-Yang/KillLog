package net.teamuni.killlog.bar;

import lombok.Getter;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.teamuni.killlog.KillLog;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class LogBar {
    @Getter
    private final Map<String, BossBar> barMap = new HashMap<>();
    private final KillLog main;
    public LogBar(KillLog instance) {
        this.main = instance;
    }

    public void showBossBar(Player player, String killerName, String victimName) {
        String space = main.getConfig().getString("space","                                  ");
        Component killLog = Component.text(space + killerName + "  =|----->  " + victimName);
        BossBar bar = BossBar.bossBar(killLog, 1, BossBar.Color.WHITE, BossBar.Overlay.PROGRESS);

        barMap.put(killerName, bar);
        player.showBossBar(bar);
    }
}
