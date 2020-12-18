package org.mb.base.map.update;

import java.util.HashMap;
import java.util.Map;

public class ReplaceExistingValueUnconditionally {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "Bedroll");
        map.put("key1", "Moussaka's");
        System.out.println(map); //{key1=Moussakat}
    }
}
