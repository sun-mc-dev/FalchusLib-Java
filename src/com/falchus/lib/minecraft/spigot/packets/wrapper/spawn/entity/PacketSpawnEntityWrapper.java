package com.falchus.lib.minecraft.spigot.packets.wrapper.spawn.entity;

import java.lang.reflect.Field;
import java.util.Set;

import com.falchus.lib.minecraft.spigot.packets.wrapper.PacketWrapper;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
abstract class PacketSpawnEntityWrapper extends PacketWrapper {

	Field id;
	Field data;

	PacketSpawnEntityWrapper(@NonNull Object handle, @NonNull Set<String> names) {
		super(handle, names);

		id = getFirstField(
			"id",
			"a"
		);
		data = getFirstField(
			"data",
			"k"
		);
	}

	public void setId(int id) {
		setField(this.id, id);
	}

	public void setData(int data) {
		setField(this.data, data);
	}

	public int getId() {
		return getFieldValue(id);
	}

	public int getData() {
		return getFieldValue(data);
	}
}
