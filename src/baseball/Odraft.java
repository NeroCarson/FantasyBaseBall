package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Odraft extends loadData {

	public static Scanner sc = new Scanner(System.in);

	public static ArrayList<String> roster1 = new ArrayList<String>();
	public static ArrayList<String> roster2 = new ArrayList<String>();
	public static ArrayList<String> roster3 = new ArrayList<String>();
	public static ArrayList<String> roster4 = new ArrayList<String>();

	public static void chooseRosters() {

		// name to test--> Anderson,T
		int i = 0;
		// populates roster 1
		while (i < 2) {
			System.out.println("Enter names for roster 1: ");
			String name = sc.next();
			for (int j = 0 ; j < list.size(); j++) {
//				if(roster1.contains(name))
//					System.out.println("Player already drafted");
				if (list.get(j).contains('"' + name + '"')) {
					roster1.add(list.get(j));
				}
			}
			i++;
		}
		for (String element : roster1) {
			System.out.println(element);
		}

		 i = 0;
		// populates roster 2
		while (i < 2) {
			System.out.println("Enter names for roster 2: ");
			String name = sc.next();
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).contains('"' + name + '"')) {
					roster2.add(list.get(j));
				}
			}
			i++;
		}
		for (String element : roster2) {
			System.out.println(element);
		}

		i = 0;
		// populates roster 3
		while (i < 2) {
			System.out.println("Enter names for roster 3: ");
			String name = sc.next();
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).contains('"' + name + '"')) {
					roster3.add(list.get(j));
				}
			}
			i++;
		}
		for (String element : roster3) {
			System.out.println(element);
		}

		i = 0;
		// populates roster 4
		while (i < 2) {
			System.out.println("Enter names for roster 4: ");
			String name = sc.next();
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).contains('"' + name + '"')) {
					roster4.add(list.get(j));
				}
			}
			i++;
		}
		for (String element : roster4) {
			System.out.println(element);
		}

	}

}
