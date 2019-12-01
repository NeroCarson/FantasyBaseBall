package baseball;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import models.League;
import models.LeagueMember;
import models.Pitcher;
import models.Player;

public class TestOdraft {

	ArrayList<Player> players;
	LeagueMember memberA;
	ByteArrayOutputStream output;
	
	League testLeague = loadData.openFile("stats.csv", "stats_pitcher.csv");
	
	@Before
	public void setUp() {
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		players = new ArrayList<>();
		Player player1 = new Player("Yelich, C", "MIL", "RF");
		memberA = new LeagueMember("A");
		memberA.team.ss = player1;
		players.add(player1);

	}
	
	// failing???

	@Test
	public void odraft() {
		FunctionsW.odraft(testLeague, "Yelich, C", "A");
		String expected = "You've recruited Yelich, C for the position of RF\n";
		String actual = output.toString()+"";
		assertEquals(expected, actual);
	}

}
