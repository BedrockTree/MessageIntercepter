package com.frank.main.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class InterceptList implements CommandExecutor {
        Plugin plugin = com.frank.main.Main.getPlugin(com.frank.main.Main.class);
        @Override
        public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
                if (commandSender instanceof Player){
                        Player player = (Player)commandSender;
                        String playerName = player.getName();
                        player.sendMessage(ChatColor.RED + "屏蔽词列表：");
                        for(String a:plugin.getConfig().getStringList("InterceptList")){
                                player.sendMessage(ChatColor.YELLOW + a);
                        }
                        return true;
                }else{
                        plugin.getLogger().warning("该指令只能由玩家输入");
                        return false;
                }
        }
}
