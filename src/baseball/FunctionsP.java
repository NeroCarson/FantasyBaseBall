package baseball;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FunctionsP {

	// SAVE
	static void save() throws IOException {
		// TODO Auto-generated method stub
		/*In order to save we should go through our objects and extract what's held there
		 * putting it into the save file.*/
		
		Scanner sc = new Scanner(System.in);
		boolean toggle = false; //toggle for file confirmation
		String fileName = "Default"; //default value for filename
		//while loop for file name confirmation
		while(toggle == false) {
			System.out.println("Enter file name to save to, Don't include the extension.");
			System.out.println("If the file already exsists it will be overwritten.");
			System.out.println("example: Season1");
			fileName = sc.next();
			
			System.out.println("You entered: "+fileName+" Is this correct? yes or no");
			String answer = sc.next();
			if(answer.equalsIgnoreCase("yes")) {
				toggle = true;
			}
		}
		sc.close();
		//writer for the file
		FileWriter record = new FileWriter(fileName);
		
		//loop through current information and write it to file
		//need load data or League object defined in order to grab what we have stored.

	}
	
	// RESTORE
	static void restore() {
	// TODO Auto-generated method stub
		System.out.println("Not yet implemented");
	}
	
	
	// QUIT
	static void quit() throws IOException {
	// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Are you sure you want to quit?: yes or no");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("yes")) {
			System.out.println("Would you like to save before quiting: yes or no");
			String saveAnswer = sc.next();
			if(saveAnswer.equalsIgnoreCase("yes")) {
				save();
				System.out.println("Exiting");
				sc.close();
				System.exit(0);
			}
			else {
				System.out.println("Exiting");
				sc.close();
				System.exit(0);
			}
		}

	}
}
