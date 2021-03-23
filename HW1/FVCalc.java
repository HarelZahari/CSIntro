/*
 
 Assignment number     :    1.2
 
 File Name             :    FVCalc.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class FVCalc {

    public static void main(String[] args) {
        // Declarations
        int years = 0;
        int dollars = 0;
        double rate = 0;
        double futureValue = 0;
        
        // Gets and parses dollars,rate, and years from command-line
        dollars = Integer.parseInt(args[0]);
        rate = Double.parseDouble(args[1]);
        years = Integer.parseInt(args[2]);
        
        futureValue = dollars * (Math.pow(1 + rate / 100, years));                                                            // Calculate the future value of the investment
        System.out.println("After " + years + " years, $" + dollars + " saved at " + rate + "% will yield $" + futureValue);    // Print the inputs and the final results of the investment
    }

}
