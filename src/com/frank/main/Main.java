package com.frank.main;

import com.frank.main.command.AddIntercept;
import com.frank.main.command.InterceptList;
import com.frank.main.event.PlayerChatIntercept;
import com.frank.main.event.PlayerJoin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
        @Override
        public void onEnable(){
                getLogger().info("插件已加载");
                getLogger().info("作者：Frank__Wang");
                getConfig().options().copyDefaults();
                saveDefaultConfig();
                FileConfiguration config = getConfig();
                getServer().getPluginManager().registerEvents(new PlayerChatIntercept(),this);
                getServer().getPluginManager().registerEvents(new PlayerJoin(),this);
                getCommand("InterceptList").setExecutor(new InterceptList());
                getCommand("AddIntercept").setExecutor(new AddIntercept());
        }

        @Override
        public void onDisable(){
                getLogger().info("插件已卸载");
                getLogger().info("作者 Frank__Wang");
        }
}

