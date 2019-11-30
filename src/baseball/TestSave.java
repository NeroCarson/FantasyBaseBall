package baseball;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import models.League;
import models.Player;

public class TestSave {
	ArrayList<Player> players;
	League testLea = loadData.openFile("stats.csv", "stats_pitcher.csv");
	@Before
	public void setUp() throws Exception {
		
		Player bob = new Player("Bob", "Test", "C");
		bob.avg = 5.5;
		bob.obp = 1.5;
		testLea.players.add(bob);
		
		Player joe = new Player("Joe", "Test", "P");
		joe.avg = 5;
		joe.obp = 5.5;
		testLea.players.add(joe);

		Player jane = new Player("Jane", "Test", "1B");
		jane.avg = 4.5;
		jane.obp = 3;
		testLea.players.add(jane);

		Player sue = new Player("Sue", "Test", "SS");
		sue.avg = 3.5;
		sue.obp = 4;
		testLea.players.add(sue);
	}
	
	@Test
	public void saveTest() {
		FunctionsW.idraft(testLea, "bob");
		FunctionsP.save(testLea, "test");
	}
	
	@Test
	public void saveNullTest() throws FileNotFoundException {
		FunctionsW.idraft(testLea, "bob");
		FunctionsW.odraft(testLea, "Arcia, O", "B");
		
		FunctionsP.save(testLea, "test");
		
		String fileName = "test.fantasy.txt";
			
		Scanner red = new Scanner(new FileReader(fileName));
		
		assertEquals("Bob", red.nextLine());
		assertEquals("null", red.nextLine());
		assertEquals("null", red.nextLine());
		assertEquals("null", red.nextLine());
		assertEquals("null", red.nextLine());
		assertEquals("null", red.nextLine());
		assertEquals("null", red.nextLine());
		assertEquals("null", red.nextLine());
		assertEquals("null", red.nextLine());
		assertEquals("null", red.nextLine());
		assertEquals("null", red.nextLine());
		assertEquals("null", red.nextLine());
		assertEquals("null", red.nextLine());
		assertEquals("Member B placement","Arcia, O", red.nextLine());
		red.close();
	}
}
