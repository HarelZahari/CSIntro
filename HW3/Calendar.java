/*
 
 Assignment number     :    3.1
 
 File Name             :    Calendar.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
/** Handles calendars and calendric calculations. */
public class Calendar {
    // Starting the calendar on 1/1/1900
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2; // 1.1.1900 was a Monday
    static int nDaysInMonth = 31; // Number of days on January

    /**
     * Prints the calendar and the number of Sundays that fell on the first day of
     * the month during the 20th century (from 1/1/1901 till 31/12/2000)
     */
    public static void main(String args[]) {
     // Advances the dates and the day-of-the-week from 1.1.1900 until 31.12.1901
        while (year < 1901) {
            advance();
        }

        int nSundaysOnFirstOfMonth = 0;
        // Advances the date and the day-of-the-week throughout the 20th century.
        // Prints each date in a separate row. If the day is a Sunday, prints "Sunday".
        // Counts Sundays that fell of the first of the month.
        while (year < 2001) {
            advance();
            if (dayOfWeek == 1 && dayOfMonth == 1) {
                nSundaysOnFirstOfMonth++;
                dayOfMonth++;
                dayOfWeek = ((dayOfWeek + 1) % 7);
            }
        }
        System.out.println(nSundaysOnFirstOfMonth + " Sundays fell on the first of the month");
    }

    // Advances the date and the day-of-the-week.
    // If the month changes, sets the number of days in this month.
    // Side effects: changes the static variables dayOfMonth, month, year,
    // dayOfWeek, nDaysInMonth.
    private static void advance() {
        do {
            while (dayOfMonth <= nDaysInMonth) {
                if (year >= 1901) {
                    if (dayOfWeek == 1) {
                        System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
                    } else {
                        System.out.println(dayOfMonth + "/" + month + "/" + year);
                    }
                }
                dayOfMonth++;
                dayOfWeek = (dayOfWeek % 7) + 1;
            }
            month++;
            nDaysInMonth = nDaysInMonth(month, year);
            dayOfMonth=1;
            if (dayOfWeek == 1 && dayOfMonth == 1 && year>=1901) {
                System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
                break;    // Exit the loop in order to increase nSundaysOnFirstOfMonth counter.
            }
        } while (month <= 12);
        if (month==13) {    // Check if we finished 12 months or we breaked.
            year++;
            month = 1;
            nDaysInMonth = nDaysInMonth(month, year);
        }
    }

    /** Returns true if the given year is a leap year, false otherwise. */
    public static boolean isLeapYear(int year) {
        boolean isLeapYear;
        // divisible by 4 but not by 100
        isLeapYear = ((year % 4) == 0) && ((year % 100) != 0);
        // or divisible by 400
        isLeapYear = isLeapYear || ((year % 400) == 0);
        if (isLeapYear)
            return true;
        return false;
    }

    /** Returns the number of days in the given month, in the given year. */
    public static int nDaysInMonth(int month, int year) {
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
