package org.mb.base.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PerformanceImprovementsWithStreamParallel {

    private static int processingrecord(int input){

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input +1;
    }

    private static void processingAllData(List<Integer> list){

       // list.stream().map(e-> processingrecord(e)).count(); // With Serie Stream, Tasks completed in: 45.348 seconds
        list.parallelStream().map(e-> processingrecord(e)).count(); // With  parallel Stream, Tasks completed in: 2.895 seconds

    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 4000 ; i++) {
            list.add(i);
        }

        // Process the data
        long start = System.currentTimeMillis();
        processingAllData(list);
        double v = 1000.0;
        double timeDone = (System.currentTimeMillis() - start) / v;

        // Report results
        System.out.println("\nTasks completed in: "+timeDone+" seconds");

        System.out.print(Stream.of(1,2,3,5,6).parallel().findAny().get());



    }

}
