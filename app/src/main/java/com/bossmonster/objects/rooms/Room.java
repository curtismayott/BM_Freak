package com.bossmonster.objects.rooms;

import com.bossmonster.objects.Card;
import com.bossmonster.objects.room_effects.RoomEffect;
import com.bossmonster.objects.treasures.Treasure;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/19/15.
 */
public class Room extends Card {
	ArrayList<Treasure> treasures;
	RoomEffect effect;
	int damage;

	public Room(){
		treasures = new ArrayList<>();
	}

	public Room(int cardID, int resourceID, String cardName, ArrayList<Treasure> treasures, RoomEffect effect, int damage){
		super(cardID, resourceID, cardName);
		setTreasures(treasures);
		setEffect(effect);
		setDamage(damage);
	}

	public ArrayList<Treasure> getTreasures() {
		return treasures;
	}

	public void setTreasures(ArrayList<Treasure> treasures) {
		this.treasures = treasures;
	}

	public RoomEffect getEffect() {
		return effect;
	}

	public void setEffect(RoomEffect effect) {
		this.effect = effect;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
