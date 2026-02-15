package com.falchus.lib.utils.builder;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Set;

import com.falchus.lib.minecraft.spigot.FalchusLibMinecraftSpigot;
import com.falchus.lib.utils.ReflectionUtils;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class ClassInstanceBuilder {

	private final FalchusLibMinecraftSpigot plugin = FalchusLibMinecraftSpigot.getInstance();
	private Class<?> clazz;
	private Object[] args = new Object[0];
	
	/**
	 * Creates a new {@link ClassInstanceBuilder} by class.
	 */
	public ClassInstanceBuilder(@NonNull Class<?> clazz) {
		this.clazz = clazz;
	}
	
	/**
	 * Creates a new {@link ClassInstanceBuilder} by class name.
	 */
	public ClassInstanceBuilder(@NonNull String name) {
		this.clazz = ReflectionUtils.getClass(name);
	}
	
	/**
	 * Creates a new {@link ClassInstanceBuilder} by first class.
	 */
	public ClassInstanceBuilder(@NonNull String... names) {
		this.clazz = ReflectionUtils.getFirstClass(names);
	}
	
	/**
	 * Sets constructor arguments for the class.
	 */
	public ClassInstanceBuilder withArgs(Object... args) {
        if (args != null) {
            this.args = args;
        }
		return this;
	}
	
	/**
	 * Builds and returns the final class instance.
	 */
	public Object build() {
		if (clazz == null) {
			throw new IllegalStateException("Class must be set");
		}
		
    	try {
    		Class<?>[] arg = new Class<?>[args.length];
    		for (int i = 0; i < args.length; i++) {
    			arg[i] = args[i].getClass();
    		}

    		Constructor<?> ctor = ReflectionUtils.getFirstConstructor(clazz,
				Set.of(
					List.of(arg)
				)
			);
    		return ctor.newInstance(args);
    	} catch (Exception e) {
            throw new RuntimeException("Failed to create class instance: " + clazz.getName(), e);
        }
	}
}
