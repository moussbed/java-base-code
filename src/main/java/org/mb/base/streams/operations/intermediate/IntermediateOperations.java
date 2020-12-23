package org.mb.base.streams.operations.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {

    public static void main(String[] args) {
        /*
         * Contrairement à une opération  terminal, les opérations intermédiaires traitent des flux infinis
         * simplement en renvoyant un flux infini
         */
        // The filter() method returns a Stream with elements that match a given expression
        Stream<String> s1 = Stream.of("monkey", "gorilla", "bonobo", "makak", "Tomi", "Mike");
        s1.filter(x -> x.startsWith("m")).forEach(System.out::println);

        //The distinct() method returns a stream with duplicate values removed.
        Stream<String> s2 = Stream.of("duck", "duck", "duck", "goose");
        s2.distinct().forEach(System.out::print); // duckgoose

        // limit() and skip()
        Stream<Integer> iterate = Stream.iterate(1, n -> n * 10);
        iterate.skip(3).limit(2).forEach(System.out::println);// 1000 10000

        // map()
        Stream<String> s3 = Stream.of("monkey", "gorilla", "bonobo");
        s3.map(String::length).forEach(System.out::print); // 676

        // flatMap() This is helpful when you want to remove empty elements from a stream or you want to combine a stream of lists.
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        List<String> stringList = animals.flatMap(l -> l.stream()).collect(Collectors.toList());
        System.out.println(stringList);//[Bonobo, Mama Gorilla, Baby Gorilla]s

        // sorted()
        Stream<String> s = Stream.of("brown bear-", "grizzly-", "12Arr");
        s.sorted().forEach(System.out::println); // 12Arr brown bear- grizzly-

        Stream<String> s4 = Stream.of("brown bear-", "grizzly-", "12Arr");
        s4.sorted(Comparator.reverseOrder()).forEach(System.out::println); // grizzly- brown bear- 12Arr

        // peek() The peek() method is our final intermediate operation. It is useful for debugging because it allows us
        // to perform a stream operation without actually changing the stream.
        //The most common use for peek() is to output the contents of the stream as it goes by.

        Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly", "gerard", "gerard");
        long count = stream.distinct()
                .filter(se -> se.startsWith("g"))
                .peek(System.out::println).count(); // grizzly
        System.out.println(count); // 2

        Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
        infinite.limit(5)
                .peek(System.out::println)
                .filter(x -> x % 2 == 1)
                .forEach(System.out::println);


    }
}
