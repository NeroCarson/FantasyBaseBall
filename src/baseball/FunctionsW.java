package baseball;

import java.util.Scanner;
import models.League;
import models.LeagueMember;
import models.Player;
import models.Team;

public class FunctionsW extends League {
	public static Scanner sc = new Scanner(System.in);
	public static League theLeague = new League();

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
				for(int i = 0; i < theLeague.players; i++) {
					if(LeagueMember.team.contains(playerName)) {
						System.out.println("player already drafted");
					}
				}
				
				LeagueMember.team.c = playerObject; // add player to the team
				break;
			case "1B":
				LeagueMember.team.b1 = playerObject;
				break;
			case "2B":
				LeagueMember.team.b2 = playerObject;
				break;
			case "3B":
				LeagueMember.team.b3 = playerObject;
				break;
			case "SS":
				LeagueMember.team.ss = playerObject;
				break;
			case "LF":
				LeagueMember.team.lf = playerObject;
				break;
			case "CF":
				LeagueMember.team.cf = playerObject;
				break;
			case "RF":
				LeagueMember.team.rf = playerObject;
				break;
			case "P":
				LeagueMember.team.p1 = pitcherObject;
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
