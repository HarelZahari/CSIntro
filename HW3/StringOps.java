/*
 
 Assignment number     :    3.3
 
 File Name             :    StringOps.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class StringOps {

    public static void main(String[] args) {
        test_concat();
        test_trim();
        test_charRunCount();
        test_tokenize();
        test_removeChar();
    }

    private static void test_concat() {
        String[] strings = new String[3];
        strings[0] = "wiki";
        strings[1] = "pe";
        strings[2] = "dia";
        System.out.println(concat(strings)); // Should print: wikipedia
    }

    private static void test_trim() {
        String s = "aaahappy birthdayaaaaaaa";
        System.out.println(trim(s, 'a')); // should print "happy birthday"
    }

    private static void test_charRunCount() {
        String s = "GCCAATGGGGCCGGTTGGGGGGGGG";
        System.out.println(charRunCount(s, 'G')); // should print 4
    }

    private static void test_tokenize() {
        String s = "   x  + Math.sqrt(x)    - rate  ";
        // creates an array of tokens, using the space character ' ' as a separator
        String[] tokens = tokenize(s, ' ');
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
        // Should print:
        // x
        // +
        // Math.sqrt(x)
        // -
        // rate
    }

    // Tests the removeChar function
    private static void test_removeChar() {
        String s = "   x  + Math.sqrt(x)    - rate  ";
        System.out.println(removeChar(s, ' ')); // Should print: x+Math.sqrt(x)-rate
    }

    /**
     * Returns a string which is the concatenation of the given array of strings
     */
    public static String concat(String[] arr) {
        String concatedString = "";
        for (int i = 0; i < arr.length; i++) {
            concatedString += arr[i];
        }
        return concatedString;
    }

    /**
     * Trims the given character from the beginning and end of the given string. For
     * example, if the given string is "aaahappy birthdayaaaaaaa", and the given
     * character is 'a', returns the string "happy birthday".
     */
    public static String trim(String str, char c) {
        int indexOfStart = 0;
        int indexOfEnd = str.length() - 1;
        while (indexOfStart <= indexOfEnd) {
            if (str.charAt(indexOfStart) == c) {
                indexOfStart++;
            }
            if (str.charAt(indexOfEnd) == c) {
                indexOfEnd--;
            }
            if (str.charAt(indexOfStart) != c && str.charAt(indexOfEnd) != c) {
                break;
            }
        }
        if (indexOfStart < indexOfEnd + 1) {
            return str.substring(indexOfStart, indexOfEnd + 1);
        } else {
            return "";
        }
    }

    /**
     * Counts how many "runs" of the given character appear in the given string. A
     * "run" is a consecutive block of one or more occurrences of the same
     * character. For example, if the string is "AATGGGGCCGGTTGGGGGGGGGAAGC" and the
     * character is "G", returns 4.
     */
    public static int charRunCount(String str, char c) {
        int counter = 0;
        int lastIndex = str.indexOf(c);                 // Find the index of the first c char on the string
        int nextIndex = str.indexOf(c, lastIndex + 1);  // Find the index of the second c char on the string
        if (lastIndex == -1) {      // Check if we don't have the given c char at the given string
            return 0;
        }
        while (lastIndex != -1) {
            if (nextIndex - 1 != lastIndex) {
                counter++;
            }
            lastIndex = nextIndex;
            nextIndex = str.indexOf(c, lastIndex + 1);
        }
        return counter;
    }

    /**
     * Separates a given string into tokens, which are the "words" that are
     * separated by one or more occurrences of the given separator character.
     * Returns the tokens as an array of String values.
     */
    public static String[] tokenize(String str, char separator) {
        int currentIndex=0;
        int nextIndex;
        int i=0;
        // Removes all the occurrences of the separator at the beginning and end of str
        String source = trim(str, separator);
        // In the following statement, replace the 0 with the correct number of tokens,
        // and complete the missing code.
        String[] tokens = new String[charRunCount(source, separator) + 1];      // Added +1 because the last word don't have separator
        do {
                nextIndex = source.indexOf(separator, currentIndex + 1);
                if (currentIndex < nextIndex-1) {
                    tokens[i] = source.substring(currentIndex+1, nextIndex);
                    i++;
                }
                if(currentIndex==0) {
                    tokens[i] = source.substring(currentIndex, nextIndex);
                    i++;
                }
                if(nextIndex==-1) {
                    tokens[i] = source.substring(currentIndex+1, source.length());
                    i++;
                }
                currentIndex = nextIndex;
        } while (i<tokens.length);
        return tokens;
    }

    /**
     * Removes all occurrences of the given character from the given string
     */
    public static String removeChar(String s, char c) {
        return concat(tokenize(s, c));
    }
}
