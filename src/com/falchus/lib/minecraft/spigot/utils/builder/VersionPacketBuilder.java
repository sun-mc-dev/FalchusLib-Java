package com.falchus.lib.minecraft.spigot.utils.builder;

import com.falchus.lib.minecraft.spigot.FalchusLibMinecraftSpigot;
import com.falchus.lib.minecraft.spigot.utils.version.VersionProvider;
import com.falchus.lib.utils.ReflectionUtils;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class VersionPacketBuilder {

	private final FalchusLibMinecraftSpigot plugin = FalchusLibMinecraftSpigot.getInstance();
	private Class<?> packet;
	private Object[] args = new Object[0];
	
	/**
	 * Creates a new {@link VersionPacketBuilder} for the given packet.
	 */
	public VersionPacketBuilder(@NonNull Class<?> packet) {
		this.packet = packet;
	}
	
	/**
	 * Creates a new {@link VersionPacketBuilder} for the given packet by class name (full package).
	 */
	public VersionPacketBuilder(@NonNull String name) {
		this.packet = ReflectionUtils.getClass(name);
	}
	
	/**
	 * Creates a new {@link VersionPacketBuilder} for the given packet by trying class names (full packages).
	 */
	public VersionPacketBuilder(@NonNull String... names) {
		this.packet = ReflectionUtils.getFirstClass(names);
	}
	
	/**
	 * Sets constructor arguments for the packet.
	 */
	public VersionPacketBuilder withArgs(Object... args) {
        if (args != null) {
            this.args = args;
        }
		return this;
	}
	
	/**
	 * Builds and returns the final packet instance.
	 */
	public Object build() {
		if (packet == null) {
			throw new IllegalStateException("Packet class must be set");
		}
		return VersionProvider.get().createPacket(packet, args);
	}
}
