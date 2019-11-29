package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

import models.LeagueMember;
import models.Person;
import models.Pitcher;
import models.Player;
import models.Team;

public class FunctionsJ {

	// RANK NON-PITCHERS BY FUNCTION
	static void evalfun(ArrayList<Player> players, String function) {

		try {
			String[] infix = function.split("\\s");
			if (!isValidFunction(infix)) {
				throw new IllegalArgumentException();
			}
			String[] postfix = infixToPostfix(infix);
			for (Player player : players) {
				String[] replacedStats = convertPlayerStats(player, postfix);
				player.rank = evaluate(replacedStats);
			}
			sort(players);
			System.out.println("Players sorted by function: " + function);
		} catch (IllegalArgumentException e) {
			System.out.println("ERROR: Invalid function '" + function + "'.\nThe supplied function could not be applied.\n"
					+ "Either a statistic is not supported or the function is invalid.\n"
					+ "Double check that a space separates each element.\n"
					+ "Supported statistics include: g, rbi, sb, cs, avg, obp.");
		}
	}

	// RANK PITCHERS BY FUNCTION
	static void pevalfun(ArrayList<Pitcher> pitchers, String function) {

		try {
			String[] infix = function.split("\\s");
			if (!isValidFunction(infix)) {
				throw new IllegalArgumentException();
			}
			String[] postfix = infixToPostfix(infix);
			for (Pitcher pitcher : pitchers) {
				String[] replacedStats = convertPitcherStats(pitcher, postfix);
				pitcher.rank = evaluate(replacedStats);
			}
			sort(pitchers);
			System.out.println("Players sorted by function: " + function);
		} catch (IllegalArgumentException e) {
			System.out.println("ERROR: Invalid function '" + function + "'.\nThe supplied function could not be applied.\n"
					+ "Either a statistic is not supported or the function is invalid.\n"
					+ "Double check that a space separates each element.\n"
					+ "Supported statistics include: w, l, era, er, avg, whip.");
		}
	}

	// PRINT PLAYERS BY RANK
	static void overall(ArrayList<Player> players, LeagueMember member, String position) {
		System.out.println();
		if (position.isEmpty()) {
			String[] openPositions = member.team.getOpenPositions();

			System.out.printf(
					"%-15s %-5s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-6s %-6s %-6s %-6s %-6s%n",
					"Player", "Team", "Pos", "G", "AB", "R", "H", "2B", "3B", "HR", "RBI", "BB", "SO", "SB", "CS",
					"AVG", "OBP", "SLG", "OPS", "RANK");
			players.stream().filter(p -> Arrays.stream(openPositions).anyMatch(q -> q.equalsIgnoreCase(p.pos)))
					.forEach(System.out::println);
		} else {
			if (member.team.isPositionFilled(position)) {
				System.out.println(
						"You have already filled the position '" + position + "' or this position does not exist.");
			} else {
				System.out.printf(
						"%-15s %-5s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-4s %-6s %-6s %-6s %-6s %-6s%n",
						"Player", "Team", "Pos", "G", "AB", "R", "H", "2B", "3B", "HR", "RBI", "BB", "SO", "SB", "CS",
						"AVG", "OBP", "SLG", "OPS", "RANK");
				players.stream().filter(p -> position.equalsIgnoreCase(p.pos)).forEach(System.out::println);
			}
		}
	}

	// PRINT PITCHERS BY RANK
	static void poverall(ArrayList<Pitcher> pitchers, LeagueMember member) {
		System.out.println();
		if (member.team.isPositionFilled("p")) {
			System.out.println("You have selected all pitchers.");
		} else {
			System.out.printf(
					"%-15s %-5s %-4s %-4s %-6s %-4s %-4s %-4s %-4s %-6s %-4s %-4s %-4s %-4s %-4s %-6s %-6s %-6s%n",
					"Player", "Team", "W", "L", "ERA", "G", "GS", "SV", "SVO", "IP", "H", "ER", "HR", "BB", "SO", "AVG",
					"WHIP", "RANK");
			pitchers.stream().forEach(System.out::println);
		}
	}

	// CONVERT INFIX EXPRESSION TO POSTFIX
	private static String[] infixToPostfix(String[] infix) {
		Stack<String> operators = new Stack<>();
		String[] postfix = new String[infix.length];
		int index = 0;

		for (String element : infix) {
			if (isOperator(element)) {
				if (operators.empty() || compareOperator(element, operators.peek()) > 0) {
					operators.push(element);
				} else {
					postfix[index] = operators.pop();
					operators.push(element);
					index++;
				}
			} else {
				postfix[index] = element;
				index++;
			}
		}

		while (!operators.empty()) {
			postfix[index] = operators.pop();
			index++;
		}
		return postfix;
	}

	// EVALUATE POST FIX EXPRESSION
	private static double evaluate(String[] postfix) {
		Stack<String> operands = new Stack<>();
		double answer = 0;

		for (String element : postfix) {
			if (isOperator(element)) {
				answer = calculate(element, operands.pop(), operands.pop());
				operands.push(String.valueOf(answer));
			} else {
				operands.push(element);
			}

		}
		return answer;
	}

