package org.mb.base.date;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class CreatingDatesAndTimes {

    private static LocalDateTime localDateTime;
    private static LocalTime localTime;
    private static LocalDate localDate;
    private static ZonedDateTime zonedDateTime;

    public static void main(String[] args) {

        localDate = LocalDate.now();
        System.out.println(localDate); // 2021-01-08
        localTime = LocalTime.now();
        System.out.println(localTime); // 23:59:40.930
        localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // 2021-01-08T23:59:40.930
        zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime); // 2021-01-08T23:59:40.930+04:00[Indian/Mauritius]

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println); // Asia/Aden America/Cuiaba Etc/GMT+9 Etc/GMT+8 Africa/Nairobi America/Marigot ... Europe/Monaco
        Optional<String> first = availableZoneIds.stream().findFirst(); // Asia/Aden
        first.ifPresent(s -> System.out.println(ZonedDateTime.of(localDateTime, ZoneId.of(s)))); // 2021-01-09T00:36:21.332+03:00[Asia/Aden]

        // Old Way : Creating an object with the current date                                                           New Way (Java 8 and Later)
           Date d = new Date();                                                                                         LocalDate d2 = LocalDate.now();

        // Old way : Creating an object with the current date and time
           Date d3 = new Date();                                                                                        LocalDateTime dt = LocalDateTime. now();

        // Old way : Creating an object representing January 1, 2015
           Calendar c = Calendar.getInstance(); c.set(2015, Calendar.JANUARY, 1); Date jan = c.getTime();    LocalDate jan2 = LocalDate.of(2015, Month.JANUARY, 1);


    }
}
