package baseball;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import models.League;
import models.LeagueMember;
import models.Person;
import models.Pitcher;
import models.Player;
import models.Team;

public class FunctionsP {

	// SAVE
	static void save(League temp ,String fileName) {
		// TODO Auto-generated method stub
		/*In order to save we should go through our objects and extract what's held there
		 * putting it into the save file.*/
		//put extension on file
		fileName = fileName + ".fantasy.txt";
			
		//writer for the file
		
		PrintWriter record;
		try {
			record = new PrintWriter(new File(fileName));
			
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
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error: No File Found");
		}
	}
	
	// RESTORE
	//May need to move RESTORE to main to access the League object
	static void restore(League temp, String fileName) {
	// TODO Auto-generated method stub
		
		try {
			
			fileName = fileName + ".fantasy.txt";
			
			Scanner red = new Scanner(new FileReader(fileName));
			String player;
			int line = 1;
			while(red.hasNext()) {
				
				player = red.next();
				if(player.equalsIgnoreCase("null")) {
					line++;
				}
				else {
					
					System.out.println();
					System.out.println("Adding: "+ player);
					//HERE WE NEED ODRAFT TO ADD THE PLAYER
					if(line <= 13) {
						//MemberA
						FunctionsW.odraft(temp, player, "A");
					}
					else if(line <= 26) {
						//MemberB
						FunctionsW.odraft(temp, player, "B");
					}
					else if(line <= 39) {
						//MemberC
						FunctionsW.odraft(temp, player, "C");
					}
					else {
						//MemberD
						FunctionsW.odraft(temp, player, "D");
					}
					line++;
				}
			}
			red.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error: File Not Found");
		}
		
		
	}
	
	
	// QUIT
	static void quit(League temp) {
	// TODO Auto-generated method stub
	System.out.println("Exiting");
	System.exit(0);	
	}
	
	
	// TEAM
	public static void team(LeagueMember alpha) {
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
	public static void stars(LeagueMember beta) {
			// TODO Auto-generated method stub

			//players
			Player[] p = new Player[8];
			Pitcher[] pi = new Pitcher[5];
			Team tm = beta.team;
			
			//players
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
		try {
			isNull(tm.c.name);
		}
		catch(NullPointerException e) {
			people[0].name = "null";
		}
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
				if(people[i].name.equalsIgnoreCase("null")) {
					big = people[people.length -1];
					people[i] = big;
					people[people.length -1] = null;
				}
				else {
					
					if(people[i].selected > people[j].selected) {
						big = people[j];
						people[j] = people[i];
						people[i] = big;
					}
				}
			}
		}
		//return people
		return people;	
	}
	public static boolean isNull(String str) {
		try {
			if(str != null && !str.isEmpty())
	            return false;
		}
        catch(NullPointerException e){
        	return true;
        }
        return true;
    }
}
