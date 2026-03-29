package com.falchus.lib.minecraft.spigot.packets.wrapper.collect;

import java.util.Set;

import lombok.NonNull;

public class WrappedPacketOutCollect extends PacketCollectWrapper {

	public WrappedPacketOutCollect(@NonNull Object handle) {
		super(handle, Set.of(
				version.getPackageNms() + "PacketPlayOutCollect",
				networkProtocolGame + "PacketPlayOutCollect"
			)
		);
	}
}
