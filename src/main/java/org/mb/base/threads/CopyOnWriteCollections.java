package org.mb.base.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyOnWriteCollections {

    public static void main(String[] args) {

        addAndIterateListWithArraylist();
    }


    /*
     This method throw ConcurrentModificationException, because we cannot
     iterate and modify the list at the same time. Use CopyOnWriteArrayList to resolve it
     */
    static void addAndIterateListWithArraylist() {
        List<Integer> list = new ArrayList<>(Arrays.asList(4,3,52)); // List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));
        for(Integer item: list) {
            System.out.print(item+" ");
            list.add(9);
        }
        System.out.println();
        System.out.println("Size: "+list.size());
    }
}
