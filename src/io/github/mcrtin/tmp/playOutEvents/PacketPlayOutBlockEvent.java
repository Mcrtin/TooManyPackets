package io.github.mcrtin.tmp.playOutEvents;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
@Getter
@Setter
public class PacketPlayOutBlockEvent extends PacketPlayOutEvent {

    private Location blockLocation;

    public PacketPlayOutBlockEvent(Player injectedPlayer, Location blockLocation) {
        super(injectedPlayer);
        this.blockLocation = blockLocation;
    }

    public Block getBlock() {
        return blockLocation.getBlock();
    }
}
