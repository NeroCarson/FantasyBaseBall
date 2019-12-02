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
		Player player2 = new Player("Yelich, C", "MIL", "RF");
		Player player3 = new Player("Marte, K", "ARI", "CF");
		Player player4 = new Player("Rendon, A", "WSH", "3B");
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		pitchers = new ArrayList<>();
		Pitcher pitcher1 = new Pitcher("Ryu, H", "LAD");
		Pitcher pitcher2 = new Pitcher("DeGrom, J", "NYM");
		pitchers.add(pitcher1);
		pitchers.add(pitcher2);
	}

	@Test
	public void idraft() {
		FunctionsW.idraft(testLeague, "Anderson, T");
		String actual_player1 = output.toString().replaceAll("[\n\r]", "");
		String expected_player1 = "You've recruited Anderson, T for the position of SS";
		assertEquals(expected_player1, actual_player1);
		output.reset();
		FunctionsW.idraft(testLeague, "Yelich, C");
		String actual_player2 = output.toString().replaceAll("[\n\r]", "");
		String expected_player2 = "You've recruited Yelich, C for the position of RF";
		assertEquals(expected_player2, actual_player2);
		output.reset();
		FunctionsW.idraft(testLeague, "Marte, K");
		String actual_player3 = output.toString().replaceAll("[\n\r]", "");
		String expected_player3 = "You've recruited Marte, K for the position of CF";
		assertEquals(expected_player3, actual_player3);
		output.reset();
		FunctionsW.idraft(testLeague, "Rendon, A");
		String actual_player4 = output.toString().replaceAll("[\n\r]", "");
		String expected_player4 = "You've recruited Rendon, A for the position of 3B";
		assertEquals(expected_player4, actual_player4);
		output.reset();
		FunctionsW.idraft(testLeague, "Ryu, H");
		String actual_pitcher1 = output.toString().replaceAll("[\n\r]", "");
		String expected_pitcher1 = "You've recruited Ryu, H for the position of pitcher";
		assertEquals(expected_pitcher1, actual_pitcher1);
		output.reset();
		FunctionsW.idraft(testLeague, "DeGrom, J");
		String actual_pitcher2 = output.toString().replaceAll("[\n\r]", "");
		String expected_pitcher2 = "You've recruited DeGrom, J for the position of pitcher";
		assertEquals(expected_pitcher2, actual_pitcher2);
	}

}
