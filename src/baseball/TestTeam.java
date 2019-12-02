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
import models.Team;

public class TestTeam {
	ByteArrayOutputStream output;	
	Team testTeam = new Team();
	LeagueMember testLeagueMember = new LeagueMember("a");

	@Before
	public void setUp() {
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		// populate team
		testTeam.c = new Player("Ramos, W", "NYM", "C");
		testTeam.b1 = new Player("Gurriel, Y","HOU","1B");
		testTeam.b2 = new Player("Altuve, J","HOU","2B");
		testTeam.b3 = new Player("Bregman, A","HOU","3B");
		testTeam.ss = new Player("Polanco, J","MIN","SS");
		testTeam.lf = new Player("McNeil, J","NYM","LF");
		testTeam.cf = new Player("Marte, S","PIT","CF");
		testTeam.rf = new Player("Betts, M","BOS","RF");
		// test does not read in pitchers!
		testTeam.p1 = new Pitcher("Ryu, H", "LAD");
		testTeam.p2 = new Pitcher("DeGrom, J", "NYM");
		testTeam.p3 = new Pitcher("Cole, G", "HOU");
		testTeam.p4 = new Pitcher("Verlander, J", "HOU");
		testTeam.p5 = new Pitcher("Soroka, M","ATL");
		//add team to league
		testLeagueMember.team = testTeam;
	}

	@Test
	public void testTeam() {
		FunctionsP.team(testLeagueMember);
		String actual = output.toString().replaceAll("[\n\r]", "");
		String expected = "";
		
		assertEquals(expected, actual);

	}

}
