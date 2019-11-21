package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Odraft extends loadData{

	public static Scanner sc = new Scanner(System.in);

	public static ArrayList<String> roster1 = new ArrayList<String>();
	public static ArrayList<String> roster2 = new ArrayList<String>();
	public static ArrayList<String> roster3 = new ArrayList<String>();
	public static ArrayList<String> roster4 = new ArrayList<String>();

	public static void chooseRosters() {
		System.out.println(list.get(0));
		System.out.println(
				"Enter a name from the *.csv files to add to your team + \nEach team must consist of a catcher,"
						+ "\nfirst baseman, second baseman, third baseman, a shortstop,"
						+ "\na left fielder, a right fielder, a center fielder, and five pitchers");
		
		// name to test --> "Anderson, T"
		String name = sc.next();
			
		for(int i = 0; i < list.size(); i++) {
			if(name.equals(list.get(i))){
				roster1.add(name);                       
			} else {
				System.out.println("ERROR");
			}
		}
		
	}
		public static void printList() {
			for (int i = 0; i < roster1.size(); i++) {
				System.out.println(roster1.get(i));
			}
		
		
		
		

	}
}
