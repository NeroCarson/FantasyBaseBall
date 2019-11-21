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
		// name to test--> "Anderson,T",CWS,SS,123,498,81,167,32,0,18,56,15,109,17,5,0.335,0.357,0.508,0.865
		System.out.println("Enter name: ");
		String name = sc.next();
		
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i))) {
				roster1.add(name);
			} 
		}
	}

	public static void printRoster1() {
		for (int i = 0; i < roster1.size(); i++) {
			System.out.println(roster1.get(i));
		}

	}
}
