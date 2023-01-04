package me.fudy.dungeons.Dungeon;

import java.io.File;

public class DungeonRoom {
    File roomSchematic;
    DungeonRoomType type;

    public DungeonRoom(File roomSchematic, DungeonRoomType type) {
        this.roomSchematic = roomSchematic;
        this.type = type;
    }
}
