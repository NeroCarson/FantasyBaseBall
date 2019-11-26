package baseball;

import java.util.Scanner;
import models.League;

public class FunctionsW extends League {
	// ODRAFT
	public static Scanner sc = new Scanner(System.in);

	static void odraft() {
		int i = 0;
		// System.out.println(
		// "Draft 13 players(a catcher, a first, second and third baseman, a shortshop,
		// a left, right and center fieldman, and 5 pitchers : ");
		System.out.println("choose player ");
		String playerName = sc.next();
		int index = 0;
		
		while (i < 2) {

			int j = 0;
			
			// finds selected player
			for (j = 0; j < players.size(); j++) {
				if (players.getClass().getName() != null && players.getClass().getName().contains(playerName)) {
					index = j;
					break;

				}

			}
			i++;

		}
		System.out.println("Team--> " + );
	}

	// System.out.println(players.get(index));

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

}
