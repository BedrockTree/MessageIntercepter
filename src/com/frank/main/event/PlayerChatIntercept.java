package com.frank.main.event;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class PlayerChatIntercept implements Listener{
        Plugin plugin = com.frank.main.Main.getPlugin(com.frank.main.Main.class);
        @EventHandler
        public void PlayerChatIntercept(AsyncPlayerChatEvent event){
                String playerName = event.getPlayer().getName();
                Player player = event.getPlayer();
                String message = event.getMessage();
                for (String a : plugin.getConfig().getStringList("InterceptList")){
                        if (event.getMessage().contains(a)){
                                event.setCancelled(true);
                                if (event.isCancelled() == true){
                                        Log.warn(playerName + "尝试发送敏感词，已拦截，原内容："+message);
                                        player.sendMessage(ChatColor.RED + "注意规范用语");

                                }
                        }
                }
        }
}

