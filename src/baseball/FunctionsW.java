package baseball;

import java.util.Scanner;
import models.League;
import models.LeagueMember;
import models.Pitcher;
import models.Player;
import models.Team;

public class FunctionsW extends League {

	public static Scanner sc = new Scanner(System.in);
	public static League theLeague = new League();
	public static Team theTeam = new Team();

	static void odraft(String playerName, String member) {
		if (!(member.equals("A") || member.contentEquals("B") || member.equals("C") || member.equals(("D")))) {
			System.out.println("LeagueMember was ommited/incorrect, no player was drafted");
			System.exit(0);
		}
		LeagueMember.name = member;

// if pitcher name found
		if (findPitchers(playerName)) {
			{
				int index_pitcher = 0;
				int i = 0;

				for (i = 0; i < pitchers.size(); i++) {
					if (pitchers.get(i).toString().toLowerCase().contains(playerName.toLowerCase()))
						break;
				}

				index_pitcher = i;
				Pitcher pitcherObj1 = pitchers.get(index_pitcher);
				System.out.println(pitcherObj1.toString());
				Team.p1 = pitcherObj1;
				theTeam = LeagueMember.team;
			}

			// pitcher name not found
			if (!(findPitchers(playerName))) {
				System.out.println("player not found!");
			}
		}

		// player name found
		else if (findPlayer(playerName)) {
			int index = 0;
			for (int j = 0; j < players.size(); j++) {
				if (players.get(j).toString().toLowerCase().contains(playerName.toLowerCase())) {
					break;
				}
				index = j + 1;
			}
			String theLine = players.get(index).toString();
			String position = findPOS(theLine);

			switch (position) {
			case "C":
				Player playerObj1 = players.get(index);
//					if (theTeam.isPositionFilled(position)) {
//						System.out.println("Position filled");
//						break;
//					}
				System.out.println(playerObj1.toString());
				Team.c = playerObj1; // add player to the team
				theTeam = LeagueMember.team; // team is assigned to leagueMember
				break;
			case "1B":
				Player playerObj2 = players.get(index);
//						if (theTeam.isPositionFilled(position)) {
//							System.out.println("Position filled");
//							break;
//						}
				System.out.println(playerObj2.toString());
				Team.b1 = playerObj2;
				theTeam = LeagueMember.team;
				break;
			case "2B":
				Player playerObj3 = players.get(index);
//						if (theTeam.isPositionFilled(position)) {
//							System.out.println("Position filled");
//							break;
//						}
				System.out.println(playerObj3.toString());
				Team.b2 = playerObj3;
				theTeam = LeagueMember.team;
				break;
			case "3B":
				Player playerObj4 = players.get(index);
//						if (theTeam.isPositionFilled(position)) {
//							System.out.println("Position filled");
//							break;
//						}
				System.out.println(playerObj4.toString());
				Team.b3 = playerObj4;
				theTeam = LeagueMember.team;
				break;
			case "SS":
				Player playerObj5 = players.get(index);
//						if (theTeam.isPositionFilled(position)) {
//							System.out.println("Position filled");
//							break;
//						}
				System.out.println(playerObj5.toString());
				Team.ss = playerObj5;
				theTeam = LeagueMember.team;
				break;
			case "LF":
				Player playerObj6 = players.get(index);
//						if (theTeam.isPositionFilled(position)) {
//							System.out.println("Position filled");
//							break;
//						}
				System.out.println(playerObj6.toString());
				Team.lf = playerObj6;
				theTeam = LeagueMember.team;
				break;
			case "CF":
				Player playerObj7 = players.get(index);
//						if (theTeam.isPositionFilled(position)) {
//							System.out.println("Position filled");
//							break;
//						}
				System.out.println(playerObj7.toString());
				Team.cf = playerObj7;
				theTeam = LeagueMember.team;
				break;
			case "RF":
				Player playerObj8 = players.get(index);
				if (theTeam.isPositionFilled(position)) {
					System.out.println("Position filled");
					break;
				}
				System.out.println(playerObj8.toString());
				Team.rf = playerObj8;
				theTeam = LeagueMember.team;
				break;
			default:
				break;
			}
		}

		else if (!(findPlayer(playerName))) {
			System.out.println("player not found!");
		}
	}

	// extract position

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

	public static boolean findPitchers(String playerName) {
		// find specified pitcher
		int found = -1;
		for (int i = 0; i < pitchers.size(); i++) {
			if (pitchers.get(i).toString().toLowerCase().contains(playerName.toLowerCase())) {
				found = 0;
				break;
			}
			else {
				System.out.println("err");
				break;
			}

		}
		if (found == 0)
			return true;
		else
			return false;

	}

	public static boolean findPlayer(String playerName) {
		// Find specified player
		int found = -1;
		for (int j = 0; j < players.size(); j++) {
			if (players.get(j).toString().toLowerCase().contains(playerName.toLowerCase())) {
				found = 0;
				break;
			}
			else {
				System.out.println("err");
				break;
			}
		}
		if (found == 0)
			return true;
		else
			return false;
	}

	public static String findPOS(String line) {
		String[] tokens = line.split("(\\S*(?:(['\"`]).*?\\2)\\S*)\\s?|\\s");
		return tokens[2];
	}

}