package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		loadData.openFile("stats.csv");
		loadData.openFile("stats_pitcher.csv");
		loadData.printList();
		Odraft.chooseRosters();

	}

}
