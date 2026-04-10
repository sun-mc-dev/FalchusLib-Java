package com.falchus.lib.minecraft.spigot.packets.wrapper.kickdisconnect;

import java.util.Set;

import lombok.NonNull;

public class WrappedPacketOutKickDisconnect extends PacketKickDisconnectWrapper {

	WrappedPacketOutKickDisconnect(@NonNull Object handle) {
		super(handle, Set.of(
				version.getPackageNms() + "PacketPlayOutKickDisconnect",
				networkProtocolCommon + "ClientboundDisconnectPacket"
			)
		);
	}
}
