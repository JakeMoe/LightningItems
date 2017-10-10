package me.jakemoe.LightningItems;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class Main extends JavaPlugin {

  private Region region;
  private World world;
  private Config pluginConfig;

  @Override
  public void onDisable() {
    super.onDisable();
  }

  @Override
  public void onEnable() {
    pluginConfig = new Config(this);
    world = getServer().getWorld("world");
    region = new Region(world, pluginConfig.getMinX(), pluginConfig.getMinZ(), pluginConfig.getMaxX(), pluginConfig.getMaxZ());
    getCommand("lightningitem").setExecutor(new PluginCommand(this));
    getServer().getPluginManager().registerEvents(new PickupItemListener(), this);
  }

  @Override
  public void onLoad() {
    super.onLoad();
  }

  void dropItem() {
    Location randomLocation = region.getRandomLocation();

    ItemStack itemStack = new ItemStack(Material.POTION, 1);
    PotionMeta potionMeta = (PotionMeta) itemStack.getItemMeta();
    PotionEffectType potionEffectType;
    Random random = new Random();
    switch (random.nextInt(6)) {
      case 0:
        potionEffectType = PotionEffectType.ABSORPTION;
        break;
      case 1:
        potionEffectType = PotionEffectType.BLINDNESS;
        break;
      case 2:
        potionEffectType = PotionEffectType.CONFUSION;
        break;
      case 3:
        potionEffectType = PotionEffectType.DAMAGE_RESISTANCE;
        break;
      case 4:
        potionEffectType = PotionEffectType.HARM;
        break;
      case 5:
        potionEffectType = PotionEffectType.HEAL;
        break;
      default:
        potionEffectType = PotionEffectType.GLOWING;
        break;
    }

    PotionEffect potionEffect = new PotionEffect(potionEffectType, 5, 1, true, true);
    potionMeta.addCustomEffect(potionEffect, true);
    itemStack.setItemMeta(potionMeta);

    world.strikeLightningEffect(randomLocation);
    world.dropItem(randomLocation, itemStack);
  }

  Config getPluginConfig() {
    return pluginConfig;
  }

}
