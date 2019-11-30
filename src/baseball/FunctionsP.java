package baseball;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import models.League;
import models.LeagueMember;
import models.Order;
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
			Order[] peeps = assignSort(temp.memberA.team);
			for(int k=0; k< peeps.length; k++) {
				if(peeps[k] == null) {
					record.println("null");
				}
				else {
					record.println(peeps[k].getTitle());
				}
			}
			
			//team member b
			peeps = assignSort(temp.memberB.team);
			for(int k=0; k< peeps.length; k++) {
				if(peeps[k] == null) {
					record.println("null");
				}
				else {
					record.println(peeps[k].getTitle());
				}
			}

			//team member c
			peeps = assignSort(temp.memberC.team);
			for(int k=0; k< peeps.length; k++) {
				if(peeps[k] == null) {
					record.println("null");
				}
				else {
					record.println(peeps[k].getTitle());
				}
			}
					
			//team member d
			peeps = assignSort(temp.memberD.team);
			for(int k=0; k< peeps.length; k++) {
				if(peeps[k] == null) {
					record.println("null");
				}
				else {
					record.println(peeps[k].getTitle());
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
	static void quit() {
	// TODO Auto-generated method stub
	System.out.println("Exiting");
	System.exit(0);	
	}
	
	
	// TEAM
	public static void team(LeagueMember alpha) {
		
		//players
		Player[] p = new Player[8];
		Pitcher[] pi = new Pitcher[5];
		Team tm = alpha.team;
		
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
			
		for(int j =0; j< p.length; j++) {
			if(p[j] != null) {
				System.out.println(p[j].pos +" "+ p[j].name);	
			}
		}
		
		for(int i=1; i< 14; i++) {
			for(int j =0; j< pi.length; j++) {
				if(pi[j] != null) {
					if(pi[j].selected == i) {
						System.out.println("Pitcher "+ pi[j].name);
					}
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
					if(p[j] != null) {
						if(p[j].selected == i) {
							System.out.println(p[j].pos +" "+ p[j].name);
						}
					}
				}
			}
			
			for(int i=1; i< 14; i++) {
				for(int j =0; j< pi.length; j++) {
					if(pi[j] != null) {
						if(p[j].selected == i) {
							System.out.println("Pitcher "+ pi[j].name);
						}
					}
				}
			}	
		}
	
	
	//helper functions
	public static Order[] assignSort(Team tm) {
		
		Order [] ord = new Order[13];

		Player [] p = new Player[8];
		Pitcher [] pi = new Pitcher[5];
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
				if(p[j] != null) {
					if(p[j].selected == i) {
						ord[i-1].setTitle(p[j].name);
					}
				} 
			}
			for(int j =0; j< pi.length; j++) {
				if(pi[j] != null) {
					if(pi[j].selected == i) {
						ord[i-1].setTitle(pi[j].name);
					}
				}
				
			}
		}
		
		//return people
		return ord;	
	}
}
