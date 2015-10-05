import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Read in the lexicons and time how long each one takes to initialize
        double t0 = 0.0;
        double t1 = 0.0;
        LexiconTrie lexTrie = null;
        LexiconAL lexAL = null;

        try {
            Stopwatch s0 = new Stopwatch();
            lexTrie = new LexiconTrie("tests/files/words.txt");
            t0 = s0.elapsedTime();

            Stopwatch s1 = new Stopwatch();
            lexAL = new LexiconAL("tests/files/words.txt");
            t1 = s1.elapsedTime();
        } catch (IOException e) {
            System.out.println("The files were not read in properly.");
        }

        System.out.println("The trie-based lexicon took " + t0 + "ms to initialize.");
        System.out.println("The ArrayList-based lexicon took " + t1 + "ms to initialize.");

        ArrayList<String> words = new ArrayList<>(109582);
        try (BufferedReader in = new BufferedReader(new FileReader("tests/files/words.txt"))) {
            String line;
            int row = 0;

            while ((line = in.readLine()) != null) {
                // Trim the white space
                line = line.trim();

                // Ignore blank lines
                if (line.length() == 0)
                    continue;

                words.add(row, line);

                // Increment the row number
                row++;
            }
        } catch (IOException e) {
            System.out.println("The files were not read in properly.");
        }


        // Time to time how long it takes to check ~16mil words via the trie

        Stopwatch s2 = new Stopwatch();

        for (int i = 0; i < 150; i++) {
            for (String s : words)
                lexTrie.isWord(s);
        }

        double t2 = s2.elapsedTime();

        System.out.println("It took " + t2 + "ms to search for ~16 million words with a trie Lexicon.");

        // Time to time how long it takes to check ~16mil words via the trie

        Stopwatch s3 = new Stopwatch();

            for (String s : words) {
                lexAL.isWord(s);
            }
            //System.out.println("Loop iteration: " + i + " time: " + s3.elapsedTime() + "ms");


        double t3 = s3.elapsedTime();

        System.out.println("It will take " + ((t3 * 150)/1000) + "s to search for ~16 million words using an ArrayList lexicon.");

    }

}