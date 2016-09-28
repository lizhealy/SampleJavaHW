package com.lizhealy.samples;

/**
 * Created by lizhealy on 9/21/16.
 */
public class test{

    public static void main(String[] args) {
        printPalindromes(0, 8000);
    }
    private static void printPalindromes(int start, int end) {

            // 00022000
        int[] daysMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        for (int curYr = start; curYr < end; curYr++) {
    // every year there is only one palindrome => just check if the palyndrome is a valid date
    // 2010
    // last digit third digit
            int day = curYr / 1000 + (curYr / 100 - curYr / 1000 * 10) * 10;
    // first digit second digit*10
            int month = curYr % 10 * 10 + (curYr % 100 - curYr % 10) * 10;
    // check if the day and month is legal
            boolean monthValid = month > 0 && month <= 12;
            if (monthValid) {
                boolean dayValid = day > 0
                        && (day < daysMonth[month] || (curYr % 4 == 0
                        && month == 2 && day == 29));
                if (dayValid) {
                    System.out.printf("P %02d%02d %04d\n", month, day, curYr);
                }
            } else {
    // System.out.printf("%02d%02d %04d\n", month, day, curYr);
            }
        }
    }

}
