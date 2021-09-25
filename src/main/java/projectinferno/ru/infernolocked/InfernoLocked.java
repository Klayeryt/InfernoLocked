package projectinferno.ru.infernolocked;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class InfernoLocked extends JavaPlugin {

    Logger log = getLogger();

    @Override
    public void onEnable() {
        log.info("Plugin is enabled!");
        log.info("Thanks for used :)");
        log.info("Plugin created by Klayeryt");
        ChatColor color_blue = ChatColor.DARK_BLUE;
        ChatColor color_green = ChatColor.GREEN;
        ChatColor color_red = ChatColor.RED;
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        getCommand("blocklimiter").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                if(args.length == 0) {
                    sender.sendMessage(color_red + "Reload plugin: /blocklimiter reload");
                }

                if (args[0].equalsIgnoreCase("info")) {
                    sender.sendMessage(color_green + "Информармация о плагине:\n + color_blue + Создал: Klayeryt \n + color_green + Плагин приватный, разработан исключительно для личного использования!");
                    return true;
                }

                if(args[0].equalsIgnoreCase("reload")) {
                    reloadConfig();
                    sender.sendMessage(color_green + "BlockLimiter reload");

                    return true;
                }
                return true;
            }
        });
    }

    @Override
    public void onDisable() {
        log.info("Plugin is Disabled!");
        log.info("Bye... Bye...");
    }
}
