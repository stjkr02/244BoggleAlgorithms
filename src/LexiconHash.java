import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/**
 * This class represents the word list.  You can check to see if a
 * word is contained or a prefix is contained in the lexicon.
 *
 * @author stjkr02
 */
public class LexiconHash {

    private HashSet<String> words = new HashSet<>(172823);
    private HashSet<String>[] prefixes = new HashSet[29];

    /**
     * Create a word list from the specified file
     *
     * @param filename the file to read
     * @throws java.io.FileNotFoundException if the file cannot be found
     * @throws java.io.IOException           if an IO Error occurs while reading
     */
    public LexiconHash(String filename) throws IOException {
        // initialize the HashSets within the array
        for (int i = 0; i < 29; i++) {
            prefixes[i] = new HashSet<String>();
        }

        // Read in the file
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = in.readLine()) != null) {
                // Trim the white space
                line = line.trim();

                // Ignore blank lines
                if (line.length() == 0)
                    continue;

                // Add the word to the hash set of words
                words.add(line);

                // Add the word as prefixes
                int length = line.length();

                for (int i = 1; i < length; i++) {
                    prefixes[i].add(line.substring(0,i));
                }

            }
        }
    }


    /**
     * Determine if the specified string is a prefix for any of the words
     *
     * @param prefix the prefix to test
     * @return true if the prefix occurs in the lexicon, false otherwise
     */
    public boolean isPrefix(String prefix) {
        return prefixes[prefix.length()].contains(prefix);
    }

    /**
     * Determine if the specified word is contained in the lexicon
     *
     * @param word the word to check
     * @return true if the word occur, false otherwise
     */
    public boolean isWord(String word) {
        return words.contains(word);
    }
}
