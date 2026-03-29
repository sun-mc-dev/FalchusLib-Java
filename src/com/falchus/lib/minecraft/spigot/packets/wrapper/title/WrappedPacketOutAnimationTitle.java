package com.falchus.lib.minecraft.spigot.packets.wrapper.title;

import java.lang.reflect.Field;
import java.util.Set;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
public class WrappedPacketOutAnimationTitle extends PacketTitleWrapper {

	Field fadeInTime;
	Field stayTime;
	Field fadeOutTime;
	
	WrappedPacketOutAnimationTitle(@NonNull Object handle) {
		super(handle, Set.of(
				version.getPackageNms() + "PacketPlayOutTitle",
				networkProtocolGame + "ClientboundSetTitlesAnimationPacket"
			)
		);
		
		fadeInTime = getFirstField(
			"fadeInTime",
			"fadeIn",
			"c"
		);
		stayTime = getFirstField(
			"stayTime",
			"stay",
			"d"
		);
		fadeOutTime = getFirstField(
			"fadeOutTime",
			"fadeOut",
			"e"
		);
	}
	
	public void setFadeInTime(int fadeInTime) {
		setField(this.fadeInTime, fadeInTime);
	}
	
	public void setStayTime(int stayTime) {
		setField(this.stayTime, stayTime);
	}
	
	public void setFadeOutTime(int fadeOutTime) {
		setField(this.fadeOutTime, fadeOutTime);
	}
	
	public int getFadeInTime() {
		return getFieldValue(fadeInTime);
	}
	
	public int getStayTime() {
		return getFieldValue(stayTime);
	}
	
	public int getFadeOutTime() {
		return getFieldValue(fadeOutTime);
	}
}
