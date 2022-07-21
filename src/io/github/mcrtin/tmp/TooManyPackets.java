package io.github.mcrtin.tmp;

import io.github.mcrtin.tmp.version.UnsupportedVersionExeption;
import io.github.mcrtin.tmp.version.Version;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

public class TooManyPackets {
    @Getter
    private static GameInterface gameInerface = null;

    public static void init(JavaPlugin plugin) {
        if (gameInerface != null)
            return;
        try {
            gameInerface = Version.CURRENT_VERSION.getInjections().getConstructor().newInstance();
            gameInerface.init(plugin);
        } catch (UnsupportedVersionExeption | ClassNotFoundException ex) {
            plugin.getLogger().log(Level.SEVERE, "No version for " + Bukkit.getVersion() + "found. Disabling.");
            plugin.getPluginLoader().disablePlugin(plugin);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException ex) {
            ex.printStackTrace();
        }

    }

    public static Entity getEntityById(int id, World world) {
        return gameInerface.getEntityById(id, world);
    }

    public static int getIdOfEntity(Entity entity) {
        return gameInerface.getIdOfEntity(entity);
    }
}
