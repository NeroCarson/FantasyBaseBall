package baseball;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import models.League;
import models.LeagueMember;
import models.Team;

public class FunctionsP {

	// SAVE
	static void save(League temp) throws IOException {
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
			fileName = fileName + ".txt";
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
		//once load data is finished we should only need to save the names  of the players 
		//we can use there names to then load the players from the data file for when we want to retrieve 
		//the information
		//get the member names first
		
		//team member A
		LeagueMember working = temp.memberA;
		Team tm = temp.memberA.team;
		record.write(working.name);
			record.write(tm.c.name);
			record.write(tm.b1.name);
			record.write(tm.b2.name);
			record.write(tm.b3.name);
			record.write(tm.ss.name);
			record.write(tm.lf.name);
			record.write(tm.cf.name);
			record.write(tm.rf.name);
			record.write(tm.p1.name);
			record.write(tm.p2.name);
			record.write(tm.p3.name);
			record.write(tm.p4.name);
			record.write(tm.p5.name);
			
			//team member B
			working = temp.memberB;
			tm = temp.memberB.team;
			record.write(working.name);
				record.write(tm.c.name);
				record.write(tm.b1.name);
				record.write(tm.b2.name);
				record.write(tm.b3.name);
				record.write(tm.ss.name);
				record.write(tm.lf.name);
				record.write(tm.cf.name);
				record.write(tm.rf.name);
				record.write(tm.p1.name);
				record.write(tm.p2.name);
				record.write(tm.p3.name);
				record.write(tm.p4.name);
				record.write(tm.p5.name);
		
				//team member C
				working = temp.memberC;
				tm = temp.memberC.team;
				record.write(working.name);
					record.write(tm.c.name);
					record.write(tm.b1.name);
					record.write(tm.b2.name);
					record.write(tm.b3.name);
					record.write(tm.ss.name);
					record.write(tm.lf.name);
					record.write(tm.cf.name);
					record.write(tm.rf.name);
					record.write(tm.p1.name);
					record.write(tm.p2.name);
					record.write(tm.p3.name);
					record.write(tm.p4.name);
					record.write(tm.p5.name);
					
					//team member D
					working = temp.memberD;
					tm = temp.memberD.team;
					record.write(working.name);
						record.write(tm.c.name);
						record.write(tm.b1.name);
						record.write(tm.b2.name);
						record.write(tm.b3.name);
						record.write(tm.ss.name);
						record.write(tm.lf.name);
						record.write(tm.cf.name);
						record.write(tm.rf.name);
						record.write(tm.p1.name);
						record.write(tm.p2.name);
						record.write(tm.p3.name);
						record.write(tm.p4.name);
						record.write(tm.p5.name);
		
		//close our file writer when done
		record.close();
	}
	
	// RESTORE
	static void restore() {
	// TODO Auto-generated method stub
		System.out.println("Not yet implemented");
	}
	
	
	// QUIT
	static void quit(League temp) throws IOException {
	// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Are you sure you want to quit?: yes or no");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("yes")) {
			System.out.println("Would you like to save before quiting: yes or no");
			String saveAnswer = sc.next();
			if(saveAnswer.equalsIgnoreCase("yes")) {
				//haven't yet decided on league object we're passing
				save(temp);
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
