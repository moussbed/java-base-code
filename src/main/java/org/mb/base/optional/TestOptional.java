package org.mb.base.optional;

import java.util.Arrays;
import java.util.Optional;

public class TestOptional {

    /*
     Think of an Optional as a box that might have something in it or might instead be empty.
     */
    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) return Optional.empty();
        int sum = Arrays.stream(scores).sum();
        return Optional.of((double) sum / scores.length);
    }

    public static void main(String[] args) {
        // Calling the method shows what is in our two boxes:
        System.out.println(average(10, 13)); // Optional[11.5]
        System.out.println(average()); // Optional.empty
        //You can see that one Optional contains a value and the other is empty.
        // Normally, we want to check if a value is there and/or get it out of the box. Here’s one way to do that:
        Optional<Double> average = average(56, 78);
        if (average.isPresent()) System.out.println(average.get());  //average.ifPresent(System.out::println);


        //What if we didn’t do the check and the Optional was empty?
        Optional<Double> opt = average();
        //System.out.println(opt.get()); // java.util.NoSuchElementException: No value present

        //When creating an Optional, it is common to want to use empty when the value is null.
        // You can do this with an if statement or ternary operator.
        String value = "Thanks you";
        Optional o1 = (value == null) ? Optional.empty() : Optional.of(value);

        //Java provides a factory method to do the same thing:
        Optional o2 = Optional.ofNullable(value);

        // Other Method
        Optional<Double> opt2 = average();
        System.out.println(opt2.orElse(Double.NaN)); //NaN
        System.out.println(opt2.orElseGet(() -> Math.random())); // 0.5093679044977383
        System.out.println(opt2.orElseThrow(() -> new IllegalStateException())); // java.lang.IllegalStateException


        Optional<Double> opt3 = average(67, 89, 67, 56, 23, 90, 43);
        System.out.println(opt3.orElse(Double.NaN)); //62.142857142857146
        System.out.println(opt3.orElseGet(() -> Math.random())); // 62.142857142857146
        System.out.println(opt3.orElseThrow(() -> new IllegalStateException())); // 62.142857142857146


    }
}
