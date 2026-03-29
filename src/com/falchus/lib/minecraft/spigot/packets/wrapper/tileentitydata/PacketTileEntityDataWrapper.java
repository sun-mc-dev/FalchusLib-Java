package com.falchus.lib.minecraft.spigot.packets.wrapper.tileentitydata;

import java.lang.reflect.Field;
import java.util.Set;

import com.falchus.lib.minecraft.spigot.packets.wrapper.PacketWrapper;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
abstract class PacketTileEntityDataWrapper extends PacketWrapper {
	
	Field pos;
	Field type;
	Field tag;

	PacketTileEntityDataWrapper(@NonNull Object handle, @NonNull Set<String> names) {
		super(handle, names);
		
		pos = getFirstField(
			"pos",
			"a"
		);
		type = getFirstField(
			"type",
			"b"
		);
		tag = getFirstField(
			"tag",
			"c"
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
	
	/**
	 * @param tag: NBTTagCompound
	 */
	public void setTag(Object tag) {
		setField(this.tag, tag);
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
	
	/**
	 * @return NBTTagCompound
	 */
	public Object getTag() {
		return getFieldValue(tag);
	}
}
