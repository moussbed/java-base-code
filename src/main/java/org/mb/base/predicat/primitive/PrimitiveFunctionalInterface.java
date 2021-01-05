package org.mb.base.predicat.primitive;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

public class PrimitiveFunctionalInterface {

    public static void main(String[] args) {

        IntPredicate intFunction = (int nombre) -> nombre > 0.5;
        boolean test = intFunction.test(5);
        System.out.println(test);

        LongPredicate longFunction = (long nombre) -> nombre > Math.random() + 0.5;
        boolean test1 = longFunction.test(1);
        System.out.println(test1);

        DoublePredicate doubleFunction = (double price) -> price > Math.random();
        boolean test2 = doubleFunction.test(0.4);
        System.out.println(test2);
    }
}
