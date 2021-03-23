/*
 
 Assignment number     :    4.1
 
 File Name             :    LoanCalc.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
/**
 * Calculates the periodical payment necessary to re-pay a given loan,
 */
public class LoanCalc {

    static int iterationCounter = 0; // monitors the efficiency of the calculation

    /**
     * Gets the loan data and computes the periodical payment, using two methods:
     * brute force search, and bisection search.
     */
    public static void main(String[] args) {
        // Gets the loan data
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);

        double epsilon = 0.001; // the computation tolerance / accuracy

        // Computes the periodical payment using brute force search
        System.out.print("Periodical payment: ");
        System.out.printf("%.2f", solveByBruteForceSearch(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);

        // Computes the periodical payment using bisection search
        System.out.print("Periodical payment: ");
        System.out.printf("%.2f", solveByBisectionSearch(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);
    }

    /**
     * Uses a brute force search method to compute an approximation of the
     * periodical payment that will bring the ending balance of a loan to 0. Given:
     * the loan, the periodical interest rate (as a percentage), the number of
     * periods (n), and epsilon, a tolerance level.
     * @param loan  The required loan
     * @param rate  The rate for the loan return
     * @param n  The number of periods
     * @param epsilon The tolerance level for the return payment
     * @return double The periodical payment that will bring the ending balance of a loan to 0
     * 
     */
    // Side effect: modifies the class variable iterationCounter.
    public static double solveByBruteForceSearch(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;
        double lastPayment;
        double periodicalPayment = loan / n;
        do {
            periodicalPayment = periodicalPayment + epsilon;
            lastPayment = endBalance(loan, rate, n, periodicalPayment);
            iterationCounter++;
        } while (lastPayment >= 0);
        return periodicalPayment;
    }

    /**
     * Uses a bisection search method to compute an approximation of the periodical
     * payment that will bring the ending balance of a loan to 0. Given: the loan,
     * the periodical interest rate (as a percentage), the number of periods (n),
     * and epsilon, a tolerance level.
     * @param loan  The required loan
     * @param rate  The rate for the loan return
     * @param n  The number of periods
     * @param epsilon The tolerance level for the return payment
     * @return double The periodical payment that will bring the ending balance of a loan to 0
     */
    // Side effect: modifies the class variable iterationCounter.
    public static double solveByBisectionSearch(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;
        double lowX = loan / n;
        double highX = loan * (1 + (rate / 100.0) * n) / n;
        double middleX = (lowX + highX) / 2.0;
        while ((highX - lowX) / 2.0 > epsilon) {
            if ((endBalance(loan, rate, n, lowX) * endBalance(loan, rate, n, middleX)) > 0) {
                lowX = middleX;
            } else {
                highX = middleX;
            }
            middleX = (lowX + highX) / 2.0;
            iterationCounter++;
        }
        return lowX;
    }

    /**
     * Computes the ending balance of a loan, given: the loan, the periodical
     * interest rate (as a percentage), the number of periods (n), and the
     * periodical payment.
     * @param loan  The required loan
     * @param rate  The rate for the loan return
     * @param n  The number of periods
     * @param payment The periodical payment to exam
     * @return double The balance of the payment after the n period
     */
    private static double endBalance(double loan, double rate, int n, double payment) {
        double endBalancePayment = loan;
        for (int i = 0; i < n; i++) {
            endBalancePayment = (endBalancePayment - payment) * (1 + (rate / 100.0));
        }
        return endBalancePayment;
    }
}