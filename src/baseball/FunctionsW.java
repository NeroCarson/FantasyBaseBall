package baseball;

import models.*;

public class FunctionsW {

	public static void odraft(League league, String playerName, String memberName) {
		LeagueMember member;
		Person person;

		try {
			member = league.getMemberFromName(memberName);
			person = league.getPersonFromName(playerName);

			if (person.getClass() == Player.class) {
				Player player = (Player) person;
				draftPlayer(member, player);
			} else if (person.getClass() == Pitcher.class) {
				Pitcher pitcher = (Pitcher) person;
				draftPitcher(member, pitcher);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}

	}

	
	public static void idraft(League league, String playerName) {
		odraft(league, playerName, "A");
	}

	
	private static void draftPlayer(LeagueMember member, Player player) {
		if (member.team.isPositionFilled(player.pos)) {
			System.out.println("ERROR: You've already filled the position '" + player.pos + "'. No player drafted");
			return;
		}
		
		boolean success = member.team.addPlayer(player);
		if (success) {
			member.recruits += 1;
			player.selected = member.recruits;
			System.out.println("You've recruited " + player.name + " for the position of " + player.pos);
		} else {
			System.out.println("ERROR: An unknown error occurred while trying to recruit " + player.name);
		}
	}

	
	private static void draftPitcher(LeagueMember member, Pitcher pitcher) {

		if (member.team.isPositionFilled("p")) {
			System.out.println("ERROR: You've already filled the position 'p'. No player drafted");
			return;
		}
		boolean success = member.team.addPitcher(pitcher);
		if (success) {
			member.recruits += 1;
			pitcher.selected = member.recruits;
			System.out.println("You've recruited " + pitcher.name + " for the position of pitcher");
		} else {
			System.out.println("ERROR: An unknown error occurred while trying to recruit " + pitcher.name);
		}
	}
}
