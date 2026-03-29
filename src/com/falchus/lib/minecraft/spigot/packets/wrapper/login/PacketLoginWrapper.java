package com.falchus.lib.minecraft.spigot.packets.wrapper.login;

import java.lang.reflect.Field;
import java.util.Set;

import com.falchus.lib.minecraft.spigot.packets.wrapper.PacketWrapper;

import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true)
abstract class PacketLoginWrapper extends PacketWrapper {
	
	Field playerId;
	Field hardcore;
	Field maxPlayers;
	Field reducedDebugInfo;

	PacketLoginWrapper(@NonNull Object handle, @NonNull Set<String> names) {
		super(handle, names);
		
		playerId = getFirstField(
			"playerId",
			"a"
		);
		hardcore = getFirstField(
			"hardcore",
			"b"
		);
		maxPlayers = getFirstField(
			"maxPlayers",
			"f"
		);
		reducedDebugInfo = getFirstField(
			"reducedDebugInfo",
			"h"
		);
	}
	
	public void setPlayerId(int playerId) {
		setField(this.playerId, playerId);
	}
	
	public void setHardcore(boolean hardcore) {
		setField(this.hardcore, hardcore);
	}
	
	public void setMaxPlayers(int maxPlayers) {
		setField(this.maxPlayers, maxPlayers);
	}
	
	public void setReducedDebugInfo(boolean reducedDebugInfo) {
		setField(this.reducedDebugInfo, reducedDebugInfo);
	}
	
	public int getPlayerId() {
		return getFieldValue(playerId);
	}
	
	public boolean getHardcore() {
		return getFieldValue(hardcore);
	}
	
	public int getMaxPlayers() {
		return getFieldValue(maxPlayers);
	}
	
	public boolean isReducedDebugInfo() {
		return getFieldValue(reducedDebugInfo);
	}
}
