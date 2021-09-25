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
        Material limited = Material.GOLD_BLOCK;
        Block set = event.getBlockPlaced();
        if(set.getType() != limited){ return; }
        int maxnumber = 10;
        int number = 0;
        Chunk checkchunk = set.getLocation().getChunk();
        for (int x = 0; x < 16; ){
            for (int y = 0; y < 128; ){
                for (int z = 0; z < 16; ){
                    Material check = checkchunk.getBlock(x, y, z).getType();
                    if(check.equals(limited)){number++;}
                    //log.info(x + " " + y + " " + z + " : " + check.toString());
                    z++;
                }
                y++;
            }
            x++;
        }
        if(number > maxnumber){event.setCancelled(true);p.sendMessage(ChatColor.DARK_RED + "Вы достигли максимального лимита блоков на чанк типов " + Material.GOLD_BLOCK);}
    }
}
