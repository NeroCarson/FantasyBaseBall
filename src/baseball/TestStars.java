package baseball;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import models.League;
import models.Player;

public class TestStars {
	
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
	public void out() {
	    System.out.print("hello");
	    assertEquals("hello", outContent.toString());
	}
	
	@Test
	public void starsNoPlayerOutput() {
		
		FunctionsP.stars(testLea.memberB);
		
		String actual = outContent.toString();		
		
		assertEquals("", actual);
	}
	
//	@Test
//	public void starsOnePlayer() {
//		
//		FunctionsW.idraft(testLea, "Arcia");
//	
//		FunctionsP.stars(testLea.memberA);
//		
//		String exp = "You've recruited Arcia, O for the position of SS\nSS Arcia, O";
//				
//		
//		
//	    assertEquals(exp, outContent.toString());
//	}
	
}
