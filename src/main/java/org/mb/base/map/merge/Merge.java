package org.mb.base.map.merge;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Merge {


    public static void main(String[] args) {
        BiFunction<String, String, String> biFunction = (u, v) -> u.length() > v.length() ? u : v;

        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");
        favorites.put("yves", "Alain");

        /* Merge can work like pufIfAbsent, except that merge use BiFunction's functional interface that
         * which conditions the replacement or the insertion if the key does not exist
         */

        String merge = favorites.merge("Jenny", "Antoine", biFunction);
        String merge2 = favorites.merge("yves", "Anima Roosevelt", biFunction);
        String merge3 = favorites.merge("aime", "Anima Roosevelt", biFunction);
        System.out.println(merge); // Bus Tour
        System.out.println(merge2); // Anima Roosevelt
        System.out.println(merge3); // Anima Roosevelt

        System.out.println(favorites); // {Tom=Tram, yves=Anima Roosevelt, Jenny=Bus Tour, aime=Anima Roosevelt}

        /*This method may be of use when combining multiple mapped values for a key.
         * For example, to either create or append a {@code String msg} to a
         * value mapping:
         *
         * <pre> {@code
         * map.merge(key, msg, String::concat)
         * }</pre>
         */

        Map<String, String> prices = new HashMap<>();
        prices.put("one", "120");
        prices.put("two", "1500");
        prices.put("three", "2340");
        for (String s : prices.keySet()) {
            prices.merge(s, " XAF", String::concat);
        }
        System.out.println(prices);

        /*
         *The final thing to know about merge() is what happens when the mapping function is called and returns null.
         * The key is removed from the map when this happens:
         */

        BiFunction<String, String, String> mapper = (u, v) ->null;

        Map<String, String> favorites2 = new HashMap<>();
        favorites2.put("Jenny", "Bus Tour");
        favorites2.put("Tom", "Bus Tour");
        favorites2.merge("Jenny", "Skyride", mapper);
        favorites2.merge("Sam", "Skyride", mapper);
        System.out.println(favorites2); // {Tom=Bus Tour, Sam=Skyride}

    }


}
