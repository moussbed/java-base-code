package org.mb.base.streams.source.primitive;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingPrimitiveStreams {

    public static void main(String[] args) {

        /*   Here are three types of primitive streams:
         *   IntStream: Used for the primitive types int, short, byte, and char
         *   LongStream: Used for the primitive type long
         *   DoubleStream: Used for the primitive types double and float
         */

        DoubleStream empty = DoubleStream.empty();
        empty.forEach(System.out::println);

        DoubleStream oneValue = DoubleStream.of(3.14);
        DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2, 1);
        oneValue.forEach(System.out::println);// 3.14
        System.out.println();
        varargs.forEach(System.out::print); // 1.01.11.21.0

        DoubleStream random = DoubleStream.generate(Math::random);
        DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);
        random.limit(3).forEach(System.out::println);
        System.out.println();
        fractions.limit(3).forEach(System.out::println);


        IntStream count = IntStream.iterate(1, n -> n + 1)
                .limit(5);
        count.forEach(System.out::print);// 12345
        System.out.println();

        IntStream range = IntStream.range(1, 6);
        range.forEach(System.out::print);//12345
        System.out.println();
        IntStream rangeClosed = IntStream.rangeClosed(1, 5);
        rangeClosed.forEach(System.out::print);//12345

        System.out.println();
        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream intStream = objStream.mapToInt(s -> s.length());
        intStream.forEach(System.out::print);//74
        

    }
}
