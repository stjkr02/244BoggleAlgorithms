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
public class LexiconAL {

    private ArrayList<String> lex = new ArrayList<>(172823);

    /**
     * Create a word list from the specified file
     *
     * @param filename the file to read
     * @throws java.io.FileNotFoundException if the file cannot be found
     * @throws java.io.IOException           if an IO Error occurs while reading
     */
    public LexiconAL(String filename) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line;
            int row = 0;

            while ((line = in.readLine()) != null) {
                // Trim the white space
                line = line.trim();

                // Ignore blank lines
                if (line.length() == 0)
                    continue;

                lex.add(row, line);

                // Increment the row number
                row++;
            }
        }

        Collections.sort(this.lex);

    }


    /**
     * Determine if the specified string is a prefix for any of the words
     *
     * @param prefix the prefix to test
     * @return true if the prefix occurs in the lexicon, false otherwise
     */
    public boolean isPrefix(String prefix) {
        int p = Collections.binarySearch(this.lex, prefix);
        String next = "";
        if (p >= 0) {
            next = lex.get(p + 1);
        } else {
            p = -(p + 1);
            next = lex.get(p);
        }
        return next.startsWith(prefix);
    }

    /**
     * Determine if the specified word is contained in the lexicon
     *
     * @param word the word to check
     * @return true if the word occur, false otherwise
     */
    public boolean isWord(String word) {
        return Collections.binarySearch(this.lex, word) >= 0;
    }
}
