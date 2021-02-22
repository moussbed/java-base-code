package org.mb.base.threads;

import java.util.concurrent.*;

public class ResultForThreadRunnable {

    private static int counter;
    public static void main(String[] args) {

        ExecutorService executorService=null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            Future<?> result = executorService.submit(() -> {
                for (int i = 0; i < 500000; i++) ResultForThreadRunnable.counter++;
            });
            result.get(1, TimeUnit.MILLISECONDS);
            System.out.println("Reached!");

        }catch (TimeoutException | InterruptedException | ExecutionException ex){
            System.out.println("Not reached in time"+ ex);
        } finally {
            if(executorService != null) executorService.shutdown();
        }

    }
}
