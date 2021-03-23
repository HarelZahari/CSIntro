/*
 
 Assignment number     :    1.1
 
 File Name             :    Coins.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class Coins {

    public static void main(String[] args) {
        // Declaration
        int numberOfCoins = 0;

        numberOfCoins = Integer.parseInt(args[0]);                                                             // Gets and parses Number of coins from command-line
        System.out.println("Use " + numberOfCoins / 25 + " quarters and " + numberOfCoins % 25 + " cents");    // Print the amount of the quarters and cents
    }

}
