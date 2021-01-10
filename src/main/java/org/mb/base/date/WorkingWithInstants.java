package org.mb.base.date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class WorkingWithInstants {
    

    // The Instant class represents a specific moment in time in the GMT time zone. Suppose that you want to run a timer:
    public static void main(String[] args) {

        Instant start = Instant.now();
        Stream<Double> limit = Stream.generate(Math::random).limit(20);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());


        // Manipulate instant, Using that Instant, you can do math. Instant allows you to add any unit day or smaller,
        long l = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        Instant instant = Instant.ofEpochSecond(l);
        System.out.println(instant); // 2021-01-09T02:43:15Z
        Instant nextDay = instant.plus(1, ChronoUnit.DAYS);
        System.out.println(nextDay); //2021-01-10T02:43:15Z
        Instant nextHour = instant.plus(1, ChronoUnit.HOURS);
        System.out.println(nextHour); // 2021-01-09T03:43:15Z
      //  Instant nextWeek = instant.plus(1, ChronoUnit.WEEKS); // java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Weeks

    }
}
