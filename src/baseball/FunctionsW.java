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
		LeagueMember A = new LeagueMember();
		LeagueMember B = new LeagueMember();
		LeagueMember C = new LeagueMember();
		LeagueMember D = new LeagueMember();

		Team a = new Team();
		Team b = new Team();
		Team c = new Team();
		Team d = new Team();

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
				a.c = players.get(index);
				break;
			case "1B": 
				a.b1 = players.get(index);
				break;
			case "2B":
				a.b2 = players.get(index);
				break;
			case "3B":
				a.b3 = players.get(index);
				break;
			case "SS":
				a.ss = players.get(index);
				break;
			case "LF":
				a.lf = players.get(index);
				break;
			case "CF":
				a.cf = players.get(index);
				break;
			case "RF":
				a.rf = players.get(index);
				break;
			case "P":
				a.p1 = pitchers.get(index);
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
