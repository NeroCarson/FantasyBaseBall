package baseball;

import java.util.Scanner;
import models.League;

public class FunctionsW extends League {
	// ODRAFT
	public static Scanner sc = new Scanner(System.in);

	
	// figure out how to add specific players to roster!!
	static void odraft() {
		System.out.println("enter name: ");
		String playerName = sc.next();

		
		
		int index = 0;
		@SuppressWarnings("unlikely-arg-type")
		boolean isFound = players.contains(playerName);
		for (int i = 0; i < players.size(); i++) {
			if (players.getClass().getName() != null && players.getClass().getName().contains(playerName)) {
				
				break;
				
			}
			index = i;
			
		}

		System.out.println(players.get(index));
		// "Alberto, H"
		// while (i < 2) {
//			
//
//			// System.out.println(
//			// "Draft 13 players(a catcher, a first, second and third baseman, a shortshop,
//			// a left, right and center fieldman, and 5 pitchers : ");
//			System.out.println("choose player ");
//		
//			String playerName = sc.next();
//			int index = 0;
//
//			int j = 0;
//
//			// finds selected player
//			for (j = 0; j < players.size(); j++) {
//				if (players.getClass().getName() != null && players.getClass().getName().contains(playerName)) {
//					index = j;
//					break;
//				}
//
//			}
//			i++;
//			System.out.println(players.get(index));

	}
	// System.out.println("Team--> " + players.get(index) );

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
