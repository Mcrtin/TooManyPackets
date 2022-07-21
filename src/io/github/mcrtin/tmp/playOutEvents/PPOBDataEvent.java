package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.block.BlockAction;
import io.github.mcrtin.tmp.playOutPackets.PPOBData;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@Getter
@Setter
public class PPOBDataEvent extends PacketPlayOutBlockEvent {
    private BlockAction action;
    private Object nbtTag;

    public PPOBDataEvent(Player injectedPlayer, Location blockLocation, BlockAction action, Object nbtTag) {
        super(injectedPlayer, blockLocation);
        this.action = action;
        this.nbtTag = nbtTag;
    }


    public PPOBDataEvent(Player injectedPlayer, PPOBData packet) {
        super(injectedPlayer, packet.getBlockLocation(injectedPlayer.getWorld()));
        action = packet.getAction();
        nbtTag = packet.getNBTTag();
    }
}
