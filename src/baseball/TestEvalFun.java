package baseball;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

import models.Player;

public class TestEvalFun {
	ArrayList<Player> players;

	@Before
	public void setUp() throws Exception {
		players = new ArrayList<>();
		Player bob = new Player("Bob", "Test", "C");
		bob.avg = 5.5;
		bob.obp = 1.5;
		players.add(bob);

		Player joe = new Player("Joe", "Test", "P");
		joe.avg = 5;
		joe.obp = 5.5;
		players.add(joe);

		Player jane = new Player("Jane", "Test", "1B");
		jane.avg = 4.5;
		jane.obp = 3;
		players.add(jane);

		Player sue = new Player("Sue", "Test", "SS");
		sue.avg = 3.5;
		sue.obp = 4;
		players.add(sue);
	}

	@Test
	public void evalfunSimpleFunction() {
		FunctionsJ.evalfun(players, "obp * 2");
		String[] actual = players.stream().map(p -> p.name).collect(Collectors.toList()).toArray(new String[0]);
		String[] expected = { "Joe", "Sue", "Jane", "Bob" };
		assertArrayEquals("obp * 2 failed", expected, actual);
	}

	@Test
	public void evalfunForTwoVariable() {
		FunctionsJ.evalfun(players, "avg * 2 + obp");
		String[] actual = players.stream().map(p -> p.name).collect(Collectors.toList()).toArray(new String[0]);
		String[] expected = { "Joe", "Bob", "Jane", "Sue" };
		assertArrayEquals("avg * 2 + obp failed", expected, actual);
	}
}