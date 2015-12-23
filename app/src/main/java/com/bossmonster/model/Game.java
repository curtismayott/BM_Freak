package com.bossmonster.model;

import com.bossmonster.objects.Card;
import com.bossmonster.objects.Deck;
import com.bossmonster.objects.treasures.Treasure;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/19/15.
 */
public class Game {
	public ArrayList<Player> players;
	Deck deck;

	public Game(){
		deck = Deck.getInstance();
		deck.init();
	}

	public void startGame(ArrayList<Player> players){
		this.players = players;
		deck.shuffleAll();
	}

	public void dealFirstHand(){
		for(Player player : players){
			for(int i = 0; i < 2; i++){
				player.drawRoom(deck.popRoom());
			}
			/*
			for(int i = 0; i < 1; i++){
				player.drawSpell(deck.popSpell());
			}
			*/
		}
	}

	public ArrayList<ArrayList<Card>> getPlayersConstruction(){
		ArrayList<ArrayList<Card>> construction = new ArrayList<>();
		for(Player player : players){
			construction.add(player.getConstruction());
		}
		return construction;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player){
		players.add(player);
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public Card drawSpell(){
		return deck.popSpell();
	}

	public Card drawRoom(){
		return deck.popRoom();
	}

	public Card drawBoss(){
		return deck.popBoss();
	}

	public void discardCard(Card card){
		deck.discardCard(card);
	}

	public Player getBidWinner(Treasure treasure){
		Player player = players.get(0);
		for(Player p : getPlayers()){
			if(p.getNumMatchingTreasures(treasure) > player.getNumMatchingTreasures(treasure)){
				player = p;
			}
		}
		return player;
	}
}
