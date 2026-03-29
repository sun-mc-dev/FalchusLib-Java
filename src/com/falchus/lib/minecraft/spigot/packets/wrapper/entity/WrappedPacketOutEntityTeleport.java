package com.falchus.lib.minecraft.spigot.packets.wrapper.entity;

import java.lang.reflect.Field;
import java.util.Set;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
public class WrappedPacketOutEntityTeleport extends PacketEntityWrapper {

	Field id;
	Field onGround;
	
	WrappedPacketOutEntityTeleport(@NonNull Object handle) {
		super(handle, Set.of(
				version.getPackageNms() + "PacketPlayOutEntityTeleport",
				networkProtocolGame + "PacketPlayOutEntityTeleport"
			)
		);
		
		id = getFirstField(
			"id",
			"a"
		);
		onGround = getFirstField(
			"onGround",
			"g"
		);
	}
	
	public void setId(int id) {
		setField(this.id, id);
	}
	
	public void setOnGround(boolean onGround) {
		setField(this.onGround, onGround);
	}
	
	public int getId() {
		return getFieldValue(id);
	}
	
	public boolean isOnGround() {
		return getFieldValue(onGround);
	}
}
