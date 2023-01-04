package me.fudy.dungeons.worldhandler;

import org.bukkit.Bukkit;
import org.bukkit.Material;

public class DungeonGridHandler {

    private int xCoordinates = -64;
    private final int yCoordinates = -64;
    private final int zCoordinates = 63;

    public DungeonGridHandler() {
        generateGridBorder();
    }

    private void gridLocator(){
        while(Bukkit.getWorld("DungeonsContainer").getBlockAt(xCoordinates,yCoordinates,zCoordinates).getType() == Material.BLACK_WOOL){
            xCoordinates = xCoordinates + 256;
        }
    }

    public void generateGridBorder(){
        gridLocator();
        for(int i = 0; i < 256; i++){
            Bukkit.getWorld("DungeonsContainer").getBlockAt(xCoordinates+i, yCoordinates, zCoordinates).setType(Material.BLACK_WOOL);
            Bukkit.getWorld("DungeonsContainer").getBlockAt(xCoordinates, yCoordinates, zCoordinates-i).setType(Material.BLACK_WOOL);
            Bukkit.getWorld("DungeonsContainer").getBlockAt((xCoordinates+255)-i, yCoordinates, (zCoordinates-255)).setType(Material.BLACK_WOOL);
            Bukkit.getWorld("DungeonsContainer").getBlockAt((xCoordinates+255), yCoordinates, (zCoordinates-255)+i).setType(Material.BLACK_WOOL);
        }
    }

    public void removeGridBorder(){
        for(int i = 0; i < 256; i++){
            Bukkit.getWorld("DungeonsContainer").getBlockAt(xCoordinates+i, yCoordinates, zCoordinates).setType(Material.AIR);
            Bukkit.getWorld("DungeonsContainer").getBlockAt(xCoordinates, yCoordinates, zCoordinates-i).setType(Material.AIR);
            Bukkit.getWorld("DungeonsContainer").getBlockAt((xCoordinates+255)-i, yCoordinates, (zCoordinates-255)).setType(Material.AIR);
            Bukkit.getWorld("DungeonsContainer").getBlockAt((xCoordinates+255), yCoordinates, (zCoordinates-255)+i).setType(Material.AIR);
        }
    }
}
