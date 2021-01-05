package org.mb.base.streams.source.primitive;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreatingPrimitiveStreams {



    public static void main(String[] args) {

        /*   Here are three types of primitive streams:
         *   IntStream: Used for the primitive types int, short, byte, and char
         *   LongStream: Used for the primitive type long
         *   DoubleStream: Used for the primitive types double and float
         */

        Stream<Integer> stream = Stream.of(1, 2, 3);
        IntStream intStream2 = stream.mapToInt(x -> x); // Convertion du Stream<Integer> en IntStream
        OptionalDouble average = intStream2.average(); // Calculate average
       // System.out.println(average.getAsDouble());
        average.ifPresent(System.out::println);

        // Not only is it possible to calculate the average, but it is also easy to do so. Clearly primitive streams are important.
        IntStream intStream1 = IntStream.of(1,34,67);
        OptionalDouble average1 = intStream1.average();
       // System.out.println(average1.getAsDouble());
        average1.ifPresent(System.out::println);



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

        // Summarizing Statistics
        System.out.println();
        IntStream intStream3 = IntStream.of(12,10,9,17,19,15);
        IntSummaryStatistics intSummaryStatistics = intStream3.summaryStatistics();
        System.out.println("Count = " + intSummaryStatistics.getCount() + " Average = " +intSummaryStatistics.getAverage() + " Sum = " + intSummaryStatistics.getSum() + " Max = " +intSummaryStatistics.getMax() + " Min = " +intSummaryStatistics.getMin());

    }
}
