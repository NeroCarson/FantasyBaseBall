package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import models.*;

public class FunctionsJ {

	// RANK NON-PITCHERS BY FUNCTION
	static void evalfun(ArrayList<Player> players, String[] infix) {
		System.out.println();

		// CONFIRM PARAMETERS ARE PRESENT
		if (players == null || players.size() == 0 || infix == null) {
			System.out.println("ERROR: Invalid parameter. Either no players found or function was empty.");
			return;
		}

		// FUNCTION STRING USED FOR PRINTING MESSAGES
		String function = String.join(" ", infix);

		try {

			// CONFIM FUNCTION IS A VALID FUNCTION
			if (!isValidFunction(infix)) {
				throw new IllegalArgumentException();
			}

			String[] postfix = infixToPostfix(infix);

			// CALCULATE RANK FOR EACH PLAYER
			for (Player player : players) {
				String[] replacedStats = convertPlayerStats(player, postfix);
				player.rank = evaluate(replacedStats);
			}

			sort(players);

			System.out.println("Players sorted by function: " + function);

		} catch (IllegalArgumentException e) {
			System.out.println(
					"ERROR: Invalid function '" + function + "'.\nThe supplied function could not be applied.\n"
							+ "Either a statistic is not supported or the function is invalid.\n"
							+ "Double check that a space separates each element.\n"
							+ "Supported statistics include: g, rbi, sb, cs, avg, obp.");
		}
	}

	// RANK PITCHERS BY FUNCTION
	static void pevalfun(ArrayList<Pitcher> pitchers, String[] infix) {
		System.out.println();

		// CONFIRM PARAMETERS ARE PRESENT
		if (pitchers == null || pitchers.size() == 0 || infix == null) {
			System.out.println("ERROR: Invalid parameter. Either no pitchers found or function was empty.");
			return;
		}

		// FUNCTION STRING USED FOR PRINTING MESSAGES
		String function = String.join(" ", infix);

		try {

			// CONFIM FUNCTION IS A VALID FUNCTION
			if (!isValidFunction(infix)) {
				throw new IllegalArgumentException();
			}

			String[] postfix = infixToPostfix(infix);

			// CALCULATE RANK FOR EACH PITCHER
			for (Pitcher pitcher : pitchers) {
				String[] replacedStats = convertPitcherStats(pitcher, postfix);
				pitcher.rank = evaluate(replacedStats);
			}

			sort(pitchers);

			System.out.println("Players sorted by function: " + function);

		} catch (IllegalArgumentException e) {
			System.out.println(
					"ERROR: Invalid function '" + function + "'.\nThe supplied function could not be applied.\n"
							+ "Either a statistic is not supported or the function is invalid.\n"
							+ "Double check that a space separates each element.\n"
							+ "Supported statistics include: w, l, era, er, avg, whip.");
		}
	}

	// PRINT PLAYERS BY RANK
	static void overall(ArrayList<Player> players, LeagueMember member, String position) {
		System.out.println();

		// CONFIRM PARAMETERS ARE PRESENT
		if (players == null || players.size() == 0 || member == null) {
			System.out.println("ERROR: Invalid parameter. Either no players found or member was not found.");
			return;
		}

		// IF NO POSITION PRINT ALL OPEN POSITIONS
		if (position == null || position.isEmpty()) {

			// GET LIST OF OPEN POSITIONS
			String[] openPositions = member.team.getOpenPositions();
			System.out.printf(Player.getShortHeaderRow());

			// PRINT OUT PLAYERS WHOSE POSITION IS IN THE OPEN POSITIONS ARRAY
			players.stream().filter(p -> Arrays.stream(openPositions)
					.anyMatch(q -> q.equalsIgnoreCase(p.pos)))
					.forEach(p -> System.out.println(p.toShortString()));
		
		// IF POSITION PARAMETER IS SUPPLIED
		} else {
			
			// CONFIRM LEAGUE MEMBER HAS NOT FILLED POSITION
			if (member.team.isPositionFilled(position)) {
				System.out.println("You have already filled the position '" + position + "' or this position does not exist.");
			
			// PRINT ALL PLAYERS FOR THE INDICATED POSITION
			} else {
				System.out.printf(Player.getShortHeaderRow());
				players.stream().filter(p -> position.equalsIgnoreCase(p.pos))
					.forEach(p -> System.out.println(p.toShortString()));
			}
		}
	}

	// PRINT PITCHERS BY RANK
	static void poverall(ArrayList<Pitcher> pitchers, LeagueMember member) {

		System.out.println();
		
		// CONFIRM PARAMETERS ARE PRESENT
		if (pitchers == null || pitchers.size() == 0 || member == null) {
			System.out.println("ERROR: Invalid parameter. Either no pitchers found or member was not found.");
			return;
		}

		// CONFIRM LEAGUE MEMBER HAS NOT FILLED ALL PITCHERS
		if (member.team.isPositionFilled("p")) {
			System.out.println("You have selected all pitchers.");
			
		// PRINT ALL PITCHERS 
		} else {
			System.out.printf(Pitcher.getShortHeaderRow());
			pitchers.stream().forEach(p -> System.out.println(p.toShortString()));
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

	// EVALUATE POSTFIX EXPRESSION
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

	// CONFIRM THAT EVERY OTHER ELEMENT IS AN OPERATOR
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

	// CONVERT ALL SUPPLIED STATISTICS TO THE PLAYERS STAT
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

	// CONVERT ALL SUPPLIED STATISTICS TO PITCHERS STAT
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
}
