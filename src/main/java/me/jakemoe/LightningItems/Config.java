package me.jakemoe.LightningItems;

import org.bukkit.configuration.file.FileConfiguration;

import javax.print.DocFlavor;

class Config {

  private Main plugin;
  private FileConfiguration fileConfig;

  Config(Main plugin) {

    this.plugin = plugin;
    this.fileConfig = this.plugin.getConfig();

    boolean configChanged = false;

    if (!fileConfig.contains("LightingItems.maxX")) {
      fileConfig.set("LightningItems.maxX", 100);
      configChanged = true;
    }

    if (!fileConfig.contains("LightingItems.maxZ")) {
      fileConfig.set("LightningItems.maxZ", 100);
      configChanged = true;
    }

    if (!fileConfig.contains("LightingItems.minX")) {
      fileConfig.set("LightningItems.minX", 0);
      configChanged = true;
    }

    if (!fileConfig.contains("LightingItems.minZ")) {
      fileConfig.set("LightningItems.minZ", 0);
      configChanged = true;
    }

    if (!fileConfig.contains("LightingItems.world")) {
      fileConfig.set("LightningItems.world", "world");
      configChanged = true;
    }

    if (configChanged) {
      this.plugin.saveConfig();
    }

  }

  int getMaxX() {
    return fileConfig.getInt("LightningItems.maxX");
  }

  void setMaxX(int x) {
    fileConfig.set("LightningItems.maxX", x);
    plugin.saveConfig();
  }

  int getMaxZ() {
    return fileConfig.getInt("LightningItems.maxZ");
  }

  void setMaxZ(int z) {
    fileConfig.set("LightningItems.maxZ", z);
    plugin.saveConfig();
  }

  int getMinX() {
    return fileConfig.getInt("LightningItems.minX");
  }

  void setMinX(int x) {
    fileConfig.set("LightningItems.minX", x);
    plugin.saveConfig();
  }

  int getMinZ() {
    return fileConfig.getInt("LightningItems.minZ");
  }

  void setMinZ(int z) {
    fileConfig.set("LightningItems.minZ", z);
    plugin.saveConfig();
  }

  String getWorld() {
    return fileConfig.getString("LightningItems.world");
  }

  void setWorld(String world) {
    fileConfig.set("LightningItems.world", world);
    plugin.saveConfig();
  }

}
