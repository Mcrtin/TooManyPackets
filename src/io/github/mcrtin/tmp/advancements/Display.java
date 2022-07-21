package io.github.mcrtin.tmp.advancements;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

public interface Display {
	String getTitle();

	void setTitle(String title);

	String getDescription();

	void setDescription(String description);

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
