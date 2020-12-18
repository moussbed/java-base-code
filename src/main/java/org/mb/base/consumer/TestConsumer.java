package org.mb.base.consumer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class TestConsumer {

    public static void main(String[] args) {
        Consumer<List<Integer>> methodLambda = (List<Integer> l) -> Collections.sort(l);
        Consumer<List<Integer>> methodRef = Collections::reverse;

        List<Integer> list = Arrays.asList(56, 2, 34, 10, 45);
        System.out.println(list); // [56, 2, 34, 10, 45]
        methodLambda.accept(list);
        System.out.println(list); // [2, 10, 34, 45, 56]

        methodRef.accept(list);
        System.out.println(list); // [56, 45, 34, 10, 2]

        Consumer<String> stringConsumer = System.out::println;
        stringConsumer.accept("Hello Word !"); // Hello Word !

    }
}
