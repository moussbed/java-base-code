package org.mb.base.threads.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizingDataAccess {

    private int sheepCount ;

    private void incrementAndReport() {
        System.out.print((++sheepCount)+" ");
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        
        try {
            SynchronizingDataAccess synchronizingDataAccess = new SynchronizingDataAccess();

            for (int i = 0; i < 10; i++)
                executorService.execute(synchronizingDataAccess::incrementAndReport);

        }finally {
             executorService.shutdown();
        }

        // Result
        // 1 2 2 3 4 5 6 7 8 9
        // 2 4 5 6 7 8 1 9 10 3
        // 2 1 3 4 5 6 7 8 9 10
    }
}
