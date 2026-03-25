package com.falchus.lib.minecraft.spigot.packets.wrapper.chat;

import java.util.Set;

import lombok.NonNull;

public class WrappedPacketInChat extends PacketChatWrapper {

	public WrappedPacketInChat(@NonNull Object handle) {
		super(handle, Set.of(
				version.getPackageNms() + "PacketPlayInChat",
				packageNetwork + "ServerboundChatPacket"
			)
		);
	}
	
	@Override
	public String getMessage() {
		return (String) super.getMessage();
	}
}
