package baseball;

import java.util.ArrayList;
import models.League;
import models.LeagueMember;
import models.Player;

public class FunctionsW {

	public static void odraft(League league, String playerName, String memberName) {
		
		LeagueMember member;
		Player player;
		
		try {
			member = getMemberFromName(league, memberName);
			player = getPlayerFromName(league.players, playerName);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		if (member.team.isPositionFilled(player.pos)) {
			System.out.println("ERROR: You've already filled the position '" + player.pos + "'. No player drafted");
			return;
		}		
		
		switch(player.pos.toLowerCase()) {
		case "c":
			member.team.c = player;
			break;
		case "b1":
			member.team.b1 = player;
			break;
		case "b2":
			member.team.b2 = player;
			break;
		case "b3":
			member.team.b3 = player;
			break;
		case "ss":
			member.team.ss = player;
			break;
		case "lf":
			member.team.lf = player;
			break;
		case "cf":
			member.team.cf = player;
			break;
		case "rf":
			member.team.rf = player;
			break;
		}
	}
	
	
	public static void idraft(League league, String playerName) {
		odraft(league, playerName, "A");
	}
	
	private static LeagueMember getMemberFromName(League league, String name) throws IllegalArgumentException {
		switch (name.toLowerCase()) {
		case "a":
			return league.memberA;
		case "b":
			return league.memberB;
		case "c":
			return league.memberC;
		case "d":
			return league.memberD;
		default:
			throw new IllegalArgumentException("ERROR: League member '" + name + "' was not found. No player drafted");
		}
	}
	
	
	private static Player getPlayerFromName(ArrayList<Player> players, String playerName) throws IllegalArgumentException {
		
		Player[] array = players.stream()
				.filter(p -> p.name.toLowerCase().startsWith(playerName.toLowerCase()))
				.toArray(Player[]::new);
		
		// No player found
		if (array.length == 0) {
			throw new IllegalArgumentException("ERROR: A player named '" + playerName + "' was not found. No player drafted");
		}
		
		// Multiple players found
		if (array.length > 1) {
			throw new IllegalArgumentException("ERROR: More than one player matched '" + playerName + "'.\n"
					+ "Please provide a more specific name. No player drafted");
		}
		
		Player player = array[0];
		boolean isAvailable = player.selected == 0;
		if (!isAvailable) {
			throw new IllegalArgumentException("ERROR: Player '" + playerName + "' has already been selected. No player drafted");
		}
		
		return player;
	}
}
