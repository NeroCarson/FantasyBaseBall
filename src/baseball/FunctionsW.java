package baseball;

import java.util.Scanner;
import models.League;
import models.LeagueMember;
import models.Player;
import models.Team;

public class FunctionsW extends League {
	public static Scanner sc = new Scanner(System.in);

	public static League theLeague = new League();

	public static Team theTeam = new Team();

	static void odraft(String playerName, String member) {
		
		LeagueMember.name = member;
		
			// find specified player object
			int index = 0;
			for (int j = 0; j < players.size(); j++) {
				// seperate loop for the pitchers???
				if (players.get(j).toString().toLowerCase().contains(playerName.toLowerCase())) {
					break;
				}
				index = j + 1;
			}
			System.out.println("String-->" + players.get(index));
			// convert the player string to player object
			Player playerObject = players.get(index);
			System.out.println("Object--> " + playerObject.toString());
			String theLine = players.get(index).toString();
			// extract the position
			String position = findPOS(theLine);
			System.out.println("Position--> " + position);

			switch (position) {
			case "C":

				if (theTeam.isPositionFilled(position)) {
					System.out.println("Position filled");
					break;
				}

				theTeam.c = playerObject; // add player to the team
				theTeam = LeagueMember.team; // team is assigned to leagueMember
				break;
			case "1B":
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
				theTeam.b1 = playerObject;
				theTeam = LeagueMember.team;
				break;
			case "2B":
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
				theTeam.b2 = playerObject;
				theTeam = LeagueMember.team;
				break;
			case "3B":
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
				theTeam.b3 = playerObject;
				theTeam = LeagueMember.team;
				break;
			case "SS":
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
				theTeam.ss = playerObject;
				theTeam = LeagueMember.team;
				break;
			case "LF":
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
				theTeam.lf = playerObject;
				theTeam = LeagueMember.team;
				break;
			case "CF":
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
				theTeam.cf = playerObject;
				theTeam = LeagueMember.team;
				break;
			case "RF":
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
				theTeam.rf = playerObject;
				theTeam = LeagueMember.team;
				break;
			case "P":
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
				// theTeam.p1 = pitcherObject;
				// theTeam =LeagueMember.team;
				// break;
			default:
				break;
			}
			
	
		System.out.println("Player " + playerName + " has been chosen");

	}

	// IDRAFT
	private static void idraft() {
		// // TODO Auto-generated method stub

	}

	// TEAM
	private static void team() {
		// TODO Auto-generated method stub

	}

	// STARS
	private static void stars() {
		// TODO Auto-generated method stub

	}

	public static String findPOS(String line) {
		String[] tokens = line.split("(\\S*(?:(['\"`]).*?\\2)\\S*)\\s?|\\s");
		return tokens[2];
	}

}
