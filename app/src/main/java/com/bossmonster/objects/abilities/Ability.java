package com.bossmonster.objects.abilities;

/**
 * Created by darkbobo on 12/20/15.
 */
public class Ability {
	boolean playImmediately;
	int numCards;
	int numCardsDiscard;

	public boolean isPlayImmediately() {
		return playImmediately;
	}

	public void setPlayImmediately(boolean playImmediately) {
		this.playImmediately = playImmediately;
	}

	public int getNumCards() {
		return numCards;
	}

	public void setNumCards(int numCards) {
		this.numCards = numCards;
	}

	public int getNumCardsDiscard() {
		return numCardsDiscard;
	}

	public void setNumCardsDiscard(int numCardsDiscard) {
		this.numCardsDiscard = numCardsDiscard;
	}
}
