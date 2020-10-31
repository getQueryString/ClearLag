package clearname;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class cmd_ClearLag extends JavaPlugin implements CommandExecutor {

    public static String noperm = "§7[§cServer§7] §4§l Keine Rechte!";
    public static String pre = "§7[§cServer§7] ";

    @Override
    public void onEnable() {
        getCommand("clearlag").setExecutor(new cmd_ClearLag());
        getServer().getConsoleSender().sendMessage("§aDas §3Chat-Plugin §awurde erfolgreich aktiviert!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§4Das §3Chat-Plugin §4wurde erfolgreich deaktiviert!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("clearlag")) {
            if (sender.hasPermission("clearlag") || sender.isOp()) {
                for (Entity e : Bukkit.getWorld("world").getEntities()) {
                    if (e instanceof Item || e instanceof Animals || e instanceof Monster) {
                        e.remove();
                    }
                }
                sender.sendMessage(pre + " §aEntitys wurden entfernt!");
            } else {
                p.sendMessage(noperm);
            }
        }
        return false;
    }

}
