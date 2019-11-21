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
		System.out.println(list.get(0));
		System.out.println("Enter name: ");
		String name = sc.next();
		
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i))) {
				roster1.add(name);
			} 
		}
	}

	public static void printList() {
		for (int i = 0; i < roster1.size(); i++) {
			System.out.println(roster1.get(i));
		}

	}
}
