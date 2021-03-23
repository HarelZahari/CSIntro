/** Prints the number of days in the 12 months of a given year. */
/*
 
 Assignment number     :    2.4
 
 File Name             :    Calendar.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
public class Calendar {

    public static void main(String args[]) {
        // Declaration
        int year;

        year = Integer.parseInt(args[0]);
        if (!isLeapYear(year))
            System.out.println("Year " + year + " is a common year");
        else
            System.out.println("Year " + year + " is a leap year");
        // Printing the days in each month according to isLeapYear status
        for (int i = 1; i < 13; i++) {
            System.out.println("Month " + i + " has " + nDaysInMonth(i, year) + " days");
        }
    }

    // Returns true if the given year is a leap year, false otherwise. return: boolean
    private static boolean isLeapYear(int year) {
        boolean isLeapYear;
        // divisible by 4 but not by 100
        isLeapYear = ((year % 4) == 0) && ((year % 100) != 0);
        // or divisible by 400
        isLeapYear = isLeapYear || ((year % 400) == 0);
        if (isLeapYear)
            return true;
        return false;
    }

    // Returns the number of days in the given month, in that year. return: int
    private static int nDaysInMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        if (month == 2 && isLeapYear(year))
            return 29;
        else
            return 28;
    }
}
