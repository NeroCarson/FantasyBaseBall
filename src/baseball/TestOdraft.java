package baseball;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import models.League;
import models.LeagueMember;
import models.Person;
import models.Pitcher;
import models.Player;

public class TestOdraft {	
	League l = new League();	
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	void before() {		
		System.setOut(new PrintStream(outContent));		
		
		Player player1 = new Player("Yelich, C","MIL","RF");
		Player player2 = new Player("Marte, K", "ARI","CF");
		l.players.add(player1);
		l.players.add(player2);

		Pitcher pitcher1 = new Pitcher("Ryu, H", "LAD");
		Pitcher pitcher2 = new Pitcher("DeGrome, J", "NYM");
		
		l.pitchers.add(pitcher1);
		l.pitchers.add(pitcher2);
	}
	@Test
	public void odraft() throws Throwable{
		FunctionsW.odraft()
		//when 
		//assertEquals(expected, result);
	}

}
