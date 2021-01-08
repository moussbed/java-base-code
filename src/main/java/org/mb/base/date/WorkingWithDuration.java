package org.mb.base.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class WorkingWithDuration {

    // Conveniently, Duration roughly works the same way as Period, except it is used with objects that have time.
    public static void main(String[] args) {

        // We can create a Duration using a number of different granularities:
        Duration daily = Duration.ofDays(1);
        System.out.println(daily); // PT24H
        Duration hourly = Duration.ofHours(1);
        System.out.println(hourly);// PT1H
        Duration everyMinute = Duration.ofMinutes(1);
        System.out.println(everyMinute); // PT1M
        Duration everyTenSeconds = Duration.ofSeconds(10);
        System.out.println(everyTenSeconds); // PT10S
        Duration everyMilli = Duration.ofMillis(1);
        System.out.println(everyMilli);// PT0.001S
        Duration everyNano = Duration.ofNanos(1);
        System.out.println(everyNano); // PT0.000000001S

        // Duration doesn’t have a constructor that takes multiple units like Period does.
        // If you want something to happen every hour and a half, you would specify 90 minutes
        Duration daily2 = Duration.of(1, ChronoUnit.DAYS);
        Duration hourly2 = Duration.of(1, ChronoUnit.HOURS);
        Duration everyMinute2 = Duration.of(1, ChronoUnit.MINUTES);
        Duration everyTenSeconds2 = Duration.of(10, ChronoUnit.SECONDS);
        Duration everyMilli2 = Duration.of(1, ChronoUnit.MILLIS);
        Duration everyNano2 = Duration.of(1, ChronoUnit.NANOS);
        Duration everyHalfDays = Duration.of(1, ChronoUnit.HALF_DAYS);
        System.out.println(everyHalfDays); // PT24H


        // ChronoUnit is a great way to determine how far apart two Temporal values are. Temporal
        // includes LocalDate, LocalTime, and so on.

        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
        LocalDate date = LocalDate.of(2016, 1, 20);
        System.out.println(ChronoUnit.HOURS.between(one, two)); // 1  The print statement shows that between truncates rather than rounds.
        System.out.println(ChronoUnit.MINUTES.between(one, two)); // 75
       // System.out.println(ChronoUnit.MINUTES.between(one, date)); // DateTimeException


        // Add a duration to a date
        LocalDateTime localDateTime = LocalDateTime.now();
        Duration duration = Duration.ofDays(1);
        LocalDateTime plus = localDateTime.plus(duration);
        System.out.println(plus);


    }
}
