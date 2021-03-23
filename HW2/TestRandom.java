/*
 
 Assignment number     :    2.5
 
 File Name             :    TestRandom.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class TestRandom {

    public static void main(String[] args) {
        // Declaration
        int qunatityNumbers = 0;

        qunatityNumbers = Integer.parseInt(args[0]);
        // Run the random4 function qunatityNumbers times
        for (int i = 0; i < qunatityNumbers; i++) {
            System.out.print(random4() + ", ");
        }
    }

    // The function randomize numbers (0, 1, 2, 3) return: int
    public static int random4() {
        // Declarations
        int randomNumber = 0;
        double x;
        
        x = (4 * Math.random()); // Get number between [0,4)
        randomNumber = (int) x; // Rounding number down then get integer number from the group {0, 1, 2, 3}
        return randomNumber;
    }

}
