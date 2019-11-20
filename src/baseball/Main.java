package baseball;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);

	public static ArrayList<String> roster1 = new ArrayList<String>(); 
	public static ArrayList<String> roster2 = new ArrayList<String>(); 
	public static ArrayList<String> roster3 = new ArrayList<String>(); 
	public static ArrayList<String> roster4 = new ArrayList<String>(); 
	
	public static void main(String[] args) {
		loadData.openFile("stats.csv");
		System.out.println();
		loadData.openFile("stats_pitcher.csv");
		loadData.createRosters();
		
	}




}
