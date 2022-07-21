package io.github.mcrtin.tmpv1_16_R3.advancemts;

import io.github.mcrtin.tmp.advancements.AdvancementType;
import io.github.mcrtin.tmp.advancements.Display;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.AdvancementDisplay;
import net.minecraft.server.v1_16_R3.AdvancementFrameType;
import net.minecraft.server.v1_16_R3.IChatBaseComponent;
import net.minecraft.server.v1_16_R3.MinecraftKey;
import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_16_R3.util.CraftChatMessage;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

@AllArgsConstructor
public class NMSDisplay implements Display {
	@NonNull
	private final AdvancementDisplay nms;

	public NMSDisplay(IChatBaseComponent title, IChatBaseComponent description, ItemStack icon,
			@Nullable NamespacedKey background, AdvancementType frame, boolean showToast, boolean announceToChat,
			boolean hidden, float x, float y) {

		Validate.notNull(title);
		Validate.notNull(description);
		Validate.notNull(icon);
		Validate.notNull(frame);
		nms = new AdvancementDisplay(CraftItemStack.asNMSCopy(icon), title, description,
				PacketUtils.toMinecraftKey(background), AdvancementFrameType.a(frame.getId()), showToast,
				announceToChat, hidden);
		nms.a(x, y);
	}

	@Override
	public String getTitle() {
		return CraftChatMessage.fromComponent(nms.a());
	}

	@Override
	public void setTitle(String title) {
		Field.set(nms, "a", CraftChatMessage.fromStringOrNull(title));
	}

	@Override
	public String getDescription() {
		return CraftChatMessage.fromComponent(nms.b());
	}

	@Override
	public void setDescription(String description) {
		Field.set(nms, "b", CraftChatMessage.fromStringOrNull(description));
	}

	@Override
	public ItemStack getIconCopy() {
		return CraftItemStack.asBukkitCopy(Field.get(nms, "c", net.minecraft.server.v1_16_R3.ItemStack.class));
	}

	@Override
	public void setIconCopy(ItemStack icon) {
		Field.set(nms, "c", CraftItemStack.asNMSCopy(icon));
	}

	@Nullable
	@Override
	public NamespacedKey getBackground() {
		final MinecraftKey nmsBackGground = Field.get(nms, "d", MinecraftKey.class);
		return PacketUtils.toNamespacedKey(nmsBackGground);
	}

	@Override
	public void setBackground(@Nullable NamespacedKey background) {
		Field.set(nms, "d", PacketUtils.toMinecraftKey(background));
	}

	@Override
	public AdvancementType getFrame() {
		return AdvancementType.getById(nms.e().a());
	}

	@Override
	public void setFrame(AdvancementType frame) {
		Field.set(nms, "e", AdvancementFrameType.a(frame.getId()));
	}

	@Override
	public boolean isShowToast() {
		return Field.get(nms, "f", boolean.class);
	}

	@Override
	public void setShowToast(boolean showToast) {
		Field.set(nms, "f", showToast);
	}

	@Override
	public boolean isAnnounceToChat() {
		return nms.i();
	}

	@Override
	public void setAnnounceToChat(boolean announceToChat) {
		Field.set(nms, "g", announceToChat);
	}

	@Override
	public boolean isHidden() {
		return nms.j();
	}

	@Override
	public void setHidden(boolean hidden) {
		Field.set(nms, "h", hidden);
	}

	@Override
	public float getX() {
		return Field.get(nms, "i", float.class);
	}

	@Override
	public void setX(float x) {
		Field.set(nms, "i", x);
	}

	@Override
	public float getY() {
		return Field.get(nms, "j", float.class);
	}

	@Override
	public void setY(float y) {
		Field.set(nms, "j", y);
	}

	public AdvancementDisplay getHandle() {
		return nms;
	}

}