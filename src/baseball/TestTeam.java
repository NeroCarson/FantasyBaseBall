package baseball;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import models.League;
import models.LeagueMember;
import models.Player;
import models.Team;

public class TestTeam {
	
	
	ByteArrayOutputStream output;
	Team testTeam = new Team();
	LeagueMember testLeagueMember = new LeagueMember("a");

	ArrayList<Player> players;
	League testLea = loadData.openFile("stats.csv", "stats_pitcher.csv");
	League testComp = loadData.openFile("stats.csv", "stats_pitcher.csv");
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
		
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void testTeam() {
		FunctionsW.idraft(testLea, "Arcia");
		FunctionsW.idraft(testLea, "Lopez");
		FunctionsP.team(testLea.memberA);
		// replaceAll("[\n\r]", "")
		
		String actual = outContent.toString();
		outContent.reset();
		System.out.println("You've recruited Arcia, O for the position of SS");
		System.out.println("You've recruited Lopez, R for the position of pitcher");
		System.out.println("SS Arcia, O");
		System.out.println("Pitcher Lopez, R");
		String expected = outContent.toString();
		
		assertEquals(expected, actual);
	}

}
