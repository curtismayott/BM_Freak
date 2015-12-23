package com.bossmonster.model;

import com.bossmonster.objects.Card;
import com.bossmonster.objects.rooms.Room;
import com.bossmonster.objects.spells.Spell;
import com.bossmonster.objects.treasures.Treasure;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by darkbobo on 12/19/15.
 */
public class Player {
	ArrayList<Card> hand;
	ArrayList<Stack<Room>> dungeon;
	ArrayList<Card> construction;
	String name;

	public Player(){
		hand = new ArrayList<>();
		dungeon = new ArrayList<>();
		construction = new ArrayList<>();
	}

	public Player(String name){
		hand = new ArrayList<>();
		dungeon = new ArrayList<>();
		construction = new ArrayList<>();
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Card> getHand(){
		return hand;
	}

	public void addConstruction(Card card){
		construction.add(card);
	}

	public ArrayList<Card> getConstruction(){
		return construction;
	}

	public Card discardSpell(Card spell){
		Card discard = null;
		if(hand.contains(spell)){
			discard = spell;
			hand.remove(spell);
		}
		return discard;
	}

	public void drawSpell(Card spell){
		hand.add(spell);
	}

	public Card discardRoom(Card room){
		Card discard = null;
		if(hand.contains(room)){
			discard = room;
			hand.remove(room);
		}
		return discard;
	}

	public void drawRoom(Card room){
		hand.add(room);
	}

	public ArrayList<Room> getRooms(){
		ArrayList<Room> rooms = new ArrayList<>();
		for(Card card : hand){
			if(card instanceof Room){
				rooms.add((Room)card);
			}
		}
		return rooms;
	}

	public ArrayList<Room> getDungeon(){
		ArrayList<Room> rooms = new ArrayList<>();
		for(int i = 0; i < dungeon.size(); i++){
			rooms.add(dungeon.get(i).peek());
		}
		return rooms;
	}

	public ArrayList<Card> getSpells(){
		ArrayList<Card> spells = new ArrayList<>();
		for(Card card : hand){
			if(card instanceof Spell){
				spells.add(card);
			}
		}
		return spells;
	}

	public int getNumberClericsTreasure(){
		int sumClerics = 0;
		if(dungeon.size() >= 0) {
			for (Card card : dungeon.get(0)) {
				for (Treasure treasure : ((Room) card).getTreasures()) {
					if (treasure.isCleric()) {
						sumClerics++;
					}
				}
			}
		}
		return sumClerics;
	}

	public int getNumMatchingTreasures(Treasure treasure) {
		int value = 0;
		for (Stack<Room> stack : dungeon) {
			for(Treasure t : (stack.peek()).getTreasures()){
				if(t.equals(treasure)){
					value++;
				}
			}
		}
		return value;
	}

	public int getNumberWarriorsTreasure(){
		int sumWarriors = 0;
		for(Card card : dungeon.get(0)){
			for(Treasure treasure : ((Room)card).getTreasures()){
				if(treasure.isWarrior()){
					sumWarriors++;
				}
			}
		}
		return sumWarriors;
	}

	public int getNumberMagesTreasure(){
		int sumMages = 0;
		for(Card card : dungeon.get(0)){
			for(Treasure treasure : ((Room)card).getTreasures()){
				if(treasure.isMage()){
					sumMages++;
				}
			}
		}
		return sumMages;
	}

	public int getNumberTheivesTreasure(){
		int sumTheives = 0;
		for(Card card : dungeon.get(0)){
			for(Treasure treasure : ((Room)card).getTreasures()){
				if(treasure.isWarrior()){
					sumTheives++;
				}
			}
		}
		return sumTheives;
	}
}
