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
			{
				int index_pitcher = 0;
				int i = 0;

				for (i = 0; i < theLeague.pitchers.size(); i++) {
					if (theLeague.pitchers.get(i).toString().toLowerCase().contains(playerName.toLowerCase()))
						break;
				}

				index_pitcher = i;
				Pitcher pitcherObj1 = theLeague.pitchers.get(index_pitcher);
				System.out.println(pitcherObj1.toString());
				theTeam.p1 = pitcherObj1;
				theTeam = league1.team;
			}

//			// pitcher name not found
//			if (!(findPitchers(playerName))) {
//				System.out.println("player not found!");
//			}
		}

		// player name found
		else if (findPlayer(playerName)) {
			int index = 0;
			for (int j = 0; j < theLeague.players.size(); j++) {
				if (theLeague.players.get(j).toString().toLowerCase().contains(playerName.toLowerCase())) {
					break;
				}
				index = j + 1;
			}
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
//							break;
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
			default:
				break;
			}
		}

//		else if (!(findPlayer(playerName))) {
//			System.out.println("player not found!");
//		}
	}

	// extract position

	// IDRAFT
	private static void idraft() {
		// // TODO Auto-generated method stub

	}

	

	public static boolean findPitchers(String playerName) {
		// find specified pitcher
		int found = -1;
		for (int i = 0; i < theLeague.pitchers.size(); i++) {
			if (theLeague.pitchers.get(i).toString().toLowerCase().contains(playerName.toLowerCase())) {
				found = 0;
				break;
			} else {
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
//		Pattern name = Pattern.compile(Pattern.quote(playerName), Pattern.CASE_INSENSITIVE);
//		Player foundPlayer = null;
//		for(Player player : theLeague.players) {
//			if(name.matcher(player.toString()).find()) {
//				if(foundPlayer != null)
//					throw new IllegalArgumentException("multiple player matches: " + playerName);
//				foundPlayer = player;
//			}
//		}
//		if (foundPlayer != null) return true;
//		else return false;
		
		
		
		// Find specified player
		int found = -1;
		for (int j = 0; j < theLeague.players.size(); j++) {
			if (theLeague.players.get(j).toString().toLowerCase().contains(playerName.toLowerCase())) {
				found = 0;
				break;
			} else {
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