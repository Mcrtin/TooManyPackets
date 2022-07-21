package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.playOutPackets.PPOBChange;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@Getter
@Setter
public class PPOBChangeEvent extends PacketPlayOutBlockEvent {
    private Material material;

    public PPOBChangeEvent(Player injectedPlayer, Location blockLocation, Material material) {
        super(injectedPlayer, blockLocation);
        this.material = material;
    }

    public PPOBChangeEvent(Player injectedPlayer, PPOBChange packet) {
        super(injectedPlayer, packet.getBlockLocation(injectedPlayer.getWorld()));
    }
}
