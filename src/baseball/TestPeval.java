package baseball;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import models.Pitcher;

public class TestPeval {
	ArrayList<Pitcher> pitchers;
	
	@Before
	public void setUp() throws Exception {
		
		pitchers = new ArrayList<>();
		pitchers.add(new Pitcher("Bob", "Test"));
		pitchers.add(new Pitcher("Joe", "Test"));
		pitchers.add(new Pitcher("Jane", "Test"));
		pitchers.add(new Pitcher("Sue", "Test"));
	}
	
	
	@Test
	public void pevalfunSimpleFunction() {
		FunctionsJ.pevalfun(pitchers, "obp * 2");
		String[] actual  = pitchers.stream().map(p -> p.name).collect(Collectors.toList()).toArray(new String[0]);
		String[] expected = {"Joe", "Sue", "Jane", "Bob" };
		assertArrayEquals("obp * 2 failed", expected, actual);;
	}
	
	@Test
	public void pevalfunForTwoVariable() {
		FunctionsJ.pevalfun(pitchers, "avg * 2 + obp");
		String[] actual  = pitchers.stream().map(p -> p.name).collect(Collectors.toList()).toArray(new String[0]);
		String[] expected = {"Joe", "Bob", "Jane", "Sue" };
		assertArrayEquals("avg * 2 + obp failed", expected, actual);
	}

}
