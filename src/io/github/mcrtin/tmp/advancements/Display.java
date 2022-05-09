package io.github.mcrtin.tmp.advancements;

import javax.annotation.Nullable;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_16_R3.IChatBaseComponent;

public interface Display {
	public IChatBaseComponent getTitle();

	public void setTitle(IChatBaseComponent title);

	public IChatBaseComponent getDescription();

	public void setDescription(IChatBaseComponent description);

	public ItemStack getIconCopy();

	public void setIconCopy(ItemStack icon);

	@Nullable
	public NamespacedKey getBackground();

	public void setBackground(@Nullable NamespacedKey background);

	public AdvancementType getFrame();

	public void setFrame(AdvancementType frame);

	public boolean isShowToast();

	public void setShowToast(boolean showToast);

	public boolean isAnnounceToChat();

	public void setAnnounceToChat(boolean announceToChat);

	public boolean isHidden();

	public void setHidden(boolean hidden);

	public float getX();

	public void setX(float x);

	public float getY();

	public void setY(float y);

}
