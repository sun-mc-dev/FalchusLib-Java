package com.falchus.lib.minecraft.spigot.packets.wrapper.resourcepackstatus;

import java.util.Set;

import lombok.NonNull;

public class WrappedPacketInResourcePackStatus extends PacketResourcePackStatusWrapper {

	WrappedPacketInResourcePackStatus(@NonNull Object handle) {
		super(handle, Set.of(
				version.getPackageNms() + "PacketPlayInResourcePackStatus",
				networkProtocolCommon + "ServerboundResourcePackPacket"
			)
		);
	}
}
