package com.falchus.lib.minecraft.spigot.packets.wrapper.update.window;

import java.util.Set;

import lombok.NonNull;

public class WrappedPacketOutWindowData extends PacketUpdateWindowData {

	public WrappedPacketOutWindowData(@NonNull Object handle) {
		super(handle, Set.of(
				version.getPackageNms() + "PacketPlayOutWindowData",
				networkProtocolGame + "PacketPlayOutWindowData"
			)
		);
	}
}
