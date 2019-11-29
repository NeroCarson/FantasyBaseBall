package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

import models.League;
import models.LeagueMember;
import models.Pitcher;
import models.Player;
import models.Team;

public class FunctionsW {

	public static Scanner sc = new Scanner(System.in);
	public static League theLeague = new League();
	public static Team theTeam = new Team();

	public static LeagueMember league1 = new LeagueMember("League1");

	static void odraft(String playerName, String member) {

		if (!(member.equals("A") || member.contentEquals("B") || member.equals("C") || member.equals(("D")))) {
			System.out.println("LeagueMember was ommited/incorrect, no player was drafted");
			System.exit(0);
		}

		league1.name = member;

		// if pitcher name found
		if (findPitchers(playerName)) {

			int index_pitcher = 0;

			int i = 0;
			for (Pitcher tmp : theLeague.pitchers) {
				for (i = 0; i < theLeague.pitchers.size(); i++) {
					if (theLeague.pitchers.get(i).toString().toLowerCase().contains(playerName.toLowerCase()))
						break;
				}
				index_pitcher = i + 1;
				Pitcher pitcherObj1 = theLeague.pitchers.get(index_pitcher);
				System.out.println(pitcherObj1);
				theTeam.p1 = pitcherObj1;
				theTeam = league1.team;

			}

		}
		// if player name found
		else if (findPlayer(playerName)) {
			int index = 0;
			for (int j = 0; j < theLeague.players.size(); j++) {
				if (theLeague.players.get(j).toString().toLowerCase().contains(playerName.toLowerCase())) {
					break;
				}
				index = j + 1;
			}
			// extract single line
			for (Player tmp : theLeague.players) {
				String theLine = theLeague.players.get(index).toString();
				String position = findPOS(theLine);

				switch (position) {
				case "C":
					Player playerObj1 = theLeague.players.get(index);
//					if (theTeam.isPositionFilled(position)) {
//						System.out.println("Position filled");
//						break;
//					}
					System.out.println(playerObj1.toString());
					theTeam.c = playerObj1; // add player to the team
					theTeam = league1.team; // team is assigned to leagueMember
					break;
				case "1B":
					Player playerObj2 = theLeague.players.get(index);
//						if (theTeam.isPositionFilled(position)) {
//							System.out.println("Position filled");
//							break;
//						}
					System.out.println(playerObj2.toString());
					theTeam.b1 = playerObj2;
					theTeam = league1.team;
					break;
				case "2B":
					Player playerObj3 = theLeague.players.get(index);
//						if (theTeam.isPositionFilled(position)) {
//							System.out.println("Position filled");
//							break;
//						}
					System.out.println(playerObj3.toString());
					theTeam.b2 = playerObj3;
					theTeam = league1.team;
					break;
				case "3B":
					Player playerObj4 = theLeague.players.get(index);
//						if (theTeam.isPositionFilled(position)) {
//							System.out.println("Position filled");
//							break;
//						}
					System.out.println(playerObj4.toString());
					theTeam.b3 = playerObj4;
					theTeam = league1.team;
					break;
				case "SS":
					Player playerObj5 = theLeague.players.get(index);
//						if (theTeam.isPositionFilled(position)) {
//							System.out.println("Position filled");
//							break;
//						}
					System.out.println(playerObj5.toString());
					theTeam.ss = playerObj5;
					theTeam = league1.team;
					break;
				case "LF":
					Player playerObj6 = theLeague.players.get(index);
//						if (theTeam.isPositionFilled(position)) {
//							System.out.println("Position filled");
//						/	break;
//						}
					System.out.println(playerObj6.toString());
					theTeam.lf = playerObj6;
					theTeam = league1.team;
					break;
				case "CF":
					Player playerObj7 = theLeague.players.get(index);
//						if (theTeam.isPositionFilled(position)) {
//							System.out.println("Position filled");
//							break;
//						}
					System.out.println(playerObj7.toString());
					theTeam.cf = playerObj7;
					theTeam = league1.team;
					break;
				case "RF":
					Player playerObj8 = theLeague.players.get(index);
					if (theTeam.isPositionFilled(position)) {
						System.out.println("Position filled");
						break;
					}
					System.out.println(playerObj8.toString());
					theTeam.rf = playerObj8;
					theTeam = league1.team;
					break;

				}
			}

		} else {
			System.out.println("player was not found");
		}
	}

	// IDRAFT
	private static void idraft() {
		// // TODO Auto-generated method stub

	}

	public static boolean findPitchers(String playerName) {

//		boolean found;
//		// loops through players lines
//		for (int i = 0; i < theLeague.players.size(); i++) {
//			if (theLeague.players.get(i).toString().toLowerCase().contains(playerName.toLowerCase())) {
//				found = true;
//				break;
//			}
//		}
//		if (found = true) {
//			return true;
//		} else
//			return false;
		// find specified pitcher
		boolean found;
		// loops through players lines
		for (int i = 0; i < theLeague.pitchers.size(); i++) {
			if (theLeague.pitchers.get(i).toString().toLowerCase().contains(playerName.toLowerCase())) {
				found = true;
				break;
			}
		}
		if (found = true) {
			return true;
		} else
			return false;
	}

	public static boolean findPlayer(String playerName) {
		boolean found;
		// loops through players lines
		for (int i = 0; i < theLeague.players.size(); i++) {
			if (theLeague.players.get(i).toString().toLowerCase().contains(playerName.toLowerCase())) {
				found = true;
				break;
			}
		}
		if (found = true) {
			return true;
		} else
			return false;
	}

//		Pattern name = Pattern.compile(Pattern.quote(playerName), Pattern.CASE_INSENSITIVE);
//		int found = -1;
//		for (Player player : theLeague.players) {
//			if (name.matcher(player.toString()).find()) {
//				found = 0;
//				break;
//			}
//
//		}
//		if (found == 0)
//			return true;
//		else {
//			return false;
//		}
//	}

	public static String findPOS(String line) {
		String[] tokens = line.split("(\\S*(?:(['\"`]).*?\\2)\\S*)\\s?|\\s");
		return tokens[2];
	}

}