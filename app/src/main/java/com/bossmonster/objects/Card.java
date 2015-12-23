package com.bossmonster.objects;

/**
 * Created by darkbobo on 12/19/15.
 */
public class Card {
	int cardID;
	int resourceID;
	String cardName;

	public Card(){

	}

	public Card(int cardID, int resourceID, String cardName){
		setCardID(cardID);
		setResourceID(resourceID);
		setCardName(cardName);
	}

	public void setCardID(int cardID){
		this.cardID = cardID;
	}

	public int getCardID(){
		return cardID;
	}

	public int getResourceID() {
		return resourceID;
	}

	public void setResourceID(int resourceID) {
		this.resourceID = resourceID;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
}
