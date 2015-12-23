package com.bossmonster.objects.rooms;

import com.bossmonster.objects.room_effects.RoomEffect;
import com.bossmonster.objects.treasures.Treasure;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/19/15.
 */
public class AdvancedTrapRoom extends TrapRoom {
	public AdvancedTrapRoom() {
	}

	public AdvancedTrapRoom(int cardID, int resourceID, String cardName, ArrayList<Treasure> treasures, RoomEffect effect, int damage) {
		super(cardID, resourceID, cardName, treasures, effect, damage);
	}
}
