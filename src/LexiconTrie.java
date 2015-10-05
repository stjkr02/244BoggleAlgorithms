import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class represents the word list.  You can check to see if a
 * word is contained or a prefix is contained in the lexicon.
 *
 * @author stjkr02
 */
public class LexiconTrie {
    private TrieNode root;
    private int offset = 97;

    /**
     * Create a word list from the specified file
     *
     * @param filename the file to read
     * @throws java.io.FileNotFoundException if the file cannot be found
     * @throws java.io.IOException           if an IO Error occurs while reading
     */
    public LexiconTrie(String filename) throws IOException {
        this.root = new TrieNode('\0');

        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = in.readLine()) != null) {
                // Trim the white space
                line = line.trim();

                // Ignore blank lines
                if (line.length() == 0)
                    continue;

                this.add(line);
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
        TrieNode currNode = this.root;
        int length = prefix.length();
        char[] letters = prefix.toLowerCase().toCharArray();

        // Traverse the tree to the end of the prefix, if it exists
        for (int i = 0; i < length; i++) {
            int currIndex = letters[i] - offset;
            if (currNode.links[currIndex] == null)
                return false;
            else
                currNode = currNode.links[currIndex];
        }

        // Check if there is a legit word, if yes then it is also a prefix
        if (currNode.fullWord)
            return true;

        //Check to see if at the current node there are links to other nodes (a.k.a more letters -> words/isPrefix)
        for (TrieNode tn : currNode.links) {
            if (tn != null)
                return true;
        }

        // If we haven't returned at this point then something went wrong, assume false.
        return false;

    }

    /**
     * Determine if the specified word is contained in the lexicon
     *
     * @param word the word to check
     * @return true if the word occur, false otherwise
     */
    public boolean isWord(String word) {
        TrieNode currNode = this.root;
        int length = word.length();
        char[] letters = word.toLowerCase().toCharArray();

        for (int i = 0; i < length; i++) {
            int currIndex = letters[i] - offset;
            if (currNode.links[currIndex] == null)
                return false;
            else
                currNode = currNode.links[currIndex];
        }

        // Is it a full word and was the string not empty?
        return currNode.fullWord && (currNode != this.root);
    }


    private void add(String word) {
        TrieNode currNode = this.root;
        int length = word.length();
        char[] letters = word.toLowerCase().toCharArray();

        for (int i = 0; i < length; i++) {
            int currIndex = letters[i] - offset;
            if (currNode.links[currIndex] == null)
                currNode.links[currIndex] = new TrieNode(letters[i]);

            currNode = currNode.links[currIndex];
        }

        currNode.fullWord = true;

    }

    private class TrieNode {
        char letter;
        TrieNode[] links;
        boolean fullWord;

        TrieNode(char letter) {
            this.letter = letter;
            links = new TrieNode[26];
            this.fullWord = false;
        }
    }


}



