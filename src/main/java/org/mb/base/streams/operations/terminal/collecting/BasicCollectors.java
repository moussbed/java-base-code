package org.mb.base.streams.operations.terminal.collecting;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicCollectors {

    public static void main(String[] args) {
        Stream<String> towns = Stream.of("Douala", "Kribi", "Bertoua", "Yaounde");
        String collect = towns.collect(Collectors.joining("-"));
        System.out.println(collect);

        Stream<String> animals = Stream.of("Lion", "Cat", "Dog", "Cow","Hippotamos");
        Double average= animals.collect(Collectors.averagingInt(String::length));
        System.out.println(average);

        Stream<String> countries = Stream.of("Cameroon", "Paris", "England", "Canada","Cameroon");
        TreeSet<String> set = countries.filter(c -> c.contains("Ca"))
                .collect(Collectors.toCollection(TreeSet::new)); // You can use Collectors.toSet()
        System.out.println(set);

    }
}
