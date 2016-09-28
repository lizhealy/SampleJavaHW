package com.lizhealy.samples;


import org.apache.commons.lang3.time.DateUtils;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * You must implement the getPalindromeDates method so that it returns
 * all of the dates that are palindromes when in format 'MMddyyyy'.  The 
 * getPalindromeDates method should have the following guarantees:
 *
 * - Always returns a non-null Set<Date>.
 * - Dates within the Set will always iterate in chronological order.
 * - The start and end parameters will always be non-null Dates.
 * - Start is not guaranteed to be chronologically before end.
 */
public class Solution {
    static Set<Date> getPalindromeDates(Date start, Date end) {
        Set<Date> dates = new HashSet<Date>();



        for (Date mmddyyyy = start; !mmddyyyy.after(end); mmddyyyy = DateUtils.addDays(mmddyyyy, 1)) {
            SimpleDateFormat monthFormat = new SimpleDateFormat();
            monthFormat.applyPattern("MM");
            int month = Integer.parseInt(monthFormat.format(mmddyyyy));
            SimpleDateFormat dayFormat = new SimpleDateFormat();
            dayFormat.applyPattern("dd");
            int day = Integer.parseInt(dayFormat.format(mmddyyyy));
            SimpleDateFormat yearFormat = new SimpleDateFormat();
            yearFormat.applyPattern("yyyy");
            int year = Integer.parseInt(yearFormat.format(mmddyyyy));

            day = year / 1000 + (year / 100 - year / 1000 * 10) * 10;
            // first digit second digit*10
            month = year % 10 * 10 + (year % 100 - year % 10) * 10;

            if (month >= 1 && month <= 12) { // Valid month.
                if (day >= 1) {// Valid lower limit for day.
                    // Upper limit must be less than number of days in each
                    // month (including leap year)
                    boolean validDay = false;
                    int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,
                            31 };
                    if (month == 2) {
                        if ((year % 4 == 0 && year % 100 != 0)
                                || year % 400 == 0) {
                            if (day <= 29) {
                                validDay = true;
                            }
                        } else {
                            if (day <= days[month - 1]) {
                                validDay = true;
                            }
                        }
                    } else { // Not feb, just pick days from the array.
                        if (day <= days[month - 1]) {
                            validDay = true;
                        }
                    }
                    if (validDay) { // Valid day && Valid month
                        dates.add(mmddyyyy);

                    }
                }
            }
        }
//        List sortedList = new ArrayList(dates);
//        Collections.sort(sortedList);
//        Set<Date> sortedDates = new HashSet<Date>(sortedList);
//        return sortedDates;
        return dates;


    }


    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Scanner in = new Scanner(System.in);
        Date start = formatter.parse(in.nextLine());
        Date end = formatter.parse(in.nextLine());
        in.close();
        Set<Date> dates = getPalindromeDates(start, end);

        System.out.println(dates);
//
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//        for(Date date : dates){
//            bw.write(formatter.format(date));
//            bw.newLine();
//        }
//        bw.close();
    }

}