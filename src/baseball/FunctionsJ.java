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

public class FunctionsJ {

	// RANK NON-PITCHERS BY FUNCTION
	static void evalfun(ArrayList<Player> players, String function) {
		String[] inputArray = function.split("\\s");
		String[] postfix = infixToPostfix(inputArray);

		for (String element : postfix)
			System.out.print(element + " ");

		for (Player player : players)
			player.rank = evaluate(player, postfix);

		sort(players);
		System.out.println("Players sorted by function: " + function);
	}
	
	// RANK PITCHERS BY FUNCTION
	static void pevalfun(ArrayList<Pitcher> pitchers, String function) {
		System.out.println("Method not implemented");
	}

	// PRINT PLAYERS BY RANK
	static void overall(ArrayList<Player> players, LeagueMember member, String position) {
		if (position.isEmpty()) {
			String[] openPositions = member.team.getOpenPositions();
			players.stream().filter(p -> Arrays.stream(openPositions).anyMatch(q -> q.equalsIgnoreCase(p.pos))).forEach(System.out::println);
		} else {
			if (member.team.isPositionFilled(position)) {
				System.out.println("You have already filled the position: '" + position +"' or this position does not exist.");
			} else {
				players.stream().filter(p -> position.equals(p.pos)).forEach(System.out::println);
			}
		}
	}

	// PRINT PITCHERS BY RANK
	static void poverall(ArrayList<Pitcher> pitchers) {
		System.out.println();
		for (Pitcher pitcher : pitchers) {
			System.out.println(pitcher);
		}
	}
	

	// CONVERT INFIX EXPRESSION TO POSTFIX
	static String[] infixToPostfix(String[] infix) {
		Stack<String> operators = new Stack<>();
		String[] postfix = new String[infix.length];
		int index = 0;

		for (String element : infix) {
			if (isOperator(element)) {
				if (operators.empty() || compareOperator(element, operators.peek()) > -1) {
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
	public static double evaluate(Player player, String[] postfix) {
		Stack<String> operands = new Stack<>();
		double answer = 0;

		for (String element : postfix) {
			if (isOperator(element)) {
				answer = calculate(player, element, operands.pop(), operands.pop());
				operands.push(String.valueOf(answer));
			} else {
				operands.push(element);
			}

		}
		return answer;
	}

	// CALCULATE BINARY EXPRESSION
	public static double calculate(Player player, String operator, String strOperand1, String strOperand2) {
		double operand1 = convertOperand(player, strOperand1);
		double operand2 = convertOperand(player, strOperand2);	

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

	// CONVERT OPERAND FROM STRING/STATISTIC TO DOUBLE
	public static double convertOperand(Player player, String operand) {
		try {
			return Double.parseDouble(operand);
		} catch (Exception e) {
			switch (operand) {
			case "avg":
				return player.avg;
			case "obp":
				return player.obp;
			}
		}
		return 0;
	}

	// SORT PLAYERS BY RANK
	public static <T extends Person> void sort(ArrayList<T> people) {

		people.sort(new Comparator<T>() {
			public int compare(T person1, T person2) {

				if (person1.rank > person2.rank) {
					return 1;
				} else if (person1.rank < person2.rank) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}

	// DETERMINE IF A STRING IS AN OPERATOR
	public static boolean isOperator(String item) {
		return "+".equals(item) || "-".equals(item) || "*".equals(item) || "/".equals(item);
	}

	// COMPARES TWO OPERATORS BY ORDER OF OPERATION
	public static int compareOperator(String op1, String op2) {
		if (("+".equals(op1) || "-".equals(op1)) && ("*".equals(op2) || "/".equals(op2))) {
			return -1;
		}
		if (("*".equals(op1) || "/".equals(op1)) && ("+".equals(op2) || "-".equals(op2))) {
			return 1;
		}
		return 0;
	}
	
	// FOR TESTING ONLY
//	public static void main(String[] args) {
//		ArrayList<Player> players = new ArrayList<>();
//		Player bob = new Player("Bob", "Test", "C");
//		bob.avg = 5.5;
//		bob.obp = 1.5;
//		players.add(bob);
//
//		Player joe = new Player("Joe", "Test", "P");
//		joe.avg = 5;
//		joe.obp = 5.5;
//		players.add(joe);
//
//		Player jane = new Player("Jane", "Test", "1B");
//		jane.avg = 4.5;
//		jane.obp = 3;
//		players.add(jane);
//
//		Player sue = new Player("Sue", "Test", "SS");
//		sue.avg = 3.5;
//		sue.obp = 4;
//		players.add(sue);
//
//		String function;
//		try (Scanner scanner = new Scanner(System.in)) {
//			System.out.print("Enter function: ");
//			function = scanner.nextLine();
//		}
//
//		evalfun(players, function);
//		overall(players);
//
//	}
}
