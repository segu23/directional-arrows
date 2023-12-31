package org.kayteam.directionalarrows.util;

import org.bukkit.Location;

public class LocationUtil {

    public static float calcYawDistance(Location from, Location to){
        float positive = -calcYawDistancePositive(from, to);
        float negative = -calcYawDistanceNegative(from, to);
        return Math.abs(positive) > Math.abs(negative) ? negative : positive;
    }

    public static float calcYawDistancePositive(Location from, Location to){
        float fromYaw = from.getYaw();
        float toYaw = to.getYaw();
        return (fromYaw - toYaw + 360) % 360;
    }

    public static float calcYawDistanceNegative(Location from, Location to){
        float fromYaw = from.getYaw();
        float toYaw = to.getYaw();
        return (fromYaw - toYaw - 360) % 360;
    }

    public static float calcPitchDistance(Location from, Location to){
        float fromPitch = from.getPitch();
        float toPitch = to.getPitch();
        return Math.abs(fromPitch - toPitch + 180) % 360 - 180;
    }
}
