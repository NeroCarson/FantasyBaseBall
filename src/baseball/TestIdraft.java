package baseball;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import models.League;
import models.Pitcher;
import models.Player;

public class TestIdraft {
	ByteArrayOutputStream output;

	ArrayList<Player> players;
	ArrayList<Pitcher> pitchers;
	
	League testLeague = loadData.openFile("stats.csv", "stats_pitcher.csv");
	
	@Before
	public void setUp() {
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		players = new ArrayList<>();
		Player player1 = new Player("Anderson, T", "CWS", "SS");
		players.add(player1);
	}
	@Test
	public void idraft() {
		FunctionsW.idraft(testLeague, "Anderson, T");
		String actual_player1 = output.toString().replaceAll("[\n\r]", "");
		String expected_player1 = "You've recruited Anderson, T for the position of SS";
		assertEquals(expected_player1, actual_player1);
	}

}
