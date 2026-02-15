package com.falchus.lib.minecraft.spigot.utils.builder;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Set;

import com.falchus.lib.minecraft.spigot.FalchusLibMinecraftSpigot;
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
		
    	try {
    		Class<?>[] arg = new Class<?>[args.length];
    		for (int i = 0; i < args.length; i++) {
    			arg[i] = args[i].getClass();
    		}

    		Constructor<?> ctor = ReflectionUtils.getFirstConstructor(packet,
				Set.of(
					List.of(arg)
				)
			);
    		return ctor.newInstance(args);
    	} catch (Exception e) {
            throw new RuntimeException("Failed to create packet for class " + packet.getName(), e);
        }
	}
}
