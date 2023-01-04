package me.fudy.dungeons.worldhandler;

import org.bukkit.Bukkit;
import org.bukkit.Material;

/**
 * Represents the location of a dungeon in the world.
 */
public class DungeonGrid{
    //Initial coords for every grid in a World.
    private int xCoordinates = -64;
    private final int yCoordinates = -64;
    private final int zCoordinates = 63;

    public DungeonGrid() {
        generateGridBorder();
    }

    /**
     * Changes a grid generation coordinates until a free space is located the world.
     */
    private void gridLocator(){
        while(Bukkit.getWorld("DungeonsContainer").getBlockAt(xCoordinates,yCoordinates,zCoordinates).getType() == Material.BLACK_WOOL){
            xCoordinates = xCoordinates + 256;
        }
    }

    /**
     * Generates the border of the grid. Before creating the border it uses {@link #gridLocator() gridLocator()} to get a free space in the world to generate the grid.
     * @see #gridLocator()
     */
    public void generateGridBorder(){
        gridLocator();
        for(int i = 0; i < 256; i++){
            Bukkit.getWorld("DungeonsContainer").getBlockAt(xCoordinates+i, yCoordinates, zCoordinates).setType(Material.BLACK_WOOL);
            Bukkit.getWorld("DungeonsContainer").getBlockAt(xCoordinates, yCoordinates, zCoordinates-i).setType(Material.BLACK_WOOL);
            Bukkit.getWorld("DungeonsContainer").getBlockAt((xCoordinates+255)-i, yCoordinates, (zCoordinates-255)).setType(Material.BLACK_WOOL);
            Bukkit.getWorld("DungeonsContainer").getBlockAt((xCoordinates+255), yCoordinates, (zCoordinates-255)+i).setType(Material.BLACK_WOOL);
        }
    }

    /**
     * Removes the grid border.
     */
    public void removeGridBorder(){
        for(int i = 0; i < 256; i++){
            Bukkit.getWorld("DungeonsContainer").getBlockAt(xCoordinates+i, yCoordinates, zCoordinates).setType(Material.AIR);
            Bukkit.getWorld("DungeonsContainer").getBlockAt(xCoordinates, yCoordinates, zCoordinates-i).setType(Material.AIR);
            Bukkit.getWorld("DungeonsContainer").getBlockAt((xCoordinates+255)-i, yCoordinates, (zCoordinates-255)).setType(Material.AIR);
            Bukkit.getWorld("DungeonsContainer").getBlockAt((xCoordinates+255), yCoordinates, (zCoordinates-255)+i).setType(Material.AIR);
        }
    }

    /**
     * Transforms the given grid coordinates to raw coordinates of the world.
     * @param x
     * @return Raw X coordinate of the world.
     * @throws Exception
     */
    public int getGridCoordX(int x) throws Exception {
        if (x>=0 && x<=255){
            return xCoordinates + x;
        }
        throw new Exception("getGridCoordX() can only accept numbers between 0 and 255.");
    }

    /**
     * Transforms the given grid coordinates to raw coordinates of the world.
     * @param y
     * @return Raw Y coordinate of the world.
     * @throws Exception
     */
    public int getGridCoordY(int y) throws Exception {
        if (y>=0 && y<=255){
            return xCoordinates + y;
        }
        throw new Exception("getGridCoordY() can only accept numbers between 0 and 255.");
    }
}
