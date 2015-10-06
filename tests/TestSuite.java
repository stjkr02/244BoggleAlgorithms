import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 * This fancy code creates a test suite for junit to run.  If you tell IntelliJ to run this
 * class, it will run all of your tests.  Just be sure to add all your test files to the list!
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({LexiconALTest.class, LexiconTrieTest.class, LexiconHashTest.class, RandomStringGeneratorTest.class})
public class TestSuite {
    //nothing
}