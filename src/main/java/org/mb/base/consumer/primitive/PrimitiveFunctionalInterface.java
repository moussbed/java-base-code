package org.mb.base.consumer.primitive;

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class PrimitiveFunctionalInterface {

    public static void main(String[] args) {

        IntConsumer intConsumer = (int nombre) -> System.out.println(nombre);
        intConsumer.accept(12);

        LongConsumer longConsumer = (long nombre) -> System.out.println(nombre);
        longConsumer.accept(1);

        DoubleConsumer doubleConsumer = System.out::println;
        doubleConsumer.accept(20);






    }
}
