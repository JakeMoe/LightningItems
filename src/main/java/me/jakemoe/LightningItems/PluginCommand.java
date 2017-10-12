package me.jakemoe.LightningItems;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

class PluginCommand implements CommandExecutor {

  private Main plugin;

  PluginCommand(Main plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (strings.length == 0) {
      plugin.dropItem();
    } else if (strings.length == 1) {
      if (strings[0].equalsIgnoreCase("about")) {
        commandSender.sendMessage("LightningItems v0.2 by Jake Moe");
      } else if (strings[0].equalsIgnoreCase("maxX")) {
        commandSender.sendMessage("Max X is currently " + String.valueOf(plugin.getPluginConfig().getMaxX()));
      } else if (strings[0].equalsIgnoreCase("maxZ")) {
        commandSender.sendMessage("Max Z is currently " + String.valueOf(plugin.getPluginConfig().getMaxZ()));
      } else if (strings[0].equalsIgnoreCase("minX")) {
        commandSender.sendMessage("Min X is currently " + String.valueOf(plugin.getPluginConfig().getMinX()));
      } else if (strings[0].equalsIgnoreCase("minZ")) {
        commandSender.sendMessage("Min Z is currently " + String.valueOf(plugin.getPluginConfig().getMinZ()));
      } else if (strings[0].equalsIgnoreCase("world")) {
        commandSender.sendMessage("World is currently " + plugin.getPluginConfig().getWorld());
      } else {
        return false;
      }
    } else if (strings.length == 2) {
      if (strings[0].equalsIgnoreCase("maxX")) {
        plugin.getPluginConfig().setMaxX(Integer.valueOf(strings[1]));
        commandSender.sendMessage("Max X is now " + String.valueOf(plugin.getPluginConfig().getMaxX()));
      } else if (strings[0].equalsIgnoreCase("maxZ")) {
        plugin.getPluginConfig().setMaxZ(Integer.valueOf(strings[1]));
        commandSender.sendMessage("Max Z is now " + String.valueOf(plugin.getPluginConfig().getMaxZ()));
      } else if (strings[0].equalsIgnoreCase("minX")) {
        plugin.getPluginConfig().setMinX(Integer.valueOf(strings[1]));
        commandSender.sendMessage("Min X is now " + String.valueOf(plugin.getPluginConfig().getMinX()));
      } else if (strings[0].equalsIgnoreCase("minZ")) {
        plugin.getPluginConfig().setMinZ(Integer.valueOf(strings[1]));
        commandSender.sendMessage("Min Z is now " + String.valueOf(plugin.getPluginConfig().getMinZ()));
      } else if (strings[0].equalsIgnoreCase("world")) {
        plugin.getPluginConfig().setWorld(strings[1]);
        commandSender.sendMessage("World is now " + plugin.getPluginConfig().getWorld());
      } else {
        return false;
      }
    } else {
      return false;
    }
    return true;
  }

}
