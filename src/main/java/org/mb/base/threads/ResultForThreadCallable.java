package org.mb.base.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultForThreadCallable {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> result = executorService.submit(() -> 1 + 3);

        try {
            System.out.println(result.get()); // 4

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
                executorService.shutdown();
        }
    }
}
