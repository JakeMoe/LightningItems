package me.jakemoe.LightningItems;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

  private Main plugin;
  private FileConfiguration fileConfig;
  private int minX, minZ, maxX, maxZ;

  public Config(Main plugin) {

    this.plugin = plugin;
    this.fileConfig = plugin.getConfig();

    boolean configChanged = false;

    if (!fileConfig.contains("LightingItems.maxX")) {
      fileConfig.set("LightningItems.maxX", 0);
      configChanged = true;
    }

    if (!fileConfig.contains("LightingItems.maxZ")) {
      fileConfig.set("LightningItems.maxZ", 0);
    }

    if (!fileConfig.contains("LightingItems.minX")) {
      fileConfig.set("LightningItems.minX", 0);
    }

    if (!fileConfig.contains("LightingItems.minZ")) {
      fileConfig.set("LightningItems.minZ", 0);
    }

  }

  int getMaxX() {
    return maxX;
  }

  int getMaxZ() {
    return maxZ;
  }

  int getMinX() {
    return minX;
  }

  int getMinZ() {
    return minZ;
  }

}
