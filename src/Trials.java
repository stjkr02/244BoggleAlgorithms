import java.io.IOException;
import java.util.ArrayList;

public class Trials {
    private static String defaultBoggleLexicon = "files/boggleWords.txt";

    public static double arrayList(String lexicon, int numTrials, ArrayList<String> words) {
        LexiconAL lex = null;
        try {
            lex = new LexiconAL(lexicon);
        } catch (IOException e) {
            System.out.println("Something went wrong when the file was being read, please check the lexicon file and its path.");
            return 0.0;
        }

        double sum = 0.0;

        for (int i = 0; i < numTrials; i++) {
            Stopwatch sw = new Stopwatch();

            for (String s : words)
                lex.isWord(s);

            sum += sw.elapsedTime();
        }

        return sum/numTrials;
    }

    public static double arrayList(int numTrials, ArrayList<String> words) {
        return Trials.arrayList(defaultBoggleLexicon, numTrials, words);
    }



    public static double trie(String lexicon, int numTrials, ArrayList<String> words) {
        LexiconTrie lex = null;
        try {
            lex = new LexiconTrie(lexicon);
        } catch (IOException e) {
            System.out.println("Something went wrong when the file was being read, please check the lexicon file and its path.");
            return 0.0;
        }

        double sum = 0.0;

        for (int i = 0; i < numTrials; i++) {
            Stopwatch sw = new Stopwatch();

            for (String s : words)
                lex.isWord(s);

            sum += sw.elapsedTime();
        }

        return sum/numTrials;
    }

    public static double trie(int numTrials, ArrayList<String> words) {
        return Trials.trie(defaultBoggleLexicon, numTrials, words);
    }



    public static double hash(String lexicon, int numTrials, ArrayList<String> words) {
        LexiconHash lex = null;
        try {
            lex = new LexiconHash(lexicon);
        } catch (IOException e) {
            System.out.println("Something went wrong when the file was being read, please check the lexicon file and its path.");
            return 0.0;
        }

        double sum = 0.0;

        for (int i = 0; i < numTrials; i++) {
            Stopwatch sw = new Stopwatch();

            for (String s : words)
                lex.isWord(s);

            sum += sw.elapsedTime();
        }

        return sum/numTrials;
    }

    public static double hash(int numTrials, ArrayList<String> words) {
        return Trials.hash(defaultBoggleLexicon, numTrials, words);
    }



    public static double[] all(String lexicon, int numTrials, ArrayList<String> words) {
        double[] d = {trie(lexicon, numTrials, words), hash(lexicon, numTrials, words), arrayList(lexicon, numTrials, words) };
        return d;
    }

    public static double[] all(int numTrials, ArrayList<String> words) {
        return all(defaultBoggleLexicon, numTrials, words);
    }
}
