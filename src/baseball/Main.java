package baseball;

import java.io.IOException;
import java.util.Scanner;

import models.League;
import models.LeagueMember;
import models.Player;

public class Main {

	static Scanner sc = new Scanner(System.in);
	// Our League object that should be used to pass into load data to input all the
	// information.
	static League league = new League();

	public static void main(String[] args) throws IOException {
		league = loadData.openFile("stats.csv");
		//loadData.openFile("stats_pitcher.csv");
		// League.printPlayer();
		// System.out.println();
		// League.printPitcher();
		
		for (Player player : league.players) {
			System.out.println(player);
		}
		
		FunctionsW.odraft(league, "znderson, T", "A");
		FunctionsW.odraft(league, "Santana", "A");
		FunctionsW.odraft(league, "Anderson, T", "A");
		FunctionsW.odraft(league, "Newman, ", "A");
		
		System.out.println(league.memberA.team.c);
		System.out.println(league.memberA.team.b1);
		System.out.println(league.memberA.team.b2);
		System.out.println(league.memberA.team.b3);
		System.out.println(league.memberA.team.ss);
		System.out.println(league.memberA.team.lf);
		System.out.println(league.memberA.team.cf);
		System.out.println(league.memberA.team.rf);
		
		while (true) {
			System.out.println("Please choose an option by typing the corresponding number:");
			System.out.println("1:  ODRAFT");
			System.out.println("2:  IDRAFT");
			System.out.println("3:  OVERALL");
			System.out.println("4:  POVERALL");
			System.out.println("5:  TEAM");
			System.out.println("6:  STARS");
			System.out.println("7:  EVALFUN");
			System.out.println("8:  PEVALFUN");
			System.out.println("9:  SAVE");
			System.out.println("10: RESTORE");
			System.out.println("11: QUIT");

			String option = sc.next();
			if (option.equalsIgnoreCase("1")) {
				FunctionsW.odraft(league, "Anderson, T", "A");
//				FunctionsW.odraft("Anderson, T", "A");
//				FunctionsW.odraft("Ramos, W", "A");
//				FunctionsW.odraft("Anderson, T", "A");
//				FunctionsW.odraft("Anderson, B", "A");
//				FunctionsW.odraft("Lyn, L", "A");  // player not found
				FunctionsW.odraft(league, "Ryu, H", "A");
//				FunctionsW.odraft("Hudson, D", "A");
//				FunctionsW.odraft("no name, A", "A");  // player not found
			} else if (option.equalsIgnoreCase("2")) {
				// call idraft
			} else if (option.equalsIgnoreCase("3")) {
				// call overall
			} else if (option.equalsIgnoreCase("4")) {
				// call poverall
			} else if (option.equalsIgnoreCase("5")) {
				// call team
			} else if (option.equalsIgnoreCase("6")) {
				// call stars
			} else if (option.equalsIgnoreCase("7")) {
				// call evalfun
			} else if (option.equalsIgnoreCase("8")) {
				// call pevalfun
			} else if (option.equalsIgnoreCase("9")) {
				//FunctionsP.save(temp);
			} else if (option.equalsIgnoreCase("10")) {
				FunctionsP.restore();
			} else if (option.equalsIgnoreCase("11")) {
				//FunctionsP.quit(temp);

			} else {
				System.out.println("Not a valid option. Please choose between 1-11 available options.");
			}

		}

	}
}
