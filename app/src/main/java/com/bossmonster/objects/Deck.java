package com.bossmonster.objects;

import com.bossmonster.R;
import com.bossmonster.objects.abilities.DestroyRoom;
import com.bossmonster.objects.abilities.DrawCards;
import com.bossmonster.objects.abilities.FindCard;
import com.bossmonster.objects.abilities.GetHero;
import com.bossmonster.objects.abilities.StealVisibleCard;
import com.bossmonster.objects.room_effects.RoomEffect;
import com.bossmonster.objects.rooms.AdvancedTrapRoom;
import com.bossmonster.objects.rooms.Room;
import com.bossmonster.objects.rooms.TrapRoom;
import com.bossmonster.objects.spells.Spell;
import com.bossmonster.objects.treasures.ClericTreasure;
import com.bossmonster.objects.treasures.MageTreasure;
import com.bossmonster.objects.treasures.ThiefTreasure;
import com.bossmonster.objects.treasures.Treasure;
import com.bossmonster.objects.treasures.WarriorTreasure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by darkbobo on 12/19/15.
 */
public class Deck {
	private static Stack<Card> spells;
	private static Stack<Card> spellDiscards;
	private static Stack<Card> bosses;
	private static Stack<Card> rooms;
	private static Stack<Card> roomDiscards;
	private static Stack<Card> heroes;
	private static Stack<Card> epicHeroes;
	private static ArrayList<Card> removedFromGame;
	private static Deck deck;

	public static Deck getInstance(){
		if(deck == null){
			deck = new Deck();
			deck.init();
			deck.shuffleAll();
		}
		return deck;
	}



	public void shuffleAll(){
		for(int i = 0; i < 10; i++) {
			Collections.shuffle(spells);
			Collections.shuffle(bosses);
			Collections.shuffle(rooms);
			Collections.shuffle(heroes);
			Collections.shuffle(epicHeroes);
		}
	}

	public Stack<Card> getSpells() {
		return spells;
	}

	public Card popSpell(){
		return spells.pop();
	}

	public void setSpells(Stack<Card> spells) {
		this.spells = spells;
	}

	public Stack<Card> getSpellDiscards() {
		return spellDiscards;
	}

	public void setSpellDiscards(Stack<Card> spellDiscards) {
		this.spellDiscards = spellDiscards;
	}

	public Stack<Card> getBosses() {
		return bosses;
	}

	public Card popBoss(){
		return bosses.pop();
	}

	public void setBosses(Stack<Card> bosses) {
		this.bosses = bosses;
	}

	public Stack<Card> getRooms() {
		return rooms;
	}

	public void setRooms(Stack<Card> rooms) {
		this.rooms = rooms;
	}

	public Card popRoom(){
		return rooms.pop();
	}

	public Stack<Card> getRoomDiscards() {
		return roomDiscards;
	}

	public void setRoomDiscards(Stack<Card> roomDiscards) {
		this.roomDiscards = roomDiscards;
	}

	public void discardCard(Card card) {
		if(card instanceof Room){
			roomDiscards.add(card);
		}else if(card instanceof Spell){
			spellDiscards.add(card);
		}
	}

	public void removeCardFromGame(Card card){
		removedFromGame.add(card);
	}

	public Card getHero(){
		if(heroes.size() >= 0) {
			return heroes.pop();
		}else{
			return epicHeroes.pop();
		}
	}

	public void init(){
		spells = new Stack<>();
		spellDiscards = new Stack<>();
		rooms = new Stack<>();
		roomDiscards = new Stack<>();
		bosses = new Stack<>();
		heroes = new Stack<>();
		epicHeroes = new Stack<>();
		removedFromGame = new ArrayList<>();

		bosses.add(new Boss(1, R.drawable.cleopatra, "Cleopatra", new ThiefTreasure(), new FindCard()));
		bosses.add(new Boss(2, R.drawable.gorgona, "Gorgona", new ThiefTreasure(), new GetHero()));
		bosses.add(new Boss(3, R.drawable.seducia, "Seducia", new MageTreasure(), new GetHero()));
		bosses.add(new Boss(4, R.drawable.robobo, "Robobo", new WarriorTreasure(), new DestroyRoom()));
		bosses.add(new Boss(5, R.drawable.draculord, "Draculord", new ClericTreasure(), new StealVisibleCard()));
		bosses.add(new Boss(6, R.drawable.king_croak, "King Croak", new WarriorTreasure(), new FindCard()));
		bosses.add(new Boss(7, R.drawable.cerebellus, "Cerebellus", new MageTreasure(), new DrawCards()));
		bosses.add(new Boss(8, R.drawable.xyzax, "Xyzax", new ClericTreasure(), new DrawCards()));

		heroes.add(new Hero(9, R.drawable.the_fool, "The Fool", null, 2));
		heroes.add(new Hero(10, R.drawable.thief_4_1, "Thief", new ThiefTreasure(), 4));
		heroes.add(new Hero(11, R.drawable.thief_4_2, "Thief", new ThiefTreasure(), 4));
		heroes.add(new Hero(12, R.drawable.thief_6_1, "Thief", new ThiefTreasure(), 6));
		heroes.add(new Hero(13, R.drawable.thief_6_2, "Thief", new ThiefTreasure(), 6));
		heroes.add(new Hero(14, R.drawable.thief_8_1, "Thief", new ThiefTreasure(), 8));
		heroes.add(new Hero(15, R.drawable.thief_8_2, "Thief", new ThiefTreasure(), 8));

		int cardID = 100;
		ArrayList<Treasure> singleThief = new ArrayList<>();
		singleThief.add(new ThiefTreasure());
		ArrayList<Treasure> doubleThief = new ArrayList<>();
		doubleThief.add(new ThiefTreasure());
		doubleThief.add(new ThiefTreasure());
		for(int i = 0 ; i < 3; i++){
			rooms.add(new TrapRoom(cardID, R.drawable.dizzygas_hallway, "Dizzygas Hallway", singleThief, new RoomEffect(), 1));
			cardID++;
			rooms.add(new TrapRoom(cardID, R.drawable.boulder_ramp, "Boulder Ramp", singleThief, new RoomEffect(), 1));
			cardID++;
			rooms.add(new TrapRoom(cardID, R.drawable.jackpot_stash, "Jackpot Stash", doubleThief, new RoomEffect(), 1));
			cardID++;
			rooms.add(new TrapRoom(cardID, R.drawable.bottomless_pit, "Bottomless Pit", singleThief, new RoomEffect(), 1));
			cardID++;
		}
		for(int i = 0; i < 2; i++){
			rooms.add(new AdvancedTrapRoom(cardID, R.drawable.the_crushinator, "The Crushinator", singleThief, new RoomEffect(), 1));
			cardID++;
			rooms.add(new AdvancedTrapRoom(cardID, R.drawable.recycling_center, "Recycling Center", singleThief, new RoomEffect(), 3));
		}


	}
}
