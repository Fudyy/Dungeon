package me.fudy.dungeons.worldhandler;

import me.fudy.dungeons.Dungeons;
import org.bukkit.*;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.Objects;

public class DungeonWorldHandler {
    Dungeons plugin;
    NamespacedKey key;

    public DungeonWorldHandler(Dungeons plugin) {
        this.plugin = plugin;
        this.key = new NamespacedKey(plugin, "dungeonWorldKey");
    }

    /**
     * Checks if the world "DungeonsContainer" exists in the server.
     * @return
     * true if the world exists, false if not.
     */
    private boolean dungeonWorldChecker() {
        List<World> worldList = Bukkit.getServer().getWorlds();
        for (World world : worldList) {
            if (Objects.equals(world.getPersistentDataContainer().get(key, PersistentDataType.STRING), "DungeonWorld")) return true;
        }
        return false;
    }

    /**
     *Creates the "DungeonsContainer" world where the dungeon matchs are going to run.
     * Checks if the world exists before creating it using dungeonWorldChecker().
     * @see #dungeonWorldChecker()
     */
    public void dungeonWorldCreation() {
        if (dungeonWorldChecker()) return;

        WorldCreator world = new WorldCreator("DungeonsContainer").type(WorldType.FLAT);
        world.generatorSettings("{\"layers\": [{\"block\": \"air\", \"height\": 1}], \"biome\":\"plains\"}");
        world.generateStructures(false);
        World dungeonContainerWorld = world.createWorld();
        dungeonContainerWorld.getPersistentDataContainer().set(key, PersistentDataType.STRING, "DungeonWorld");
    }
}