package org.mb.base.streams.operations.terminal.collecting;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMaps {

    public static void main(String[] args) {
        Stream<String> animals = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> animalsMap = animals.collect(Collectors.toMap(s -> s.toUpperCase(), s -> s.length()));
        //Map<String, Integer> animalsMap = animals.collect(Collectors.toMap(String::toUpperCase, String::length));
        System.out.println(animalsMap); // {LIONS=5, TIGERS=6, BEARS=5}
        // Now we want to do the reverse and map the length of the animal name to the name itself.
        // Running this gives an exception similar to the following:
        // Exception in thread "main" java.lang.IllegalStateException: Duplicate key lions
        // at java.util.stream.Collectors.lambda$throwingMerger$114(Collectors.java:133)
        // at java.util.stream.Collectors$$Lambda$3/1044036744.apply(Unknown Source)
        // What’s wrong? Two of the animal names are the same length.


        // Let’s suppose that our requirement is to create a comma-separated String with the animal names. We could write this:
        Stream<String> animales = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map = animales.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println(map); // {5=lions,bears, 6=tigers}
        // With us so far? This code is long but not particularly complicated.
        // We can use Grouping


    }
}
