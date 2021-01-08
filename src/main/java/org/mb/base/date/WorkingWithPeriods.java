package org.mb.base.date;

import java.time.*;

public class WorkingWithPeriods {

    public static void main(String[] args) {

        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2021, Month.JANUARY, 9);
        // performAnimalEnrichment(start, end);
        Period period = Period.ofMonths(1); // create a period
        performAnimalEnrichment(start, end, period);


        // LocalDate has toEpochDay(), which is the number of days since January 1, 1970
        System.out.println(end.toEpochDay());

        // LocalDateTime and ZonedDateTime have toEpochSecond(), which is the number of seconds since January 1, 1970.
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toEpochSecond(ZoneOffset.UTC));

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime.toEpochSecond());


        // There are five ways to create a Period class:
        Period annually = Period.ofYears(1); // every 1 year
        System.out.println(annually); // P1Y
        Period quarterly = Period.ofMonths(3); // every 3 months
        System.out.println(quarterly);// P3M
        Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
        System.out.println(everyThreeWeeks); // P21D
        Period everyOtherDay = Period.ofDays(2); // every 2 days
        System.out.println(everyOtherDay);// P2D
        Period everyYearAndAWeek = Period.of(1, 0, 7);  // every year and 7 days
        System.out.println(everyYearAndAWeek);//P1Y7D

        // You cannot chain methods when creating a Period.
        Period wrong = Period.ofYears(1).ofWeeks(1); // every week
        System.out.println(wrong); // P7D instead of P1Y7D

        // This tricky code is really like writing the following:

        Period fine = Period.of(1,0,1);
        System.out.println(fine);// P1Y1D


        // Add a period to a date
        LocalDateTime now = LocalDateTime.now();
        Period oneYear = Period.ofYears(1);
        LocalDateTime plus = now.plus(oneYear);
        System.out.println(plus);


    }

    /**
     * This code works fine. It adds a month to the date until it hits the end date.
     * The problem is that this method can’t be reused. Our zookeeper wants to try different schedules to see which works best
     *
     * @param start
     * @param end
     */
    private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
        LocalDate upTo = start;
        while (upTo.isBefore(end)) { // check if still before end
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plusMonths(1); // add a month
        }
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end,
                                                Period period) { // uses the generic period
        LocalDate upTo = start;
        while (upTo.isBefore(end)) {
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plus(period); // adds the period
        }
    }
}