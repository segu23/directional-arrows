package org.kayteam.directionalarrows.task;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.kayteam.directionalarrows.DirectionalArrows;
import org.kayteam.taskapi.task.Task;

import static org.kayteam.directionalarrows.util.LocationUtil.calcPitchDistance;
import static org.kayteam.directionalarrows.util.LocationUtil.calcYawDistance;

public class LookTask extends Task {

    private final Location initialLocation;
    private final Player player;

    public LookTask(Location initialLocation, Player player) {
        super(DirectionalArrows.getInstance(), 10);
        this.initialLocation = initialLocation;
        this.player = player;
    }

    @Override
    public void actions() {

        Vector vec = initialLocation.toVector().subtract(player.getLocation().toVector());
        Location loc = player.getEyeLocation().setDirection(vec);

        loc.setX(player.getLocation().getX());
        loc.setY(player.getLocation().getY());
        loc.setZ(player.getLocation().getZ());

        float yawDistance = calcYawDistance(player.getLocation(), loc);

        float yawDistanceReal = Math.abs(yawDistance);

        System.out.println("yawDistance" + yawDistance);
        System.out.println("yawDistanceReal" + yawDistanceReal);

        String arrow = "X";

        if(yawDistance < -67.5 && yawDistance > -112.5){
            arrow = "←";
        }else if(yawDistance > 67.5 && yawDistance < 112.5){
            arrow = "→";
        }else if(yawDistance < -157.5 || yawDistance > 157.5){
            arrow = "↓";
        }else if(yawDistance > -22.5 && yawDistance < 22.5){
            arrow = "↑";
        }else if(yawDistance < -22.5 && yawDistance > -67.5){
            arrow = "↖";
        }else if(yawDistance > 22.5 && yawDistance < 67.5){
            arrow = "↗";
        }else if(yawDistance > 112.5 && yawDistance < 157.5){
            arrow = "↘";
        }else if(yawDistance < -112.5 && yawDistance > -157.5){
            arrow = "↙";
        }

        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(arrow));
    }
}
