/*
 
 Assignment number     :    4.2
 
 File Name             :    Primes.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class Primes {

    /**
     * Get integer as a user input and print all the prime numbers until this input (include) 
     */
    public static void main(String[] args) {
        int lastNumber = Integer.parseInt(args[0]);
        boolean[] primeArray = primeArr(lastNumber);
        for (int i = 2; i <= lastNumber; i++) {
            if (primeArray[i] == true) {
                System.out.print(i + " ");
            }
        }
    }
    /**
     * Get lastNumber (int) and create an array of all the prime numbers until this parameter (include)
     * @param lastNumner  The number that represent the highest number that need to test
     * @return boolean array that represent the prime numbers until lastNumber
     */
    public static boolean[] primeArr(int lastNumber) {
        boolean[] primeArray = new boolean[lastNumber + 1];
        for(int n=0;n<primeArray.length;n++) {
            primeArray[n]=true;
        }
        for (int i = 2; i * i <= lastNumber; i++) {
            if (primeArray[i] == true) {
                for (int j = i * i; j <= lastNumber; j += i) {
                    primeArray[j] = false;
                }
            }
        }
        return primeArray;
    }

}
