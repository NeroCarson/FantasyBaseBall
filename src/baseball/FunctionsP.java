package baseball;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Scanner;

import models.League;
import models.LeagueMember;
import models.Person;
import models.Pitcher;
import models.Player;
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
		
		PrintWriter record = new PrintWriter(new File(fileName));
		//loop through current information and write it to file
		//need load data or League object defined in order to grab what we have stored.
		//once load data is finished we should only need to save the names  of the players 
		//we can use there names to then load the players from the data file for when we want to retrieve 
		//the information
		//get the member names first, use assignSort to go through teams and order them
		//in a person array and use assignSort to order them by rank now when we write them to our
		//save file they'll be written in the order they were picked.
		
		//team member A
		Person[] peeps = assignSort(temp.memberA.team);
		for(int k=0; k< peeps.length; k++) {
			if(peeps[k] == null) {
				record.println("null");
			}
			else {
				record.println(peeps[k].name);
			}
		}
		
		//team member b
		peeps = assignSort(temp.memberB.team);
		for(int k=0; k< peeps.length; k++) {
			if(peeps[k] == null) {
				record.println("null");
			}
			else {
				record.println(peeps[k].name);
			}
		}

		//team member c
		peeps = assignSort(temp.memberC.team);
		for(int k=0; k< peeps.length; k++) {
			if(peeps[k] == null) {
				record.println("null");
			}
			else {
				record.println(peeps[k].name);
			}
		}
				
		//team member d
		peeps = assignSort(temp.memberD.team);
		for(int k=0; k< peeps.length; k++) {
			if(peeps[k] == null) {
				record.println("null");
			}
			else {
				record.println(peeps[k].name);
			}
		}
		
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
	
	
	// TEAM
		private static void team(LeagueMember alpha) {
			// TODO Auto-generated method stub

			Team tm = alpha.team;
			Pitcher[] pitch = new Pitcher[5];
//pitchers
			
			pitch[0] = tm.p1;
			pitch[1] = tm.p2;
			pitch[2] = tm.p3;
			pitch[3] = tm.p4;
			pitch[4] = tm.p5;
			
			System.out.println(alpha.team.c.pos +" "+alpha.team.c.name);
			System.out.println(alpha.team.b1.pos +" "+alpha.team.b1.name);
			System.out.println(alpha.team.b2.pos +" "+alpha.team.b2.name);
			System.out.println(alpha.team.b3.pos +" "+alpha.team.b3.name);
			System.out.println(alpha.team.ss.pos +" "+alpha.team.ss.name);
			System.out.println(alpha.team.lf.pos +" "+alpha.team.lf.name);
			System.out.println(alpha.team.cf.pos +" "+alpha.team.cf.name);
			System.out.println(alpha.team.rf.pos +" "+alpha.team.rf.name);
			
			for(int i=1; i< 14; i++) {
				for(int j =0; j< pitch.length; j++) {
					if(pitch[j].selected == i) {
						System.out.println("Pitcher "+ pitch[j].name);
					}
				}
			}
		}

		// STARS
		private static void stars(LeagueMember beta) {
			// TODO Auto-generated method stub
//			STARS leagueMember
//
//			Same as TEAM, but the ordering of the players 
//			matches the order in which they were drafted overall.
			//players
			Player[] p = new Player[8];
			Pitcher[] pi = new Pitcher[5];
			Team tm = beta.team;
			
			p[0] = tm.c;
			p[1] = tm.b1;
			p[2] = tm.b2;
			p[3] = tm.b3;
			p[4] = tm.ss;
			p[5] = tm.lf;
			p[6] = tm.cf;
			p[7] = tm.rf;
			
			//pitchers
			pi[0] = tm.p1;
			pi[1] = tm.p2;
			pi[2] = tm.p3;
			pi[3] = tm.p4;
			pi[4] = tm.p5;
			
			for(int i=1; i< 14; i++) {
				for(int j =0; j< p.length; j++) {
					if(p[j].selected == i) {
						System.out.println(p[j].pos +" "+ p[j].name);
					}
				}
			}
			
			for(int i=1; i< 14; i++) {
				for(int j =0; j< pi.length; j++) {
					if(p[j].selected == i) {
						System.out.println("Pitcher "+ pi[j].name);
					}
				}
			}	
		}
	
	
	
	
	
	//helper functions
	public static Person[] assignSort(Team tm) {
		
		Person [] people = new Person [13];
		Person big;
		
		//players
		people[0].name = tm.c.name; 
		people[0].selected = tm.c.selected;
		
		people[1].name = tm.b1.name; 
		people[1].selected = tm.b1.selected;
		
		people[2].name = tm.b2.name; 
		people[2].selected = tm.b2.selected;
		
		people[3].name = tm.b3.name; 
		people[3].selected = tm.b3.selected;
		
		people[4].name = tm.ss.name; 
		people[4].selected = tm.ss.selected;
		
		people[5].name = tm.lf.name; 
		people[5].selected = tm.lf.selected;
		
		people[6].name = tm.cf.name; 
		people[6].selected = tm.cf.selected;
		
		people[7].name = tm.rf.name; 
		people[7].selected = tm.rf.selected;
		
		//pitchers
		people[8].name = tm.p1.name; 
		people[8].selected = tm.p1.selected;
		
		people[9].name = tm.p2.name; 
		people[9].selected = tm.p2.selected;
		
		people[10].name = tm.p3.name; 
		people[10].selected = tm.p3.selected;
		
		people[11].name = tm.p4.name; 
		people[11].selected = tm.p4.selected;
		
		people[12].name = tm.p5.name; 
		people[12].selected = tm.p5.selected;
		
		//sort people by rank
		for(int i = 0; i< people.length; i++) {
			for(int j = 0; j< people.length; j++) {
				if(people[i] != null) {
					if(people[j] != null) {
						if(people[i].selected > people[j].selected) {
							big = people[j];
							people[j] = people[i];
							people[i] = big;
						}
					}
				}
				else {
					big = people[people.length -1];
					people[i] = big;
					people[people.length -1] = null;
				}
			}
		}
		
		//return people
		return people;
		
		
	}
	
}
