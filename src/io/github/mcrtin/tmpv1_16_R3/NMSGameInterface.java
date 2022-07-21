package io.github.mcrtin.tmpv1_16_R3;

import io.github.mcrtin.tmp.GameInterface;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public class NMSGameInterface implements GameInterface {

    @Override
    public void init(JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(new Injections(), plugin);
    }

    @Override
    public Entity getEntityById(int id, World world) {
        return PacketUtils.getEntity(world, id);
    }

    @Override
    public int getIdOfEntity(Entity entity) {
        return ((CraftEntity) entity).getHandle().getId();
    }

}
