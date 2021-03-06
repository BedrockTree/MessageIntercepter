package com.frank.main.command;

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
                        if (commandSender.hasPermission("op")){
                                FileConfiguration config = plugin.getConfig();
                                List<String> temp = config.getStringList("InterceptList");
                                temp.add(strings[0]);
                                config.set("InterceptList",temp);
                                plugin.saveConfig();
                                if (commandSender instanceof Player) {
                                        commandSender.sendMessage(ChatColor.RED + "成功将" + strings[0] + "加入到屏蔽词列表");
                                } else {
                                        plugin.getLogger().info("成功将" + strings[0] + "加入到屏蔽词列表");
                                }
                                Bukkit.broadcastMessage(ChatColor.RED +commandSender.getName() + "将" + strings[0] + "加入了屏蔽词列表，请注意\n");
                                plugin.getLogger().warning(commandSender.getName() + "将" + strings[0] + "加入了屏蔽词列表");
                                plugin.saveConfig();
                                plugin.saveDefaultConfig();
                                plugin.reloadConfig();
                                return true;
                        }else{
                                commandSender.sendMessage(ChatColor.RED + "你没有执行该指令的权限（MessageIntercepter.commands.AddIntercept）");
                                return false;
                        }
                } else {
                        return false;
                }
        }
}

