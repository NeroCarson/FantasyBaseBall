package baseball;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

import models.Pitcher;
import models.Player;

public class FunctionsJ {

	static void evalfun(ArrayList<Player> players, String function) {
		
	}
	
	static void pevalfun(ArrayList<Pitcher> pitchers, String function) {
		
	}
	
	// OVERALL
	static void overall(ArrayList<Player> players) {
		// TODO Auto-generated method stub
		System.out.println("Test");
	}

	// POVERALL
	static void poverall(ArrayList<Pitcher> pitchers) {
		// TODO Auto-generated method stub

	}
	
	
	public static void test() {
		ArrayList<Player> players = new ArrayList<>();
		Player bob = new Player("Bob", "Test", "C");
		bob.avg = 5.5;
		bob.obp = 1.5;
		players.add(bob);
		
		Player joe = new Player("Joe", "Test", "P");
		joe.avg = 5;
		joe.obp = 5.5;
		players.add(joe);
		
		Player jane = new Player("Jane", "Test", "1B");
		jane.avg = 4.5;
		jane.obp = 3;
		players.add(jane);
		
		Player sue = new Player("Sue", "Test", "SS");
		sue.avg = 3.5;
		sue.obp = 4;
		players.add(sue);

		String input = "avg + 5";
		String[] inputArray = input.split("\\s");

		for (Player player : players) {
			Stack<String> postfix = createTree(inputArray);
			player.rank = evaluateExpression(player, postfix);
		}

		sort(players);

	}


	static Stack<String> createTree(String[] args) {
		Stack<String> stack = new Stack<>();
		Stack<String> postfix = new Stack<String>();

		for (String arg : args) {
			if (isOperator(arg)) {
				if (stack.empty()) {
					stack.push(arg);
				} else if (("+".equals(arg) || "-".equals(arg))
						&& ("*".equals(stack.peek()) || "/".equals(stack.peek()))) {
					while ("*".equals(stack.peek()) || "/".equals(stack.peek())) {
						String operator = stack.pop();
						postfix.add(operator);
					}
					stack.push(arg);
				} else {
					stack.push(arg);
				}
			} else {
				postfix.add(arg);
			}
		}

		while (!stack.empty())
			postfix.add(stack.pop());

		Stack<String> reversed = new Stack<String>();
		while (!postfix.empty()) {
			reversed.push(postfix.pop());
		}

		return reversed;
	}

	
	// TODO ADD SUPPORT FOR LONGER EXPRESSIONS
	public static double evaluateExpression(Player player, Stack<String> postfix) {
		char operator;
		String operand1, operand2;
		Stack<String> expression = new Stack<>();
		double answer = 0;

		while (!postfix.empty()) {
			while (!isOperator(postfix.peek())) {
				expression.push(postfix.pop());
			}

			operator = postfix.pop().toCharArray()[0];
			operand1 = expression.pop();
			operand2 = expression.pop();
			answer = evaluate(player, operator, operand1, operand2);
		}
		return answer;
	}

	public static boolean isOperator(String item) {
		return "+".equals(item) || "-".equals(item) || "*".equals(item) || "/".equals(item);
	}

	public static <T> void printArrayList(ArrayList<T> items) {
		for (T item : items) {
			System.out.println(item);
		}
	}

	public static double evaluate(Player player, char operator, String strOperand1, String strOperand2) {
		double operand1 = 0, operand2 = 0;
		try {
			operand1 = Double.parseDouble(strOperand1);
		} catch (Exception e) {
			switch (strOperand1) {
			case "avg":
				operand1 = player.avg;
				break;
			case "obp":
				operand1 = player.obp;
				break;
			}
		}

		try {
			operand2 = Double.parseDouble(strOperand2);
		} catch (Exception e) {
			switch (strOperand2) {
			case "avg":
				operand2 = player.avg;
				break;
			case "obp":
				operand2 = player.obp;
				break;
			}
		}

		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			if (operand2 == 0) {
				return 0;
			}
			return operand1 / operand2;
		default:
			return 0;
		}
	}

	public static void sort(ArrayList<Player> players) {

		players.sort(new Comparator<Player>() {
			public int compare(Player player1, Player player2) {

				if (player1.rank > player2.rank) {
					return 1;
				} else if (player1.rank < player2.rank) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		printArrayList(players);

	}
	
	
}
