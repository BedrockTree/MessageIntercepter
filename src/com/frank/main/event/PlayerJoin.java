package com.frank.main.event;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent event){
                event.getPlayer().sendMessage(ChatColor.RED + "[MessageIntercepter]：输入/InterceptList获取屏蔽关键词列表\n");
        }
}
