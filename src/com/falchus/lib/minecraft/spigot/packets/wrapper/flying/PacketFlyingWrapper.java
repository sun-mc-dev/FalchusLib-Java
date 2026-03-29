package com.falchus.lib.minecraft.spigot.packets.wrapper.flying;

import java.lang.reflect.Field;
import java.util.Set;

import com.falchus.lib.minecraft.spigot.packets.wrapper.PacketWrapper;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
abstract class PacketFlyingWrapper extends PacketWrapper {

	Field x;
	Field y;
	Field z;
	Field yaw;
	Field pitch;
	Field onGround;
	Field hasPos;
	Field hasRot;
	
	PacketFlyingWrapper(@NonNull Object handle, @NonNull Set<String> names) {
		super(handle, names);
		
		x = getField("x");
		y = getField("y");
		z = getField("z");
		yaw = getFirstField(
			"yaw",
			"yRot"
		);
		pitch = getFirstField(
			"pitch",
			"xRot"
		);
		onGround = getFirstField(
			"onGround",
			"f"
		);
		hasPos = getField("hasPos");
		hasRot = getFirstField(
			"hasRot",
			"hasLook"
		);
	}
	
	public void setX(double x) {
		setField(this.x, x);
	}
	
	public void setY(double y) {
		setField(this.y, y);
	}
	
	public void setZ(double z) {
		setField(this.z, z);
	}
	
	public void setYaw(float yaw) {
		setField(this.yaw, yaw);
	}
	
	public void setPitch(float pitch) {
		setField(this.pitch, pitch);
	}
	
	public void setOnGround(boolean onGround) {
		setField(this.onGround, onGround);
	}
	
	public void setHasPos(boolean hasPos) {
		setField(this.hasPos, hasPos);
	}
	
	public void setHasRot(boolean hasRot) {
		setField(this.hasRot, hasRot);
	}
	
	public double getX() {
		return getFieldValue(x);
	}
	
	public double getY() {
		return getFieldValue(y);
	}
	
	public double getZ() {
		return getFieldValue(z);
	}
	
	public float getYaw() {
		return getFieldValue(yaw);
	}
	
	public float getPitch() {
		return getFieldValue(pitch);
	}
	
	public boolean isOnGround() {
		return getFieldValue(onGround);
	}
	
	public boolean isHasPos() {
		return getFieldValue(hasPos);
	}
	
	public boolean isHasRot() {
		return getFieldValue(hasRot);
	}
}
