package org.mb.base.threads;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ObtainingSynchronizedCollections {


    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(12);
        integerList.add(4);
        integerList.add(23);

        parcours(integerList);

        Map<String, Object> foodData = new HashMap<>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        removeOnMap(foodData);

    }

    private static void parcours(List<Integer> list) {
        List<Integer> synchronizedList = Collections.synchronizedList(list);
        ExecutorService executorService = Executors.newFixedThreadPool(16);

        try {
            for (int i = 0; i < 4; i++) {
                executorService.execute(()->{
                    synchronized (synchronizedList){
                        for (Integer integer : synchronizedList) {
                            System.out.print(integer +" ");
                        }
                        System.out.println();
                    }
                });
            }

        }finally {

            executorService.shutdown();

        }

        try {
            executorService.awaitTermination(4, TimeUnit.MILLISECONDS);

            if(executorService.isTerminated()) System.out.println(synchronizedList);
            else System.out.println("At least one task is still running");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void removeOnMap(Map<String, Object> foodData){
        // If you use Collections.synchronizedMap(foodData) instead of new ConcurrentHashMap<>(foodData) a exception will be thrown even if
        // you use synchronized on the iterator
        Map<String,Object> synchronizedFoodData = new ConcurrentHashMap<>(foodData);

           for(String key: synchronizedFoodData.keySet())
               synchronizedFoodData.remove(key);

        System.out.println(synchronizedFoodData);

    }
}
