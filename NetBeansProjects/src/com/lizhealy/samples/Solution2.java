package com.lizhealy.samples;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lizhealy on 9/21/16.
 */
public class Solution2 {
    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Scanner in = new Scanner(System.in);
        Date start = formatter.parse(in.nextLine());
        Date end = formatter.parse(in.nextLine());
        in.close();
        Set<Date> dates = getPalindromeDates(start, end);

        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for(Date date : dates){
            bw.write(formatter.format(date));
            bw.newLine();
        }
        bw.close();
    }
}

    static Set<Date> getPalindromeDates(Date start, Date end) {
        Set<Date> dates = new HashSet<Date>();

        SimpleDateFormat firstYearFormat = new SimpleDateFormat();
        firstYearFormat.applyPattern("yyyy");
        int startYear = Integer.parseInt(firstYearFormat.format(start));

        SimpleDateFormat secondYearFormat = new SimpleDateFormat();
        secondYearFormat.applyPattern("yyyy");
        int endYear = Integer.parseInt(secondYearFormat.format(end));

        int[] daysInAMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        for (int currentYear = startYear; currentYear < endYear; currentYear++) {
            int day = currentYear / 1000 + (currentYear / 100 - currentYear / 1000 * 10) * 10;
            int month = currentYear % 10 * 10 + (currentYear % 100 - currentYear % 10) * 10;
            boolean isMonthValid = false;
            if (month > 0 && month <= 12) {
                isMonthValid = true;
                if (isMonthValid) {
                    boolean isDayValid = false;
                    if (month == 2) {
                        if ((currentYear % 4 == 0 && currentYear % 100 != 0)
                                || year % 400 == 0) {
                            if (day <= 29) {
                                isDayValid = true;
                            }
                        } else {
                            if (day <= days[month - 1]) {
                                isDayValid = true;
                            }
                        }
                    }
                    else {
                        if (day <= days[month - 1]) {
                            isDayValid = true;
                        }
                    }
                    if (isDayValid) {
                        Date date = new GregorianCalendar(currentYear, month-1, day).getTime();
                        dates.add(date);
                    }
                }
                else {
                }
            }
            return dates;
        }