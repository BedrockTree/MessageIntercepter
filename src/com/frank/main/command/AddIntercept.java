package com.frank.main.command;

import com.frank.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class AddIntercept implements CommandExecutor {
        Plugin plugin = com.frank.main.Main.getPlugin(com.frank.main.Main.class);

        @Override
        public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
                if (strings.length == 1) {
                        FileConfiguration config = plugin.getConfig();
                        List<String> temp = config.getStringList("InterceptList");
                        temp.add(strings[0]);
                        config.set("InterceptList",temp);
                        plugin.saveConfig();
                        if (commandSender instanceof Player) {
                                commandSender.sendMessage(ChatColor.RED + "成功将" + strings[0] + "加入到屏蔽词列表");
                        } else {
                                Log.info("成功将" + strings[0] + "加入到屏蔽词列表");
                        }
                        Bukkit.broadcastMessage(net.md_5.bungee.api.ChatColor.RED +commandSender.getName() + "将" + strings[0] + "加入了屏蔽词列表，请注意\n");
                        Log.warn(commandSender.getName() + "将" + strings[0] + "加入了屏蔽词列表");
                        plugin.saveConfig();
                        plugin.saveDefaultConfig();
                        plugin.reloadConfig();
                        return true;
                } else {
                        return false;
                }
        }
}

