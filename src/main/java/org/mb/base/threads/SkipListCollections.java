package org.mb.base.threads;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class SkipListCollections {

    public static void main(String[] args) {

        ConcurrentSkipListMap<String, Object> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put("fromage",4);
        skipListMap.put("cacaoutte",2);
        skipListMap.put("arrachide", 5);

        skipListMap.forEach((k,v)->{
            System.out.println(v);
        });

        ConcurrentSkipListSet<String> objects = new ConcurrentSkipListSet<>();
        objects.add("Tamao");
        objects.add("Henry");
        objects.add("Sidone");
        objects.add("Eliezabeth");


        for (String object : objects) {
            System.out.println(object);
        }


    }
}
