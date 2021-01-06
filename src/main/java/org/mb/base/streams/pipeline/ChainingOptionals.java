package org.mb.base.streams.pipeline;

import java.util.Optional;

public class ChainingOptionals {

    // It works, but it contains nested if statements. That’s extra complexity.
    static void threeDigits(Optional<Integer> number){
        if(number.isPresent()){
            Integer num = number.get();
            String s = num + "";
            if(s.length()==3) System.out.println(num);
        }

    }
    // Let’s try this again with functional programming
    static void threeDigits2(Optional<Integer> number){
        number.filter(num-> String.valueOf(num).length()==3)
              .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        Optional<Integer> number = Optional.of(456);
        threeDigits(number);

        Optional<Integer> number2 = Optional.empty();
        threeDigits2(number2);

        /*
         * Now suppose that we wanted to get an Optional<Integer> representing the length of the String contained in another Optional.
         * Easy enough:
         * Optional<Integer> result = optional.map(String::length);
         */

    }
}
