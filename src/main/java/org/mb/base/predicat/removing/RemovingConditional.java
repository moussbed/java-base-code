package org.mb.base.predicat.removing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemovingConditional {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Tami");
        list.add("Amina");
        list.add("Richard");
        System.out.println(list); // [Tami, Amina, Richard]

        Predicate<String> predicate = (word)-> word.contains("m");
        list.removeIf(predicate);
        System.out.println(list); // [Richard]
        
    }

}
