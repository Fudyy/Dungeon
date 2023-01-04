package me.fudy.dungeons.Dungeon;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private final DungeonGrid grid;
    private List<DungeonRoom> rooms = new ArrayList<>();
    private List<Player> players = null;
    private long seed;

    private final DungeonType type;

    public Dungeon(DungeonType type) {
        this.grid = new DungeonGrid(57);
        this.type = type;
    }

    public void loadDungeonRooms(){
        File schemsFolder = new File(getDungeonSchemPath());
        File[] schems = schemsFolder.listFiles();

        for (File schem : schems) {

            DungeonRoomType roomType = null;

            for (DungeonRoomType c : DungeonRoomType.values()) {
                if(schem.getName().indexOf(c.name()) != -1) {
                    roomType = c;
                    break;
                }
            }
            rooms.add(new DungeonRoom(schem, roomType));
        }
    }

    private String getDungeonSchemPath(){
        String schemsFolderPath = new File(".").getAbsolutePath();
        return schemsFolderPath.substring(0, schemsFolderPath.length() - 1) + "/dungeons/" + type.name();
    }

}
