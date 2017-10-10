package me.jakemoe.LightningItems;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

class PluginCommand implements CommandExecutor {

  Main plugin;

  PluginCommand(Main plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (strings.length == 0) {
      plugin.dropItem();
    } else if (strings.length == 1) {
    }
    return true;
  }

}
