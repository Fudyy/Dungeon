package me.fudy.dungeons.worldhandler;

import org.bukkit.Bukkit;
import org.bukkit.Material;

public class DungeonGridHandler {
    private int initialPosX;
    private int initialPosY;
    private int initialPosZ;

    public DungeonGridHandler(int initialPosX, int initialPosY, int initialPosZ) {
        this.initialPosX = initialPosX;
        this.initialPosY = initialPosY;
        this.initialPosZ = initialPosZ;
    }

    public void generateGridBorder(){
        for(int i = 0; i < 256; i++){
            Bukkit.getWorld("DungeonsContainer").getBlockAt(initialPosX+i, initialPosY, initialPosZ).setType(Material.BLACK_WOOL);
            Bukkit.getWorld("DungeonsContainer").getBlockAt(initialPosX, initialPosY, initialPosZ-i).setType(Material.BLACK_WOOL);
            Bukkit.getWorld("DungeonsContainer").getBlockAt((initialPosX+255)-i, initialPosY, (initialPosZ-255)).setType(Material.BLACK_WOOL);
            Bukkit.getWorld("DungeonsContainer").getBlockAt((initialPosX+255), initialPosY, (initialPosZ-255)+i).setType(Material.BLACK_WOOL);
        }
    }
}
