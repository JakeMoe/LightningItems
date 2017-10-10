package me.jakemoe.LightningItems;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.Random;

class Region {

  private World world;
  private int maxX, maxZ;
  private int minX, minZ;

  Region(World world, int minX, int minZ, int maxX, int maxZ) {
    this.world = world;
    this.minX = minX;
    this.minZ = minZ;
    this.maxX = maxX;
    this.maxZ = maxZ;
  }

  Location getRandomLocation() {
    Random random = new Random();

    int x = random.nextInt(maxX - minX) + minX;
    int z = random.nextInt(maxZ - minZ) + minZ;

    int y = world.getHighestBlockYAt(x, z);

    return new Location(world, x, y, z);
  }

}
