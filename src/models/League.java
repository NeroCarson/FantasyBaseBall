package models;

import java.util.ArrayList;

import baseball.loadData;

public class League {

	public LeagueMember memberA;
	public LeagueMember memberB;
	public LeagueMember memberC;
	public LeagueMember memberD;

	public ArrayList<Player> players = new ArrayList<Player>();
	public ArrayList<Pitcher> pitchers = new ArrayList<Pitcher>();

	public void printPlayer() {
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).toString());
		}
	}

	public void printPitcher() {
		for (int i = 0; i < pitchers.size(); i++) {
			System.out.println(pitchers.get(i).toString());
		}
	}
}
