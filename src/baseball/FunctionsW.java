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
		// System.out.println("String-->" + players.get(index));
		// convert the player string to player object
		// Player playerObject = players.get(index);
		// System.out.println("Object--> " + playerObject.toString());
		String theLine = players.get(index).toString();
		// extract the team + position
		String team = findTeam(theLine);
		String position = findPOS(theLine);

		System.out.println("Name-->" + playerName);
		System.out.println("Team-->" + team);
		System.out.println("Position--> " + position);

		switch (position) {
		case "C":
			Player playerObj1 = new Player(playerName, team, position);
			// Player playerObj1 = players.get(index);
			if (theTeam.isPositionFilled(position)) {
				System.out.println("Position filled");
				break;
			}
			theTeam.c = playerObj1; // add player to the team
			theTeam = LeagueMember.team; // team is assigned to leagueMember
			break;
		case "1B":
			Player playerObj2 = new Player(playerName, team, position);
//				Player playerObj2 = players.get(index);
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
			theTeam.b1 = playerObj2;
			theTeam = LeagueMember.team;
			break;
		case "2B":
			Player playerObj3 = new Player(playerName, team, position);
//				Player playerObj3 = players.get(index);
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
			theTeam.b2 = playerObj3;
			theTeam = LeagueMember.team;
			break;
		case "3B":
			Player playerObj4 = new Player(playerName, team, position);
//				Player playerObj4 = players.get(index);
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
			theTeam.b3 = playerObj4;
			theTeam = LeagueMember.team;
			break;
		case "SS":
			Player playerObj5 = new Player(playerName, team, position);
//				Player playerObj5 = players.get(index);
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
			theTeam.ss = playerObj5;
			theTeam = LeagueMember.team;
			break;
		case "LF":
			Player playerObj6 = new Player(playerName, team, position);
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
			theTeam.lf = playerObj6;
			theTeam = LeagueMember.team;
			break;
		case "CF":
			Player playerObj7 = new Player(playerName, team, position);
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
			theTeam.cf = playerObj7;
			theTeam = LeagueMember.team;
			break;
		case "RF":
			Player playerObj8 = new Player(playerName, team, position);
//				if (theTeam.isPositionFilled(position)) {
//					System.out.println("Position filled");
//					break;
//				}
			theTeam.rf = playerObj8;
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

		//System.out.println("Player " + playerName + " has been chosen");

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

	public static String findName(String line) {
		String[] tokens = line.split("(\\S*(?:(['\"`]).*?\\2)\\S*)\\s?|\\s");
		return tokens[0];

	}

	public static String findTeam(String line) {
		String[] tokens = line.split("(\\S*(?:(['\"`]).*?\\2)\\S*)\\s?|\\s");
		return tokens[1];
	}

	public static String findPOS(String line) {
		String[] tokens = line.split("(\\S*(?:(['\"`]).*?\\2)\\S*)\\s?|\\s");
		return tokens[2];
	}

}
