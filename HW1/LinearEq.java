/*
 
 Assignment number     :    1.3
 
 File Name             :    LinearEq.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class LinearEq {

    public static void main(String[] args) {
        // Declaration
        double x = 0;

        // Gets and parses a,b and c from command-line
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        System.out.println(a + " * x + " + b + " = " + c);   // Print the Linear equation
        x = (c - b) / a;                                    // Calculate the x of the linear equation
        System.out.println("x = " + x);                     // Print the x variable
    }

}
