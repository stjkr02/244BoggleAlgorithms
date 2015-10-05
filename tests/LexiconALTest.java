import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LexiconALTest {
    String lex = "files/boggleWords.txt";

    // Check to make sure that the FileNotFound exception works
    @Test(expected = FileNotFoundException.class)
    public void testBadNonexistentFile() throws Exception {
        new LexiconAL("NonExistent.dat");
    }

    // Some tests to make sure that LexiconAL functions properly after being loaded
    @Test
    public void testValidWords() throws Exception {
        LexiconAL l = new LexiconAL(lex);

        assertTrue(l.isWord("aa"));
        assertTrue(l.isWord("cab"));
        assertTrue(l.isWord("hedonic"));
        assertTrue(l.isWord("resistance"));
        assertTrue(l.isWord("tandem"));
        assertTrue(l.isWord("zyzzyvas"));

    }

    @Test
    public void testValidPrefixes() throws Exception {
        LexiconAL l = new LexiconAL(lex);

        assertTrue(l.isPrefix("a"));
        assertTrue(l.isPrefix("aas"));
        assertTrue(l.isPrefix("broke"));
        assertTrue(l.isPrefix("bum"));
        assertTrue(l.isPrefix("cine"));
        assertTrue(l.isPrefix("deform"));
        assertTrue(l.isPrefix("emir"));
        assertTrue(l.isPrefix("feudal"));
        assertTrue(l.isPrefix("gimbal"));
        assertTrue(l.isPrefix("hair"));
        assertTrue(l.isPrefix("impersonal"));
        assertTrue(l.isPrefix("joy"));
        assertTrue(l.isPrefix("keep"));
        assertTrue(l.isPrefix("labor"));
        assertTrue(l.isPrefix("major"));
        assertTrue(l.isPrefix("nap"));
        assertTrue(l.isPrefix("occasion"));
        assertTrue(l.isPrefix("pallet"));
        assertTrue(l.isPrefix("queer"));
        assertTrue(l.isPrefix("ration"));
        assertTrue(l.isPrefix("sand"));
        assertTrue(l.isPrefix("term"));
        assertTrue(l.isPrefix("un"));
        assertTrue(l.isPrefix("vase"));
        assertTrue(l.isPrefix("warran"));
        assertTrue(l.isPrefix("xi"));
        assertTrue(l.isPrefix("yod"));
        assertTrue(l.isPrefix("zin"));
    }

    @Test
    public void testInvalidWords() throws Exception {
        LexiconAL l = new LexiconAL(lex);

        assertFalse(l.isWord("jbagjabg"));
        assertFalse(l.isWord("effiqy"));
        assertFalse(l.isWord("kittzen"));
        assertFalse(l.isWord("effiqy"));
        assertFalse(l.isWord("glemor"));
        assertFalse(l.isWord("zdrfh"));
        assertFalse(l.isWord("zsderf"));
    }


    @Test
    public void testInvalidPrefixes() throws Exception {
        LexiconAL l = new LexiconAL(lex);

        assertFalse(l.isPrefix("ez"));
        assertFalse(l.isPrefix("bz"));
        assertFalse(l.isPrefix("sx"));
        assertFalse(l.isPrefix("cx"));

    }



}