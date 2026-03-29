package com.falchus.lib.minecraft.spigot.packets.wrapper.world.event;

import java.lang.reflect.Field;
import java.util.Set;

import com.falchus.lib.minecraft.spigot.packets.wrapper.PacketWrapper;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

// TODO: add PacketPlayOutWorldParticles wrapper
@FieldDefaults(makeFinal = true)
abstract class PacketWorldEventWrapper extends PacketWrapper {
	
	Field type;
	Field pos;
	Field data;
	Field globalEvent;

	PacketWorldEventWrapper(@NonNull Object handle, @NonNull Set<String> names) {
		super(handle, names);
		
		type = getFirstField(
			"type",
			"a"
		);
		pos = getFirstField(
			"pos",
			"b"
		);
		data = getFirstField(
			"data",
			"c"
		);
		globalEvent = getFirstField(
			"globalEvent",
			"d"
		);
	}
	
	public void setType(int type) {
		setField(this.type, type);
	}
	
	/**
	 * @param pos: BlockPosition
	 */
	public void setPos(Object pos) {
		setField(this.pos, pos);
	}
	
	public void setData(int data) {
		setField(this.data, data);
	}
	
	public void setGlobalEvent(boolean globalEvent) {
		setField(this.globalEvent, globalEvent);
	}
	
	public int getType() {
		return getFieldValue(type);
	}
	
	/**
	 * @return BlockPosition
	 */
	public Object getPos() {
		return getFieldValue(type);
	}
	
	public int getData() {
		return getFieldValue(data);
	}
	
	public boolean isGlobalEvent() {
		return getFieldValue(globalEvent);
	}
}
