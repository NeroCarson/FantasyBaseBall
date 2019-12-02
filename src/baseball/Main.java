package baseball;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.*;

public class Main {

	public static void main(String[] args) throws IOException {

		League league = loadData.openFile("stats.csv", "stats_pitcher.csv");
		String input;
		ArrayList<String> command = new ArrayList<>();

		try (Scanner scanner = new Scanner(System.in)) {

			do {

				try {

					System.out.print("Enter command: ");
					input = scanner.nextLine();
					
					Pattern pattern = Pattern.compile("([\\w+\\-*\\/\\.]+)|\"([^\"]+)\"");
					Matcher matcher = pattern.matcher(input);
					command.clear();
					while (matcher.find()) {
						command.add(matcher.group().replaceAll("\"", ""));
					}

					if (command.size() == 0) {
						throw new IllegalArgumentException();
					}

					switch (command.get(0).toLowerCase()) {
					case "odraft":
						if (command.size() < 3) {
							throw new IllegalArgumentException();
						}
						FunctionsW.odraft(league, command.get(1), command.get(2));
						break;

					case "idraft":
						if (command.size() < 2) {
							throw new IllegalArgumentException();
						}
						FunctionsW.idraft(league, command.get(1));
						break;

					case "overall":
						String position = "";
						if (command.size() > 1) {
							position = command.get(1);
						}
						FunctionsJ.overall(league.players, league.memberA, position);
						break;

					case "poverall":
						FunctionsJ.poverall(league.pitchers, league.memberA);
						break;

					case "team":
						if (command.size() < 2) {
							throw new IllegalArgumentException();
						}
						LeagueMember memberTeam = league.getMemberFromName(command.get(1));
						FunctionsP.team(memberTeam);
						break;
					case "stars":
						if (command.size() < 2) {
							throw new IllegalArgumentException();
						}
						LeagueMember memberStars = league.getMemberFromName(command.get(1));
						FunctionsP.stars(memberStars);
						break;
					case "save":
						if (command.size() < 2) {
							throw new IllegalArgumentException();
						}
						FunctionsP.save(league, command.get(1));
						break;
					case "quit":
						System.out.println("Would you like to save before quiting: yes or no");
						String saveAnswer = scanner.next();
						if(saveAnswer.equalsIgnoreCase("yes")) {
							break;
						}
						else {
							FunctionsP.quit();
						}
					case "restore":
						if (command.size() < 2) {
							throw new IllegalArgumentException();
						}
						FunctionsP.restore(league, command.get(1));
						break;
					case "evalfun":
						if (command.size() < 2) {
							throw new IllegalArgumentException();
						}
						String[] evalFunction = command.stream().skip(1).toArray(String[]::new);
						FunctionsJ.evalfun(league.players, evalFunction);
						break;
					case "pevalfun":
						if (command.size() < 2) {
							throw new IllegalArgumentException();
						}
						String[] pevalFunction = command.stream().skip(1).toArray(String[]::new);
						FunctionsJ.pevalfun(league.pitchers, pevalFunction);
						break;
					default:
						System.out.println("ERROR: Command '" + command.get(0) + "' not recognized.");
					}

				} catch (IllegalArgumentException e) {
					System.out.println("ERROR: Wrong number of arguments provided.");
				}
			} while (!"quit".equals(command.get(0)));
		}
		System.out.println("\nGoodbye!");
	}
}
