package org.mb.base.map.update;

import java.util.HashMap;
import java.util.Map;

public class Replace {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        //Replace existing value unconditionally
        map.put("key1", "Bedroll");
        map.put("key1", "Moussaka's");
        System.out.println(map); //{key1=Moussakat}

        // Replace existing value with condition
        map.put("key2", "Anna");
        map.put("key3", null);
        map.putIfAbsent("key2", "Sidoine");
        map.putIfAbsent("key4", "Eyala");
        System.out.println(map);
    }
}
