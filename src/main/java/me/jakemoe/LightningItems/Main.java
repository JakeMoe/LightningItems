package me.jakemoe.LightningItems;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class Main extends JavaPlugin {

  private Region region;

  @Override
  public void onDisable() {
    super.onDisable();
  }

  @Override
  public void onEnable() {
    config = net Config(this);
    World world = getServer().getWorld("world");
    region = new Region(world, 0, 0, 100, 100);
  }

  @Override
  public void onLoad() {
    super.onLoad();
  }

  void dropItems() {
    Random random = new Random(

  }

}
