package org.mb.base.map.compute;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class computeIfPresentAndIfAbsent {

    public static void main(String[] args) {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);

        BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;

        Integer jenny = counts.computeIfPresent("Jenny", mapper);
        Integer sam = counts.computeIfPresent("Sam", mapper);
        System.out.println(counts); // {Jenny=2}
        System.out.println(jenny); // 2
        System.out.println(sam); // null

        /*
         *For computeIfAbsent(), the functional interface runs only when the key isn’t present or is null:
         */

        Map<String, Integer> counts2 = new HashMap<>();
        counts2.put("Jenny", 15);
        counts.put("Tom", null);
        Function<String, Integer> mapper2 = (k) -> 1;
        Integer jenny2 = counts2.computeIfAbsent("Jenny", mapper2);// 15
        Integer sam2 = counts2.computeIfAbsent("Sam", mapper2);// 1
        Integer tom2 = counts2.computeIfAbsent("Tom", mapper2); // 1
        System.out.println(counts2); // {Tom=1, Jenny=15, Sam=1}


    }
}
