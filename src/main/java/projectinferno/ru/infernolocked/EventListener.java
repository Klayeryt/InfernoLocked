package projectinferno.ru.infernolocked;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class EventListener implements Listener {

    @EventHandler

    public void onSetBlock(BlockPlaceEvent event) {
        Player p = event.getPlayer();
        Material limited = Material.GOLD_BLOCK; // Блок для запрета
        Block set = event.getBlockPlaced();
        if(set.getType() != limited){ return; }
        int maxnumber = 10; // Блоков на чанк
        int number = 0; // Начальное число блоков
        Chunk checkchunk = set.getLocation().getChunk();
        for (int x = 0; x < 16; ){
            for (int y = 0; y < 128; ){
                for (int z = 0; z < 16; ){
                    Material check = checkchunk.getBlock(x, y, z).getType();
                    if(check.equals(limited)){number++;}
                    //log.info(x + " " + y + " " + z + " : " + check.toString()); // <== Если хотите чтобы когда ставили блоки писало в консоль на каких кордах
                    z++;
                }
                y++;
            }
            x++;
        }
        if(number > maxnumber){event.setCancelled(true);p.sendMessage(ChatColor.DARK_RED + "Вы достигли максимального лимита блоков на чанк типов " + Material.GOLD_BLOCK);}
    }
}
