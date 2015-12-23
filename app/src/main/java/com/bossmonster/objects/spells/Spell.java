package com.bossmonster.objects.spells;

import com.bossmonster.objects.Card;
import com.bossmonster.states.State;

/**
 * Created by darkbobo on 12/19/15.
 */
public class Spell extends Card {
	SpellEffect effect;
	State playTime;

	public Spell() {
	}

	public Spell(int cardID, int resourceID, String cardName, SpellEffect effect, State playTime) {
		super(cardID, resourceID, cardName);
	}

	public SpellEffect getEffect() {
		return effect;
	}

	public void setEffect(SpellEffect effect) {
		this.effect = effect;
	}

	public State getPlayTime() {
		return playTime;
	}

	public void setPlayTime(State playTime) {
		this.playTime = playTime;
	}
}
