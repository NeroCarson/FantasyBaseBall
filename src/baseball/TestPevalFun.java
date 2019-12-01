package baseball;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import models.Pitcher;

public class TestPevalFun {
	ArrayList<Pitcher> pitchers;

	@Before
	public void setUp() throws Exception {
		pitchers = new ArrayList<>();
		Pitcher bob = new Pitcher("Bob", "Test");
		bob.era = 2.35;
		bob.avg = .85;
		pitchers.add(bob);

		Pitcher joe = new Pitcher("Joe", "Test");
		joe.era = 4.5;
		joe.avg = .65;
		pitchers.add(joe);

		Pitcher jane = new Pitcher("Jane", "Test");
		jane.era = 3.2;
		jane.avg = .79;
		pitchers.add(jane);

		Pitcher sue = new Pitcher("Sue", "Test");
		sue.era = 4.4;
		sue.avg = .9;
		pitchers.add(sue);
	}

	@Test
	public void constantFunction() {
		FunctionsJ.pevalfun(pitchers, new String[] { "6" });
		String[] actual = pitchers.stream().map(p -> p.name).collect(Collectors.toList()).toArray(new String[0]);
		String[] expected = { "Bob", "Joe", "Jane", "Sue" };
		assertArrayEquals("Constant function failed.", expected, actual);
	}

	@Test
	public void simpleFunction() {
		FunctionsJ.pevalfun(pitchers, new String[] { "era", "/", "2" });
		String[] actual = pitchers.stream().map(p -> p.name).collect(Collectors.toList()).toArray(new String[0]);
		String[] expected = { "Joe", "Sue", "Jane", "Bob" };
		assertArrayEquals("Simple function failed", expected, actual);
	}

	@Test
	public void twoVariableFunction() {
		FunctionsJ.pevalfun(pitchers, new String[] { "era", "-", "1", "+", "avg", "*", "5" });
		String[] actual = pitchers.stream().map(p -> p.name).collect(Collectors.toList()).toArray(new String[0]);
		String[] expected = { "Sue", "Joe", "Jane", "Bob" };
		assertArrayEquals("Two variable function failed", expected, actual);
	}

	@Test
	public void invalidFunction() {
		FunctionsJ.pevalfun(pitchers, new String[] { "erg", "*", "10" });
		String[] actual = pitchers.stream().map(p -> p.name).collect(Collectors.toList()).toArray(new String[0]);
		String[] expected = { "Bob", "Joe", "Jane", "Sue" };
		assertArrayEquals("Invalid function failed", expected, actual);
	}
	
	@Test
	public void nullPitchers() {
		FunctionsJ.pevalfun(null, new String[] { "erg", "*", "10" });
		String[] actual = pitchers.stream().map(p -> p.name).collect(Collectors.toList()).toArray(new String[0]);
		String[] expected = { "Bob", "Joe", "Jane", "Sue" };
		assertArrayEquals("Invalid function failed", expected, actual);
	}
	
	@Test
	public void nullFunction() {
		FunctionsJ.pevalfun(pitchers, null);
		String[] actual = pitchers.stream().map(p -> p.name).collect(Collectors.toList()).toArray(new String[0]);
		String[] expected = { "Bob", "Joe", "Jane", "Sue" };
		assertArrayEquals("Invalid function failed", expected, actual);
	}
}
