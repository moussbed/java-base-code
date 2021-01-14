package org.mb.base.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormattingDatesAndTimes {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // 2020-01-20
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME)); // 11:12:34
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2020-01-20T11:12:34


        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDateTime.format(dateTime)); // 20/01/20
        System.out.println(shortDateTime.format(date)); // 20/01/20
       // System.out.println(shortDateTime.format(time)); // UnsupportedTemporalTypeException


        // The following statements print exactly the same thing as the previous code:

        DateTimeFormatter shortDateTime2 =DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(dateTime.format(shortDateTime2));
        System.out.println(date.format(shortDateTime2));
       // System.out.println(time.format(shortDateTime2));


        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dateTime.format(f)); // January 20, 2020, 11:12


        // -------Parsing --------
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date1 = LocalDate.parse("01 02 2015", f1);
        LocalTime time1 = LocalTime.parse("11:22");
        System.out.println(date1); // 2015–01–02
        System.out.println(time1); // 11:22

    }
}
