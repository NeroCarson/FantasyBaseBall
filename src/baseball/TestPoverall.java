package baseball;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import models.LeagueMember;
import models.Pitcher;

public class TestPoverall {
	ArrayList<Pitcher> pitchers;
	LeagueMember memberA;
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		
		pitchers = new ArrayList<>();
		Pitcher bob = new Pitcher("Bob", "Test");
		bob.rank = 1;
		pitchers.add(bob);
		
		Pitcher joe = new Pitcher("Joe", "Test");
		joe.rank = 2;
		pitchers.add(joe);
		
		Pitcher jane = new Pitcher("Jane", "Test");
		jane.rank = 3;
		pitchers.add(jane);
		
		Pitcher sue = new Pitcher("Sue", "Test");
		sue.rank = 4;
		pitchers.add(sue);
		
		memberA = new LeagueMember("A");
		memberA.team.p1 = bob;
		memberA.team.p2 = joe;
	}
	
	@Test
	public void OverallPrint() {
		FunctionsJ.poverall(pitchers, memberA);
		String expected = "Bob Test P 1\nJoe Test P 2\nJane Test P 3\nSue Test P\n";
		String actual = outContent.toString();
		assertEquals(expected, actual);
	}
}
