package net.teamuni.killlog.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommandTabCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("killlog")) {
            List<String> tabCompleteList = new ArrayList<>();
            if (args.length > 0) {
                if (args.length == 1) {
                    tabCompleteList.add("reload");
                }
            }
            return tabCompleteList;
        }
        return null;
    }
}
