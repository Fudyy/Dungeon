package me.fudy.dungeons.worldhandler;

import me.fudy.dungeons.Dungeons;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.*;
import org.bukkit.persistence.PersistentDataType;


public class DungeonWorldHandler {
    Dungeons plugin;
    NamespacedKey key;

    public DungeonWorldHandler(Dungeons plugin) {
        this.plugin = plugin;
        this.key = new NamespacedKey(plugin, "dungeonWorldKey");
    }

    /**
     *Creates the "DungeonsContainer" world where the dungeon matchs are going to run.
     * Checks if the world exists before creating it using dungeonWorldChecker().
     */
    public void dungeonWorldCreation() {

        Bukkit.getServer().sendMessage(
                Component.text("Seting up").color(TextColor.color(25, 182, 255))
                .append(Component.text(" \"DungeonsContainer\" world").color(TextColor.color(255, 167, 36)))
                .append(Component.text(" in the server folder").color(TextColor.color(25, 182, 255)))
        );

        WorldCreator world = new WorldCreator("DungeonsContainer").type(WorldType.FLAT);
        world.generatorSettings("{\"layers\": [{\"block\": \"air\", \"height\": 1}], \"biome\":\"plains\"}");
        world.generateStructures(false);
        World dungeonContainerWorld = world.createWorld();
        dungeonContainerWorld.getPersistentDataContainer().set(key, PersistentDataType.STRING, "DungeonWorld");
        dungeonContainerWorld.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        dungeonContainerWorld.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        dungeonContainerWorld.setGameRule(GameRule.DO_FIRE_TICK, false);
    }

}