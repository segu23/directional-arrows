package org.kayteam.directionalarrows;

import org.bukkit.plugin.java.JavaPlugin;
import org.kayteam.directionalarrows.command.MainCommand;

import java.util.Objects;

public final class DirectionalArrows extends JavaPlugin {

    private static DirectionalArrows instance;

    @Override
    public void onEnable() {
        instance = this;
        Objects.requireNonNull(getCommand("directionalarrows")).setExecutor(new MainCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static DirectionalArrows getInstance() {
        return instance;
    }
}
