package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.playOutPackets.PPOCustomPayload;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

@Getter
@Setter
public class PPOCustomPayloadEvent extends PacketPlayOutEvent{
    private NamespacedKey channel;
    private ByteBuf data;

    public PPOCustomPayloadEvent(Player injectedPlayer, NamespacedKey channel, ByteBuf data) {
        super(injectedPlayer);
        this.channel = channel;
        this.data = data;
    }

    public PPOCustomPayloadEvent(Player injectedPlayer, PPOCustomPayload packet) {
        super(injectedPlayer);
        channel = packet.getChannel();
        data = packet.getData();
    }
}
