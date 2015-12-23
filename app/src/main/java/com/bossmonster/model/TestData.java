package com.bossmonster.model;

import java.util.ArrayList;

/**
 * Created by darkbobo on 12/22/15.
 */
public class TestData {
	public static ArrayList<Player> players;

	public static ArrayList<Player> setupPlayers(){
		players = new ArrayList<>();
		players.add(new Player("curtis"));
		players.add(new Player("sophia"));
		players.add(new Player("travis"));
		players.add(new Player("karyn"));
		return players;
	}
}