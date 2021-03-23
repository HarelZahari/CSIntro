/*
 
 Assignment number     :    2.1
 
 File Name             :    CalcExp.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class CalcExp {

    public static void main(String[] args) {
        // Declarations
        int nDegree = 0;
        int factorial = 1;
        double exponent = 0.0;
        double macLaurin = 1.0;
        
        exponent = Double.parseDouble(args[0]);
        nDegree = Integer.parseInt(args[1]);
        // Calculation of e power exponent with Math library
        System.out.println("e raised to the power of 2 according to Java: " + Math.exp(exponent));
        // Calculation of e power exponent, with Maclaurin series for the exponential function e^x
        for (int i = 1; i < nDegree; i++) {
            factorial = factorial * i;
            macLaurin = macLaurin + (Math.pow(exponent, i) / factorial);
        }
        System.out.println("Same, using MacLaurin polynomial with degree " + nDegree + ": " + macLaurin);
    }

}
