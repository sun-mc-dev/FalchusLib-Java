package com.falchus.lib.minecraft.spigot.packets.wrapper.playerlistheaderfooter;

import java.lang.reflect.Field;
import java.util.Set;

import com.falchus.lib.minecraft.spigot.packets.wrapper.PacketWrapper;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
abstract class PacketPlayerListHeaderFooterWrapper extends PacketWrapper {
	
	Field header;
	Field footer;

	PacketPlayerListHeaderFooterWrapper(@NonNull Object handle, @NonNull Set<String> names) {
		super(handle, names);
		
		header = getFirstField(
			"header",
			"a"
		);
		footer = getFirstField(
			"footer",
			"b"
		);
	}
	
	/**
	 * @param header: IChatBaseComponent
	 */
	public void setHeader(Object header) {
		setField(this.header, header);
	}
	
	/**
	 * @param footer: IChatBaseComponent
	 */
	public void setFooter(Object footer) {
		setField(this.footer, footer);
	}
	
	/**
	 * @return IChatBaseComponent
	 */
	public Object getHeader() {
		return getFieldValue(header);
	}
	
	/**
	 * @return IChatBaseComponent
	 */
	public Object getFooter() {
		return getFieldValue(footer);
	}
}
