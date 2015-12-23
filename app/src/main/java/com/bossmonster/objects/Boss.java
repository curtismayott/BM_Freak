package com.bossmonster.objects;

import com.bossmonster.objects.abilities.Ability;
import com.bossmonster.objects.treasures.Treasure;

/**
 * Created by darkbobo on 12/19/15.
 */
public class Boss extends Card {
	Treasure treasure;
	Ability levelUp;
	boolean isLeveledUp;

	public Boss(int cardID, int resourceID, String cardName, Treasure treasure, Ability levelUp){
		super(cardID, resourceID, cardName);
		setTreasure(treasure);
		setLevelUp(levelUp);
		setIsLeveledUp(false);
	}

	public Treasure getTreasure() {
		return treasure;
	}

	public void setTreasure(Treasure treasure) {
		this.treasure = treasure;
	}

	public Ability getLevelUp() {
		return levelUp;
	}

	public void setLevelUp(Ability levelUp) {
		this.levelUp = levelUp;
	}

	public boolean isLeveledUp() {
		return isLeveledUp;
	}

	public void setIsLeveledUp(boolean isLeveledUp) {
		this.isLeveledUp = isLeveledUp;
	}
}
