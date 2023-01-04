package me.fudy.dungeons.Dungeon;

import java.io.File;

public class DungeonRoom {
    public File roomSchematic;
    public DungeonRoomType type;

    public DungeonRoom(File roomSchematic, DungeonRoomType type) {
        this.roomSchematic = roomSchematic;
        this.type = type;
    }

    public File getRoomSchematic() {
        return roomSchematic;
    }

    public DungeonRoomType getType() {
        return type;
    }
}
