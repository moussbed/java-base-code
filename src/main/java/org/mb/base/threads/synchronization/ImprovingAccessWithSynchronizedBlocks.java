package org.mb.base.threads.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ImprovingAccessWithSynchronizedBlocks {
    private AtomicInteger sheepCount = new AtomicInteger(0);

    private void incrementAndReport() {
         synchronized (this){
             System.out.print(sheepCount.incrementAndGet() + " ");
         }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        try {
            ImprovingAccessWithSynchronizedBlocks synchronizingDataAccess = new ImprovingAccessWithSynchronizedBlocks();

            for (int i = 0; i < 10; i++){
                    executorService.execute(synchronizingDataAccess::incrementAndReport);
            }

        } finally {
            executorService.shutdown();
        }
    }

}