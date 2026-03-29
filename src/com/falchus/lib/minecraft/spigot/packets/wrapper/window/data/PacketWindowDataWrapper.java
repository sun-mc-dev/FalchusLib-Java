package com.falchus.lib.minecraft.spigot.packets.wrapper.window.data;

import java.lang.reflect.Field;
import java.util.Set;

import com.falchus.lib.minecraft.spigot.packets.wrapper.PacketWrapper;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
abstract class PacketWindowDataWrapper extends PacketWrapper {
	
	Field containerId;
	Field id;
	Field value;

	PacketWindowDataWrapper(@NonNull Object handle, @NonNull Set<String> names) {
		super(handle, names);
		
		containerId = getFirstField(
			"containerId",
			"a"
		);
		id = getFirstField(
			"id",
			"b"
		);
		value = getFirstField(
			"value",
			"c"
		);
	}
	
	public void setContainerId(int containerId) {
		setField(this.containerId, containerId);
	}
	
	public void setId(int id) {
		setField(this.id, id);
	}
	
	public void setValue(int value) {
		setField(this.value, value);
	}
	
	public int getContainerId() {
		return getFieldValue(containerId);
	}
	
	public int getId() {
		return getFieldValue(id);
	}
	
	public int getValue() {
		return getFieldValue(value);
	}
}
