/*
 
 Assignment number     :    4.4 and 4.5
 
 File Name             :    CodeOps.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class CodeOps {
    /**
       The program receives a string and a key, and prints the encoded string and then its decoded version
     */
    public static void main(String[] args) {
        String decodeStr = args[0].toLowerCase();
        int key = Integer.parseInt(args[1])%26;
        System.out.println("Encode: " + encode(decodeStr, key));
        System.out.println("Decode: " + decode(encode(decodeStr, key), key));
        System.out.println("Decode without key: " + decode(encode(decodeStr, key)));
    }

    /**
    The method receives a string and a key, and decode the string.
    @param encodeStr  The encode string that need to decode
    @param key  The key that required in order to decode the encodeStr string
    @return String return the decode string
  */
    public static String decode(String encodeStr, int key) {
        String decode = "";
        int currentUnicodeChar;
        for (int i = 0; i < encodeStr.length(); i++) {
            currentUnicodeChar = encodeStr.charAt(i);
            if (currentUnicodeChar >= (int) 'a' && currentUnicodeChar <= (int) 'z') {
                currentUnicodeChar = currentUnicodeChar - (int) 'a';
                if(currentUnicodeChar>=key)
                    decode += (char) (((currentUnicodeChar - key) % 26) + (int) 'a');
                else
                    decode += (char) (((currentUnicodeChar+26 - key) % 26) + (int) 'a');
            } else {
                decode += encodeStr.charAt(i);
            }
        }
        return decode;
    }

    /**
    The method receives a string, and decode it without any key (we assume that most frequent letter in English texts that are is 'e').
    @param encodeStr  The encode string that need to decode
    @return String return the decode string
  */
    public static String decode(String encodeStr) {
        int key=0;
        int currentUnicodeChar;
        final int ALPHABET_SIZE = 26;
        int[] freqs = new int[ALPHABET_SIZE];
        for (int i = 0; i < encodeStr.length(); i++) {
            currentUnicodeChar = encodeStr.charAt(i);
            if (currentUnicodeChar >= (int) 'a' && currentUnicodeChar <= (int) 'z') {
                freqs[currentUnicodeChar - (int) 'a']++;
            }
         for(int j=0; j<freqs.length;j++) {
             if(freqs[j]>key) {
                 key=j;
             }
         }
         key=Math.abs(key-((int)'e'-97));
        }
        return decode(encodeStr,key);
    }

    /**
    The method receives a string and a key, and encode the string.
    @param decodeStr  The decode string that need to encode
    @param key  The key that required in order to encode the encodeStr string
    @return String return the encode string
  */
    public static String encode(String decodeStr, int key) {
        String encode = "";
        int currentUnicodeChar;
        for (int i = 0; i < decodeStr.length(); i++) {
            currentUnicodeChar = decodeStr.charAt(i);
            if (currentUnicodeChar >= (int) 'a' && currentUnicodeChar <= (int) 'z') {
                currentUnicodeChar = currentUnicodeChar - (int) 'a';
                encode += (char) (((currentUnicodeChar + key) % 26) + (int) 'a');
            } else {
                encode += decodeStr.charAt(i);
            }
        }
        return encode;
    }
}
