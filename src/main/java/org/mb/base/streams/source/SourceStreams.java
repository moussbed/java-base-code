package org.mb.base.streams.source;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SourceStreams {
    public static void main(String[] args) {

        // There are a few ways to create a finite stream:
        Stream<String> empty = Stream.empty();
        System.out.println(empty.count());
        Stream<Integer> integerStream = Stream.of(12);
        System.out.println(integerStream.count());
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3);
        System.out.println(integerStream1.count());

        //Java provides a convenient way to convert from a list to a stream:
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();

        //We can’t create an infinite list, though, which makes streams more powerful:
        Stream<Double> generate = Stream.generate(Math::random);
        generate.forEach(System.out::println);

        Stream<Integer> iterate = Stream.iterate(1, n -> n + 1);
        iterate.forEach(System.out::println);
        System.out.println(iterate); // java.util.stream.ReferencePipeline$Head@3d494fbf


    }
}
