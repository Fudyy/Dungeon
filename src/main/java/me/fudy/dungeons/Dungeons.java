package me.fudy.dungeons;

import me.fudy.dungeons.worldhandler.DungeonWorldHandler;
import org.bukkit.plugin.java.JavaPlugin;

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
