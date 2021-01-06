package org.mb.base.streams.operations.terminal.collecting;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingUsingGrouping {

    public static void main(String[] args) {
        Stream<String> animals = Stream.of("lions", "tigers", "bears", "tigers");
        Map<Integer, List<String>> listMap = animals.collect(Collectors.groupingBy(String::length));
        System.out.println(listMap); //  {5=[lions, bears], 6=[tigers, tigers]}

        Stream<String> animales = Stream.of("lions", "tigers", "bears","tigers");
        Map<Integer, Set<String>> map1 = animales.collect(
                Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map1); // {5=[lions, bears], 6=[tigers]}

        Stream<String> animales2 = Stream.of("lions", "tigers", "bears","tigers");
        TreeMap<Integer, Set<String>> map2 = animales2.collect(
                Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(map2); // {5=[lions, bears], 6=[tigers]}

        Stream<String> animales3 = Stream.of("lions", "tigers", "bears","tigers");
        TreeMap<Integer, List<String>> map = animales3.collect(
                Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
        System.out.println(map); // {5=[lions, bears], 6=[tigers, tigers]}

    }
}
