package io.github.mcrtin.tmp;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public interface GameInterface {

    void init(JavaPlugin plugin);

    Entity getEntityById(int id, World world);

    int getIdOfEntity(Entity entity);
}
