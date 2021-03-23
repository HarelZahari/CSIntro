/*
 
 Assignment number     :    1.5
 
 File Name             :    Gen3.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class Gen3 {

    public static void main(String[] args) {
        // Declarations
        int m;
        int n;
        int k;
        // Gets and parses a and b from command-line (a and b represent the range for the random)
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        // Get 3 random numbers on the range [a,b) the number represent by the variables x,y,z
        m = (int) (Math.random() * (b - a) + a);
        n = (int) (Math.random() * (b - a) + a);
        k = (int) (Math.random() * (b - a) + a);

        // Print m,n,k 
        System.out.println(m);
        System.out.println(n);
        System.out.println(k);

        System.out.println("The minimal generated number was " + (int) (Math.min((Math.min(m, n)), k)));    // Print the minimal number that generated
    }

}
