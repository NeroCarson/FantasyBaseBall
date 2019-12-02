// Mock system.out idea ...
// https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

package baseball;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import models.LeagueMember;
import models.Player;

public class TestOverall {
	ArrayList<Player> players;
	LeagueMember memberA;
	ByteArrayOutputStream output;
	String headerRow;
	String janeRow;
	String sueRow;
	
	@Before
	public void setUp() throws Exception {
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		players = new ArrayList<>();
		Player bob = new Player("Bob", "Test", "C");
		bob.rank = 1;
		players.add(bob);
		
		Player joe = new Player("Joe", "Test", "CF");
		joe.rank = 2;
		players.add(joe);
		
		Player jane = new Player("Jane", "Test", "B1");
		jane.rank = 3;
		players.add(jane);
		
		Player sue = new Player("Sue", "Test", "SS");
		sue.rank = 4;
		players.add(sue);
		
		memberA = new LeagueMember("A");
		memberA.team.c = bob;
		bob.selected = 1;
		memberA.team.cf = joe;
		joe.selected = 2;
		
		headerRow = String.format("%-15s %-5s %-4s %-6s%n", "Player", "Team", "Pos", "RANK");
		janeRow = String.format("%-15s %-5s %-4s %-6.3f", "Jane", "Test", "B1", 3.0);
		sueRow = String.format("%-15s %-5s %-4s %-6.3f", "Sue", "Test", "SS", 4.0);
	}
	
	@Test
	public void printAll() {
		FunctionsJ.overall(players, memberA, "");
		
		String actual = output.toString();
		String expected = String.format("%n%s%s%n%s%n", headerRow, janeRow, sueRow);
		assertEquals(expected, actual);
	}
	
	@Test
	public void PrintFirstOnePosition() {
		FunctionsJ.overall(players, memberA, "B1");
		String actual = output.toString();
		String expected = String.format("%n%s%s%n", headerRow, janeRow);
		assertEquals(expected, actual);
	}
	
	@Test
	public void PrintFilledPosition() {
		FunctionsJ.overall(players, memberA, "C");
		String actual = output.toString();		
		output.reset();
		System.out.println();
		System.out.println("You have already filled the position 'C' or this position does not exist.");
		String expected = output.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void PrintNullPosition() {
		FunctionsJ.overall(players, memberA, null);
		String actual = output.toString();
		String expected = String.format("%n%s%s%n%s%n", headerRow, janeRow, sueRow);
		assertEquals(expected, actual);
	}
	
	@Test
	public void PrintNullPlayers() {
		FunctionsJ.overall(null, memberA, "");
		String actual = output.toString();
		output.reset();
		System.out.println();
		System.out.println("ERROR: Invalid parameter. Either no players found or member was not found.");
		String expected = output.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void PrintNullMember() {
		FunctionsJ.overall(players, null, "");
		String actual = output.toString();
		output.reset();
		System.out.println();
		System.out.println("ERROR: Invalid parameter. Either no players found or member was not found.");
		String expected = output.toString();
		assertEquals(expected, actual);
	}
}
