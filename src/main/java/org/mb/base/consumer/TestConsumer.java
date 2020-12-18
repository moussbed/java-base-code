package org.mb.base.consumer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class TestConsumer {

    public static void main(String[] args) {
        Consumer<List<Integer>> methodLambda = (List<Integer> l) -> Collections.sort(l);
        Consumer<List<Integer>> methodRef = Collections::reverse;
        Consumer<List<Integer>> methodClassAnonym = new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) {
                for (int i = 0; i < integers.size(); i++) {
                    integers.set(i, 2 * integers.get(i));
                }
            }
        };

        List<Integer> list = Arrays.asList(56, 2, 34, 10, 45);
        System.out.println(list); // [56, 2, 34, 10, 45]
        methodLambda.accept(list);
        System.out.println(list); // [2, 10, 34, 45, 56]

        methodRef.accept(list);
        System.out.println(list); // [56, 45, 34, 10, 2]

        methodClassAnonym.accept(list); // [112, 90, 68, 20, 4]
        System.out.println(list);

       // list.replaceAll((integer -> 2*integer)); // That is better to multiply by two
        //System.out.println(list);

        Consumer<String> stringConsumer = System.out::println;
        stringConsumer.accept("Hello Word !"); // Hello Word !

    }
}
