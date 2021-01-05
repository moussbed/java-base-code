package org.mb.base.supplier.primitive;

import java.util.concurrent.Callable;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

public class PrimitiveFunctionInterface {

    /*
     * BooleanSupplier is a separate type. It has one method to implement:
     * boolean getAsBoolean()
     */

    public static void main(String[] args) {

        BooleanSupplier b1 = () -> true;
        BooleanSupplier b2 = () -> Math.random() > .5;
        System.out.println(b1.getAsBoolean());
        System.out.println(b2.getAsBoolean());

        IntSupplier intSupplier = () -> 1;
        System.out.println(intSupplier.getAsInt());

        LongSupplier longSupplier= () -> 2L;
        System.out.println(longSupplier.getAsLong());

        DoubleSupplier doubleSupplier = Math::random;
        System.out.println(doubleSupplier.getAsDouble());


    }
}
