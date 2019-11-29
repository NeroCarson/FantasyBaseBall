package models;

import java.util.ArrayList;

public class League {

	public LeagueMember memberA;
	public LeagueMember memberB;
	public LeagueMember memberC;
	public LeagueMember memberD;

	public ArrayList<Player> players;
	public ArrayList<Pitcher> pitchers;

	public League() {
		memberA = new LeagueMember("A");
		memberB = new LeagueMember("B");
		memberC = new LeagueMember("C");
		memberD = new LeagueMember("D");
		players = new ArrayList<>();
		pitchers = new ArrayList<>();
	}
	
	public LeagueMember getMemberFromName(String name) throws IllegalArgumentException {
		switch (name.toLowerCase()) {
		case "a":
			return memberA;
		case "b":
			return memberB;
		case "c":
			return memberC;
		case "d":
			return memberD;
		default:
			throw new IllegalArgumentException("ERROR: League member '" + name + "' was not found. No player drafted");
		}
	}
	
	public Person getPersonFromName(String playerName) throws IllegalArgumentException {
		
		Player[] matchingPlayers = players.stream()
				.filter(p -> p.name.toLowerCase().startsWith(playerName.toLowerCase()))
				.toArray(Player[]::new);
		
		Pitcher[] matchingPitchers = pitchers.stream()
				.filter(p -> p.name.toLowerCase().startsWith(playerName.toLowerCase()))
				.toArray(Pitcher[]::new);
		
		// No player found
		if (matchingPlayers.length == 0 && matchingPitchers.length == 0) {
			throw new IllegalArgumentException("ERROR: A player named '" + playerName + "' was not found. No player drafted");
		}
		
		// Multiple players found
		if (matchingPlayers.length + matchingPitchers.length > 1) {
			throw new IllegalArgumentException("ERROR: More than one player matched '" + playerName + "'.\n"
					+ "Please provide a more specific name. No player drafted");
		}
		
		Person foundPlayer;
		if (matchingPlayers.length == 1) {
			foundPlayer = matchingPlayers[0];
		} else {
			foundPlayer = matchingPitchers[0];
		}
		
		boolean isAvailable = foundPlayer.selected == 0;
		if (!isAvailable) {
			throw new IllegalArgumentException("ERROR: Player '" + playerName + "' has already been selected. No player drafted");
		}
		
		return foundPlayer;
	}
}