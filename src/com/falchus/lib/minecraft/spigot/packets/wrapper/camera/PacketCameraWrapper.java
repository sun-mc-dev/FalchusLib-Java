package com.falchus.lib.minecraft.spigot.packets.wrapper.camera;

import java.lang.reflect.Field;
import java.util.Set;

import com.falchus.lib.minecraft.spigot.packets.wrapper.PacketWrapper;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
abstract class PacketCameraWrapper extends PacketWrapper {
	
	Field cameraId;

	PacketCameraWrapper(@NonNull Object handle, @NonNull Set<String> names) {
		super(handle, names);
		
		cameraId = getFirstField(
			"cameraId",
			"a"
		);
	}
	
	public void setCameraId(int cameraId) {
		setField(this.cameraId, cameraId);
	}
	
	public int getCameraId() {
		return getFieldValue(cameraId);
	}
}
