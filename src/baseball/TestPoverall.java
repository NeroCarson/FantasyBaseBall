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
	ByteArrayOutputStream output;
	String headerRow;
	String janeRow;
	String sueRow;
	
	@Before
	public void setUp() throws Exception {
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
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
		
		headerRow = String.format("%-15s %-5s %-4s %-4s %-6s %-4s %-4s %-4s %-4s %-6s %-4s %-4s %-4s %-4s %-4s %-6s %-6s %-6s%n",
				"Player", "Team", "W", "L", "ERA", "G", "GS", "SV", "SVO", "IP", "H", "ER", "HR", "BB", "SO", "AVG", "WHIP", "RANK");
		
		janeRow = String.format("%-15s %-5s %-4d %-4d %-6.2f %-4d %-4d %-4d %-4d %-6.1f %-4d %-4d %-4d %-4d %-4d %-6.3f %-6.3f %-6.3f",
				"Jane", "Test", 0, 0, 0.0, 0, 0, 0, 0, 0.0, 0, 0, 0, 0, 0, 0.0, 0.0, 3.0);
		
		sueRow = String.format("%-15s %-5s %-4d %-4d %-6.2f %-4d %-4d %-4d %-4d %-6.1f %-4d %-4d %-4d %-4d %-4d %-6.3f %-6.3f %-6.3f", 
				"Sue", "Test", 0, 0, 0.0, 0, 0, 0, 0, 0.0, 0, 0, 0, 0, 0, 0.0, 0.0, 4.0);
	
	}
	
	@Test
	public void printAll() {
		FunctionsJ.poverall(pitchers, memberA);
		
		String actual = output.toString();
		String expected = String.format("%n%s%s%n%s%n", headerRow, janeRow, sueRow);
		assertEquals(expected, actual);
	}
	
	@Test
	public void PrintNullPlayers() {
		FunctionsJ.poverall(null, memberA);
		String actual = output.toString();
		output.reset();
		System.out.println();
		System.out.println("ERROR: Invalid parameter. Either no pitchers found or member was not found.");
		String expected = output.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void PrintNullMember() {
		FunctionsJ.poverall(pitchers, null);
		String actual = output.toString();
		output.reset();
		System.out.println();
		System.out.println("ERROR: Invalid parameter. Either no pitchers found or member was not found.");
		String expected = output.toString();
		assertEquals(expected, actual);
	}
	
	
	
}
