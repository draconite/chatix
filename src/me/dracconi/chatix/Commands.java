package me.dracconi.chatix;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by dracconi on 23.05.16.
 */
@SuppressWarnings("deprecation")
public class Commands implements CommandExecutor {
    private Chatix main = Chatix.getInstance();
    public Commands(Chatix plugin) {
        this.main = plugin;
    }
    public boolean toggleChat(boolean state){
        Chatix.getInstance().chat_status = state;
        return main.chat_status;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("chatix")) {
                if (sender.hasPermission("chatix.admin")) {
                    if (args.length == 0) {
                        String msg = "";
                        if (toggleChat(!main.chat_status)){msg="Chat turned on";}else{msg="Chat turned off";}
                        sender.sendMessage(main.chat_tag+msg);
                    }
                }else if (args[0].equalsIgnoreCase("clear")) {
                            for (int i = 0; i < 100; i++) {
                                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                                    player.sendMessage("");
                                }
                            }
                            Bukkit.broadcastMessage(main.chat_tag + "Chat cleared by " + sender.getName());
                        }
                    }

        return false;
    }

}

