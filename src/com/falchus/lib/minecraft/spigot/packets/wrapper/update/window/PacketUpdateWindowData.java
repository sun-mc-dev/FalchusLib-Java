package com.falchus.lib.minecraft.spigot.packets.wrapper.update.window;

import java.lang.reflect.Field;
import java.util.Set;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
abstract class PacketUpdateWindowData extends PacketUpdateWindow {
	
	Field id;
	Field value;

	PacketUpdateWindowData(@NonNull Object handle, @NonNull Set<String> names) {
		super(handle, names);
		
		id = getFirstField(
			"id",
			"b"
		);
		value = getFirstField(
			"value",
			"c"
		);
	}
	
	public void setId(int id) {
		setField(this.id, id);
	}
	
	public void setValue(int value) {
		setField(this.value, value);
	}
	
	public int getId() {
		return getFieldValue(id);
	}
	
	public int getValue() {
		return getFieldValue(value);
	}
}
