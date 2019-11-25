package baseball;

import java.io.IOException;
import java.util.Scanner;

import models.League;

public class Main {

	static Scanner sc = new Scanner(System.in);
	//Our League object that should be used to pass into load data to input all the information.
	static League temp = new League();
	
	public static void main(String[] args) throws IOException {
		loadData.openFile("stats.csv");
		loadData.openFile("stats_pitcher.csv");
		// League.printPlayer();
		// System.out.println();
		// League.printPitcher();

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
				FunctionsW.odraft(); //needs work
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
				FunctionsP.save();
			} else if (option.equalsIgnoreCase("10")) {
				FunctionsP.restore();
			} else if (option.equalsIgnoreCase("11")) {
				FunctionsP.quit();
			} else {
				System.out.println("Not a valid option. Please choose between 1-11 available options.");
			}

		}

	}
}
