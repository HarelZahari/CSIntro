/*
 
 Assignment number     :    2.2
 
 File Name             :    Collatz.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class Collatz {

    public static void main(String[] args) {
        // Declarations
        int seed = 0;
        int tmp = 0;
        int counter = 1;
        String mode = "";
        String iStringLine = "";

        seed = Integer.parseInt(args[0]);
        mode = args[1];

        // Create the hailstone sequences until seed
        for (int i = 1; i <= seed; i++) {
            iStringLine = "";
            tmp = i;
            // Obtain a sequence of numbers by the hailstone sequence rules
            // The do-while is because we want to create hailstone sequence also for the number: 1
            do {
                iStringLine += tmp + ", ";
                if (tmp % 2 == 0) {
                    tmp = tmp / 2;
                } else {
                    tmp = tmp * 3 + 1;
                }
                counter++;
            } while (tmp != 1);
            
            if (tmp == 1)
                iStringLine += tmp + " (" + counter + ")"; // Add to the string: iStringLine, the number of terms on i
            // Print the string iStringLine if mode equal to "v"
            if (mode.equalsIgnoreCase("v"))
                System.out.println(iStringLine);
        }
        // Print that the program finished the hailstone sequences, and reached to 1 in all 1-seed numbers.
        System.out.println("The first " + seed + " hailstone sequences reached " + tmp + ".");
    }
}