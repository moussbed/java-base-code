package org.mb.base.threads;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentCollections {

    Map<String,Object> foodData = new ConcurrentHashMap<>();

    public void put(String key, Object value){
          foodData.put(key, value);
    }

    public Object get (String key){
         return  foodData.get(key);
    }


    public static void main(String[] args) {
        Map<String, Object> foodData = new ConcurrentHashMap<>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for(String key: foodData.keySet()){
            System.out.println(foodData.get(key));
            foodData.remove(key);
        }

        // Queue est une fille d'attente : FIFO
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        queue.offer(18);


        System.out.println(queue.peek()); // 31
        System.out.println(queue.poll()); // 31
        System.out.println(queue); // [18]

        // Deque est une pile : LIFO
        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.offer(41);
        deque.push(10);

        System.out.println(deque.peek()); // 10
        System.out.println(deque.poll()); // 10
        System.out.println(deque); // [41]


    }


}
