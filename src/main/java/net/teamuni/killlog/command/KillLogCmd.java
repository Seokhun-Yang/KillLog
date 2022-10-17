package net.teamuni.killlog.command;

import net.teamuni.killlog.KillLog;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KillLogCmd implements CommandExecutor {
    private final KillLog main;
    public KillLogCmd(KillLog instance) {
        this.main = instance;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (command.getName().equalsIgnoreCase("killlog")
                    && args[0].equalsIgnoreCase("reload")
                    && player.hasPermission("kl.reload")) {
                main.reloadConfig();
            }
        }
        return false;
    }
}
