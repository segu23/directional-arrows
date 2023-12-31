package org.kayteam.directionalarrows.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.kayteam.directionalarrows.task.LookTask;

import java.util.Locale;

public class MainCommand implements CommandExecutor {

    private LookTask lookTask;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player player)) return false;

        switch (args[0].toLowerCase(Locale.ROOT)){
            case "start":{
                if(lookTask != null){
                    lookTask.stopTask();
                }
                lookTask = new LookTask(player.getLocation(), player);
                lookTask.startTask();
                player.sendMessage("Started");
            }
        }

        return false;
    }
}
