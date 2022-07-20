package io.github.mcrtin.tmp.advancements;

import javax.annotation.Nullable;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_16_R3.IChatBaseComponent;

public interface Display {
	IChatBaseComponent getTitle();

	void setTitle(IChatBaseComponent title);

	IChatBaseComponent getDescription();

	void setDescription(IChatBaseComponent description);

	ItemStack getIconCopy();

	void setIconCopy(ItemStack icon);

	@Nullable
	NamespacedKey getBackground();

	void setBackground(@Nullable NamespacedKey background);

	AdvancementType getFrame();

	void setFrame(AdvancementType frame);

	boolean isShowToast();

	void setShowToast(boolean showToast);

	boolean isAnnounceToChat();

	void setAnnounceToChat(boolean announceToChat);

	boolean isHidden();

	void setHidden(boolean hidden);

	float getX();

	void setX(float x);

	float getY();

	void setY(float y);

}
