package org.mb.base.map.merge;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Merge {


    public static void main(String[] args) {
        BiFunction<String, String, String> biFunction = (u, v) -> u.length() > v.length() ? u : v;

        Map<String,String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");
        favorites.put("yves", "Alain");

        String merge = favorites.merge("Jenny", "Antoine", biFunction);
        String merge2 = favorites.merge("yves", "Anima Roosevelt", biFunction);
        System.out.println(merge);
        System.out.println(merge2);


    }





}
