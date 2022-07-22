package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.TooManyPackets;
import io.github.mcrtin.tmp.playOutPackets.PPOECollect;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

@Getter
@Setter
public class PPOECollectEvent extends PacketPlayOutEntityEvent {
    private int collectorId;
    private int count;

    public PPOECollectEvent(Player injectedPlayer, int collectedEntityId, int collectorId, int count) {
        super(injectedPlayer, collectedEntityId);
        this.collectorId = collectorId;
        this.count = count;
    }

    public PPOECollectEvent(Player injectedPlayer, PPOECollect packet) {
        super(injectedPlayer, packet.getEntityId());
        collectorId = packet.getCollectorEntityId();
        count = packet.getCount();
    }

    @Nullable
    public Entity getCollectorEntity() {
        return TooManyPackets.getEntityById(collectorId, getPlayer().getWorld());
    }
}
