package com.falchus.lib.minecraft.spigot.packets.wrapper.block.action;

import java.lang.reflect.Field;
import java.util.Set;

import com.falchus.lib.minecraft.spigot.packets.wrapper.PacketWrapper;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
abstract class PacketBlockActionWrapper extends PacketWrapper {
	
	Field pos;
	Field type;
	Field data;
	Field block;
	
	PacketBlockActionWrapper(@NonNull Object handle, @NonNull Set<String> names) {
		super(handle, names);
		
		pos = getFirstField(
			"pos",
			"a"
		);
		type = getFirstField(
			"b0",
			"b"
		);
		data = getFirstField(
			"b1",
			"c"
		);
		block = getFirstField(
			"block",
			"d"
		);
	}
	
	/**
	 * @param pos: BlockPosition
	 */
	public void setPos(Object pos) {
		setField(this.pos, pos);
	}
	
	public void setType(int type) {
		setField(this.type, type);
	}
	
	public void setData(int data) {
		setField(this.data, data);
	}
	
	/**
	 * @param block: Block
	 */
	public void setBlock(Object block) {
		setField(this.block, block);
	}
	
	/**
	 * @return BlockPosition
	 */
	public Object getPos() {
		return getFieldValue(pos);
	}
	
	public int getType() {
		return getFieldValue(type);
	}
	
	public int getData() {
		return getFieldValue(data);
	}
	
	public Object getBlock() {
		return getFieldValue(block);
	}
}
