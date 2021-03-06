package io.github.mcrtin.tmpv1_16_R3;

import io.github.mcrtin.tmp.reflections.Field;
import net.minecraft.server.v1_16_R3.SoundCategory;
import net.minecraft.server.v1_16_R3.*;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.UsageMode;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;

public class PacketUtils {
	@Nullable
	public static org.bukkit.entity.Entity getEntity(World world, int entityId) {
		return CraftEntity.getEntity((CraftServer) Bukkit.getServer(),((CraftWorld)world).getHandle().getEntity(entityId));
	}
	public static void sendPacket(Player player, Packet<?> packet) {
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}

	public static byte toBitSet(boolean... booleans) {
		Validate.isTrue(booleans.length <= 8);
		byte obyte = 0;
		for (int i = 0; i < booleans.length; i++)
			obyte += booleans[i] ? 1 << i : 0;
		return obyte;
	}

	public static boolean[] toBooleanArray(byte abyte) {
		boolean[] booleans = new boolean[Byte.SIZE];
		for (int i = 0; i < booleans.length; i++)
			booleans[i] = (abyte & 1 << i) == 1 << i;
		return booleans;
	}

	public static Location toLocation(BlockPosition pos, @Nullable World world) {
		Validate.notNull(pos);
		return new Location(world, pos.getX(), pos.getY(), pos.getZ());
	}

	public static BlockPosition toBlockPosition(Location loc) {
		Validate.notNull(loc);
		return new BlockPosition(loc.getX(), loc.getY(), loc.getZ());
	}

	public static Location toLocation(SectionPosition pos, @Nullable World world) {
		Validate.notNull(pos);
		return new Location(world, pos.getX(), pos.getY(), pos.getZ());
	}

	public static SectionPosition toSectionPosition(Location loc) {
		Validate.notNull(loc);
		return SectionPosition.a(loc.getBlockX(), loc.getBlockX(), loc.getBlockZ());
	}

	public static Vector toVetor(Vec3D vec3d) {
		Validate.notNull(vec3d);
		return new Vector(vec3d.getX(), vec3d.getY(), vec3d.getZ());
	}

	public static Vec3D toVec3D(Vector vector) {
		Validate.notNull(vector);
		return new Vec3D(vector.getX(), vector.getY(), vector.getZ());
	}

	@SuppressWarnings("deprecation")
	public static NamespacedKey toNamespacedKey(MinecraftKey minecraftKey) {
		return minecraftKey == null ? null : new NamespacedKey(minecraftKey.getNamespace(), minecraftKey.getKey());
	}

	public static MinecraftKey toMinecraftKey(NamespacedKey namespacedKey) {
		return namespacedKey == null ? null : new MinecraftKey(namespacedKey.getNamespace(), namespacedKey.getKey());
	}

	@SuppressWarnings("deprecation")
	public static GameMode toGameMode(EnumGamemode enumGamemode) {
		Validate.notNull(enumGamemode);
		return GameMode.getByValue(enumGamemode.getId());
	}

	@SuppressWarnings("deprecation")
	public static EnumGamemode toEnumGamemode(GameMode gameMode) {
		Validate.notNull(gameMode);
		return EnumGamemode.getById(gameMode.getValue());
	}

	@SuppressWarnings("deprecation")
	public static Difficulty toDifficulty(EnumDifficulty enumDifficulty) {
		Validate.notNull(enumDifficulty);
		return Difficulty.getByValue(enumDifficulty.a());
	}

	@SuppressWarnings("deprecation")
	public static EnumDifficulty toEnumDifficulty(Difficulty difficulty) {
		Validate.notNull(difficulty);
		return EnumDifficulty.getById(difficulty.getValue());
	}

	public static SoundCategory toSoundCategory(net.minecraft.server.v1_16_R3.SoundCategory nmsSoundCategory) {
		Validate.notNull(nmsSoundCategory);
		return SoundCategory.valueOf(nmsSoundCategory.name());
	}

	public static net.minecraft.server.v1_16_R3.SoundCategory toNMSSoundCategory(SoundCategory soundCategory) {
		Validate.notNull(soundCategory);
		return net.minecraft.server.v1_16_R3.SoundCategory.valueOf(soundCategory.name());
	}

	@SuppressWarnings("deprecation")
	public static EntityType toEntityType(EntityTypes<?> entityTypes) {
		Validate.notNull(entityTypes);
		return EntityType.fromName(entityTypes.f());
	}

	@SuppressWarnings("deprecation")
	public static EntityTypes<?> toEntityTypes(EntityType entityType) {
		Validate.notNull(entityType);
		return EntityTypes.a(entityType.getName()).orElseThrow();
	}

	public static BlockFace toBlockFace(EnumDirection enumDirection) {
		Validate.notNull(enumDirection);
		return BlockFace.valueOf(enumDirection.name());
	}

	public static EnumDirection toEnumDirection(BlockFace facing) {
		Validate.notNull(facing);
		return EnumDirection.valueOf(facing.name());
	}

	public static NamespacedKey toNamespacedKey(ResourceKey<?> resourceKey) {
		Validate.notNull(resourceKey);
		return toNamespacedKey(resourceKey.a());
	}

