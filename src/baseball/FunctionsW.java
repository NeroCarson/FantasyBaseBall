package baseball;

import java.util.Scanner;
import models.League;
import models.LeagueMember;
import models.Player;
import models.Team;

public class FunctionsW extends League {
	public static Scanner sc = new Scanner(System.in);

	// ODRAFT
	static void odraft() {
		LeagueMember a = new LeagueMember();
		LeagueMember b = new LeagueMember();
		LeagueMember c = new LeagueMember();
		LeagueMember d = new LeagueMember();
		
		int i = 0;
		while (i < 12) {
			int index = 0;
			System.out.println("Enter names for team 1: ");
			String playerName = sc.nextLine();
			// find specified player
			for (int j = 0; j < players.size(); j++) {
				if (players.get(j).toString().toLowerCase().contains(playerName.toLowerCase())) {
					break;
				}
				index = j + 1;
			}
			//System.out.println(players.get(index));
			String theLine = players.get(index).toString();
			String position = findPOS(theLine);
			switch (position) {
			case "C":
				a.team.c = players.get(index);
				break;
			case "1B": 
				a.team.b1 = players.get(index);
				break;
			case "2B":
				a.team.b2 = players.get(index);
				break;
			case "3B":
				a.team.b3 = players.get(index);
				break;
			case "SS":
				a.team.ss = players.get(index);
				break;
			case "LF":
				a.team.lf = players.get(index);
				break;
			case "CF":
				a.team.cf = players.get(index);
				break;
			case "RF":
				a.team.rf = players.get(index);
				break;
			case "P":
				a.team.p1 = pitchers.get(index);
				break;
			default:
				break;
			}

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
