package com.falchus.lib.minecraft.spigot.packets.wrapper.window.click;

import java.lang.reflect.Field;
import java.util.Set;

import com.falchus.lib.minecraft.spigot.packets.wrapper.PacketWrapper;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
abstract class PacketWindowClickWrapper extends PacketWrapper {
	
	Field containerId;
	Field slotNum;
	Field buttonNum;
	Field uid;

	PacketWindowClickWrapper(@NonNull Object handle, @NonNull Set<String> names) {
		super(handle, names);
		
		containerId = getFirstField(
			"containerId",
			"a"
		);
		slotNum = getFirstField(
			"slotNum",
			"b"
		);
		buttonNum = getFirstField(
			"buttonNum",
			"c"
		);
		uid = getFirstField(
			"uid",
			"d"
		);
	}
	
	public void setContainerId(int containerId) {
		setField(this.containerId, containerId);
	}
	
	public void setSlotNum(int slotNum) {
		setField(this.slotNum, slotNum);
	}
	
	public void setButtonNum(int buttonNum) {
		setField(this.buttonNum, buttonNum);
	}
	
	public void setUID(short uid) {
		setField(this.uid, uid);
	}
	
	public int getContainerId() {
		return getFieldValue(containerId);
	}
	
	public int getSlotNum() {
		return getFieldValue(slotNum);
	}
	
	public int getButtonNum() {
		return getFieldValue(buttonNum);
	}
	
	public short getUID() {
		return getFieldValue(uid);
	}
}
