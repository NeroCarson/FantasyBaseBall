package baseball;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import models.League;
import models.Player;

public class TestRestore {
	ArrayList<Player> players;
	League testLea = loadData.openFile("stats.csv", "stats_pitcher.csv");
	League testComp = loadData.openFile("stats.csv", "stats_pitcher.csv");
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
	public void testRestore() {
		
		FunctionsW.odraft(testLea, "Arcia, O", "B");
		
		FunctionsP.save(testLea, "test");
		
		String fileName = "test";
		
		FunctionsP.restore(testComp, fileName);
		String origin = testComp.memberB.team.ss.name;
		
		assertEquals("Restore adds players to righ spot", origin, "Arcia, O");
	}
}