	// CALCULATE BINARY EXPRESSION
	private static double calculate(String operator, String strOperand2, String strOperand1) {
		double operand1 = Double.parseDouble(strOperand1);
		double operand2 = Double.parseDouble(strOperand2);

		switch (operator) {
		case "+":
			return operand1 + operand2;
		case "-":
			return operand1 - operand2;
		case "*":
			return operand1 * operand2;
		case "/":
			if (operand2 == 0) {
				return 0;
			}
			return operand1 / operand2;
		default:
			return 0;
		}
	}
	
	private static boolean isValidFunction(String[] function) {
		
		for (int i = 0; i < function.length; i++) {
			if (isOperator(function[i])) {
				if (i % 2 == 0) {
					return false;
				}
			} else {
				if (i % 2 == 1) {
					return false;
				}
			}
		}
		
		return true;
	}

	private static String[] convertPlayerStats(Player player, String[] originalFunction)
			throws IllegalArgumentException {

		String[] newFunction = new String[originalFunction.length];

		for (int i = 0; i < originalFunction.length; i++) {
			if (originalFunction[i] == null) {
				throw new IllegalArgumentException();
			}
			
			if (isOperator(originalFunction[i])) {
				newFunction[i] = originalFunction[i];
				continue;
			}
			
			try {
				Double.parseDouble(originalFunction[i]);
				newFunction[i] = originalFunction[i];
				continue;
			} catch (NumberFormatException e) {
				switch (originalFunction[i].toLowerCase()) {
				case "g":
					newFunction[i] = String.valueOf(player.g);
					break;
				case "rbi":
					newFunction[i] = String.valueOf(player.rbi);
					break;
				case "sb":
					newFunction[i] = String.valueOf(player.sb);
					break;
				case "cs":
					newFunction[i] = String.valueOf(player.cs);
					break;
				case "avg":
					newFunction[i] = String.valueOf(player.avg);
					break;
				case "obp":
					newFunction[i] = String.valueOf(player.obp);
					break;
				default:
					throw new IllegalArgumentException();
				}
			}
		}
		return newFunction;
	}

	private static String[] convertPitcherStats(Pitcher pitcher, String[] originalFunction)
			throws IllegalArgumentException {
		
		String[] newFunction = new String[originalFunction.length];
		
		for (int i = 0; i < originalFunction.length; i++) {
			if (originalFunction[i] == null) {
				throw new IllegalArgumentException();
			}
			
			if (isOperator(originalFunction[i])) {
				newFunction[i] = originalFunction[i];
				continue;
			}

			try {
				Double.parseDouble(originalFunction[i]);
				newFunction[i] = originalFunction[i];
				continue;
			} catch (NumberFormatException e) {
				switch (originalFunction[i].toLowerCase()) {
				case "w":
					newFunction[i] = String.valueOf(pitcher.w);
					break;
				case "l":
					newFunction[i] = String.valueOf(pitcher.l);
					break;
				case "era":
					newFunction[i] = String.valueOf(pitcher.era);
					break;
				case "er":
					newFunction[i] = String.valueOf(pitcher.er);
					break;
				case "avg":
					newFunction[i] = String.valueOf(pitcher.avg);
					break;
				case "whip":
					newFunction[i] = String.valueOf(pitcher.whip);
					break;
				default:
					throw new IllegalArgumentException();
				}
			}
		}
		return newFunction;
	}

	// SORT PLAYERS BY RANK
	private static <T extends Person> void sort(ArrayList<T> people) {

		people.sort(new Comparator<T>() {
			public int compare(T person1, T person2) {

				if (person1.rank < person2.rank) {
					return 1;
				} else if (person1.rank > person2.rank) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}

	// DETERMINE IF A STRING IS AN OPERATOR
	private static boolean isOperator(String item) {
		return "+".equals(item) || "-".equals(item) || "*".equals(item) || "/".equals(item);
	}

	// COMPARES TWO OPERATORS BY ORDER OF OPERATION
	private static int compareOperator(String op1, String op2) {
		if (("+".equals(op1) || "-".equals(op1)) && ("*".equals(op2) || "/".equals(op2))) {
			return -1;
		}
		if (("*".equals(op1) || "/".equals(op1)) && ("+".equals(op2) || "-".equals(op2))) {
			return 1;
		}
		return 0;
	}

	// FOR TESTING ONLY
	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<>();
		Player bob = new Player("Bob", "Test", "C");
		bob.avg = .5;
		bob.obp = .5;
		players.add(bob);

		Player joe = new Player("Joe", "Test", "CF");
		joe.avg = .5;
		joe.obp = .5;
		players.add(joe);

		Player jane = new Player("Jane", "Test", "1B");
		jane.avg = .5;
		jane.obp = .3;
		players.add(jane);

		Player sue = new Player("Goldschmidt, P", "RDX", "SS");
		sue.avg = .5;
		sue.obp = .4;
		players.add(sue);

		ArrayList<Pitcher> pitchers = new ArrayList<>();
		Pitcher smith = new Pitcher("Bob", "Re");
		Pitcher tom = new Pitcher("Tom", "TGR");
		pitchers.add(smith);
		pitchers.add(tom);

		Team team = new Team();
		team.c = bob;
		// team.cf = joe;
		team.b1 = jane;

		LeagueMember member = new LeagueMember("A");
		member.team = team;

		String function;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter function: ");
			function = scanner.nextLine();
		}

		evalfun(players, function);
		overall(players, member, "");
		poverall(pitchers, member);

	}
}
