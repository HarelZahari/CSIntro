/*
 
 Assignment number     :    4.3
 
 File Name             :    LetterFreq.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
/**
 * Counts and prints the frequencies of the letters of the English alphabet in a
 * given text.
 */

public class LetterFreq {
    // The class has two use cases, described below.
    public static void main(String[] args) {
        String text; // The input text
        // If the user supplied no command-line argument:
        if (args.length == 0) {
            // Reads the text from standard input (typically, a user-supplied text file)
            text = StdIn.readAll(); // This function reads all the text into one string
        }
        // If there is a command-line argument:
        else {
            // Reads the text from the command-line argument
            text = args[0];
        }

        // Computes the frequency of each letter in the English alphabet within the text
        int[] freqs = frequencies(text);
        printHistogram(freqs);
    }

    /**
     * Counts the frequencies of the 26 letters of the English alphabet in the given
     * string. The count is case-insensitive: 'a' and 'A' are treated and counted
     * the same way. All the non-alphabetic characters are ignored.
     * 
     * @param text
     *            The text to analyze
     * @return An array of frequencies, with 26 entries. Location <i> of the array
     *         holds the number of times letter number <i> in the English alphabet
     *         appeared in the given text. We consider 'a' to be the 0'th letter.
     */
    public static int[] frequencies(String text) {
        // The English alphabet has 26 letters
        final int ALPHABET_SIZE = 26;
        int[] freqs = new int[ALPHABET_SIZE];
        text = text.toLowerCase();
        int currentUnicodeChar = 0;
        for (int i = 0; i < text.length(); i++) {
            currentUnicodeChar = text.charAt(i);
            if (currentUnicodeChar >= (int) 'a' && currentUnicodeChar <= (int) 'z') {
                freqs[currentUnicodeChar - (int)'a']++;
            }
        }
        return freqs;
    }

    /**
     * Prints the given array of letter frequencies, as a histogram. Entry 0 in the
     * array is assumed to hold the number of occurrences of 'a', Entry 1 is assumed
     * to hold the number of occurrences of 'b', etc.
     * 
     * @param frequencies The given array of frequencies
     * @return Void print the given array of letter frequencies
     */
    public static void printHistogram(int[] frequencies) {
        for (int i = 0; i < frequencies.length; i++) {
            System.out.print(((char) (i + (int) 'a')) + ":");
            for (int j = 0; j < frequencies[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
