package me.fudy.dungeons.Dungeon;

import me.fudy.dungeons.worldhandler.DungeonGridHandler;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.List;

public class DungeonMatch {
    private List<Player> matchPlayers;
    private DungeonGridHandler grid;
    private DungeonType type;

    public DungeonMatch(List<Player> matchPlayers, DungeonGridHandler grid, DungeonType type) {
        this.matchPlayers = matchPlayers;
        this.grid = grid;
        this.type = type;
    }

    public List<Player> getMatchPlayers() {
        return matchPlayers;
    }

    public DungeonGridHandler getGrid() {
        return grid;
    }

    public DungeonType getType() {
        return type;
    }

    private void getSchemsFolder(){
        String serverFolderRaw = new File(".").getAbsolutePath();
        String dungeonFolderPath = serverFolderRaw.substring(0, serverFolderRaw.length() - 1) + "/dungeons/" + type.toString();
        File dungeonFolder = new File(dungeonFolderPath);

        Bukkit.getServer().sendMessage(Component.text(dungeonFolder.getAbsolutePath()));
    }
    private void getSpawnRoom(){

    }
}
