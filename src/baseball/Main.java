package baseball;

import java.io.IOException;
import java.util.Scanner;
import models.*;

public class Main {

	public static void main(String[] args) throws IOException {

		League league = loadData.openFile("stats.csv", "stats_pitcher.csv");
		String input;
		String[] command = null;

		try (Scanner scanner = new Scanner(System.in)) {

			do {

				try {

					System.out.print("Enter command: ");
					input = scanner.nextLine();
					command = input.split("(?<!,)[ \"]+");

					if (command == null || command.length == 0) {
						throw new IllegalArgumentException();
					}

					switch (command[0].toLowerCase()) {
					case "odraft":
						if (command.length < 3) {
							throw new IllegalArgumentException();
						}
						FunctionsW.odraft(league, command[1], command[2].trim());
						break;

					case "idraft":
						if (command.length < 2) {
							throw new IllegalArgumentException();
						}
						FunctionsW.idraft(league, command[1]);
						break;

					case "overall":
						String position = "";
						if (command.length > 1) {
							position = command[1];
						}
						FunctionsJ.overall(league.players, league.memberA, position);
						break;

					case "poverall":
						FunctionsJ.poverall(league.pitchers, league.memberA);
						break;

					case "team":
						if (command.length < 2) {
							throw new IllegalArgumentException();
						}
						LeagueMember memberTeam = league.getMemberFromName(command[1]);
						FunctionsP.team(memberTeam);
						break;
					case "stars":
						if (command.length < 2) {
							throw new IllegalArgumentException();
						}
						LeagueMember memberStars = league.getMemberFromName(command[1]);
						FunctionsP.team(memberStars);
						break;
					case "save":
						if (command.length < 2) {
							throw new IllegalArgumentException();
						}
						FunctionsP.save(league, command[1]);
						break;
					case "quit":
						System.out.println("Would you like to save before quiting: yes or no");
						String saveAnswer = scanner.next();
						if(saveAnswer.equalsIgnoreCase("yes")) {
							break;
						}
						else {
							FunctionsP.quit(league);
						}
					case "restore":
						if (command.length < 2) {
							throw new IllegalArgumentException();
						}
						FunctionsP.restore(league, command[1]);
						break;
					case "evalfun":
						if (command.length < 2) {
							throw new IllegalArgumentException();
						}
						FunctionsJ.evalfun(league.players, command[1]);
						break;
					case "pevalfun":
						if (command.length < 2) {
							throw new IllegalArgumentException();
						}
						FunctionsJ.pevalfun(league.pitchers, command[1]);
						break;
					default:
						System.out.println("ERROR: Command '" + command[0] + "' not recognized.");
					}

				} catch (IllegalArgumentException e) {
					System.out.println("ERROR: Wrong number of arguments provided.");
				}
			} while (!"quit".equals(command[0]));
		}
		System.out.println("\nGoodbye!");
	}
}
