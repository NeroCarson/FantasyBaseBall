// Mock system.out idea ...
// https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

package baseball;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import models.Player;

public class TestOverall {
	ArrayList<Player> players;
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		
		players = new ArrayList<>();
		Player bob = new Player("Bob", "Test", "C");
		bob.rank = 1;
		players.add(bob);
		
		Player joe = new Player("Joe", "Test", "P");
		joe.rank = 2;
		players.add(joe);
		
		Player jane = new Player("Jane", "Test", "1B");
		jane.rank = 3;
		players.add(jane);
		
		Player sue = new Player("Sue", "Test", "SS");
		sue.rank = 4;
		players.add(sue);
	}
	
	@Test
	public void OverallPrint() {
//		FunctionsJ.overall(players);
//		String expected = "Bob Test C 1\nJoe Test P 2\nJane Test 1B 3\nSue Test SS \n";
//		String actual = outContent.toString();
//		assertEquals(expected, actual);
	}
}
