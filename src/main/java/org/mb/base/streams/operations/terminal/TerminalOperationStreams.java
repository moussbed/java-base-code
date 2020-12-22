package org.mb.base.streams.operations.terminal;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationStreams {

    /*
     * You can perform a terminal operation without any intermediate operations but not the other way around.
     * This is why we will talk about terminal operations first.
     * Reductions are a special type of terminal operation where all of the contents of the stream are combined into a single primitive or Object.
     * For example, you might have an int or a Collection.
     * The collect() method is a special type of reduction called a mutable reduction.
     */

    public static void main(String[] args) {

        // count()
        Stream<String> animalStream = Stream.of("Monkey", "Lion", "zebra");
        System.out.println(animalStream.count());//3

        // min() and max()
        Stream<String> animalStream2 = Stream.of("Monkey", "Lion", "zebra");
        Comparator<String> comparator = Comparator.naturalOrder();
        Optional<String> min = animalStream2.min(comparator);
        min.ifPresent(System.out::println); // Lion
        Stream<String> animalStream3 = Stream.of("Monkey", "Lion", "zebra");
        Optional<String> max = animalStream3.max(comparator);
        max.ifPresent(System.out::println); // Zebra

        // findAny() and findFirst()
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.findFirst().ifPresent(System.out::println); // monkey

        Stream<String> s2 = Stream.of("monkey", "gorilla", "bonobo");
        s2.findAny().ifPresent(System.out::println); // monkey

        Stream<String> infinite = Stream.generate(() -> "chimp" + Math.random());
        infinite.findAny().ifPresent(System.out::println);

        //allMatch(), anyMatch() and noneMatch()

        List<String> list = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite2 = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

        System.out.println(list.stream().anyMatch(pred));//true
        System.out.println(list.stream().allMatch(pred));//false
        System.out.println(list.stream().noneMatch(pred));//false
        System.out.println(infinite2.anyMatch(pred)); // true

        //forEach()
        Stream<String> s3 = Stream.of("Monkey", "Gorilla", "Bonobo");
        s3.forEach(System.out::print); // MonkeyGorillaBonobo

        //reduce()
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (a, c) -> a + c);
        System.out.println();
        System.out.println(word); // wolf

        Stream<Integer> stream2 = Stream.of(3, 5, 6);
        Integer reduce = stream2.reduce(1, (a, b) -> a * b);
        System.out.println(reduce);// 90

        //Notice that Optional is returned because we don't pass identity parameter in the reduce function
        Optional<Integer> reduce1 = Stream.of(3, 10, 6).reduce((a, b) -> a * b);
        reduce1.ifPresent(System.out::println); // 180

        //collect()
        //Common mutable objects include StringBuilder and ArrayList.
        Stream<String> streamw = Stream.of("B", "e", "d", "r", "i", "l");
        /*
         * The first parameter is a Supplier that creates the object that will store the results as we collect data.
         * Remember that a Supplier doesn’t take any parameters and returns a value. In this case, it constructs a new StringBuilder.
         * The second parameter is a BiConsumer, which takes two parameters and doesn’t return anything.
         * It is responsible for adding one more element to the data collection. In this exam- ple, it appends the next String to the StringBuilder.
         * The final parameter is another BiConsumer. It is responsible for taking two data collections and merging them.
         */
        StringBuilder collect = streamw.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(collect);

        Stream<String> streame = Stream.of("w", "o", "l", "f","t","l");
        TreeSet<String> set = streame.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(set); // [f, l, o, t, w]

        Stream<String> streamee = Stream.of("w", "o", "l", "f");
        TreeSet<String> set1 = streamee.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set1); // [f, l, o, w]

        Stream<String> streameee = Stream.of("w", "o", "l", "f");
        Set<String> set2 = streameee.collect(Collectors.toSet());
        System.out.println(set2); // [f, w, l, o]

    }

}
