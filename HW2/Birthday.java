/*
 
 Assignment number     :    2.3
 
 File Name             :    Birthday.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class Birthday {

    public static void main(String[] args) {
        // Declarations
        double minimalN = 0.5;
        double probability = 0.0;
        int n = 1;
        // Calculate what is the minimum amount of people that required in order that the probability will by less than minimalN
        while (probability < minimalN) {
            n++;
            probability = probSameBirthday(n);
        }
        System.out.println("The minamal n requierd that the probability will be at least: " + minimalN + " is: " + n);
    }

    /* The function calculate the probability that on group of n people at least 2 people will have birthday
    at the same day and return the probability return: double */
    public static double probSameBirthday(int n) {
        // Declarations
        double probability = 1;
        double c = 1.0 / 365;
        
        for (int i = 1; i < n; i++) {
            probability *= (1 - i * c);
        }
        return 1 - probability;
    }

}
