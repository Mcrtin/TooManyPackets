package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.playOutPackets.PPOBAction;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@Getter
@Setter
public class PPOBActionEvent extends PacketPlayOutBlockEvent {
    private int actionId;
    private int paramId;
    @NonNull
    private Material material;

    public PPOBActionEvent(Player injectedPlayer, Location blockLocation, int actionId, int paramId, @NonNull Material material) {
        super(injectedPlayer, blockLocation);
        this.actionId = actionId;
        this.paramId = paramId;
        this.material = material;
    }

    public PPOBActionEvent(Player injectedPlayer, PPOBAction packet) {
        super(injectedPlayer, packet.getBlockLocation(injectedPlayer.getWorld()));
        actionId = packet.getActionId();
        paramId = packet.getActionParam();
        material = packet.getMaterial();
    }
}
