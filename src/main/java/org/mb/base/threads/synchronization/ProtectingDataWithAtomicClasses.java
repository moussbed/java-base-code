package org.mb.base.threads.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ProtectingDataWithAtomicClasses {

    private AtomicInteger sheepCount = new AtomicInteger(0) ;

    private void incrementAndReport() {
        System.out.print(sheepCount.incrementAndGet()+" ");
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        
        try {
            ProtectingDataWithAtomicClasses synchronizingDataAccess = new ProtectingDataWithAtomicClasses();

            for (int i = 0; i < 10; i++)
                executorService.execute(synchronizingDataAccess::incrementAndReport);

        }finally {
             executorService.shutdown();
        }

        // Result
        // 2 4 5 6 7 8 1 9 10 3
        // 2 1 3 4 5 6 7 8 9 10
    }
}
