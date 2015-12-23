package com.bossmonster.objects;

import com.bossmonster.objects.treasures.Treasure;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by darkbobo on 12/19/15.
 */
public class Hero extends Card {
	Treasure treasure;
	int lifePoints;
	String description;

	public Hero(){

	}

	public Hero(int cardID, int resourceID, String cardName, Treasure treasure, int lifePoints){
		super(cardID, resourceID, cardName);
		setTreasure(treasure);
		this.lifePoints = lifePoints;
	}

	public Treasure getTreasure() {
		return treasure;
	}

	public void setTreasure(Treasure treasure) {
		this.treasure = treasure;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
