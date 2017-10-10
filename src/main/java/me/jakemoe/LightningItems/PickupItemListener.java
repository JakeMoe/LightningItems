package me.jakemoe.LightningItems;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

public class PickupItemListener implements Listener {

  @EventHandler
  public void PlayerPickupItem(EntityPickupItemEvent e) {
    ItemStack itemStack = new ItemStack(Material.POTION, 1);
    if ((e.getEntity() instanceof Player) && (e.getItem().getItemStack().getType().equals(itemStack.getType()))) {
      PotionMeta meta = (PotionMeta) e.getItem().getItemStack().getItemMeta();
      for (PotionEffect effect : meta.getCustomEffects()) {
        e.getEntity().addPotionEffect(effect);
      }
      ((Player) e.getEntity()).getInventory().remove(itemStack);
    }
  }

}
