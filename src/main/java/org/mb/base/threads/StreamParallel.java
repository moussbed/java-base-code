package org.mb.base.threads;


import java.util.Arrays;
import java.util.stream.Stream;

public class StreamParallel {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> parallel = stream.parallel();
        parallel.forEach(e-> System.out.print(e+ " ")); // 3 1 4 2 5
        System.out.println();

        Stream<Integer> integerStream = Arrays.asList(6, 7, 8, 9, 10).parallelStream();
        integerStream.forEach(e-> System.out.print(e+ " ")); // 8 10 7 6 9
        System.out.println();

        Stream<Integer> concat = Stream.concat(Stream.of(1, 2, 3, 4).parallel(), Stream.of(5, 6, 7, 8));
        boolean isParallel= concat.isParallel();
        System.out.println(isParallel);
        concat.forEachOrdered(e-> System.out.print(e+ " ")); // 1 2 3 4 5 6 7 8
        System.out.println();
        System.out.print(Stream.of(1,2,3,4,5,6).findAny().get()); // 1
        System.out.println();
        System.out.print(Arrays.asList(1,2,3,4,5,6).parallelStream().findAny().get()); // any

        System.out.println();
        System.out.println(Stream.of('w', 'o', 'l', 'f')
                .reduce("",(c,s1) -> c + s1, (s2,s3) -> s2 + s3));

        Integer reduce = Arrays.asList(6, 7, 8, 9, 10).parallelStream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

        System.out.println(Arrays.asList(1,2,3,4,5,6)
                .parallelStream()
                .reduce(0,(a,b) -> (a-b)));

    }
}
