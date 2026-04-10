package com.falchus.lib.minecraft.spigot.packets.wrapper.open.signeditor;

import java.util.Set;

import lombok.NonNull;

public class WrappedPacketOutOpenSignEditor extends PacketOpenSignEditorWrapper {

	public WrappedPacketOutOpenSignEditor(@NonNull Object handle) {
		super(handle, Set.of(
				version.getPackageNms() + "PacketPlayOutOpenSignEditor",
				networkProtocolGame + "PacketPlayOutOpenSignEditor"
			)
		);
	}
}
