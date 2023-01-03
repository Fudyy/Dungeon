package me.fudy.dungeons;

import me.fudy.dungeons.Dungeon.DungeonMatch;
import me.fudy.dungeons.worldhandler.DungeonWorldHandler;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Dungeons extends JavaPlugin {
    DungeonWorldHandler dungeonWorldHandler;
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.dungeonWorldHandler = new DungeonWorldHandler(this);
        dungeonWorldHandler.dungeonWorldCreation();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
