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
		int team = 0;
		while (team < 3) {
			// find specified player object
			int index = 0;
			for (int j = 0; j < players.size(); j++) {
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

			LeagueMember.name = member; 
			
			// Player thePlayer = theLine;
			switch (position) {
			case "C":
//				for(int i = 0; i < theLeague.team; i++) {
//					if(League.players.contains(playerName)) {
//						System.out.println("player already drafted");
//					}
//				}
				theTeam.c = playerObject; // add player to the team
				theTeam =LeagueMember.team; // player is assigned to leagueMember
				break;
			case "1B":
				theTeam.b1 = playerObject;
				theTeam =LeagueMember.team;
				break;
			case "2B":
				theTeam.b2 = playerObject;
				theTeam =LeagueMember.team;
				break;
			case "3B":
				theTeam.b3 = playerObject;
				theTeam =LeagueMember.team;
				break;
			case "SS":
				theTeam.ss = playerObject;
				theTeam =LeagueMember.team;
				break;
			case "LF":
				theTeam.lf = playerObject;
				theTeam =LeagueMember.team;
				break;
			case "CF":
				theTeam.cf = playerObject;
				theTeam =LeagueMember.team;
				break;
			case "RF":
				theTeam.rf = playerObject;
				theTeam =LeagueMember.team;
				break;
			case "P":
				theTeam.p1 = pitcherObject;
				theTeam =LeagueMember.team;
				break;
			default:
				break;
			}
			team++;
		}

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
