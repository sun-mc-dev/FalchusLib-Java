package com.falchus.lib.minecraft.spigot.packets.wrapper.entity;

import java.lang.reflect.Field;
import java.util.Set;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
public class WrappedPacketOutEntityHeadRotation extends PacketEntityWrapper {
	
	Field yHeadRot;
	
	WrappedPacketOutEntityHeadRotation(@NonNull Object handle) {
		super(handle, Set.of(
				version.getPackageNms() + "PacketPlayOutEntityHeadRotation",
				networkProtocolGame + "PacketPlayOutEntityHeadRotation"
			)
		);
		
		yHeadRot = getFirstField(
			"yHeadRot",
			"b"
		);
	}
	
	public void setYHeadRot(byte yHeadRot) {
		setField(this.yHeadRot, yHeadRot);
	}
	
	public byte getYHeadRot() {
		return getFieldValue(yHeadRot);
	}
}
