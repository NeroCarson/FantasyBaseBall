package baseball;


import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestIdraft.class,
	TestOdraft.class,
	TestOverall.class,
	TestPoverall.class,
	TestQuit.class,
	TestRestore.class,
	TestSave.class,
	TestStars.class,
	TestTeam.class,
})
public class BaseballTestSuite {

}
