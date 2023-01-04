package me.fudy.dungeons;

import me.fudy.dungeons.Dungeon.Dungeon;
import me.fudy.dungeons.Dungeon.DungeonType;
import me.fudy.dungeons.worldhandler.DungeonWorldHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public final class DungeonsPlugin extends JavaPlugin {
    DungeonWorldHandler dungeonWorldHandler;
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.dungeonWorldHandler = new DungeonWorldHandler(this);
        dungeonWorldHandler.dungeonWorldCreation();

        new Dungeon(DungeonType.lost_mines).loadDungeonRooms();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