	public static <T> ResourceKey<T> toResourceKey(NamespacedKey worldName, ResourceKey<IRegistry<T>> type) {
		Validate.notNull(worldName);
		Validate.notNull(type);
		return ResourceKey.a(type, PacketUtils.toMinecraftKey(worldName));
	}

	public static Sound toSound(SoundEffect soundEffect) {
		Validate.notNull(soundEffect);
		NamespacedKey key = toNamespacedKey(Field.get(soundEffect, "b", MinecraftKey.class));
		for (Sound sound : Sound.values())
			if (sound.getKey().equals(key))
				return sound;
		throw new IllegalArgumentException();
	}

	public static SoundEffect toSoundEffect(Sound sound) {
		Validate.notNull(sound);
		MinecraftKey key = toMinecraftKey(sound.getKey());
		for (SoundEffect soundEffect : IRegistry.SOUND_EVENT)
			if (Field.get(soundEffect, "b", MinecraftKey.class).equals(key))
				return soundEffect;
		throw new IllegalArgumentException();
	}

	public static Sound toSound(MinecraftKey minecraftKey) {
		Validate.notNull(minecraftKey);
		NamespacedKey key = toNamespacedKey(minecraftKey);
		for (Sound sound : Sound.values())
			if (sound.getKey().equals(key))
				return sound;
		throw new IllegalArgumentException();
	}

	@SuppressWarnings("deprecation")
	public static EntityEffect toEntityEffect(MobEffectList mobEffectList) {
		Validate.notNull(mobEffectList);
		for (EntityEffect effect : EntityEffect.values())
			if (effect.getData() == MobEffectList.getId(mobEffectList))
				return effect;
		throw new IllegalArgumentException();
	}

	@SuppressWarnings("deprecation")
	public static MobEffectList toMobEffectList(EntityEffect entityEffect) {
		Validate.notNull(entityEffect);
		return MobEffectList.fromId(entityEffect.getData());
	}

	public static UsageMode toUsageMode(BlockPropertyStructureMode blockPropertyStructureMode) {
		Validate.notNull(blockPropertyStructureMode);
		for (UsageMode usageMode : UsageMode.values())
			if (usageMode.name().equals(blockPropertyStructureMode.name()))
				return usageMode;
		throw new IllegalArgumentException();
	}

	public static BlockPropertyStructureMode toBlockPropertyStructureMode(UsageMode usageMode) {
		Validate.notNull(usageMode);
		for (BlockPropertyStructureMode blockPropertyStructureMode : BlockPropertyStructureMode.values())
			if (blockPropertyStructureMode.name().equals(usageMode.name()))
				return blockPropertyStructureMode;
		throw new IllegalArgumentException();
	}

	public static Mirror toMirror(EnumBlockMirror enumBlockMirror) {
		Validate.notNull(enumBlockMirror);
		for (Mirror mirror : Mirror.values())
			if (mirror.name().equals(enumBlockMirror.name()))
				return mirror;
		throw new IllegalArgumentException();
	}

	public static EnumBlockMirror toEnumBlockMirror(Mirror mirror) {
		Validate.notNull(mirror);
		for (EnumBlockMirror enumBlockMirror : EnumBlockMirror.values())
			if (enumBlockMirror.name().equals(mirror.name()))
				return enumBlockMirror;
		throw new IllegalArgumentException();
	}

	public static Rotation toRotation(EnumBlockRotation enumBlockRotation) {
		Validate.notNull(enumBlockRotation);
		for (Rotation rotation : Rotation.values())
			if (rotation.name().equals(enumBlockRotation.name()))
				return rotation;
		throw new IllegalArgumentException();
	}

	public static EnumBlockRotation toEnumBlockRotation(Rotation rotation) {
		Validate.notNull(rotation);
		for (EnumBlockRotation enumBlockRotation : EnumBlockRotation.values())
			if (enumBlockRotation.name().equals(rotation.name()))
				return enumBlockRotation;
		throw new IllegalArgumentException();
	}

	public static ChatColor toColor(EnumChatFormat enumChatFormat) {
		Validate.notNull(enumChatFormat);
		return ChatColor.getByChar(Field.get(enumChatFormat, "character", char.class));
	}

	public static EnumChatFormat toEnumChatFormat(ChatColor chatColor) {
		Validate.notNull(chatColor);
		return EnumChatFormat.a(Field.get(chatColor, "intCode", int.class));
	}

	public static Material toMaterial(Item item) {
		Validate.notNull(item);
		return Field.getConstant(Material.class, "byId", Material[].class)[Item.getId(item)];
	}

	@SuppressWarnings("deprecation")
	public static Item toItem(Material material) {
		Validate.notNull(material);
		return Item.getById(material.getId());
	}

	public static EntityPose toEntityPose(Pose pose) {
		Validate.notNull(pose);
		return EntityPose.valueOf(pose.name());
	}

	public static Vector3f toVector3f(Vector headRotation) {
		Validate.notNull(headRotation);
		return new Vector3f((float) headRotation.getX(), (float) headRotation.getY(), (float) headRotation.getZ());
	}
}