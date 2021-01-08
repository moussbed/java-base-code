package org.mb.base.streams.operations.terminal.collecting;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingPartitioning {

    // Partitioning is a special case of grouping. With partitioning, there are only two possible groups—true and false.
    // Partitioning is like splitting a list into two parts.

    public static void main(String[] args) {

        Stream<String> animals = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> listMap = animals.collect(Collectors.partitioningBy(s -> s.length() > 5));
        System.out.println(listMap); // {false=[lions, bears], true=[tigers]}

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map = ohMy.collect(
                Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println(map); // {false=[], true=[lions, tigers, bears]}

    }
}
