package com.falchus.lib.minecraft.spigot.packets.wrapper.flying;

import java.util.Set;

import lombok.NonNull;

public class WrappedPacketInFlying extends PacketFlyingWrapper {

	WrappedPacketInFlying(@NonNull Object handle) {
		super(handle, Set.of(
				version.getPackageNms() + "PacketPlayInFlying",
				networkProtocolGame + "PacketPlayInFlying"
			)
		);
	}
}
